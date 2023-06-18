package PageClasses;

import BaseClasses.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBaseClass {

    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;
    @FindBy(id = "Title")
    public WebElement jobTitle;
    @FindBy(id = "Primary_Discipline__c")
    public WebElement primaryDiscipline;
    @FindBy(id = "Email")
    public WebElement workEmail;
    @FindBy(id = "Phone")
    public WebElement phone;
    @FindBy(id = "Company")
    public WebElement institutionName;
    @FindBy(id = "Institution_Type__c")
    public WebElement institutionType;
    @FindBy(id = "Country")
    public WebElement country;
    @FindBy(id = "State")
    public WebElement state;
    @FindBy(id = "What_the_lead_asked_for_on_the_website__c")
    public WebElement description;
    @FindBy(id = "rentalField5")
    public WebElement brief;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitBtn;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String[][] data) {
        setFirstName(firstName, data[0][0]);
        setLastName(lastName, data[0][1]);
        setJobTitle(jobTitle, data[0][2]);
        setPrimaryDiscipline(primaryDiscipline, data[0][3]);
        setEmail(workEmail, data[0][4]);
        setPhone(phone, data[0][5]);
        setInstitutionName(institutionName, data[0][6]);
        setInstitutionType(institutionType, data[0][7]);
        setCountry(country, data[0][8]);
        setState(state, data[0][9]);
        setDescription(description, data[0][10]);
        setBrief(brief, data[0][11]);
        clickSubmitBtn(submitBtn);
    }
}
