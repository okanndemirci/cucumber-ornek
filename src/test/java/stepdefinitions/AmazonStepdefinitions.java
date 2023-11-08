package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepdefinitions {

    AmazonPage amazonPage = new AmazonPage();


    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @Then("arama kutusuna {string} yazip, ENTER tusuna basar")
    public void aramaKutusunaYazipENTERTusunaBasar(String aranacakUrun) {

        amazonPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

    }

    @And("arama sonuclarinin {string} icerdigini test eder")
    public void aramaSonuclarininIcerdiginiTestEder(String arananIcerik) {

        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(arananIcerik));

    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int beklemeSuresi) {

        try {
            Thread.sleep(beklemeSuresi*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String istenenUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));
    }

    @When("ilk urunu tiklar")
    public void ilk_urunu_tiklar() {
        amazonPage.ilkUrunElementi.click();
    }
    @Then("urun isminde {string} oldugunu test eder")
    public void urun_isminde_oldugunu_test_eder(String istenenIcerik) {

        Assert.assertTrue(amazonPage.ilkUrunIsimElementi.getText().contains(istenenIcerik));
    }
    @Then("kullanıcı girişi yapar")
    public void kullanıcı_girişi_yapar() {
        amazonPage.helloSignIn.click();
        amazonPage.amazonSignInButton.sendKeys(ConfigReader.getProperty("amazonUserName"));
        amazonPage.SignInContinueButton.click();
        amazonPage.Amazonpassword.sendKeys("asdfzxc1.");
        amazonPage.PasswordSignIn.click();

    }
    @When("sepete ekler")
    public void sepete_ekler() {
        amazonPage.sepeteEkleme.click();

    }


    @When("sepetteki ürünler kontrol edilir")
    public void sepetteki_ürünler_kontrol_edilir() {
        amazonPage.amazonSepet.click();
        String expectedTitle="Shopping Cart";
        String actualTitle =Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Then("anasayfaya dönülür")
    public void anasayfaya_donulur() {
        amazonPage.amazonAnasayfa.click();
        String expectedUrl="https://www.amazon.com/ref=nav_logo";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }


}
