package steps;

import net.thucydides.core.annotations.Step;
import pages.RapNameHomePage;
import java.util.logging.Logger;

public class RapNameSteps {

    RapNameHomePage rapNameHomePage;

    static Logger logger = Logger.getLogger(RapNameSteps.class.getName());

    @Step
    public void loadPage(String pageName) {
        switch (pageName) {
            case "My Rap Name":
                rapNameHomePage.loadRapNameHomePage();
                break;

            default:
                logger.info("Can't view page unknown text" + pageName);
        }
    }

    @Step
    public void verifyInputFields() {
        rapNameHomePage.verifyInputFieldsDisplayed();
    }

    @Step
    public void verifyErrorText(String text) {
        rapNameHomePage.verifyErrorText(text);
    }

    @Step
    public void enterFirstName(String firstName) {
        rapNameHomePage.enterFirstName(firstName);
    }

    @Step
    public void enterLastInitial(String lastInitial) {
        rapNameHomePage.enterLastInitial(lastInitial);
    }

    @Step
    public void clickCTA(String ctaName) {
        switch (ctaName) {
            case "Suggest Male Rap Name":
                rapNameHomePage.clickMaleRapNameButton();
                break;
            case "Suggest Female Rap Name":
                rapNameHomePage.clickFemaleRapNameButton();
                break;

            default:
                logger.info("Can't find element unknown text" + ctaName);
        }
    }

    @Step
    public void verifyRapNameTextDisplayed() {
        rapNameHomePage.verifyRapNameTextDisplayed();
    }

    @Step
    public void verifyNewRapNamePrepended() {
        rapNameHomePage.verifyNewRapNamePrepended();
    }

    @Step
    public void unSelectNickName() {
        rapNameHomePage.unSelectNickName();
    }

    @Step
    public void selectNickName() {
        rapNameHomePage.selectNickName();
    }
}
