package co.deepa;

import co.deepa.checkoutflow.ObjectRepository;
import io.ddavison.conductor.Locomotive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static co.deepa.checkoutflow.MotoroloPurchase.*;


/**
 * Created by admin on 4/9/2016.
 */
public class  CustomLocomotive extends Locomotive {

    public WebElement getLastElement(String cssSelector) {
        return getLastElement(By.cssSelector(cssSelector));
    }

    public WebElement getLastElement(By by) {
        List<WebElement> allProducts = driver.findElements(by);
        if (allProducts.size()>0) {
            return allProducts.get(allProducts.size() - 1);
        } else {
            return null;
        }
    }

    public void logout(){
        List<WebElement> logoutElement = driver.findElements(By.cssSelector(ObjectRepository.logout));
        if (logoutElement.size()>0) {
            logoutElement.get(0).click();
            log.info("Logged out");
            waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(ObjectRepository.signInButton)), TIME_OUT,SLEEP_INTERVAL);
            navigateTo(configuration.url());
        }}
}

