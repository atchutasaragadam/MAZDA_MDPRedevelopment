package testCases;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects_PF.MDP_Menu_PF;
import utility.MDP_MyCustomisedLogs;

public class MDP_Menu_TC extends MDP_SuperClass {

	@Test(description = "verify Menu", enabled = false)
	public void verifyMenu(Method method) throws Exception {

		String methodName = method.getName();
		try {

			MDP_MyCustomisedLogs.startTestCase(methodName);
			test.log(LogStatus.INFO, "Started test case : " + methodName);

			MDP_Menu_PF menuPF = new MDP_Menu_PF(driver);
			getURLFromSpreadsheet();

			menuPF.verifyMenu();
			// verifyLinks_Execute();
			getScreenshot(driver, methodName, "PASS", "");

			MDP_MyCustomisedLogs.endTestCase(methodName);
			test.log(LogStatus.INFO, "Ended test case : " + methodName);

		} catch (Exception e) {

			getScreenshot(driver, methodName, "FAIL", "");
			MDP_MyCustomisedLogs.error(e.toString());
			test.log(LogStatus.ERROR, e.toString());

		}

	}

}
