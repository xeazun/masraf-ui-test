package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import constants.AdminConstant;
import constants.CommonConstant;
import org.testng.annotations.BeforeTest;
import services.UITestService;
import constants.UserConstant;
import org.testng.annotations.Test;

import java.util.UUID;


public class MasrafUITests {
    private WebDriver _driver;
    private AdminConstant _adminConstant;
    private CommonConstant _commonConstant;
    private UserConstant _userConstant;
    private UITestService _uiTestService;


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

//    //ADMİN LOGİN
//  @Test(priority = 1)
//    void AdminLoginTest() throws InterruptedException {
//
//        int durationTime = 10;
//
//        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
//        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.admin@nttdata.com");
//
//  }
//    //KULLANICI YÖNET
//    @Test(priority = 2)
//    void ManageUserTest() throws InterruptedException {
//
//        int durationTime = 10;
//
//        _uiTestService.Wait(_adminConstant.userToManageSectionXpath, durationTime);
//        _uiTestService.FindElementClick(_adminConstant.userToManageSectionXpath);
//        _uiTestService.UserNewRecord("ezgi.admin@nttdata.com", "ezgi.admin@nttdata.com", "Ezgi", "Azun", durationTime);
//
//        _uiTestService.Notification(durationTime);
//        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);
//
//    }
////ÖDEME YÖNTEMİ
//    @Test(priority = 3)
//    void PaymentMethodTest() throws InterruptedException {
//
//        int durationTime = 10;
//        _uiTestService.Wait(_adminConstant.paymentSectionXpath, durationTime);
//        _uiTestService.FindElementClick(_adminConstant.paymentSectionXpath);
//        _uiTestService.NewRecord("KREDI5", "KRD5", durationTime);
//        _uiTestService.Notification(durationTime);
//        _uiTestService.DetailSection(_commonConstant.showEighthRecordButtonXpath, durationTime);
//    }
//    //        //MASRAF MERKEZİ
//    @Test(priority = 4)
//    void CostCenterTest() throws InterruptedException {
//
//        int durationTime = 10;
//        _uiTestService.Wait(_adminConstant.costCenterSectionXpath, durationTime);
//        _uiTestService.FindElementClick(_adminConstant.costCenterSectionXpath);
//        _uiTestService.NewRecord("Masraf Merkezi 5", "MER5", durationTime);
//        _uiTestService.Notification(durationTime);
//        _uiTestService.DetailSection(_commonConstant.showFiveRecordButtonXpath, durationTime);
//
//    }
//
//    //PARA BİRİMİ
//    @Test(priority = 5)
//    void CurrencyTest() throws InterruptedException {
//
//        int durationTime = 10;
//        _uiTestService.Wait(_adminConstant.currencySectionXpath, durationTime);
//        _uiTestService.FindElementClick(_adminConstant.currencySectionXpath);
//        _uiTestService.NewRecord("STERLİN", "GBD", durationTime);
//        _uiTestService.Notification(durationTime);
//        _uiTestService.DetailSection(_commonConstant.showFourRecordButtonXpath, durationTime);
//
//
//    }
//    //LOGOUT
//    @Test(priority = 6)
//    void AdminLogoutTest() throws InterruptedException {
//
//        int durationTime = 10;
//        _uiTestService.Logout(durationTime);
//    }
//
//    //USER LOGİN
//    @Test(priority = 7)
//    void UserLoginTest() throws InterruptedException {
//
//        int durationTime = 10;
//
//        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
//        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.user@nttdata.com");
//
//    }
//    //FİŞ EKLEME
//    @Test(priority = 8)
//    void AddAPlugTest() throws InterruptedException {
//
//        int durationTime = 10;
//
//        for (int i = 1; i <= 3; i++) { // randomları metot olarak topla.
//
//            Random random = new Random();
//
//            int tutar = random.nextInt((901) + 100);
//
//            double kdvTutar = (tutar * (1 + (18.0 / 100.0))); // virgüllü kullanmam lazım onu nasıl yaparım ögren
//            int kdvTutarint = (int) kdvTutar;
//
//            int fisNo = random.nextInt((10) + 1);
//            String stringFisNo = Integer.toString(fisNo);
//
//            String[] kdv = {"1", "8", "18"};
//            int randomIndex = random.nextInt(kdv.length);
//            String randomKdv = kdv[randomIndex];
//
//            String[] institution = {"Trendyol", "Opet", "Market", "Getir", "Taksi"};
//            int randomInstitution = random.nextInt(institution.length);
//            String randomInstitutions = institution[randomInstitution];
//
//            LocalDate currentDate = LocalDate.now();
//            LocalDate startDate = currentDate.minusDays(5);
//            LocalDate endDate = currentDate.plusDays(5);
//            int randomDays = random.nextInt(endDate.getDayOfYear() - startDate.getDayOfYear()) + startDate.getDayOfYear();
//            LocalDate randomDate = LocalDate.ofYearDay(currentDate.getYear(), randomDays);
//            String formattedDate = randomDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//
//            _uiTestService.DocumentSection("Test Fiş" + i, stringFisNo, durationTime);
//            _uiTestService.DropDownLastElement(_userConstant.documentCostCenterDropdownXpath, durationTime);
//            _uiTestService.DropDownLastElement(_userConstant.documentPaymentMethodDropdownXpath, durationTime);
//            _uiTestService.DropDownLastElement(_userConstant.documentCurrencyDropdownXpath, durationTime);
//            _uiTestService.FindElementWrite(_userConstant.documentAmountFieldXpath, Integer.toString(tutar));
//            _uiTestService.FindElementWrite(_userConstant.documentVatRateFieldXpath, randomKdv);
//            _uiTestService.FindElementWrite(_userConstant.documentVatAmountFieldXpath, Integer.toString(kdvTutarint));
//            _uiTestService.FindElementWrite(_userConstant.documentExchangeRateFieldXpath, Integer.toString(random.nextInt((20) + 1)));
//            _uiTestService.FindElementWrite(_userConstant.documentInstitutionFieldXpath, randomInstitutions);
//            _uiTestService.FindElementWrite(_userConstant.documentIssuedDateFieldXpath, formattedDate);
//            _uiTestService.FindElementWrite(_userConstant.documentDescriptionFieldXpath, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
//            _uiTestService.DocumentImageFileField();
//            _uiTestService.FindElementClick(_commonConstant.modalSaveButtonXpath);
//
//            Thread.sleep(1000);
//            _uiTestService.Notification(durationTime * 3);
//        }
//        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);
//    }
//    //LOGOUT
//    @Test(priority = 9)
//    void UserLogoutTest() throws InterruptedException {
//
//        int durationTime = 10;
//        _uiTestService.Logout(durationTime);
//
//
//    }
//    //APPROVER LOGİN
//    @Test(priority = 10)
//    void ApproverLoginTest() throws InterruptedException {
//        int durationTime = 10;
//        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
//        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.approver@nttdata.com");
//    }
//   //FİŞ ONAY/RED
//    @Test(priority = 11)
//    void VoucherApproverOrRejectTest() throws InterruptedException {
//        int durationTime = 10;
//
//        _uiTestService.Wait(_commonConstant.documentSectionXpath, durationTime * 2);
//        _uiTestService.FindElementClick(_commonConstant.documentSectionXpath);
//
//        for (int i = 0; i < 3; i++) {
//            JavascriptExecutor js = (JavascriptExecutor) _driver;
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight * " + i + ");"); // kodu UI test servise tası
//            Thread.sleep(1000);
//
//        }
//
//        _uiTestService.DocumentApproveButton(_commonConstant.showSeventeenRecordButtonXpath, durationTime);
//        _uiTestService.NotificationApprover(durationTime);
//        _uiTestService.DetailSection(_commonConstant.showSeventeenRecordButtonXpath, durationTime);
//
//        Thread.sleep(1000);
//
//        _uiTestService.DocumentApproveButton(_commonConstant.showEighteenRecordButtonXpath, durationTime);
//        _uiTestService.NotificationApprover(durationTime);
//        _uiTestService.DetailSection(_commonConstant.showEighteenRecordButtonXpath, durationTime);
//
//        Thread.sleep(1000);
//
//        _uiTestService.DocumentRejectButton(_commonConstant.showNineteenRecordButtonXpath, durationTime);
//        _uiTestService.NotificationApprover(durationTime);
//        _uiTestService.DetailSection(_commonConstant.showNineteenRecordButtonXpath, durationTime);
//
//        JavascriptExecutor js = (JavascriptExecutor) _driver;
//        js.executeScript("window.scrollTo(0,0);");
//        Thread.sleep(1000);
//    }
//
//    //LOGOUT
//    @Test(priority = 12)
//    void ApproverLogoutTest() throws InterruptedException {
//        int durationTime = 10;
//        _uiTestService.Logout(durationTime);
//        _uiTestService.Logout(durationTime);
//    }

    //USER LOGİN
    @Test(priority = 13)
    void UserLoginFormTest() throws InterruptedException {
        int durationTime = 10;

        _uiTestService.Wait(_commonConstant.loginMailFieldXpath, durationTime);
        _uiTestService.Login(_commonConstant.loginMailFieldXpath, "murat.user@nttdata.com");

    }

    //FORM YARAT
    @Test(priority = 14)
    void FormCreationTest() throws InterruptedException {
        int durationTime = 10;

        _uiTestService.Wait(_commonConstant.formSectionXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.formSectionXpath);

        _uiTestService.Wait(_commonConstant.createRecordXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.createRecordXpath);

        _uiTestService.Wait(_commonConstant.nameFieldXpath, durationTime);
        _uiTestService.FindElementWrite(_commonConstant.nameFieldXpath, "Test Form");

        _uiTestService.Wait(_commonConstant.codeFieldXpath, durationTime);
        _uiTestService.FindElementWrite(_commonConstant.codeFieldXpath, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));

        _uiTestService.Wait(_commonConstant.modalSaveButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalSaveButtonXpath);

        _uiTestService.Wait(_commonConstant.notificationSuccessStateTextXpath, durationTime);
        _uiTestService.Notification(durationTime);

        _uiTestService.Wait(_commonConstant.modalCloseButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

        _uiTestService.Wait(_commonConstant.showSevenRecordFirstButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.showSevenRecordFirstButtonXpath);

        _uiTestService.Wait(_userConstant.addDocumentToFormButtonXpath, durationTime);
        _uiTestService.FindElementClick(_userConstant.addDocumentToFormButtonXpath);

        _uiTestService.Wait(_userConstant.formDocumentDropdownXpath, durationTime);
        _uiTestService.DocumentDropDown(_userConstant.formDocumentDropdownXpath, durationTime * 2);


        _uiTestService.Wait(_commonConstant.modalCloseButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

        _uiTestService.Wait(_commonConstant.showSevenRecordFirstButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.showSevenRecordFirstButtonXpath);

        _uiTestService.Wait(_userConstant.viewFormDocumentsButtonXpath, durationTime);
        _uiTestService.FindElementClick(_userConstant.viewFormDocumentsButtonXpath);

        _uiTestService.Wait(_commonConstant.modalCloseButtonXpath, durationTime);
        _uiTestService.FindElementClick(_commonConstant.modalCloseButtonXpath);

        // _uiTestService.Logout(durationTime);
    }


    @AfterEach
    void tearDown() throws InterruptedException {
//        Thread.sleep(1500);
//        _driver.close();
    }
}

