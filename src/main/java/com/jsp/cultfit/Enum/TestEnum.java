package com.jsp.cultfit.Enum;

public class TestEnum {
    public static void main(String[] args) {
        printPrices();    
        updatePrices();
        printPrices();
    }

    private static void printPrices() {
        for (MemberShipType type : MemberShipType.values()) {
            System.out.println(type + ": " + type.getPrice());
        }
    }

    
    private static void updatePrices() {
        MemberShipType.ONEMONTH.updatePrice(600.00);
        MemberShipType.TWOMONTH.updatePrice(750.00);
    }
}
