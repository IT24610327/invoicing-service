package com.sliit.invoicing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceProcessorTest {

    @Test
    void vipHolidayDiscountIsAppliedCorrectly() {
        InvoiceProcessor processor = new InvoiceProcessor();

        double result =
                processor.calculateDiscount(500.0, "VIP", true, 3);

        assertEquals(375.0, result, 0.001);
    }
}
