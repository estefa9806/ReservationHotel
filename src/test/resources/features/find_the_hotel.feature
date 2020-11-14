#Author: estefa9806@gmail.com

Feature: Check hotel rate
  AS Sales Manager
  I WANT to select the cheapest hotel rate according to the destination offered
  TO validate that the total price is correct

    Scenario:Check the hotel rate
    Given  that Carolina enters the data for the hotel
      |Location  |checkIn|CheckOut|
      | Las Vegas | 11/18/2020      |11/30/2020 |
    When she selects the most economical trip
    Then  verify that the rate corresponds according to the days selected

