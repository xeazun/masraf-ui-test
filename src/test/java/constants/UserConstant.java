package constants;
public class UserConstant {

    public final String createDocumentButtonXpath = "//button[@class='btn btn-sm btn-success mb-1 dropdown-toggle']";
    public final String createDocumentManuelOptionXpath = "//li[.='Manuel']";
    public final String documentNameFieldXpath = "//input[@name='document-name']";
    public final String documentNoFieldXpath = "//input[@name='document-no']";
    public final String documentCategoryDropdownXpath = "//select[@name='category-code']";
    public final String documentCostCenterDropdownXpath = "//select[@name='costcenter-code']";
    public final String documentPaymentMethodDropdownXpath = "//select[@name='paymentmethod-code']";
    public final String documentCurrencyDropdownXpath = "//select[@name='currency-code']";
    public final String documentAmountFieldXpath = "//input[@name='amount']"; //tutar
    public final String documentVatRateFieldXpath = "//input[@name='vat-rate']"; //random bir tutar olucak ama makul bir random tutar olacak.
    public final String documentVatAmountFieldXpath = "//input[@name='vat-amount']";

    public final String documentExchangeRateFieldXpath = "//input[@name='exchange-rate']"; //random bir tutar olucak ama makul bir random tutar olacak.
    public final String documentInstitutionFieldXpath = "//input[@name='institution']"; //bir dizi oluştur ordan random çek dizide 5 kurum adı olsun 3ü sana lazım.
    public final String documentIssuedDateFieldXpath = "//input[@id='issued-date']"; // +5 -5 gün
    public final String documentDescriptionFieldXpath = "//input[@name='description']"; // UUID acıklama form içinde bu kullanılacak.
    public final String documentImageFileFieldXpath = "//input[@name='file']"; // resim yükleme tek bir resim olsa yeterli

    public final String addDocumentToFormButtonXpath = "//button[@class='btn btn-sm btn-tertiary m-1 fw-bold']";
    public final String formDocumentDropdownXpath = "//select[@name='category-code']";
    public final String viewFormDocumentsButtonXpath = "//button[@class='btn btn-sm btn-primary m-1 fw-bold']";

}
