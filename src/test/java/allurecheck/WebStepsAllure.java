package allurecheck;

import com.codeborne.selenide.Configuration;
import help.WebSteps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class WebStepsAllure {

    private final WebSteps webSteps = new WebSteps();
    private static final String REPOSITORY = "vklonin/QA_GURU_2_0";
    private static final int ISSUE_NUMBER = 2;
    private static final String MAIN_PAGE = "https://github.com";

    @BeforeAll
    static void setup() {
        Configuration.browser = "safari";
        Configuration.startMaximized = true;
    }

    @Test
    void webStepsTest(){
        webSteps.openMainPage(MAIN_PAGE);
        webSteps.searchForRepository(REPOSITORY);
        webSteps.openRepository(REPOSITORY);
        webSteps.proceedIssuesTab();
        webSteps.shouldSeeIssueWithNumber(""+ISSUE_NUMBER);
    }
}
