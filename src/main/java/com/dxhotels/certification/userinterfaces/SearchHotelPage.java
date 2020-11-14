package com.dxhotels.certification.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SearchHotelPage extends PageObject {
    public static final Target LOCATION = Target.the(" field containing hotel location").locatedBy("//span[contains(text(), 'Location')]/parent::*/parent::*/parent::*//input[@class='dx-texteditor-input']");
    public static final Target SELECT_VALUE = Target.the(" A value is selected").locatedBy("//div[@role='option']/div[contains(text(), '{0}')]");
    public static final Target ROOMS = Target.the(" field containing hotel location").locatedBy("//input[contains(@id, '_rooms')]");
    public static final Target CHECK_IN = Target.the("Field containing the date of entry to the hotel").locatedBy("//input[contains(@id, '_checkIn')]");
    public static final Target CHECK_OUT = Target.the("Bield containing the date of departure from the hotel").locatedBy("//input[contains(@id, '_checkOut')]");
    public static final Target BTN_SEARCH = Target.the("Button to search").locatedBy("//span[contains(text(), 'SEARCH')]");
    public static final Target HOTELS_PRICE = Target.the("Field with the hotel price").locatedBy("//div[@class='night-button']//child::p");
    public static final Target LOWER_PRICE = Target.the("Field with the lowest price").locatedBy("//div[@class='night-button']//child::p[contains(text(),'{0}')]/parent::div/parent::div/div//child::span");
    public static final Target PRICE_PER_DAY = Target.the("Field with the lowest price").locatedBy("//h4[@class='price'][1]");
    public static final Target DATE_CHECK_IN = Target.the("Field containing the date of entry to the hotel").locatedBy("//p[@class='check-in']");
    public static final Target DATE_CHECK_OUT = Target.the("Field containing the date of entry to the hotel").locatedBy("//p[@class='check-out']");

public static final Target TOTAL_PRICE = Target.the("Field containing the date of entry to the hotel").locatedBy("//h4[@class= 'total-price']");



}
