package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="twotabsearchtextbox")
    public WebElement aramaKutusu;


    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYaziElementi;


    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
    public WebElement ilkUrunElementi;//(//*[@class='puisg-col-inner'])[1]

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsimElementi;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement amazonSignInButton;

    @FindBy(xpath = "//*[@class='a-button-input']")
    public WebElement SignInContinueButton;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement Amazonpassword;

    @FindBy(xpath = "(//*[@class='a-button-input'])[1]")
    public WebElement PasswordSignIn;
    @FindBy(id= "nav-link-accountList-nav-line-1")
    public WebElement helloSignIn;

    @FindBy(xpath = "//*[@name='submit.add-to-cart']")
    public WebElement sepeteEkleme;

    @FindBy(xpath = "(//*[@class='a-button-text'])[5]")
    public WebElement amazonSepet;

    @FindBy(id="nav-logo-sprites")
    public WebElement amazonAnasayfa;
}
