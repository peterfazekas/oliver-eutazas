package hu.etravel;

import hu.etravel.controller.TravelService;
import hu.etravel.model.service.FileReader;
import hu.etravel.model.service.TravelDateApi;
import hu.etravel.model.service.TravelDetailParser;

public class App {

    private final TravelService travelService;

    private App() {
        TravelDateApi travelDateApi = new TravelDateApi(new FileReader(), new TravelDetailParser());
        travelService = new TravelService(travelDateApi.getTravelDetails("utasadat.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat: A buszra " + travelService.getPassengerCount() + " utas akart felszállni.");
        System.out.println("3. feladat: A buszra " + travelService.getInValidTryOuts() + " utas nem szállhatott fel.");
        System.out.println("4. feladat: " + travelService.getMostPassengersStop());
    }
}
