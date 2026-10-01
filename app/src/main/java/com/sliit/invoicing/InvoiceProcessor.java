package com.sliit.invoicing;

public class InvoiceProcessor {

    public double calculateDiscount(
            double amount,
            String customerType,
            boolean isHoliday,
            int loyaltyYears) {

        double discount;

        if (customerType.equals("VIP")) {
            discount = calculateVipDiscount(isHoliday);
        } else if (customerType.equals("REGULAR")) {
            discount = calculateRegularDiscount(loyaltyYears);
        } else {
            discount = 0;
        }

        if (amount > 1000) {
            discount += 0.05;
        }

        return amount - (amount * discount);
    }

    private double calculateVipDiscount(boolean isHoliday) {
        if (isHoliday) {
            return 0.25;
        }
        return 0.15;
    }

    private double calculateRegularDiscount(int loyaltyYears) {
        if (loyaltyYears > 5) {
            return 0.10;
        } else if (loyaltyYears > 2) {
            return 0.05;
        }
        return 0.02;
    }

    public boolean isKnownCustomerType(String customerType) {
        return customerType.equals("VIP")
                || customerType.equals("REGULAR");
    }

    public String customerTypeLabel(String customerType) {
        if (customerType.equals("REGULAR")) {
            return "Regular customer";
        }

        return "VIP customer";
    }
}
