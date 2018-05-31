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
}
