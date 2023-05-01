package pageObjects.avSelenium;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

@Log4j
public class CarPage extends BasePage {
    private final By priceChangesBtn = By.xpath("//button[contains(@class, 'card__price')]");
    private final By priceChangesBox = By.xpath("//div[contains(text(), 'цены')]");
    private final By closePriceChangesBoxBtn = By.xpath("//div[contains(@class, 'flexible')]/div/button");
    private final By carDescription = By.xpath("//h1[@class='card__title']");
    private final By counterCarViews = By.xpath("//span[@class='card__view']");

    public CarPage clickPriceChangesBtn() {
        log.debug("CLick price changes btn");
        click(priceChangesBtn);
        return this;
    }

    public CarPage verifyPriceChangesBox() {
        log.debug("Verify price changes box is displayed");
        Assert.assertTrue(findElement(priceChangesBox).isEnabled());
        return this;
    }

    public CarPage verifyPriceChangesBoxText() {
        log.debug("Verify price changes box text");
        Assert.assertTrue(findElement(priceChangesBox).getText().contains("Изменения цены"));
        return this;
    }

    public CarPage clickClosePriceChangesBoxBtn() {
        log.debug("Click close price changes box");
        click(closePriceChangesBoxBtn);
        return this;
    }

    public String getCarNumberAd() {
        log.debug("Get car number ad");
        String[] data = getPageUrl().split("/");
        return data[5];
    }

    public String getCarDescription() {
        log.debug("Get car description");
        return findElement(carDescription).getText();
    }

    public String getCarViews() {
        log.debug("Get car views");
        return findElement(counterCarViews).getText();
    }
}
