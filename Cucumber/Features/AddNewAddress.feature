Feature: Add new address
  Scenario Outline: Login to account and add new address
    Given "Open page https://prod-kurs.coderslab.pl/"
    When "Sign in" link clicked
    And Fill "email" form with <drwkpoeygkqypbvmtf@bptfp.com>
    And Fill "password" form with <12345>
    And Click "Sign in" button
    And Click "Addresses" button
    And Click "Add First Address" button
    And Fill "Address" with <Rzeczna>
    And Fill "Zip/Postal Code" with <20-200>
    And Fill "City" with <Katowice>
    And Fill "Country" with <United Kingdom>
    Then Click button "Save"

    Examples:
      |Address        |Rzeczna|
      |Zip/Postal Code|20-200|
      |City           |Katowice|
      |Country        |United Kingdom|
