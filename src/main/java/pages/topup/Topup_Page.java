package pages.topup;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;
import pages.account.Login_Page;

public class Topup_Page extends PageObject {

    private static final String page_url = "http://pdp.lazada.test/mobilerecharge.html";

    @FindBy(css = ".topup-phone-field__input-container input") private WebElement number_field;
    @FindBy(css = ".topup-operators__select") private WebElement operator_field;
    //@FindBy(xpath = "//span[contains(string(), 'dewei_test_topup_vi')]") private WebElement product;
    @FindBy(css = ".topup__submit-button") private  WebElement submit;
    @FindBy(css = ".topup-login-prompt__link") private WebElement login_button;

    private By helloMessage = By.xpath("//span[starts-with(string(), 'Hello,')]");


    public static void visit(String page_url){ Global.browser.goTo(page_url); }

    public Topup_Page(){ super();}

    public void enterNumber(String number)
    {
        this.number_field.sendKeys(number);
    }

    public void selectOperator(int id) {
        operator_field.click();
        By css = By.cssSelector(".next-menu-content li:nth-child("+ id +")");
        waitUntilPresentOfElementBy(css);
        findDynamicElement(css).click();
    }

    public void selectProduct(String nameProduct) throws InterruptedException {
        By xpath = By.xpath("//span[contains(string(), '" + nameProduct + "')]");
        waitUntilPresentOfElementBy(xpath);
        WebElement web = findDynamicElement(xpath);
        waitUntilVisible(web);
        web.click();
    }

    public void selectTab(String nameTab){
        By xpath = By.xpath("//button[contains(string(), '" + nameTab + "')]");
        waitUntilClickable(xpath);
        WebElement web = findDynamicElement(xpath);
        web.click();
    }

    public void pushSubmit(){
        waitUntilVisible(submit);
        submit.click();
    }

    public void openLogIn(String login, String password){
        waitUntilVisible(login_button);
        login_button.click();
        new Login_Page().login(login,password);
    }

    public void checkAfterLogIn(){
        waitUntilPresentOfElementBy(helloMessage);
//        waitUntilElementNotVisibleByXpath(hello_message);
        findDynamicElement(helloMessage).click();
//        getWebDriver().findElement(By.xpath(hello_message));
    }

    public void selectNumberFromList(int id) throws Exception{
        number_field.click();
        By css = By.cssSelector(".expandInDown li:nth-child("+ id +")");
        WebElement number = findDynamicElement(css);
        String listNumber = number.getText();
        number.click();
        String fieldNumber = number_field.getAttribute("value");
        if(!listNumber.equals(fieldNumber)) {
            throw new Exception("Numbers do not match");
        }
    }

    public void selectNumberFromList(String number) throws Exception{
        number_field.click();
        By css = By.xpath("//li[contains(string(), '" + number + "')]");
        WebElement numberWeb = findDynamicElement(css);
        String listNumber = numberWeb.getText();
        numberWeb.click();
        String fieldNumber = number_field.getAttribute("value");
        if(!listNumber.equals(fieldNumber)) {
            throw new Exception("Numbers do not match");
        }
    }
}
