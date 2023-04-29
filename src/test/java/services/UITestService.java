package services;

import constants.AdminConstant;
import constants.ApproverConstant;
import constants.CommonConstant;
import constants.UserConstant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    public void Login(String elementId, String email, int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.loginSectionButtonXpath))).click();
        // driver.findElement(By.xpath(_commonConstant.loginSectionButtonXpath)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId))).sendKeys(email);
        //  driver.findElement(By.xpath(elementId)).sendKeys(email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.loginPasswordFieldXpath))).sendKeys("Password12.");
        //  driver.findElement(By.xpath(_commonConstant.loginPasswordFieldXpath)).sendKeys("Password12.");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.loginButtonXpath))).click();
        //  driver.findElement(By.xpath(_commonConstant.loginButtonXpath)).click();
    }

    public void FindElementClick(String elementId, int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId))).click();
        //driver.findElement(By.xpath(elementId)).click();
    }

    public void FindElementWrite(String elementId, String generalText, int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
        WebElement textBox = driver.findElement(By.xpath(elementId));
        textBox.clear();
        textBox.sendKeys(generalText);
    }

    public void ScrollBarDown(int durationTime) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight * " + i + ");");
            Thread.sleep(1000);
        }
    }

    public void ScrollBarUp(int durationTime) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0);");
        Thread.sleep(1000);
    }

    public void AdminAndUserNotification(int durationTime) {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationCloseButtonXpath))).click();
        //driver.findElement(By.xpath(_commonConstant.notificationCloseButtonXpath)).click();

        WebElement notificationTrue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationSuccessStateTextXpath)));
        // driver.findElement(By.xpath(_commonConstant.notificationSuccessStateTextXpath));
        String notificationTrueText = notificationTrue.getText();

        System.out.println("Notification text: " + notificationTrueText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.notificationCloseButtonXpath))).click();
        // driver.findElement(By.xpath(_commonConstant.notificationCloseButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalCloseButtonXpath))).click();
        // driver.findElement(By.xpath(_commonConstant.modalCloseButtonXpath)).click();
    }

    public void ApproverNotification(int durationTime) {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(durationTime))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement notificationTrue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.notificationSuccessStateTextXpath)));
       // WebElement notificationTrue = driver.findElement(By.xpath(_approverConstant.notificationSuccessStateTextXpath));

        String notificationTrueText = notificationTrue.getText();
        System.out.println("Notification text: " + notificationTrueText);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_approverConstant.notificationCloseButton))).click();
       // driver.findElement(By.xpath(_approverConstant.notificationCloseButton)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_commonConstant.modalCloseButtonXpath))).click();
        // driver.findElement(By.xpath(_commonConstant.modalCloseButtonXpath)).click();
    }

    public void ApproverAndUserNotification(int durationTime) {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.notificationCloseButton))).click();
        // driver.findElement(By.xpath(_approverConstant.notificationCloseButton)).click();

        WebElement notificationTrue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.notificationSuccessStateTextXpath)));
        //driver.findElement(By.xpath(_approverConstant.notificationSuccessStateTextXpath));

        String notificationTrueText = notificationTrue.getText();
        System.out.println("Notification text: " + notificationTrueText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.notificationCloseButton))).click();
        // driver.findElement(By.xpath(_approverConstant.notificationCloseButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalCloseButtonXpath))).click();
        // driver.findElement(By.xpath(_commonConstant.modalCloseButtonXpath)).click();
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

    public void DetailSection(int durationTime, int i) {
        WebElement table = new WebDriverWait(driver, Duration.ofSeconds(durationTime)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-no-more table-bordered table-striped mb-0']")));
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        int rowCount = rows.size();
        int lastRowIndex = rowCount - i;
        String lastRowShowButtonXpath = "//tr[" + lastRowIndex + "]//button[@class='btn btn-sm btn-info m-1']";
        driver.findElement(By.xpath(lastRowShowButtonXpath)).click();
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

    public void DocumentDropDown(String elementId, int durationTime, int i) {
        // for (int i = 2; i <= 3; i++) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
        driver.findElement(By.xpath(elementId)).click();

        WebElement dropdownCenter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementId)));
        Select selectCenter = new Select(dropdownCenter);

        List<WebElement> optionsCenter = selectCenter.getOptions();
        WebElement lastOption = optionsCenter.get(optionsCenter.size() - i);
        selectCenter.selectByValue(lastOption.getAttribute("value"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.modalSaveButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.modalSaveButtonXpath)).click();

        //  }
    }

    public void DocumentImageFileField() {
        WebElement fileInput = driver.findElement(By.xpath(_userConstant.documentImageFileFieldXpath));
        String filePaths = "C:\\Users\\10127518\\Desktop/market-fis.jpg";
        fileInput.sendKeys(filePaths);
    }

    public void DocumentApproveButton(int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.approveOrRejectButtonXpath)));
        driver.findElement(By.xpath(_approverConstant.approveOrRejectButtonXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.approveButtonXpath)));
        driver.findElement(By.xpath(_approverConstant.approveButtonXpath)).click();
    }

    public void DocumentRejectButton(int durationTime) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.approveOrRejectButtonXpath)));
        driver.findElement(By.xpath(_approverConstant.approveOrRejectButtonXpath)).click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_approverConstant.rejectButtonXpath)));
        driver.findElement(By.xpath(_approverConstant.rejectButtonXpath)).click();
    }

    public void Logout(int durationTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationTime));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.userDropdownXpath)));
        driver.findElement(By.xpath(_commonConstant.userDropdownXpath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(_commonConstant.logoutButtonXpath)));
        driver.findElement(By.xpath(_commonConstant.logoutButtonXpath)).click();
    }
}




