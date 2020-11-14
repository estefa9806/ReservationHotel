package com.dxhotels.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.text.ParseException;

import static com.dxhotels.certification.userinterfaces.SearchHotelPage.*;
import static com.dxhotels.certification.utils.CalculateDays.numberOfDays;

public class ValidatePrice implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String checkIn = Text.of(DATE_CHECK_IN).viewedBy(actor).asString().trim();
            String checkOut = Text.of(DATE_CHECK_OUT).viewedBy(actor).asString().trim();
            String priceDay = Text.of(PRICE_PER_DAY).viewedBy(actor).asString().trim().replace("$", "");
            String totalPrice = Text.of(TOTAL_PRICE).viewedBy(actor).asString().trim().replace("$", "").replace(".00","");
            int days = numberOfDays(checkIn, checkOut);
            double price = Double.parseDouble(priceDay) * (days + 1);
            return totalPrice.equalsIgnoreCase(String.valueOf(price).replace(".0",""));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

    }



    public static ValidatePrice byNumberOfDays() {
        return new ValidatePrice();
    }

}
