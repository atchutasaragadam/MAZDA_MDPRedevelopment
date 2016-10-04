package pageObjects_PF;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import testCases.MDP_SuperClass;
import utility.MDP_MyCustomisedLogs;

public class MDP_Menu_PF extends MDP_SuperClass {

	// @FindBy(how=How.CSS, using="#koala > div > div > nav > div:nth-child(2) >
	// span")
	@FindBy(how = How.CSS, using = "span[data-test='Our Range']")
	public WebElement we_Menu_OurRange;

	// @FindBy(how=How.CSS, using="#koala > div > div > nav > div:nth-child(3) >
	// span")
	@FindBy(how = How.CSS, using = "span[data-test='Buying Guide']")
	public WebElement we_Menu_BuyingGuide;

	// @FindBy(how=How.CSS, using="#koala > div > div > nav > div:nth-child(4) >
	// a")
	@FindBy(how = How.CSS, using = "a[data-test='Find a Dealer']")
	public WebElement we_Menu_FindADealer;

	// @FindBy(how=How.CSS, using="#koala > div > div > nav > button")
	@FindBy(css = "button[data-test='More +']")
	// #koala > div > div > nav > button
	public WebElement we_Menu_More;

	@FindBy(how = How.CSS, using = "span")
	// #koala > div > div > nav > div:nth-child(3) > span
	// #koala > div > div > nav > div:nth-child(2) > span
	// #koala > div > div > nav > div:nth-child(4) > a
	public List<WebElement> we_List_AllSpanElements;

	@FindBy(how = How.TAG_NAME, using = "a")
	public List<WebElement> we_list_AllTags_A_Elements;

	public MDP_Menu_PF(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void verifyMenu() throws Exception {

		// #Menu - Our Range
		isElementDisplayed(we_Menu_OurRange);
		isElementClickable(we_Menu_OurRange);

		// # Menu - Buying Guide
		isElementDisplayed(we_Menu_BuyingGuide);
		isElementClickable(we_Menu_BuyingGuide);

		// #Menu - Find A Dealer
		isElementDisplayed(we_Menu_FindADealer);
		isElementClickable(we_Menu_FindADealer);

		// #Menu - More +
		isElementDisplayed(we_Menu_More);
		isElementClickable(we_Menu_More);

	}

	public void isElementDisplayed(WebElement element) {

		element.isDisplayed();
		MDP_MyCustomisedLogs.info("Element <=== " + element.getText() + " ===> is displayed");
		test.log(LogStatus.INFO, "Element <=== " + element.getText() + " ==> is displayed");
	}

	public void isElementClickable(WebElement element) {
		element.click();
		MDP_MyCustomisedLogs.info("Clicked on  < " + element.getText() + "   ===>");
		test.log(LogStatus.INFO, "Clicked on  < " + element.getText() + "   ===>");

	}
}
