package hu.etravel.model.domain;

public enum TicketType {

    FEB(DiscountType.FULL_PRICE),
    TAB(DiscountType.DISCOUNTED),
    NYB(DiscountType.DISCOUNTED),
    NYP(DiscountType.FREE),
    RVS(DiscountType.FREE),
    GYK(DiscountType.FREE),
    JGY(DiscountType.FULL_PRICE);

    private final DiscountType discountType;

    TicketType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }
}
