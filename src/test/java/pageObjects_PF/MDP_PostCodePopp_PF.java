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

public class MDP_PostCodePopp_PF extends MDP_SuperClass {

	@FindBy(how = How.CSS, css = "svg[data-test='postcode']")
	// #koala > div > div > footer > div > span > div:nth-child(1) > svg
	public static WebElement we_PostCodeIcon;

	@FindBy(how = How.CSS, using = "input[data-test='Enter Postcode']")
	// #koala > div > div > footer > div > span > div:nth-child(2) > div >
	// div.rmq-63c906da > div > input[type="text"]
	public WebElement we_Loc_EnterPostCodeText;

	@FindBy(how = How.CSS, css = "button[data-test='Submit']")
	// #koala > div > div > footer > div > span > div:nth-child(2) > div >
	// div.rmq-63c906da > button
	public WebElement we_btn_SubmitBtn;

	@FindBy(how = How.CSS, css = "div[data-test='close']")
	public WebElement we_btn_CancelBtn;

	@FindBy(how = How.CSS, using = "div[data-test='contentpostcode']")
	// #koala > div > div > footer > div > span > div:nth-child(2)>div
	// #koala > div > div > footer > div > span >
	// #koala > div > div > footer > div > span > div:nth-child(2)
	// @FindBy(how=How.CSS, using="span[data-test = 'postcode']")
	public List<WebElement> we_List_allElements;

	public MDP_PostCodePopp_PF(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// main execution start for post code pop up
	public void execute_PostCode_PopUP() throws Exception {

		allElementsList(we_List_allElements);

	}

	// post code pop up - submit button
	public void execute_PostCodeUP_Submit(String sPostCode) throws Exception {

		System.out.println("To test submit button  on post code pop up");

		clickOnPostCodeIcon(we_PostCodeIcon);
		enterPostCode(we_Loc_EnterPostCodeText, sPostCode);
		clickOnSubmitButton(we_btn_SubmitBtn);
		getElementsText(we_PostCodeIcon, sPostCode);

	}

	// post code - pop up - Close button
	public void execute_PostCodeUP_Close() throws Exception {

		System.out.println("To test close button  on post code pop up");

		clickOnPostCodeIcon(we_PostCodeIcon);
		enterPostCode(we_Loc_EnterPostCodeText, "3000");
		clickOnCloseButton(we_btn_CancelBtn);

	}

	private void getElementsText(WebElement element, String postcode) {
		element.getText();
		if (element.getText() == postcode) {
			MDP_MyCustomisedLogs.info("Location is set to this post code : " + postcode);
			test.log(LogStatus.INFO, "Location is set to this post code : " + postcode);

		} else {

			MDP_MyCustomisedLogs.info("Location is not set to correct post code : " + postcode);
			test.log(LogStatus.INFO, "Location is not set to correct post code : " + postcode);

		}

	}

	// retrieves all the elements present in the post code pop up
	private void allElementsList(List<WebElement> elements) {

		for (WebElement we : elements) {

			MDP_MyCustomisedLogs.info("Elements are : <  " + we.getText() + "  >");
			test.log(LogStatus.INFO, "Elements are : <  " + we.getText() + "  >");

		}
	}

	private void clickOnPostCodeIcon(WebElement element) {
		element.click();
		MDP_MyCustomisedLogs.info("Clicked on Post Code icon on the footer");
		test.log(LogStatus.INFO, "Clicked on Post Code icon on the footer");

	}

	private void clickOnSubmitButton(WebElement element) throws Exception {
		Thread.sleep(1500);
		element.click();
		MDP_MyCustomisedLogs.info("Clicked on Submit button post code pop up >");
		test.log(LogStatus.INFO, "Clicked on Submit button post code pop up >");

	}

	private void clickOnCloseButton(WebElement element) throws Exception {
		// Thread.sleep(3000);
		element.click();
		MDP_MyCustomisedLogs.info("Clicked on Cancel button post code pop up >");
		test.log(LogStatus.INFO, "Clicked on Cancel button post code pop up >");

	}

	public void enterPostCode(WebElement element, String postcode) throws Exception {

		element.clear();
		element.sendKeys(postcode);
		MDP_MyCustomisedLogs.info("entered post code : " + postcode);
		test.log(LogStatus.INFO, "entered post code : " + postcode);
		System.out.println("entered post code : " + postcode);

	}

}
