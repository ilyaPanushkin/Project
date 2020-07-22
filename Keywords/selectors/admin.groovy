package selectors

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

public class Adminselector {

    static WebDriver driver = DriverFactory.getWebDriver();







    public static void getTextFromXpathElement(String xpath, String formatElement, String text, String folderName, String fileName){


	String xpathAfterFormat = String.format(xpath, "${formatElement}");
	WebElement element = driver.findElement(By.xpath(xpathAfterFormat));
	String textelement = element.getText();
	logs.LogErrors.logFile(" ${text} \"${textelement}\" " +"\n", "${folderName}", "${fileName}")
	element.click()
    }


    public static void getTextZipCodeAdmin(String text, String formatElement, String folderName, String fileName){
	String xpath = '/html/body/div[7]/div[3]/div[1]/div[2]/div/div[11]/div[3]/div[3]/div/div/table/tbody/tr[%s]/td[1]/div/a'

	for(int i = 1; i<=25 ;i++){

	    String toString = Integer.toString(i);
	    selectors.Adminselector.getTextFromXpathElement(xpath, toString , "Number of order is:", "Pay" ,"OrderNumberZip")
	    wait.WaitLoad.jQuery()


	    if (this.driver.findElements(By.xpath('//*[@id="id_credit_card_panel"]/div[2]/table/tbody/tr[2]/td[3]/button')).size() > 0){

		this.driver.findElement(By.xpath('//*[@id="id_credit_card_panel"]/div[2]/table/tbody/tr[2]/td[3]/button')).click();
		String zipcode = driver.findElement(By.xpath('//*[@id="billing_address_form"]/div[14]/input')).getAttribute("value");
		logs.LogErrors.logFile(" ${text} \"${zipcode}\" " +"\n", "${folderName}", "${fileName}")
		WebUI.back()
		wait.WaitLoad.jQuery()
		WebUI.click(findTestObject('Object Repository/Page_Admin/Page_Jandh admin Order list/a_Delivered                    3076'))
		wait.WaitLoad.jQuery()
	    }
	    else if (this.driver.findElements(By.xpath('//*[@id="id_paypal_panel"]/div[2]/table/tbody/tr[2]/td[3]/button')).size() > 0) {

		this.driver.findElement(By.xpath('//*[@id="id_paypal_panel"]/div[2]/table/tbody/tr[2]/td[3]/button')).click();
		String zipcode = driver.findElement(By.xpath('//*[@id="billing_address_form"]/div[14]/input')).getAttribute("value");
		logs.LogErrors.logFile(" ${text} \"${zipcode}\" " +"\n", "${folderName}", "${fileName}")
		WebUI.back()
		wait.WaitLoad.jQuery()
		WebUI.click(findTestObject('Object Repository/Page_Admin/Page_Jandh admin Order list/a_Delivered                    3076'))
		wait.WaitLoad.jQuery()
	    }

	    else {


		WebUI.back()
		wait.WaitLoad.jQuery()
		WebUI.click(findTestObject('Object Repository/Page_Admin/Page_Jandh admin Order list/a_Delivered                    3076'))
		wait.WaitLoad.jQuery()
	    }
	}
    }
}









