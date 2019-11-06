package hu.etravel.model.service;

import hu.etravel.model.domain.TravelDetail;

import java.util.List;

public class TravelDateApi {
    private final FileReader fileReader;
    private final TravelDetailParser travelDetailParser;

    public TravelDateApi(FileReader fileReader, TravelDetailParser travelDetailParser) {
        this.fileReader = fileReader;
        this.travelDetailParser = travelDetailParser;
    }

    public List<TravelDetail> getTravelDetails(String input) {
        return travelDetailParser.parse(fileReader.read(input));
    }
}
