package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jbehave.core.annotations.Given;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;

public class GoogleStepdefs extends Steps{

    @Given("User is on google page")
    public void givenUserIsOnGooglePage(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.by";
        Configuration.timeout = 10000;
        open(Configuration.baseUrl);
    }

    @When("User enters '$searchText' in search field")
    public void whenUserEntersInSearchField(@Named("searchText") String searchText){
        $(By.id("lst-ib")).sendKeys(searchText);
    }
    @When("User clicks Search button")
    public void whenUserClicksSearchButton(){
        $(By.name("btnK")).submit();
    }

    @Then("User clicks first link")
    public void thenUserClicksLink() throws InterruptedException {
        ElementsCollection links = $$(By.className("r"));
        SelenideElement thisLink = links.first();
        thisLink.click();
        Thread.sleep(3000);
    }
}
