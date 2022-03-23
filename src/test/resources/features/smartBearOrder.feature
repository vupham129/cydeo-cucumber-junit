Feature: SmartBear order process


  @wip
  Scenario Outline: SmartBear order process
    Given User is logged into SmartBear Tester account and on Order page
    When  User fills out the form as followed from the table below:
    And   User selects “<product>” from product dropdown
    And   User enters <quantity> to quantity
    And   User enters “<customerName>” to costumer name
    And   User enters “<street>” to street
    And   User enters “<city>” to city
    And   User enters “<state>” to state
    And   User enters <zip> to zip
    And   User selects “<cardType>” as card type
    And   User enters “<cardNumber>” to card number
    And   User enters “<expirationDate>” to expiration date
    And   User clicks process button
    Then  User verifies “<expectedCustomerName>” is in the list

    Examples: Order list
      | product     | quantity | customerName  | street    | city    | state | zip   | cardType | cardNumber  | expirationDate | expectedCustomerName |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |
      | FamilyAlbum | 4        | Joey Tribbiani | State st  | Chicago | IL    | 60656 | Visa     | 12343353336  | 12/22           | Joey Tribbiani         |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | IL    | 60004 | Visa     | 313313133315 | 12/22           | Ken Adams              |