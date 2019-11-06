package hu.etravel.model.service;

import hu.etravel.model.domain.TicketType;
import hu.etravel.model.domain.TravelDate;
import hu.etravel.model.domain.TravelDetail;

import java.util.List;
import java.util.stream.Collectors;

public class TravelDetailParser {

    public List<TravelDetail> parse(List<String> lines) {
        return lines.stream()
                .map(i -> createTravelDetail(i))
                .collect(Collectors.toList());
    }

    private TravelDetail createTravelDetail(String line) {
        String[] items = line.split(" ");
        var stopId = Integer.parseInt(items[0]);
        var boardingDate = new TravelDate(items[1]);
        var ticketId = items[2];
        var ticketType = TicketType.valueOf(items[3]);
        TravelDate dueDate = null;
        Integer dueCounter = null;
        if (TicketType.JGY.equals(ticketType)) {
            dueCounter = Integer.parseInt(items[4]);
        } else {
            dueDate = new TravelDate(items[4]);
        }
        return new TravelDetail(stopId, boardingDate, ticketId, ticketType, dueDate, dueCounter);
    }
}
