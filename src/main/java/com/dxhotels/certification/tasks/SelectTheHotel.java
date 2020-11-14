package com.dxhotels.certification.tasks;

import com.dxhotels.certification.interaction.SelectThePrice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectTheHotel  implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectThePrice.moreAccessible());
    }

    public static SelectTheHotel inThePage(){
        return Tasks.instrumented(SelectTheHotel.class);
    }

}
