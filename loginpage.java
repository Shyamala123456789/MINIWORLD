package pages;

import enums.UserEnum;
import interfaces.ISelector;
import org.openqa.selenium.By;
import utils.CommonUtils;

import static org.testng.Assert.assertTrue;

public class LoginPage extends CommonUtils{

    private static final String baseURL = "https://the-internet.herokuapp.com";
    private static final String login = "/login";
    private static final String pageTitle = "LOGIN_PAGE: ";

    public void navigateToLoginPage(){
        System.out.println(pageTitle + "Navigating to the Login page...");
        navigateToURL(baseURL + login);
    }

    public void enterUserName(String user) {
        waitForElementToBeVisible(LoginPageEnum.USERNAME.selector());
        System.out.println(pageTitle + "Entering username.");
        sendKeys(LoginPageEnum.USERNAME.selector(), user);
    }

    public void enterPassword(String password) {

        waitForElementToBeVisible(LoginPageEnum.PASSWORD.selector());
        System.out.println(pageTitle + "Enter password.");
        sendKeys(LoginPageEnum.PASSWORD.selector(), password);
    }

    public void logIntoPage(UserEnum user){

        String username = user.getUserName();
        String password = user.getPassword();

        enterUserName(username);
        enterPassword(password);
        waitForElementToBeClickable((LoginPageEnum.LOGIN_BUTTON.selector()));
        click(LoginPageEnum.LOGIN_BUTTON.selector());
    }
