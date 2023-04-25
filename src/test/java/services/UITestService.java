package services;

import constants.AdminConstant;
import constants.ApproverConstant;
import constants.CommonConstant;
import constants.UserConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class UITestService {
    WebDriver driver;

    private final AdminConstant _adminUser;
    private final CommonConstant _commonConstant;
    private final UserConstant _userConstant;
    private final ApproverConstant _approverConstant;

    public UITestService(WebDriver driver) {
        this.driver = driver;
        _adminUser = new AdminConstant();
        _commonConstant = new CommonConstant();
        _userConstant = new UserConstant();
        _approverConstant = new ApproverConstant();
    }

    public void Login(String elementId, String email) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.loginSectionButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.loginSectionButtonXpath)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));
        driver.findElement(By.xpath(elementId)).sendKeys(email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.loginPasswordFieldXpath)));
        driver.findElement(By.xpath(_commonConstant.loginPasswordFieldXpath)).sendKeys("Password12.");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.loginButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.loginButtonXpath)).click();
    }

    public void Wait(String elementId, int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
    }

    public void FindElementClick(String elementId) {
        driver.findElement(By.xpath(elementId)).click();
    }

    public void FindElementWrite(String elementId, String generalText) {

        WebElement textBox = driver.findElement(By.xpath(elementId));
        textBox.clear();
        textBox.sendKeys(generalText);
    }

    public void Notification(int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationSuccessStateTextXpath)));
        WebElement notificationTrue = driver.findElement(By.xpath(_commonConstant.notificationSuccessStateTextXpath));

        String notificationTrueText = notificationTrue.getText();
        System.out.println("Notification text: " + notificationTrueText);

        driver.findElement(By.xpath(_commonConstant.notificationCloseButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationSuccessStateTextXpath)));
        driver.findElement(By.xpath(_commonConstant.notificationCloseButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalCloseButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.modalCloseButtonXpath)).click();

    }

    public void NotificationApprover(int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationSuccessStateTextXpath)));
        WebElement notificationTrue = driver.findElement(By.xpath(_commonConstant.notificationSuccessStateTextXpath));

        String notificationTrueText = notificationTrue.getText();
        System.out.println("Notification text: " + notificationTrueText);

        driver.findElement(By.xpath(_commonConstant.notificationCloseButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalCloseButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.modalCloseButtonXpath)).click();

    }

    public void UserNewRecord(String adminName, String adminMail, String adminFirstName, String adminLastName, int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_adminUser.userToManageSectionXpath)));
        driver.findElement(By.xpath(_adminUser.userToManageSectionXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.createRecordXpath)));
        driver.findElement(By.xpath(_commonConstant.createRecordXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.nameFieldXpath)));
        driver.findElement(By.xpath(_commonConstant.nameFieldXpath)).sendKeys(adminName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_adminUser.createUserMailXpath)));
        driver.findElement(By.xpath(_adminUser.createUserMailXpath)).sendKeys(adminMail);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_adminUser.createUserFirstNameXpath)));
        driver.findElement(By.xpath(_adminUser.createUserFirstNameXpath)).sendKeys(adminFirstName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_adminUser.createUserLastNameXpath)));
        driver.findElement(By.xpath(_adminUser.createUserLastNameXpath)).sendKeys(adminLastName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalSaveButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.modalSaveButtonXpath)).click();

    }

    public void NewRecord(String name, String code, int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.createRecordXpath)));
        driver.findElement(By.xpath(_commonConstant.createRecordXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.nameFieldXpath)));
        driver.findElement(By.xpath(_commonConstant.nameFieldXpath)).sendKeys(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.codeFieldXpath)));
        driver.findElement(By.xpath(_commonConstant.codeFieldXpath)).sendKeys(code);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalSaveButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.modalSaveButtonXpath)).click();

    }

    public void DetailSection(String elementId, int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
        driver.findElement(By.xpath(elementId)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalCloseButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.modalCloseButtonXpath)).click();
    }

    public void DocumentSection(String documentName, String documentNo, int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.documentSectionXpath)));
        driver.findElement(By.xpath(_commonConstant.documentSectionXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_userConstant.createDocumentButtonXpath)));
        driver.findElement(By.xpath(_userConstant.createDocumentButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_userConstant.createDocumentManuelOptionXpath)));
        driver.findElement(By.xpath(_userConstant.createDocumentManuelOptionXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_userConstant.documentNameFieldXpath)));
        driver.findElement(By.xpath(_userConstant.documentNameFieldXpath)).sendKeys(documentName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_userConstant.documentNoFieldXpath)));
        driver.findElement(By.xpath(_userConstant.documentNoFieldXpath)).sendKeys(documentNo);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_userConstant.documentCategoryDropdownXpath)));
        driver.findElement(By.xpath(_userConstant.documentCategoryDropdownXpath)).click();

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_userConstant.documentCategoryDropdownXpath)));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        Random rand = new Random();
        int randomIndex = rand.nextInt(options.size());
        select.selectByIndex(randomIndex);

    }

    public void DropDownLastElement(String elementId, int durationTime) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
        driver.findElement(By.xpath(elementId)).click();

        WebElement dropdownCenter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
        Select selectCenter = new Select(dropdownCenter);
        List<WebElement> optionsCenter = selectCenter.getOptions();
        WebElement lastOption = optionsCenter.get(optionsCenter.size() - 1);
        selectCenter.selectByValue(lastOption.getAttribute("value"));
    }
public void Deneme(String elementIdFirst,String elementIdLast, int durationTime){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementIdFirst+elementIdLast)));

    List<WebElement> buttonList = driver.findElements(By.xpath(elementIdFirst+elementIdLast));
    int lastIndex = buttonList.size();
     buttonList.get(lastIndex - 1).click();
}
    public void DocumentDropDown(String elementId,int durationTime) throws InterruptedException {

        for (int i = 2; i <= 3; i++) {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
            driver.findElement(By.xpath(elementId)).click();

            Thread.sleep(3000);

            WebElement dropdownCenter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
            Select selectCenter = new Select(dropdownCenter);

            for (WebElement option : selectCenter.getOptions()) {
                if (option.getText().equals("Test Fiş" + (i-1))) {
                    option.click();
                    break;
                }
            }
//            List<WebElement> optionsCenter = selectCenter.getOptions();
//            WebElement lastOption = optionsCenter.get(optionsCenter.size() - i);
//            selectCenter.selectByValue(lastOption.getAttribute("value"));

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalSaveButtonXpath)));
                driver.findElement(By.xpath(_commonConstant.modalSaveButtonXpath)).click();

                Thread.sleep(2000);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationSuccessStateTextXpath)));
                WebElement notificationTrue = driver.findElement(By.xpath(_commonConstant.notificationSuccessStateTextXpath));

                String notificationTrueText = notificationTrue.getText();
                System.out.println("Notification text: " + notificationTrueText);

                driver.findElement(By.xpath(_commonConstant.notificationCloseButtonXpath)).click();

            }
        }

        public void DocumentImageFileField () {
            WebElement fileInput = driver.findElement(By.xpath(_userConstant.documentImageFileFieldXpath));
            String filePaths = "C:\\Users\\10127518\\Desktop/market-fis.jpg";
            fileInput.sendKeys(filePaths);
        }

        public void DocumentApproveButton (String elementId,int durationTime) throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
            driver.findElement(By.xpath(elementId)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.approveOrRejectButtonXpath)));
            driver.findElement(By.xpath(_approverConstant.approveOrRejectButtonXpath)).click();

            Thread.sleep(1000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.approveButtonXpath)));
            driver.findElement(By.xpath(_approverConstant.approveButtonXpath)).click();

        }

        public void DocumentRejectButton (String elementId,int durationTime) throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId))); //elementID detail olandan secicez commonXpath te visibilityOfElementLocated
            driver.findElement(By.xpath(elementId)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.approveOrRejectButtonXpath)));
            driver.findElement(By.xpath(_approverConstant.approveOrRejectButtonXpath)).click();

            Thread.sleep(1000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.rejectButtonXpath)));
            driver.findElement(By.xpath(_approverConstant.rejectButtonXpath)).click();


        }

        public void Logout ( int durationTime){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.userDropdownXpath)));
            driver.findElement(By.xpath(_commonConstant.userDropdownXpath)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.logoutButtonXpath)));
            driver.findElement(By.xpath(_commonConstant.logoutButtonXpath)).click();
        }
    }




