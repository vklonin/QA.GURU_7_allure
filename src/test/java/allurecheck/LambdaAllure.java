package allurecheck;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LambdaAllure
{

    private static final String REPOSITORY = "vklonin/QA_GURU_2_0";
    private static final int ISSUE_NUMBER = 2;

    @BeforeAll
    static void setup(){
        Configuration.browser = "safari";
        Configuration.startMaximized = true;
    }

    @Test
    void checkIssueByText(){
        step("Open main page" , () ->open("https://github.com") );
        step("Finding a " + REPOSITORY + " repository", () -> $("[name=q]").setValue(REPOSITORY).pressEnter());
        step("Going inside found repository", () -> $(byAttribute("href", "/"+ REPOSITORY)).click());
        step("Going to the issue tab", () -> $("#issues-tab").click());
        step("Check issue number " + ISSUE_NUMBER, () -> $(withText("#" + ISSUE_NUMBER)).should(Condition.exist));
    }

}



