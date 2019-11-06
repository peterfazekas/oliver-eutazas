package hu.etravel.model.domain;

public class TravelDetail {

    private final int stopId;
    private final TravelDate boardingDate;
    private final String ticketId;
    private final TicketType ticketType;
    private final TravelDate dueDate;
    private final Integer dueCounter;

    public TravelDetail(int stopId, TravelDate boardingDate, String ticketId, TicketType ticketType, TravelDate dueDate, Integer dueCounter) {
        this.stopId = stopId;
        this.boardingDate = boardingDate;
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.dueDate = dueDate;
        this.dueCounter = dueCounter;
    }

    public int getStopId() {
        return stopId;
    }

    public TravelDate getBoardingDate() {
        return boardingDate;
    }

    public String getTicketId() {
        return ticketId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public TravelDate getDueDate() {
        return dueDate;
    }

    public boolean isValid() {
        return (TicketType.JGY.equals(ticketType) && dueCounter > 0)
        || (!TicketType.JGY.equals(ticketType) && (boardingDate.getDayDifference(dueDate) >= 0));
    }

    public Integer getDueCounter() {
        return dueCounter;
    }
}
