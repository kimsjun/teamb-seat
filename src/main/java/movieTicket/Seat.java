package movieTicket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Seat_table")
public class Seat {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long seatId;
    private String seatStatus;
    private Long bookingId;

    @PostUpdate
    public void onPostUpdate(){
        UnbookedSeat unbookedSeat = new UnbookedSeat();
        BeanUtils.copyProperties(this, unbookedSeat);
        unbookedSeat.publishAfterCommit();


        BookedSeat bookedSeat = new BookedSeat();
        BeanUtils.copyProperties(this, bookedSeat);
        bookedSeat.publishAfterCommit();


    }


    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }
    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }




}
