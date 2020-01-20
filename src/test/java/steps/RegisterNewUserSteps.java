package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageObjects.RegisterNewUserPage;

import static core.DriverHelper.getDriver;

public class RegisterNewUserSteps {

    RegisterNewUserPage currentPage;

    @Given("I want to register a new user")
    public void iWantToRegisterANewUser() throws Throwable{
        currentPage = new RegisterNewUserPage(getDriver());
        currentPage.openPage();
    }

    @When("I fill in {string} with {string}")
    public void iFillInFieldWith(String fieldName, String value) throws Throwable {
        currentPage.fillIn(fieldName, value);
    }

    @And("I select {string} as a marital_status")
    public void iSelectAMaritalStatus(String maritalStatus) throws Throwable {
        currentPage.selectMaritalStatus(maritalStatus);
    }

    @And("I select {string} as a hobby")
    public void iSelectAHobby(String hobby) throws Throwable {
        currentPage.selectHobby(hobby);
    }

    @And("I fill in country with {string}")
    public void iSelectACountry(String country) throws Throwable {
        currentPage.chooseValue(By.id("dropdown_7"), country);
    }

    @And("I fill in birthday with {string}")
    public void iFillInBirthday(String birthday) throws Throwable {
        currentPage.selectBirthdayInCalendar(birthday);
    }

    @Then("I click on submit button")
    public void iClickOnSubmitButton() {
        currentPage.clickSubmitButton();
        currentPage.assertRegistrationCompleted();
    }
}
