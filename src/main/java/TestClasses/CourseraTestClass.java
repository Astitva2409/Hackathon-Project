package TestClasses;

import BaseClasses.PageBaseClass;
import PageClasses.*;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class CourseraTestClass extends PageBaseClass {

    public LandingPage landingPage;
    public CoursePage coursePage;
    public EnterprisePage enterprisePage;
    public CampusPage campusPage;
    public ContactUsPage contactUsPage;
    public String[][] data;

    @Test(priority = 1)
    public void courseraTest() {
        logger = report.createTest("Coursera Test Report");
        invokeBrowser();
        logger.log(Status.PASS, "Opening the chrome browser");
        landingPage = openApplication();
        logger.log(Status.PASS, "Coursera website opened");
        coursePage = landingPage.enterCourseName("//input[@type='text']", "Web Development Courses");
        logger.log(Status.PASS, "Web Development Courses entered in search box");

        coursePage.selectLevel("//span[text()='Beginner']");
        logger.log(Status.PASS, "Beginner level selected");
        coursePage.selectLanguage("//span[text()='English']");
        logger.log(Status.PASS, "Language selected");
        coursePage.printWebCourses("//div[@data-e2e='ProductCard']");
        logger.log(Status.PASS, "printing the first 2 course names, ratings and duration");

        coursePage.enterCourseName("//input[@type='text']", "Language Learning");
        logger = report.createTest("Language Learning entered in search box");

        System.out.println("\n" + "************************************************");
        System.out.println("Beginner course names");
        System.out.println("*************************************************" + "\n");

        coursePage.selectLevel("//div[@data-testid='Beginner-false']/label/div/span");
        logger.log(Status.PASS, "Beginner level selected");
        coursePage.printCourseNames("//div[@data-e2e='ProductCard']//h2");
        logger.log(Status.PASS, "Beginner level courses printed");
        coursePage.deSelectLevel("//div[@data-testid='Beginner-true']/label/div/span");
        logger.log(Status.PASS, "Beginner level deselected");

        System.out.println("\n" + "************************************************");
        System.out.println("Intermediate course names");
        System.out.println("*************************************************" + "\n");

        coursePage.selectLevel("//div[@data-testid='Intermediate-false']/label/div/span");
        logger.log(Status.PASS, "Intermediate level selected");
        coursePage.printCourseNames("//div[@data-e2e='ProductCard']//h2");
        logger.log(Status.PASS, "Intermediate level courses printed");
        coursePage.deSelectLevel("//div[@data-testid='Intermediate-true']/label/div/span");
        logger.log(Status.PASS, "Beginner level deselected");

        System.out.println("\n" + "************************************************");
        System.out.println("Advanced course names");
        System.out.println("*************************************************" + "\n");

        coursePage.selectLevel("//div[@data-testid='Advanced-false']/label/div/span");
        logger.log(Status.PASS, "Advanced level selected");
        coursePage.printCourseNames("//div[@data-e2e='ProductCard']//h2");
        logger.log(Status.PASS, "Advanced level courses printed");
        coursePage.deSelectLevel("//div[@data-testid='Advanced-true']/label/div/span");
        logger.log(Status.PASS, "Advanced level deselected");

        System.out.println("\n" + "************************************************");
        System.out.println("Mixed course names");
        System.out.println("*************************************************" + "\n");

        coursePage.selectLevel("//div[@data-testid='Mixed-false']/label/div/span");
        logger.log(Status.PASS, "Mixed level selected");
        coursePage.printCourseNames("//div[@data-e2e='ProductCard']//h2");
        logger.log(Status.PASS, "Mixed level courses printed");
        coursePage.deSelectLevel("//div[@data-testid='Mixed-true']/label/div/span");
        logger.log(Status.PASS, "Mixed level deselected");

        quitBrowser();
    }

    @Test(priority = 2)
    public void buisness() throws IOException {
        logger = report.createTest("Buisness Tests");
        invokeBrowser();
        logger.log(Status.PASS, "Opening the chrome browser");
        landingPage = openApplication();
        logger.log(Status.PASS, "Coursera website opened");
        enterprisePage = landingPage.clickOnForBusiness();
        logger.log(Status.PASS, "For Buisness button clicked");
        campusPage = enterprisePage.clickElement("//a[text()='For Campus']");
        logger.log(Status.PASS, "For Campus button clicked");
        contactUsPage = campusPage.clickElement("a[role=button]");
        logger.log(Status.PASS, "Contact US button clicked");
        data = readExcelData(System.getProperty("user.dir") + "//src//main//resources//FormData.xlsx");
        contactUsPage.fillForm(data);
        logger.log(Status.PASS, "Contact Us form filled");
        takeScreenShot();
        logger.log(Status.PASS, "error message screenshot captured");
        quitBrowser();
        logger.log(Status.PASS, "Browser closed");
    }
}
