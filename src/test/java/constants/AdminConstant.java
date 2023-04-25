package constants;
public class AdminConstant {

    // TABLER
    public final String userToManageSectionXpath = "//span[.='Kullanıcıları Yönet']";
    public final String paymentSectionXpath = "//span[.='Ödeme Yöntemi']";
    public final String costCenterSectionXpath ="//span[.='Masraf Merkezi']";
    public final String currencySectionXpath ="//span[.='Para Birimi']";

    // Tüm tablerde aynı


    //Yeni kullanıcı kaydı
    public final String createUserMailXpath = "//form[@class='form-control-modern container-fluid form-control-lg']/div[2]//input[@id='inputDefault']";
    public final String createUserFirstNameXpath = "//form[@class='form-control-modern container-fluid form-control-lg']/div[3]//input[@id='inputDefault']";
    public final String createUserLastNameXpath = "//div[4]//input[@id='inputDefault']";
}
