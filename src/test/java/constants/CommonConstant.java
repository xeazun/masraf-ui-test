package constants;

public class CommonConstant {
    int j;
    //LOGİN
    public final String loginSectionButtonXpath = "//button[@name='login']";
    public final String loginMailFieldXpath = "//input[@name='email']";
    public final String loginPasswordFieldXpath = "//input[@name='password']";
    public final String loginButtonXpath = "//button[@class='btn btn-primary mt-2']";

    //LOGOUT
    public final String userDropdownXpath = "//i[@class='fa custom-caret']";
    public final String logoutButtonXpath = "//a[.='Çıkış Yap']";

    //
    public final String documentSectionXpath = "//a[@name='Fiş']";
    public final String formSectionXpath = "//a[@name='Form']";

    public final String createRecordXpath = "//button[@class='btn btn-sm btn-success mb-1']";
    public final String nameFieldXpath = "//input[@name='form-name']";
    public final String codeFieldXpath = "//input[@name='description']";
    public final String modalCloseButtonXpath = "//button[@class='button close']";
    public final String modalSaveButtonXpath = "//button[@id='inputDefault']";

    //DETAİL
    public final String showFourRecordButtonXpath = "//tr[4]//button[@class='btn btn-sm btn-info m-1']";
    public final String showFiveRecordButtonXpath = "//tr[5]//button[@class='btn btn-sm btn-info m-1']";
    public final String showSevenRecordFirstButtonXpath = "//tr[7]//button[@class='btn btn-sm btn-info m-1']"; // 7 değişkene cevir.
    public final String showSevenRecordLastButtonXpath = "";
    public final String showEighthRecordButtonXpath = "//tr[8]//button[@class='btn btn-sm btn-info m-1']";
    public final String showSeventeenRecordButtonXpath = "//tr[17]//button[@class='btn btn-sm btn-info m-1']";
    public final String showEighteenRecordButtonXpath = "//tr[18]//button[@class='btn btn-sm btn-info m-1']";
    public final String showNineteenRecordButtonXpath = "//tr[19]//button[@class='btn btn-sm btn-info m-1']";
    //NOTIFICATION
    public final String notificationCloseButtonXpath = "//div[@class='modal-body']//div[1]/button[.='X']";
    public final String notificationSuccessStateTextXpath = "//p[.='İşlem Başarılı']";


}