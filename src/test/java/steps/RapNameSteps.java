package steps;

import net.thucydides.core.annotations.Step;
import pages.RapNameHomePage;
import java.util.logging.Logger;

public class RapNameSteps {

    RapNameHomePage rapNameHomePage;

    /* SLF4J is not working with IntelliJ Community Edition */
    static Logger logger = Logger.getLogger(RapNameSteps.class.getName());

    /* This should be part of Setup or base page but just for this project keeping it here */
    /* Used switch case as we can use the same step later for other pages */
    @Step
    public void loadPage(String pageName) {
        switch (pageName) {
            case "My Rap Name":
                rapNameHomePage.open();
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
