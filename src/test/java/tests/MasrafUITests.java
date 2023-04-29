package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import constants.AdminConstant;
import constants.CommonConstant;
import services.UITestService;
import constants.UserConstant;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class MasrafUITests {
    private WebDriver _driver;
    private AdminConstant _adminConstant;
    private CommonConstant _commonConstant;
    private UserConstant _userConstant;
    private UITestService _uiTestService;
    int durationTime = 50;

    String paymentName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
    String paymentCode = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 3);
    String currencyName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
    String currencyCode = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 3);
    String costName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
    String costCode = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 3);
    String description = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);



    @BeforeTest
    void setup() {
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _adminConstant = new AdminConstant();
        _commonConstant = new CommonConstant();
        _userConstant = new UserConstant();
        _uiTestService = new UITestService(_driver);
        _driver.get("https://masraf-dev-front.azurewebsites.net/");

    }

    @Test(priority = 1)
    void AdminLoginTest() {
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.admin@nttdata.com",durationTime);
    }

    @Test(priority = 2)
    void ManageUserTest() {
        _uiTestService.FindElementClick(_adminConstant.userToManageSectionXpath, durationTime);
        _uiTestService.UserNewRecord("ezgi.admin@nttdata.com", "ezgi.admin@nttdata.com", "Ezgi", "Azun", durationTime);
        _uiTestService.AdminAndUserNotification(durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath, durationTime);
    }

    @Test(priority = 3)
    void PaymentMethodTest() {
        _uiTestService.FindElementClick(_adminConstant.paymentSectionXpath, durationTime);
        _uiTestService.NewRecord(paymentName, paymentCode, durationTime);
        _uiTestService.AdminAndUserNotification(durationTime);
        _uiTestService.DetailSection(durationTime,1);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath, durationTime);
    }

    @Test(priority = 4)
    void CostCenterTest() {
        _uiTestService.FindElementClick(_adminConstant.costCenterSectionXpath, durationTime);
        _uiTestService.NewRecord(costName, costCode, durationTime);
        _uiTestService.AdminAndUserNotification(durationTime);
        _uiTestService.DetailSection(durationTime,1);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath, durationTime);
    }

    @Test(priority = 5)
    void CurrencyTest() {
        _uiTestService.FindElementClick(_adminConstant.currencySectionXpath, durationTime);
        _uiTestService.NewRecord(currencyName, currencyCode, durationTime);
        _uiTestService.AdminAndUserNotification(durationTime);
        _uiTestService.DetailSection(durationTime,1);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath, durationTime);
    }

    @Test(priority = 6)
    void AdminLogoutTest() {
        _uiTestService.Logout(durationTime);
    }

    @Test(priority = 7)
    void UserLoginTest() {
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.user@nttdata.com",durationTime);
    }

    @Test(priority = 8)
    void AddAVoucherTest(){

        for (int i = 1; i <= 3; i++) {
            Random random = new Random();
            int amount = random.nextInt((901) + 100);
            double kdvAmount = (amount * (1 + (18.0 / 100.0)));
            int voucherNumber = random.nextInt((10) + 1);
            String stringVoucherumber = Integer.toString(voucherNumber);

            String[] kdv = {"1", "8", "18"};
            int randomIndex = random.nextInt(kdv.length);
            String randomKdv = kdv[randomIndex];
            String[] institution = {"Trendyol", "Opet", "Market", "Getir", "Taksi"};
            int randomInstitution = random.nextInt(institution.length);
            String randomInstitutions = institution[randomInstitution];
            String exchangeRate = Integer.toString(random.nextInt((20) + 1));

            LocalDate currentDate = LocalDate.now();
            LocalDate startDate = currentDate.minusDays(5);
            LocalDate endDate = currentDate.plusDays(5);

            int randomDays = random.nextInt(endDate.getDayOfYear() - startDate.getDayOfYear()) + startDate.getDayOfYear();
            LocalDate randomDate = LocalDate.ofYearDay(currentDate.getYear(), randomDays);
            String formattedDate = randomDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            String voucherName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);

            _uiTestService.DocumentSection(voucherName, stringVoucherumber, durationTime);
            _uiTestService.DropDownLastElement(_userConstant.documentCostCenterDropdownXpath, durationTime);
            _uiTestService.DropDownLastElement(_userConstant.documentPaymentMethodDropdownXpath, durationTime);
            _uiTestService.DropDownLastElement(_userConstant.documentCurrencyDropdownXpath, durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentAmountFieldXpath, Integer.toString(amount),durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentVatRateFieldXpath, randomKdv,durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentVatAmountFieldXpath, Double.toString(kdvAmount),durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentExchangeRateFieldXpath, exchangeRate,durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentInstitutionFieldXpath, randomInstitutions,durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentIssuedDateFieldXpath, formattedDate,durationTime);
            _uiTestService.FindElementWrite(_userConstant.documentDescriptionFieldXpath, description,durationTime);
            _uiTestService.DocumentImageFileField();
            _uiTestService.FindElementClick(_commonConstant.modalSaveButtonXpath, durationTime);
            _uiTestService.AdminAndUserNotification(durationTime);
        }
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath, durationTime);
    }

    @Test(priority = 9)
    void UserLogoutTest() {
        _uiTestService.Logout(durationTime);
    }

    @Test(priority = 10)
    void ApproverLoginTest() {
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.approver@nttdata.com",durationTime);
    }

    //FİŞ ONAY/RED
    @Test(priority = 11)
    void VoucherApproverOrRejectTest() throws InterruptedException {

        _uiTestService.FindElementClick(_commonConstant.documentSectionXpath,durationTime);
        _uiTestService.ScrollBarDown(durationTime);

        _uiTestService.DetailSection(durationTime,3);
        _uiTestService.DocumentApproveButton(durationTime);

        _uiTestService.ApproverNotification(durationTime);

        _uiTestService.DetailSection(durationTime,2);
        _uiTestService.DocumentApproveButton(durationTime);
        _uiTestService.ApproverAndUserNotification(durationTime);

        _uiTestService.DetailSection(durationTime,1);
        _uiTestService.DocumentRejectButton(durationTime);
        _uiTestService.ApproverNotification(durationTime);

        _uiTestService.ScrollBarUp(durationTime);

    }

    //LOGOUT
    @Test(priority = 12)
    void ApproverLogoutTest(){
        _uiTestService.Logout(durationTime);
    }

    //USER LOGİN
    @Test(priority = 13)
    void UserLoginFormTest(){
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.user@nttdata.com",durationTime);
    }

    @Test(priority = 14)
    void FormCreationTest(){

        _uiTestService.FindElementClick(_commonConstant.formSectionXpath, durationTime);

        _uiTestService.FindElementClick(_commonConstant.createRecordXpath,durationTime);

        _uiTestService.FindElementWrite(_commonConstant.nameFieldXpath, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8),durationTime);

        _uiTestService.FindElementWrite(_commonConstant.codeFieldXpath, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20),durationTime);

        _uiTestService.FindElementClick(_commonConstant.modalSaveButtonXpath,durationTime);

        _uiTestService.AdminAndUserNotification(durationTime);

        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath,durationTime);

        _uiTestService.DetailSection(durationTime,1);
        _uiTestService.FindElementClick(_userConstant.addDocumentToFormButtonXpath,durationTime);
        _uiTestService.DocumentDropDown(_userConstant.formDocumentDropdownXpath, durationTime,2);
        _uiTestService.ApproverNotification(durationTime);

        _uiTestService.DetailSection(durationTime,1);
        _uiTestService.FindElementClick(_userConstant.addDocumentToFormButtonXpath,durationTime);
        _uiTestService.DocumentDropDown(_userConstant.formDocumentDropdownXpath, durationTime,2);
        _uiTestService.ApproverNotification(durationTime);

        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath,durationTime);

        _uiTestService.DetailSection(durationTime,1);

        _uiTestService.FindElementClick(_userConstant.viewFormDocumentsButtonXpath,durationTime);

        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath,durationTime);

    }
    @Test(priority = 15)
    void UserFormLogoutTest(){
    // _uiTestService.Logout(durationTime);
    }
    @AfterEach
    void tearDown() throws InterruptedException {
//        Thread.sleep(1500);
//        _driver.close();
    }
}

