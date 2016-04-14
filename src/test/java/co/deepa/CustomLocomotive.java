package co.deepa;

import io.ddavison.conductor.Locomotive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by admin on 4/9/2016.
 */
public class CustomLocomotive extends Locomotive {

    public WebElement getLastElement(String cssSelector) {
        return getLastElement(By.cssSelector(cssSelector));
    }

    public WebElement getLastElement(By by) {
        List<WebElement> allProducts = driver.findElements(by);
        return allProducts.get(allProducts.size() - 1);
    }
}

