package stepdefs;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jbehave.core.annotations.Given;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import util.ElementUtils;


public class GoogleStepdefs extends Steps{

   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    private ElementUtils elementUtils =(ElementUtils) context.getBean("util");
    private SelenideElement thisLink;

    @Given("User is on google page")
    public void givenUserIsOnGooglePage(){
       elementUtils.openLinkInChrome("https://www.google.by");
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
        //$$(By.className("r")).shouldHave(size(11));
        thisLink = links.first();
        Thread.sleep(3000);
        thisLink.click();
        Thread.sleep(3000);
    }
    @Then("Link should contain search text '$searchText'")
    public void thenLinkContainSearchText(@Named("searchText") String searchText){
        String nameOfTitle;
        nameOfTitle = thisLink.getSelectedText();
        elementUtils.cheakTitle(nameOfTitle,searchText);
    }
}
