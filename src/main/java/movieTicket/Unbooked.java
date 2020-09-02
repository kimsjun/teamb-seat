package movieTicket;

public class Unbooked extends AbstractEvent {

    private Long bookingId;
    private Long customerId;
    private Long seatId;
    private Long quantity;
    private Double price;
    private String bookingStatus;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatIdList) {
        this.seatId = seatId;
    }
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getOrderStatus() {
        return bookingStatus;
    }

    public void setOrderStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}