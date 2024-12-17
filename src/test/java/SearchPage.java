import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class SearchPage {
    private final SelenideElement searchCountry = $x("//input [@name='ss']");
    private final SelenideElement fiveStarsCheckBox = $x("//input [@id=':r29:']");
    private final SelenideElement cookie = $x("//*[@id=\"onetrust-reject-all-handler\"]");
    private final SelenideElement krestik = $x("//button[@aria-label='Скрыть меню входа в аккаунт.']");
    private final SelenideElement firstHotelOnPage = $x("//div[@data-testid='property-card']");


    public String getSearch() {
        return searchCountry.getAttribute("value");
    }

    public void clickOnCheckBox() {
        if (fiveStarsCheckBox.isDisplayed()) {
            fiveStarsCheckBox.click();
        } else {
            checkCookie();
            if (fiveStarsCheckBox.isDisplayed()) {
                fiveStarsCheckBox.click();
            } else {
                checkKrestik();
                fiveStarsCheckBox.click();
            }
        }

    }

    public int countAllHotels() throws InterruptedException {
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        sleep(2000);
        ElementsCollection countHotelsCollection = $$x("//div[@data-testid='property-card']");
        return countHotelsCollection.size();
    }

    public int countAllFiveStarsHotels() {
        ElementsCollection countFiveStarsHotelsCollection = $$x("//div [@aria-label='5 из 5']");
        return countFiveStarsHotelsCollection.size();
    }

    public void checkCookie() {
        if(cookie.exists()) {
            cookie.click();
        }
    }

    public void checkKrestik() {
        if(krestik.exists()) {
            krestik.click();
        }
    }

    public void checkCreateAccount() {
        if (!firstHotelOnPage.isDisplayed()) {
            checkKrestik();
        }
    }
}
