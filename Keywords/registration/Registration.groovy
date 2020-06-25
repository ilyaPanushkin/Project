package registration

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import internal.GlobalVariable
import io.appium.java_client.functions.ExpectedCondition
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.WebDriverWait

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

// Метод для ошибки в консоли при котором кейс проходит далее. Пока не актуально. Актуальные логи в пакете logs
public class Registration {
	public static void failedTest(){
		KeywordUtil.markFailed("Element is not present");
		KeywordLogger.logFailed ("Failed")
	}

	//Ввод пароля и повторный ввод пароля для страницы регистрации
	public static void passEnter() {
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_JH - JH Tackle/input_Enter a password_password'), 'wQVl5eFVzPg=')

		WebUI.setEncryptedText(findTestObject('Object Repository/Page_JH - JH Tackle/input_Type it again_password_confirmation'),
				'wQVl5eFVzPg=')
	}




}

