package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DefaultUrl("http://www.myrapname.com/")
public class RapNameHomePage extends PageObject {

    private String firstRapName;

    @FindBy(css = "form input[name='firstname']")
    private WebElementFacade firstNameTextBox;

    @FindBy(css = "form input[name='lastinitial']")
    private WebElementFacade lastInitialTextBox;

    @FindBy(css = "form input[type='checkbox']")
    private WebElementFacade nickNameCheckbox;

    @FindBy(xpath = "//h1[contains(text(), 'You must enter your first name.')]")
    private WebElementFacade errorText;

    @FindBy(css = "form input[name='Male']")
    private WebElementFacade maleRapNameButton;

    @FindBy(css = "form input[name='Female']")
    private WebElementFacade femaleRapNameButton;

    @FindBy(css = "div table div h1")
    private WebElementFacade latestRapNameText;

    @FindBy(css = "div table tr:nth-child(2) td:nth-child(1) div")
    private WebElementFacade secondRapNameText;

    public void verifyInputFieldsDisplayed() {
        firstNameTextBox.isDisplayed();
        lastInitialTextBox.isDisplayed();
        nickNameCheckbox.isDisplayed();
    }

    public void verifyErrorText(String text) {
        errorText.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.type(firstName);
    }

    public void enterLastInitial(String lastInitial) {
        lastInitialTextBox.type(lastInitial);
    }

    public void unSelectNickName() {
        if (nickNameCheckbox.isSelected()) {
            nickNameCheckbox.click();
        }
    }

    public void selectNickName() {
        if (!nickNameCheckbox.isSelected()) {
            nickNameCheckbox.click();
        }
    }

    public void clickMaleRapNameButton() {
        maleRapNameButton.click();
    }

    public void clickFemaleRapNameButton() {
        femaleRapNameButton.click();
    }

    public void verifyRapNameTextDisplayed() {
        firstRapName = latestRapNameText.getText();
        assertThat(latestRapNameText.getText()).isNotEmpty();
    }

    public void verifyNewRapNamePrepended() {
        assertThat(latestRapNameText.getText()).isNotEqualTo(secondRapNameText.getText());
        assertThat(firstRapName).isEqualTo(secondRapNameText.getText());
    }
}
