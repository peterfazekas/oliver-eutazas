package hu.etravel;

import hu.etravel.controller.TravelService;
import hu.etravel.model.domain.DiscountType;
import hu.etravel.model.service.FileReader;
import hu.etravel.model.service.FileWriter;
import hu.etravel.model.service.TravelDateApi;
import hu.etravel.model.service.TravelDetailParser;

class App {

    private final TravelService travelService;
    private final FileWriter fileWriter;

    private App() {
        TravelDateApi travelDateApi = new TravelDateApi(new FileReader(), new TravelDetailParser());
        travelService = new TravelService(travelDateApi.getTravelDetails("utasadat.txt"));
        fileWriter = new FileWriter("figyelmeztetes.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat: A buszra " + travelService.getPassengerCount() + " utas akart felszállni.");
        System.out.println("3. feladat: A buszra " + travelService.getInValidTryOuts() + " utas nem szállhatott fel.");
        Integer stopId = travelService.getMostPassengersStop().getKey();
        Long passengerCount = travelService.getMostPassengersStop().getValue();
        System.out.println("4. feladat: A legtöbb utas (" + passengerCount + " fő) a "
                + stopId + ". megállóban próbált felszállni.");
        System.out.println("5. feladat");
        System.out.println("Ingyenesen utazók száma: " + travelService.countTicketDiscountType(DiscountType.FREE) + " fő");
        System.out.println("A kedvezményesen utazók száma: " + travelService.countTicketDiscountType(DiscountType.DISCOUNTED) + " fő");
        fileWriter.printAll(travelService.getSoonExpireTickets());
    }
}
