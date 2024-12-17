import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@name='ss']");
    private final SelenideElement searchButton = $x("//button[@type='submit']");


    public MainPage(String url) {
        Selenide.open(url);
    }

    public void searchCountry(String name) {
        textBoxInput.setValue(name);
    }

    public void clickOnSearch() {
        searchButton.click();
    }
}
