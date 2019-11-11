package hu.etravel.model.domain;

public class TravelDate {

    private final String value;

    public TravelDate(String value) {
        this.value = value;
    }

    private int getYear() {
        return Integer.parseInt(value.substring(0, 4));
    }

    private int getMonth() {
        return Integer.parseInt(value.substring(4, 6));
    }

    private int getDay() {
        return Integer.parseInt(value.substring(6, 8));
    }

    public int getDayDifference(TravelDate travelDate) {
        return napokszama(getYear(), getMonth(), getDay(), travelDate.getYear(), travelDate.getMonth(), travelDate.getDay());
    }

    private int napokszama(int e1, int h1, int n1, int e2, int h2, int n2) {
        h1 = (h1 + 9) % 12;
        e1 = e1 - h1 / 10;
        var d1 = 365 * e1 + e1 / 4 - e1 / 100 + e1 / 400 + (h1 * 306 + 5) / 10 + n1 - 1;
        h2 = (h2 + 9) % 12;
        e2 = e2 - h2 / 10;
        var d2 = 365 * e2 + e2 / 4 - e2 / 100 + e2 / 400 + (h2 * 306 + 5) / 10 + n2 - 1;
        return d2 - d1;
    }

    @Override
    public String toString() {
        return String.format("%4d-%02d-%02d", getYear(), getMonth(), getDay());
    }

    /*
Függvény napokszama(e1:egész, h1:egész, n1: egész, e2:egész, h2: egész, n2: egész): egész
	h1 = (h1 + 9) MOD 12
	e1 = e1 - h1 DIV 10
	d1= 365*e1 + e1 DIV 4 - e1 DIV 100 + e1 DIV 400 + (h1*306 + 5) DIV 10 + n1 - 1
	h2 = (h2 + 9) MOD 12
	e2 = e2 - h2 DIV 10
	d2= 365*e2 + e2 DIV 4 - e2 DIV 100 + e2 DIV 400 + (h2*306 + 5) DIV 10 + n2 - 1
	napokszama:= d2-d1
Függvény vége
    
     */
}
