# new feature
# Tags: optional
@Ui
    
Feature: Subscription package validation
    
Scenario: Validate Packages – Type & Price and Currency for all Countries (SA /Kuwait and Baharin)
    Given Open Browser and navigate to application
    When Click on English tab to select Language and Select the <country>
    Then Verify the <packageType> and <monthlyPrice> and <currency> for selected Country

Examples:
    | country | packageType | monthlyPrice | currency |
    | Bahrain | LITE:CLASSIC:PREMIUM | 2:3:6 | BHD/month |
    | KSA | LITE:CLASSIC:PREMIUM | 15:25:60 | SAR/month |
    | Kuwait | LITE:CLASSIC:PREMIUM | 1.2:2.5:4.8 | KWD/month |