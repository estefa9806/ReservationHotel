package com.dxhotels.certification.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/find_the_hotel.feature",
        glue = {"com.dxhotels.certification.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class FindTheHotelRunner {
}
