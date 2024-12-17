import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class BookingTest extends BaseTest{

    private final static String url = "https://booking.com/";
    private final static String searchString = "Анталья";

    @Test
    public void testSearch() {
        String expectedSearchTerm = searchString;
        String actualSearchTerm = getSearchTerm();
        Assertions.assertEquals(expectedSearchTerm, actualSearchTerm, "Поисковый результат не соответствует ожиданиям");
    }
    @Step("Получение поискового результата")
    private String getSearchTerm() {
        MainPage mainPage = new MainPage(url);
        mainPage.searchCountry(searchString);
        mainPage.clickOnSearch();

        SearchPage searchPage = new SearchPage();
        return searchPage.getSearch();
    }
    /*
    public void checkHref() throws InterruptedException {
        MainPage mainPage = new MainPage(url);
        mainPage.searchCountry(searchString);
        mainPage.clickOnSearch();

        SearchPage searchPage = new SearchPage();
        Assertions.assertEquals(searchPage.getSearch(), searchString);
        sleep(1000);
        searchPage.clickOnCheckBox();
        searchPage.checkCreateAccount();
        sleep(2000);
        Assertions.assertEquals(searchPage.countAllHotels(), searchPage.countAllFiveStarsHotels());
    }
    */



}
