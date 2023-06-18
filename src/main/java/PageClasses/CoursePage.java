package PageClasses;

import BaseClasses.PageBaseClass;
import org.openqa.selenium.*;

import java.util.List;

public class CoursePage extends PageBaseClass {
    public WebDriver driver;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectLevel(String levelXpath) {
//        driver.findElement(By.xpath(levelXpath)).click();
//        String count = driver.findElement(By.xpath("//span[contains(text(), 'results for')]")).getText();
//        System.out.println(count.substring(0,5));
        try {
            driver.findElement(By.xpath(levelXpath)).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(levelXpath)));
        }
    }

    public void selectLanguage(String langXpath) {
        driver.findElement(By.xpath(langXpath)).click();
    }

    public void enterCourseName(String xpath, String data) {
        WebElement searchBtn = driver.findElement(By.xpath(xpath));
        searchBtn.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        searchBtn.sendKeys(data + Keys.RETURN);
    }

    public void printWebCourses(String coursesXpath) {
        List<WebElement> courses = driver.findElements(By.xpath(coursesXpath));
        for (int i = 0; i < 2; i++) {
            String nameOfCourse = courses.get(i).findElement(By.tagName("h2")).getText();
            String ratingOfCourse = courses.get(i).findElement(By.xpath("//div[2]/div[2]/div[1]/p[1]")).getText();
            String durationOfCourse = courses.get(i).findElement(By.xpath("//div[2]/div[2]/p")).getText();

            System.out.println(nameOfCourse + " " + ratingOfCourse + " " + durationOfCourse);
        }
    }

    public void printCourseNames(String courseNameXpath) {
        List<WebElement> allCourses = driver.findElements(By.xpath(courseNameXpath));
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.println(allCourses.get(i).getText());
        }
    }

    public void deSelectLevel(String levelXpath) {
        try {
            driver.findElement(By.xpath(levelXpath)).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(levelXpath)));
        }
    }
}
