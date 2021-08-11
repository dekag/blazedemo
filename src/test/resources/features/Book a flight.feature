#Feature to test the booking functionality pprovided all the required information
#Author: Gautam Deka
@Functional
Feature: Book a flight

  Background: 
    Given user navigates to Simple Travel Agency
    Then verify the home page is loaded

  @SC1
  Scenario Outline: Book a flight with valid data
    When user enters the deparature city as "<DepartureCity>"
    And user enters the destination city ad "<DestinationCity>"
    And clicks on Find FLights
    Then user is able to view the flights from "<DepartureCity>" to "<DestinationCity>"
    And verify flight details is displayed correctly
    When user clicks on Choose the Flight option for the flight number "<FlightNumber>"
    #There is a bug on the purchase page, the flight number is different from the reserve page
    Then user is able to view the purchase page with the selected flight number "<FlightNumber>"
    When user enters the below user information to purchase the flight
      | Name | Address    | City   | State | Zip    |
      | Test | 1234 Sreet | Mumbai | MH    | 400001 |
    And user enters the below card information to purchase the flight
      | Card Type | CreditCardNumber | Month | Year | Name On Card |
      | Visa      |        123456789 |    07 | 2021 | Test Test    |
    And user clicks on Purchase flight
    Then verify the confirmation page is displayed
    And verify the booking status is "PendingCapture"

    Examples: 
      | DepartureCity | DestinationCity | FlightNumber |
      | Paris         | Rome            |         9696 |
      | Portland      | London          |         4346 |

  @SC2
  Scenario Outline: Select different flight with page navigation
    When user enters the deparature city as "<DepartureCity>"
    And user enters the destination city ad "<DestinationCity>"
    And clicks on Find FLights
    Then user is able to view the flights from "<DepartureCity>" to "<DestinationCity>"
    And verify flight details is displayed correctly
    When user clicks on Choose the Flight option for the flight number "<FlightNumber>"
    #There is a bug on the purchase page, the flight number is different from the reserve page
    Then user is able to view the purchase page with the selected flight number "<FlightNumber>"
    When user enters the below user information to purchase the flight
      | Name | Address    | City   | State | Zip    |
      | Test | 1234 Sreet | Mumbai | MH    | 400001 |
    And user enters the below card information to purchase the flight
      | Card Type | CreditCardNumber | Month | Year | Name On Card |
      | Visa      |        123456789 |    07 | 2021 | Test Test    |
    And User selects Remember Me checkbox
    When user navigates back to reserve flight page
    Then user is able to view the flights from "<DepartureCity>" to "<DestinationCity>"
    And verify flight details is displayed correctly
    When user clicks on Choose the Flight option for the flight number "<NewFlightNumber>"
    Then user is able to view the purchase page with the selected flight number "<NewFlightNumber>"
    #Bug - user info and card info details are not captured
    And user clicks on Purchase flight
    Then verify the confirmation page is displayed
    And verify the booking status is "PendingCapture"

    Examples: 
      | DepartureCity | DestinationCity | FlightNumber | NewFlightNumber |
      | San Diego     | New York        |           43 |             234 |

  #User Information on confirmation page is not captured correctly
  @SC3 @NotAutomated
  Scenario Outline: Validate the user information on confirmation page
    When user enters the deparature city as "<DepartureCity>"
    And user enters the destination city ad "<DestinationCity>"
    And clicks on Find FLights
    Then user is able to view the flights from "<DepartureCity>" to "<DestinationCity>"
    And verify flight details is displayed correctly
    When user clicks on Choose the Flight option for the flight number "<FlightNumber>"
    #There is a bug on the purchase page, the flight number is different from the reserve page
    Then user is able to view the purchase page with the selected flight number "<FlightNumber>"
    When user enters the below user information to purchase the flight
      | Name | Address    | City   | State | Zip    |
      | Test | 1234 Sreet | Mumbai | MH    | 400001 |
    And user enters the below card information to purchase the flight
      | Card Type | CreditCardNumber | Month | Year | Name On Card |
      | Visa      |        123456789 |    07 | 2021 | Test Test    |
    And user clicks on Purchase flight
    Then verify the confirmation page is displayed
    And verify the booking status is "PendingCapture"
    And verify the user information on the confirmation page

    Examples: 
      | DepartureCity | DestinationCity | FlightNumber |
      | San Diego     | New York        |           43 |

  #Card Information on confirmation page is not captured correctly
  @SC4 @NotAutomated
  Scenario Outline: Validate the card information on confirmation page
    When user enters the deparature city as "<DepartureCity>"
    And user enters the destination city ad "<DestinationCity>"
    And clicks on Find FLights
    Then user is able to view the flights from "<DepartureCity>" to "<DestinationCity>"
    And verify flight details is displayed correctly
    When user clicks on Choose the Flight option for the flight number "<FlightNumber>"
    #There is a bug on the purchase page, the flight number is different from the reserve page
    Then user is able to view the purchase page with the selected flight number "<FlightNumber>"
    When user enters the below user information to purchase the flight
      | Name | Address    | City   | State | Zip    |
      | Test | 1234 Sreet | Mumbai | MH    | 400001 |
    And user enters the below card information to purchase the flight
      | Card Type | CreditCardNumber | Month | Year | Name On Card |
      | Visa      |        123456789 |    07 | 2021 | Test Test    |
    And user clicks on Purchase flight
    Then verify the confirmation page is displayed
    And verify the booking status is "PendingCapture"
    And verify the card information on the confirmation page

    Examples: 
      | DepartureCity | DestinationCity | FlightNumber |
      | San Diego     | New York        |           43 |
