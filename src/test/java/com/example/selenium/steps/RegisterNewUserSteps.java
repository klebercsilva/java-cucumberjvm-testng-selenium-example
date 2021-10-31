package com.example.selenium.steps;

import com.example.selenium.pageObjects.RegisterNewUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterNewUserSteps {

    @Autowired
    private RegisterNewUserPage currentPage;

    @Given("I want to register a new user")
    public void iWantToRegisterANewUser() {
        currentPage.openPage();
    }

    @When("I fill in {string} with {string}")
    public void iFillInFieldWith(String fieldName, String value) {
        currentPage.fillIn(fieldName, value);
    }

    @And("I select {string} as a marital_status")
    public void iSelectAMaritalStatus(String maritalStatus) {
        currentPage.selectMaritalStatus(maritalStatus);
    }

    @And("I select {string} as a hobby")
    public void iSelectAHobby(String hobby) {
        currentPage.selectHobby(hobby);
    }

    @And("I fill in country with {string}")
    public void iSelectACountry(String country) {
        currentPage.chooseValue(By.id("dropdown_7"), country);
    }

    @And("I fill in birthday with {string}")
    public void iFillInBirthday(String birthday) {
        currentPage.selectBirthdayInCalendar(birthday);
    }

    @Then("I click on submit button")
    public void iClickOnSubmitButton() {
        currentPage.clickSubmitButton();
        currentPage.assertRegistrationCompleted();
    }
}
