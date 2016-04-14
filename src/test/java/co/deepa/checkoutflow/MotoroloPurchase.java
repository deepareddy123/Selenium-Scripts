package co.deepa.checkoutflow;

import co.deepa.CustomLocomotive;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by admin on 4/9/2016.
 */
@Config(browser = Browser.CHROME,
        url = "http://www.amazon.in")

public class MotoroloPurchase extends CustomLocomotive {

    public String categoryDropdown = "#nav-link-shopall > span.nav-line-2 > span";
    public String androidMobiles = "#shopAllLinks > tbody > tr > td:nth-child(1) > div:nth-child(5) > ul > li:nth-child(3) > a";
    public String checkboxMotorolo = "#ref_3837712031 > li:nth-child(2) > a";
    public String sort = "#sort";
    public String sortByLowPriceOptionValue = "price-asc-rank";
    public String allProducts = ".s-result-item.celwidget ";
    public String pincodeArea = "#ddmSelectedAddressText";
    public String pincode = "#ddmZipCodeInput";
    public String updatePincode = "#ddmZipCodeUpdateBtn > span > input";
    public String addToCart = "#add-to-cart-button";
    public String recommendedProduct = "#huc-first-upsell-row > div.a-row.huc-position-rel > div > div:nth-child(1) > div > div > a";
    public String addRecommendedProduct = ".a-box  #add-to-cart-button";
    public String proceedToCheckout = "#hlb-ptc-btn-native";
    public static String signInLink = "#nav-link-yourAccount";
    public static String email = "#ap_email";
    public static String password = "#ap_password";
    public static String signInButton = "#signInSubmit";
    public static String usersOrdersDropdown = "#nav-link-yourAccount";
    public String errorMessage = "#auth-error-message-box > div > div > ul > li > span";
    public String logout = "#nav-item-signout";
    public String lastMobile = "div > div:nth-child(3) > div.a-row.a-spacing-none > a";

    public static final int TIME_OUT = 15;
    public static final int SLEEP_INTERVAL = 15;


    @Test
    public void ifUserLoggedIn() {
        driver.manage().window().maximize();
        hoverOver(usersOrdersDropdown);
        List<WebElement> logoutElement = driver.findElements(By.cssSelector(logout));
        if (logoutElement.size()>0) {
            logoutElement.get(0).click();
            log.info("Logged out");
            waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(signInButton)), TIME_OUT,SLEEP_INTERVAL);
            navigateTo(configuration.url());
        }
        click(categoryDropdown);
        click(androidMobiles);
        isChecked(checkboxMotorolo);
        click(checkboxMotorolo);
        selectOptionByValue(sort, sortByLowPriceOptionValue);
        log.debug("Motorola phones sorted");
        waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(allProducts)), TIME_OUT,SLEEP_INTERVAL);
        WebElement element = getLastElement(allProducts);
        String lastMobileUrl = element.findElement(By.cssSelector(lastMobile)).getAttribute("href");
        log.debug("wait is over");
        element.findElement(By.cssSelector(lastMobile)).click();
        lastMobileUrl = lastMobileUrl.substring(0, lastMobileUrl.lastIndexOf("/"));
        log.debug(lastMobileUrl);
        waitForWindow(lastMobileUrl);
        log.debug("Navigated to new tab");
        click(pincodeArea);
        log.debug(isPresent(pincode));
        click(pincode);
        log.debug("clicked on pincode input");
        setText(pincode, "560013");
        click(updatePincode);
        click(addToCart);
        click(recommendedProduct);
        log.debug("Selected recommended product");
        click(addRecommendedProduct);
        log.debug("Add recom. prod.  cart");
        click(proceedToCheckout);
        log.debug("Proceeded to checkout");
        setText(email,"careers.floh.in");
        setText(password,"Test@123");
        click(signInButton);
        log.debug("Signed in with invalid credentials");
        validateText(errorMessage,"Your email or password was incorrect. Please try again.");
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
        log.info("Browser closed");
    }
}

