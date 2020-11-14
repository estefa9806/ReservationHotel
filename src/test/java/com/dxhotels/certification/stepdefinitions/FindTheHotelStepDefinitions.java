package com.dxhotels.certification.stepdefinitions;

import com.dxhotels.certification.model.ReservationModel;
import com.dxhotels.certification.questions.ValidatePrice;
import com.dxhotels.certification.tasks.SearchHotel;
import com.dxhotels.certification.tasks.SelectTheHotel;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class FindTheHotelStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Carolina");
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url("https://js.devexpress.com/Demos/DXHotels/#home"));

    }

    @Given("^that Carolina enters the data for the hotel$")
    public void thatCarolinaEntersTheDataForTheHotel(List<ReservationModel> reservationData) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchHotel.inThePage(reservationData));
    }

    @When("^she selects the most economical trip$")
    public void sheSelectsTheMostEconomicalTrip() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectTheHotel.inThePage());
    }


    @Then("^verify that the rate corresponds according to the days selected$")
    public void verifyThatTheRateCorrespondsAccordingToTheDaysSelected() {
        theActorInTheSpotlight().should(seeThat(ValidatePrice.byNumberOfDays(),equalTo(Boolean.TRUE) ));
    }

}
