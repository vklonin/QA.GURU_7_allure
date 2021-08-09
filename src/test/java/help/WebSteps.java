package help;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open URL")
    public void openMainPage(String url){
        open(url);
    }

    @Step("Search repository")
    public void searchForRepository(String repository){
        $("input[name='q']").click();
        $("input[name='q']").sendKeys(repository);
        $("input[name='q']").submit();
    }

    @Step("Step into Repository")
    public void openRepository(String repository){
        $(byAttribute("href", "/"+repository)).click();
    }

    @Step("Switch to Issues tab")
    public void proceedIssuesTab(){
        $("#issues-tab").click();
    }

    @Step("Issue with number {number} has found")
    public void shouldSeeIssueWithNumber(String number){
        $(withText("#"+number)).should(Condition.exist);
    }

}