package base;

import global.Global;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

/**
 * Created by admin.son.ton on 1/23/18.
 */
public class PageObject {

    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 60;
    private int FLAG = 0;

    protected PageObject() {
        driver = Global.getBrowser().getWebDriver();
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilPageReady(){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitUntilJqueryReady(){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0").equals(true));
    }

    protected void scrollToView(WebElement ele){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
    }

    protected void hover(WebElement ele){
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }

    protected void switchToFrame(WebElement iframe){
        driver.switchTo().frame(iframe);
    }

    protected void waitUntilNotVisible(WebElement ele) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(ele));
    }

    protected String currentUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement findDynamicElement(By by) {
        return driver.findElement(by);
    }

    protected void waitUntilPresentOfElementBy(By by) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitUntilClickable(By by) {
        waitUntilClickable(by,DEFAULT_TIMEOUT);
    }
    
    protected void waitUntilClickable(By by, int timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitUntilVisibility(By by) {
        //not exist && not visible
        waitUntilVisibility(by,DEFAULT_TIMEOUT);
    }

    protected void waitUntilVisible(WebElement ele) {
        // Exist in DOM but not visible on Actual Page.
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(ele));
    }

    protected void waitUntilVisibility(By by, int timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilLocated(By by) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilInvisibilityOf(By by) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitLongUntilInvisibilityOf(By by, int time) {
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void clickWithoutException (WebElement ele) { // This method is used to click on the element by avoiding any kind of exception
      int FLAG = 0;
        do {
            try {
                Actions action = new Actions(driver);
                hover(ele);
                action.click(ele);
                Action ob = action.build();
                ob.perform();
                FLAG =11;
            } catch (Exception ex) {
                FLAG++;
            }
        } while (FLAG <=10);
    }

    protected int getRandom(int size) { // This method returns the random number of the given bound
        Random rand = new Random();
        return rand.nextInt((size-1));
    }

    protected void clearText(WebElement ele){
        ele.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),Keys.DELETE);
    }

    protected boolean isExist(By bySelector) {
        return driver.findElements(bySelector).size() > 0;
    }
}
