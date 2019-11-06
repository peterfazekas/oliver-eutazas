package hu.etravel.controller;

import hu.etravel.model.domain.TravelDetail;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TravelService {

    private final List<TravelDetail> travelDetails;

    public TravelService(List<TravelDetail> travelDetails) {
        this.travelDetails = travelDetails;
    }

    public int getPassengerCount() {
        return travelDetails.size();
    }

    public long getInValidTryOuts() {
        return travelDetails.stream()
                .filter(i -> !i.isValid())
                .count();
    }

    public String getMostPassengersStop() {
        Map<Integer, Long> passengerStopMap = countPassengersPerStops();
        Map.Entry<Integer, Long> mostPassengerStop = passengerStopMap.entrySet().stream()
                .min((i, j) -> j.getValue().compareTo(i.getValue()))
                .get();
        return String.format("A legtöbb utas (%d fő) a %d. megállóban próbált felszállni.",
                mostPassengerStop.getValue(), mostPassengerStop.getKey());
    }

    private Map<Integer, Long> countPassengersPerStops() {
        return travelDetails.stream()
                .collect(Collectors.groupingBy(TravelDetail::getStopId, Collectors.counting()));
    }
}
