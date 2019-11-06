package hu.etravel.model.domain;

public enum TicketType {

    FEB("nem kedvezményes"),
    TAB("kedvezményes"),
    NYB("kedvezményes"),
    NYP("ingyenes"),
    RVS("ingyenes"),
    GYK("ingyenes"),
    JGY("nem kedvezményes");

    private final String discountType;

    TicketType(String discountType) {
        this.discountType = discountType;
    }
}
