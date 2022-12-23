package stepdef.ui;

import framework.BaseTest;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utility.PageActionLibrary;
import java.util.ArrayList;
import java.util.List;

import static locators.Web.homePage.*;


public class HomeStepDef extends BaseTest {

    @ParameterType(".*")
    public String country(String country) {
        return country;
    }
    @ParameterType(".*")
    public String packageType(String packageType) {
        return packageType;
    }
    @ParameterType(".*")
    public String monthlyPrice(String monthlyPrice) {
        return monthlyPrice;
    }
    @ParameterType(".*")
    public String currency(String currency) {
        return currency;
    }
    @Given("Open Browser and navigate to application")
    public void open_Browser_and_navigate_to() {
        getDriver();
    }
/*
This method is used to click on english language button and select the country
 */
    @When("Click on English tab to select Language and Select the {country}")
    public void click_on_English_tab_to_select_Language_and_Select_the_country(String country)
    {
        PageActionLibrary.clickElement(LANGUAGE_SELECT);
        PageActionLibrary.clickElement(COUNTRY_LIST_BUTTON);
        PageActionLibrary.clickElement(selectCountry(country));
    }

/*
This method is used for validation of package type, monthly price and currency for the selected country.
 */
    @Then("Verify the {packageType} and {monthlyPrice} and {currency} for selected Country")
    public void Verify_the_Packages_Type_and_Price_and_Currency_for_selected_Country(String packageType, String monthlyPrice, String currency)
    {
        String[] expectedPackageList = packageType.split(":");
        String[] expectedPriceList = monthlyPrice.split(":");

        for(int i=0; i<expectedPackageList.length;i++)
        {
            String actualPackageName = PageActionLibrary.getText(getPackage(expectedPackageList[i]));
            String actualPriceName = PageActionLibrary.getText(getPrice(expectedPackageList[i]));
            String actualCurrency = PageActionLibrary.getText(getCurrency(expectedPackageList[i]));

            Assert.assertEquals( actualPackageName, expectedPackageList[i]);
            Assert.assertEquals( actualPriceName, expectedPriceList[i]);
            if(currency.contains( "SAR/month" )) {
                Assert.assertEquals(PageActionLibrary.getText(getCurrenyforKSA(expectedPackageList[i])), currency);
            }
            else {
                Assert.assertEquals( actualCurrency, currency);
            }
        }

        closeDriver();
    }

}
