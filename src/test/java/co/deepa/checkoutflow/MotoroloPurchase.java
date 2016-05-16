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
        url = "https://www.amazon.in")

public class MotoroloPurchase extends CustomLocomotive {

    public static final int TIME_OUT = 15;
    public static final int SLEEP_INTERVAL = 15;


    @Test
    public void purchaseMotoRolo() {
        driver.manage().window().maximize();
        hoverOver(ObjectRepository.usersOrdersDropdown);
        List<WebElement> logoutElement = driver.findElements(By.cssSelector(ObjectRepository.logout));
        if (logoutElement.size()>0) {
            logoutElement.get(0).click();
            log.info("Logged out");
            waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(ObjectRepository.signInButton)), TIME_OUT,SLEEP_INTERVAL);
            navigateTo(configuration.url());
        }
        click(ObjectRepository.categoryDropdown);
        click(ObjectRepository.androidMobiles);
        isChecked(ObjectRepository.checkboxMotorolo);
        click(ObjectRepository.checkboxMotorolo);
        selectOptionByValue(ObjectRepository.sort, ObjectRepository.sortByLowPriceOptionValue);
        log.debug("Motorola phones sorted");
        waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(ObjectRepository.allProducts)), TIME_OUT,SLEEP_INTERVAL);
        WebElement element = getLastElement(ObjectRepository.allProducts);
        String lastMobileUrl = element.findElement(By.cssSelector(ObjectRepository.lastMobile)).getAttribute("href");
        log.debug("wait is over");
        element.findElement(By.cssSelector(ObjectRepository.lastMobile)).click();
        lastMobileUrl = lastMobileUrl.substring(0, lastMobileUrl.lastIndexOf("/"));
        log.debug(lastMobileUrl);
        waitForWindow(lastMobileUrl);
        log.debug("Navigated to new tab");
        click(ObjectRepository.pincodeArea);
        log.debug(isPresent(ObjectRepository.pincode));
        click(ObjectRepository.pincode);
        log.debug("clicked on pincode input");
        setText(ObjectRepository.pincode, "560013");
        click(ObjectRepository.updatePincode);
        click(ObjectRepository.addToCart);
        click(ObjectRepository.recommendedProduct);
        log.debug("Selected recommended product");
        click(ObjectRepository.addRecommendedProduct);
        log.debug("Add recom. prod.  cart");
        click(ObjectRepository.proceedToCheckout);
        log.debug("Proceeded to checkout");
        setText(ObjectRepository.loginemail,"careers.floh.in");
        setText(ObjectRepository.loginpassword,"Test@123");
        click(ObjectRepository.signInButton);
        log.debug("Signed in with invalid credentials");
        validateText(ObjectRepository.errorMessage,"Your email or password was incorrect. Please try again.");
    }

    @AfterTest
    public void teardown()
    {
       // driver.quit();
        log.info("Browser closed");
    }
}

