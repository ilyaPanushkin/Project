package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;
import internal.GlobalVariable

public class Login {


	public static void loginPositive(String email, String nameSurname, String expectedEmail, String expectedNameSurname){
		WebUI.comment(email);
		if(  WebUI.verifyMatch(email ,  expectedEmail,   false, FailureHandling.CONTINUE_ON_FAILURE) == false ){
			logs.LogErrors.logFile("Actual text in email field is \"${email}\" , expected text is \"${expectedEmail} \""  , "Login");
			logs.LogErrors.logScreen("Email isn't expected", "Login")
			
		}
		else  {
			FailureHandling.CONTINUE_ON_FAILURE
		}



		if(   WebUI.verifyMatch(nameSurname ,   expectedNameSurname, false, FailureHandling.CONTINUE_ON_FAILURE) == false){

			logs.LogErrors.logFile("Actual text in name/surname field is \"${nameSurname}\" , expected text is \"${expectedNameSurname} \""  , "Login");
			logs.LogErrors.logScreen("Name or Surname isn't expected", "Login");
		}


		else{
			FailureHandling.CONTINUE_ON_FAILURE
		}
	}






















}
