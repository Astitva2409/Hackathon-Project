package PageClasses;

import BaseClasses.PageBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EnterprisePage extends PageBaseClass {

    public EnterprisePage(WebDriver driver) {
        this.driver = driver;
    }

    public CampusPage clickElement(String xpath) {
        WebElement campusBtn = driver.findElement(By.xpath(xpath));
        campusBtn.click();
        return PageFactory.initElements(driver, CampusPage.class);
    }
}
