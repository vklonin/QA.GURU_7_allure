package allurecheck;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void setup(){
        Configuration.browser = "safari";
        Configuration.startMaximized = true;
    }

    @Test
    void checkIssueByText(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("[name=q]").setValue("vklonin/QA_GURU_2_0").pressEnter();
        sleep(1000);
        $(byAttribute("href", "/vklonin/QA_GURU_2_0")).click();
        $("#issues-tab").click();
        $(withText("#2")).should(Condition.exist);
    }

}
