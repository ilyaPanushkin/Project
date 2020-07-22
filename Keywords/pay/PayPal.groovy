package pay

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.*
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
import java.io.FileWriter;
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
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

public class PayPal {

    static WebDriver driver = DriverFactory.getWebDriver();

    public static void requiredFields(String name, String surname, String phone, String address, String zipcode, String cardnumber, String cvv){

	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_first_name'), "${name}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_last_name'), "${surname}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_phone_number'), "${phone}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_address1'), "${address}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_zip_code'), "${zipcode}")
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Object Repository/Pay/pay_pal_checkbox'))
	WebUI.click(findTestObject('Object Repository/Pay/review_your_order'))
	wait.WaitLoad.jQuery()


	// Store the current window handle
	String winHandleBefore = driver.getWindowHandle();

	// Perform the click operation that opens new window
	WebUI.click(findTestObject('Object Repository/Pay/place_your_order'))
	wait.WaitLoad.jQuery()

	// Switch to new window opened
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	// Perform the actions on new window (PayPal cred)

	WebUI.setText(findTestObject('Object Repository/Pay/email_paypal'), 'vad.pr.it_Personal@gmail.com')
	WebUI.click(findTestObject('Object Repository/Pay/paypal_nextpage'))
	WebUI.setText(findTestObject('Object Repository/Pay/paypal_pass'), '11111111')
	WebUI.click(findTestObject('Object Repository/Pay/paypal_login'))
	WebUI.click(findTestObject('Object Repository/Pay/paypal_accept_cookies'))
	WebUI.click(findTestObject('Object Repository/Pay/paypal_agree_continue'))

	// Switch back to original browser (first window)
	driver.switchTo().window(winHandleBefore);
	wait.WaitLoad.jQuery()
	String ordernumber  = WebUI.getText(findTestObject('Object Repository/Pay/order_number'));
	logs.LogErrors.logFile("Pass with  \"${ordernumber}\" " + "\n", "Pay");
	logs.LogErrors.logFile(" Pass with  \"${ordernumber}\" " +"\n", "Pay", "OrderNumber")
    }









}
