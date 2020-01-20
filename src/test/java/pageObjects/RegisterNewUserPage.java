package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.StringUtils;

import java.util.concurrent.TimeUnit;

public class RegisterNewUserPage extends BasePage {

    private WebDriver driver;

    public RegisterNewUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openPage() {
        driver.manage().window().maximize();
        driver.get("http://demoqa.com/registration/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void fillIn(String fieldName, String text) {
        By by;
        WebElement element;
        boolean isEmail = false;
        boolean isPhoneNumber = false;
        switch(fieldName) {
            case "firstName":
                by = By.id("name_3_firstname");
                break;
            case "lastName":
                by = By.id("name_3_lastname");
                break;
            case "email":
                by = By.id("email_1");
                isEmail = true;
                break;
            case "phoneNumber":
                by = By.id("phone_9");
                isPhoneNumber = true;
                break;
            case "username":
                by = By.id("username");
                break;
            case "password":
                by = By.id("password_2");
                break;
            case "confirmPassword":
                by = By.id("confirm_password_password_2");
                break;
            case "profilePicture":
                by = By.id("profile_pic_10");
                break;
            case "description":
                by = By.id("description");
                break;
            default:
                throw new IllegalArgumentException("Invalid fieldName");

        }

        if (isEmail || isPhoneNumber) {
            if (isEmail) {
                if (StringUtils.isValidEmail(text)) {
                    element = driver.findElement(by);
                    enterText(element, text);
                } else {
                    throw new IllegalArgumentException("Please provide a valid e-mail address");
                }
            }
            if (isPhoneNumber) {
                if (StringUtils.isValidPhoneNumber(text)) {
                    element = driver.findElement(by);
                    enterText(element, text);
                } else {
                    throw new IllegalArgumentException("Please provide a valid phone number");
                }
            }
        } else {
            element = driver.findElement(by);
            enterText(element, text);
        }
    }

    public void selectMaritalStatus(String maritalStatus) {
        WebElement element;
        By by;
        switch (maritalStatus.toLowerCase()) {
            case "single":
                by = By.xpath(".//*[@name='radio_4[]'][1]");
                break;
            case "married":
                by = By.xpath(".//*[@name='radio_4[]'][2]");
                break;
            case "divorced":
                by = By.xpath(".//*[@name='radio_4[]'][3]");
                break;
            default:
                throw new IllegalArgumentException("Invalid fieldName");
        }
        element = driver.findElement(by);
        click(element);
    }

    public void selectHobby(String hobbyName) {
        WebElement element;
        By by;
        switch (hobbyName.toLowerCase()) {
            case "dance":
                by = By.xpath("(//input[@name='checkbox_5[]'])[1]");
                break;
            case "reading":
                by = By.xpath("(//input[@name='checkbox_5[]'])[2]");
                break;
            case "cricket":
                by = By.xpath("(//input[@name='checkbox_5[]'])[3]");
                break;
            default:
                throw new IllegalArgumentException("Invalid fieldName");
        }
        element = driver.findElement(by);
        click(element);
    }

    public void selectBirthdayInCalendar(String birthday) {
        chooseValue(By.id("mm_date_8"), "01");
        chooseValue(By.id("dd_date_8"), "01");
        chooseValue(By.id("yy_date_8"), "1992");
    }

    public void clickSubmitButton() {
        click(driver.findElement(By.name("pie_submit")));
    }

    public void assertRegistrationCompleted() {
        assertDisplayed(driver.findElement(By.className("piereg_login_error")));
    }
}
