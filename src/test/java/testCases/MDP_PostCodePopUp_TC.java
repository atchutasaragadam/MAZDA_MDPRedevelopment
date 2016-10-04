package testCases;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects_PF.MDP_PostCodePopp_PF;
import utility.MDP_Constant;
import utility.MDP_Excel;
import utility.MDP_MyCustomisedLogs;

public class MDP_PostCodePopUp_TC extends MDP_SuperClass {

	@Test(description = "verifying post code icon is present or not", enabled = true)
	public void verify_PostCodePopupPresence(Method method) throws Exception {
		String methodName = method.getName();
		try {

			MDP_MyCustomisedLogs.startTestCase(methodName);
			test.log(LogStatus.INFO, "Started test case :" + methodName);

			MDP_PostCodePopp_PF postcode_PF = new MDP_PostCodePopp_PF(driver);
			getURLKoala();
			MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
			test.log(LogStatus.INFO, "navigated to " + driver.getCurrentUrl());

			postcode_PF.execute_PostCode_PopUP();
			getScreenshot(driver, methodName, "PASS", "");

		} catch (Exception e) {

			getScreenshot(driver, methodName, "FAIL", "");
			MDP_MyCustomisedLogs.error(e.toString());
			test.log(LogStatus.ERROR, e.toString());
		}
	}

	@Test(description = "verifying close on post code pop up", enabled = true)
	public void verify_ClosePostCodePopUp(Method method) throws Exception {
		String methodName = method.getName();
		try {

			MDP_MyCustomisedLogs.startTestCase(methodName);
			test.log(LogStatus.INFO, "Started test case :" + methodName);

			MDP_PostCodePopp_PF postcode_PF = new MDP_PostCodePopp_PF(driver);
			getURLKoala();
			MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
			test.log(LogStatus.INFO, "navigated to " + driver.getCurrentUrl());

			driver.navigate().refresh();
			postcode_PF.execute_PostCodeUP_Close();
			getScreenshot(driver, methodName, "PASS", "");

		} catch (Exception e) {

			getScreenshot(driver, methodName, "FAIL", "");
			MDP_MyCustomisedLogs.error(e.toString());
			test.log(LogStatus.ERROR, e.toString());
		}
	}

	@Test(description = "Post Code Pop Up", enabled = true)
	public void verifyPostCodePopUp(Method method) throws Exception {
		String methodName = method.getName();
		try {

			MDP_MyCustomisedLogs.startTestCase(methodName);
			test.log(LogStatus.INFO, "Started test case : " + methodName);

			MDP_PostCodePopp_PF postcode_PF = new MDP_PostCodePopp_PF(driver);
			getURLKoala();
			MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
			test.log(LogStatus.INFO, "navigated to " + driver.getCurrentUrl());

			int i_RowCount = MDP_Excel.getRowCount(MDP_Constant.ExcelFilePath, MDP_Constant.SheetPostCodePopUp);

			for (int i = 1; i <= i_RowCount; i++) {

				String TestCaseID = MDP_Excel.getCellValue(MDP_Constant.ExcelFilePath, MDP_Constant.SheetPostCodePopUp,
						i, MDP_Constant.Col_TestCaseID);
				String sRunMode = MDP_Excel.getCellValue(MDP_Constant.ExcelFilePath, MDP_Constant.SheetPostCodePopUp, i,
						MDP_Constant.Col_RunMode);
				if (sRunMode.equalsIgnoreCase("yes") || sRunMode.equalsIgnoreCase("y")) {
					MDP_MyCustomisedLogs.startTestCase(TestCaseID);
					test.log(LogStatus.INFO, "Starting Test case: <  " + TestCaseID + " >");

					String sPostCode = MDP_Excel.getCellValue(MDP_Constant.ExcelFilePath,
							MDP_Constant.SheetPostCodePopUp, i, MDP_Constant.Col_PostCode);

					if (sPostCode.length() == 4) {
						int[] postcodeArray = new int[4];
						for (int i1 = 0; i1 < sPostCode.length(); i1++) {
							if (Character.isDigit(sPostCode.charAt(i1))) {
								postcodeArray[i1] = sPostCode.charAt(i1);

							}

						}
						if (postcodeArray.length > 0) {
							driver.navigate().refresh();
							postcode_PF.execute_PostCodeUP_Submit(sPostCode);
							getScreenshot(driver, TestCaseID, "PASS", sPostCode);
						} else {

							MDP_MyCustomisedLogs
									.info("Not executing the post code as the value from excel is : " + sPostCode);
							test.log(LogStatus.INFO,
									"Not executing the post code as the value from excel is : " + sPostCode);

							getScreenshot(driver, methodName, "PASS", sPostCode);
						}

					} else {

						MDP_MyCustomisedLogs
								.info("Not executing the post code as the value from excel is : " + sPostCode);
						test.log(LogStatus.INFO,
								"Not executing the post code as the value from excel is : " + sPostCode);
						getScreenshot(driver, methodName, "PASS", sPostCode);
					}

					MDP_MyCustomisedLogs.endTestCase("Post Code Pop Up");
					test.log(LogStatus.INFO, "Ended test case : < Post Code Pop Up > ");

					getScreenshot(driver, methodName, "PASS", sPostCode);

				} else {
					MDP_MyCustomisedLogs.skipTestCase(TestCaseID, "Skipping the test case < " + TestCaseID
							+ " > as the Run Mode for this test case is < " + sRunMode + " >");

					test.log(LogStatus.SKIP, "Skipping the test case < " + TestCaseID
							+ " > as the Run Mode for this test case is < " + sRunMode + " >");

					getScreenshot(driver, methodName, "PASS", "");
				}
			}

		} catch (Exception e) {

			getScreenshot(driver, methodName, "PASS", "");

			MDP_MyCustomisedLogs.error(e.toString());
			test.log(LogStatus.ERROR, e.toString());

		}
	}

}
