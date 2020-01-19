package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RegisterNewUserSteps {

    private WebDriver driver;
    private String baseUrl = "http://demoqa.com/";

    @Given("I want to register a new user")
    public void iWantToRegisterANewUser() throws Throwable{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/registration/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^I fill in firstName with \"([^\"]*)\"$")
    public void iFillInFirstName(String firstName) throws Throwable {
        driver.findElement(By.id("name_3_firstname")).clear();
        driver.findElement(By.id("name_3_firstname")).sendKeys(firstName);
    }

    @And("^I fill in lastName with \"([^\"]*)\"$")
    public void iFillInLastName(String lastName) throws Throwable {
        driver.findElement(By.id("name_3_lastname")).clear();
        driver.findElement(By.id("name_3_lastname")).sendKeys(lastName);
    }

    @And("^I select \"([^\"]*)\" as a marital_status$")
    public void iSelectAMaritalStatus(String maritalStatus) throws Throwable {
        switch(maritalStatus) {
            case "Single":
                driver.findElement(By.xpath(".//*[@name='radio_4[]'][1]")).click();
                break;
            case "Married":
                driver.findElement(By.xpath(".//*[@name='radio_4[]'][2]")).click();
                break;
            case "Divorced":
                driver.findElement(By.xpath(".//*[@name='radio_4[]'][3]")).click();
                break;
        }
    }

    @And("^I select \"([^\"]*)\" as a hobby$")
    public void iSelectAHobby(String hobby) throws Throwable {
        switch(hobby) {
            case "Dance":
                driver.findElement(By.xpath("(//input[@name='checkbox_5[]'])[1]")).click();
                break;
            case "Reading":
                driver.findElement(By.xpath("(//input[@name='checkbox_5[]'])[2]")).click();
                break;
            case "Cricket":
                driver.findElement(By.xpath("(//input[@name='checkbox_5[]'])[3]")).click();
                break;
        }
    }

    @And("^I fill in country with \"([^\"]*)\"$")
    public void iSelectACountry(String country) throws Throwable {
        new Select(driver.findElement(By.id("dropdown_7"))).selectByVisibleText(country);
    }

    @And("^I fill in birthday with \"([^\"]*)\"$")
    public void iFillInBirthday(String birthday) throws Throwable {
        new Select(driver.findElement(By.id("mm_date_8"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("dd_date_8"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("yy_date_8"))).selectByVisibleText("2000");
    }

    @And("^I fill in phoneNumber with \"([^\"]*)\"$")
    public void iFillInPhoneNumber(String phoneNumber) throws Throwable {
        driver.findElement(By.id("phone_9")).clear();
        driver.findElement(By.id("phone_9")).sendKeys(phoneNumber);
    }

    @And("^I fill in username with \"([^\"]*)\"$")
    public void i_fill_in_username(String username) throws Throwable {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
    }

    @And("^I fill in password with \"([^\"]*)\"$")
    public void iFillInPassword(String password) throws Throwable {
        driver.findElement(By.id("password_2")).clear();
        driver.findElement(By.id("password_2")).sendKeys(password);
    }

    @And("^I fill in confirmPassword with \"([^\"]*)\"$")
    public void i_fill_in_confirmPassword(String confirmPassword) throws Throwable {
        driver.findElement(By.id("confirm_password_password_2")).clear();
        driver.findElement(By.id("confirm_password_password_2")).sendKeys(confirmPassword);
    }

    @And("^I fill in email with \"([^\"]*)\"$")
    public void i_fill_in_email(String email) throws Throwable {
        driver.findElement(By.id("email_1")).clear();
        driver.findElement(By.id("email_1")).sendKeys(email);
    }

    @And("^I fill in profilePicture with \"([^\"]*)\"$")
    public void i_fill_in_profilePicture(String profilePicture) throws Throwable {
        driver.findElement(By.id("profile_pic_10")).sendKeys(profilePicture);
    }

    @And("^I fill in description with \"([^\"]*)\"$")
    public void i_fill_in_description(String description) throws Throwable {
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(description);
    }

    @Then("^I press the submit button and register a new user$")
    public void i_press_the_submit_button_and_register_a_new_user() {
        driver.findElement(By.name("pie_submit")).click();
        driver.findElement(By.className("piereg_login_error")).isDisplayed();
    }
}
