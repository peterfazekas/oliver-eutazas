package hu.etravel.controller;

import hu.etravel.model.domain.DiscountType;
import hu.etravel.model.domain.TravelDetail;

import java.util.Comparator;
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
                .filter(TravelDetail::isExpired)
                .count();
    }

    public Map.Entry<Integer, Long> getMostPassengersStop() {
        Map<Integer, Long> passengerStopMap = countPassengersPerStops();
        return passengerStopMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get();
    }

    public long countTicketDiscountType(DiscountType discountType) {
        return travelDetails.stream()
                .filter(TravelDetail::isValid)
                .filter(i -> i.getDiscountType().equals(discountType))
                .count();
    }

    public List<String> getSoonExpireTickets() {
        return travelDetails.stream()
                .filter(TravelDetail::isExpireSoon)
                .map(TravelDetail::toString)
                .collect(Collectors.toList());
    }

    private Map<Integer, Long> countPassengersPerStops() {
        return travelDetails.stream()
                .collect(Collectors.groupingBy(TravelDetail::getStopId, Collectors.counting()));
    }
}
