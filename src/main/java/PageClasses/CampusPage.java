package PageClasses;

import BaseClasses.PageBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CampusPage extends PageBaseClass {

    public CampusPage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactUsPage clickElement(String xpath) {
        WebElement contactBtn = driver.findElement(By.xpath(xpath));
        contactBtn.click();
        return PageFactory.initElements(driver, ContactUsPage.class);
    }
}
