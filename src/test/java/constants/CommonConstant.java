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

    //NOTIFICATION
    public final String notificationCloseButtonXpath = "//div[@class='modal-body']//div[1]/button[.='X']";
    public final String notificationSuccessStateTextXpath = "//p[.='İşlem Başarılı']";


}