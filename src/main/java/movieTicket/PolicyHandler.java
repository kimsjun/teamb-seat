package movieTicket;

import movieTicket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    SeatRepository seatRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentSucceed_BookSeat(@Payload PaymentSucceeded paymentSucceeded){

        if(paymentSucceeded.isMe()){
            Seat seat = new Seat();
            seat.setBookingId(paymentSucceeded.getBookingId());
            seat.setSeatId((long) 111);
            seat.setSeatStatus("bookedSeat!!");

            seatRepository.save(seat);

            System.out.println("##### listener BookSeat : " + paymentSucceeded.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverUnbooked_UnbookeSeat(@Payload Unbooked unbooked){

        if(unbooked.isMe()){
            Seat seat = new Seat();
            unbooked.setBookingId(unbooked.getBookingId());
            seat.setSeatId((long) 111);
            seat.setSeatStatus("unbookedSeat!!");

            seatRepository.save(seat);
            System.out.println("##### listener UnbookeSeat : " + unbooked.toJson());
        }
    }
}
