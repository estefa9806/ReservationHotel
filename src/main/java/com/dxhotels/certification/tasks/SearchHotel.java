package com.dxhotels.certification.tasks;

import com.dxhotels.certification.model.ReservationModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static com.dxhotels.certification.userinterfaces.SearchHotelPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchHotel implements Task {
    private List<ReservationModel> reservation;

    public SearchHotel(List<ReservationModel> reservation) {
        this.reservation = reservation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ReservationModel reservationData=reservation.get(0);
        actor.attemptsTo(
                Check.whether(CurrentVisibility.of(LOCATION).viewedBy(actor).asBoolean()).
                        andIfSo(Click.on(LOCATION)).
                        otherwise(),
                WaitUntil.the(SELECT_VALUE.of(reservationData.getLocation()), isVisible()));
        actor.attemptsTo(
                Check.whether(CurrentVisibility.of(SELECT_VALUE.of(reservationData.getLocation())).viewedBy(actor).asBoolean()).
                        andIfSo(Click.on(SELECT_VALUE.of(reservationData.getLocation()))).otherwise(),
                WaitUntil.the(CHECK_OUT, isVisible()),
                Check.whether(CurrentVisibility.of(CHECK_OUT).viewedBy(actor).asBoolean()).
                        andIfSo(Enter.theValue(reservationData.getCheckOut()).into(CHECK_OUT)).
                        otherwise(),
                Check.whether(CurrentVisibility.of(CHECK_IN).viewedBy(actor).asBoolean()).
                        andIfSo(Enter.theValue(reservationData.getCheckIn()).into(CHECK_IN)).
                        otherwise(),
                Check.whether(CurrentVisibility.of(ROOMS).viewedBy(actor).asBoolean()).
                        andIfSo(Click.on(ROOMS)).
                        otherwise(),
                Check.whether(CurrentVisibility.of(SELECT_VALUE.of("1")).viewedBy(actor).asBoolean()).
                        andIfSo(Click.on(SELECT_VALUE.of("1"))).otherwise(), Click.on(BTN_SEARCH));


    }

    public static SearchHotel inThePage(List<ReservationModel> reservation) {
        return Tasks.instrumented(SearchHotel.class, reservation);

    }
}
