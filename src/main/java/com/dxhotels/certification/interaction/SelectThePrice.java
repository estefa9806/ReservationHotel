package com.dxhotels.certification.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.dxhotels.certification.userinterfaces.SearchHotelPage.HOTELS_PRICE;
import static com.dxhotels.certification.userinterfaces.SearchHotelPage.LOWER_PRICE;


public class SelectThePrice implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> hotelPrice = new ArrayList<>();
        Comparator<Integer> priceComparator = Collections.reverseOrder();

        for (int i=0;i<HOTELS_PRICE.resolveAllFor(actor).size();i++) {
            hotelPrice.add(i,HOTELS_PRICE.resolveAllFor(actor).get(i).getText().replace(".","").replace("$","").trim());
        }

        List<Integer> orderedPrices = new ArrayList<>(hotelPrice.size());
        for(String current:hotelPrice){
            orderedPrices.add(Integer.parseInt(current));
        }
        Collections.sort(orderedPrices, priceComparator);
        String lowerValue=String.valueOf((orderedPrices.get(HOTELS_PRICE.resolveAllFor(actor).size()-1)));
        actor.attemptsTo(Click.on(LOWER_PRICE.of(lowerValue)));
    }

    public static SelectThePrice moreAccessible(){
        return Tasks.instrumented(SelectThePrice.class);
    }
}
