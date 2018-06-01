package util;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class ElementUtils {

    public void openLinkInChrome(String link){
        Configuration.browser = "chrome";
        Configuration.baseUrl = link;
        Configuration.timeout = 10000;
        open(Configuration.baseUrl);
    }

    public boolean cheakTitle(String nameOfLink, String textOfSearch){
        textOfSearch = textOfSearch.toLowerCase();
        nameOfLink = nameOfLink.toLowerCase();
        return nameOfLink.contains(textOfSearch);
    }
}
