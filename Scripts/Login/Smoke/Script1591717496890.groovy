import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/signin')
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'))
WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Email_email'), 'derektesting11+126@gmail.com')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Password_password'), '111111')

WebUI.click(findTestObject('Page_JH - JH Tackle/button_Login'))
wait.WaitLoad.jQuary();
WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/account');
wait.WaitLoad.jQuary();




GlobalVariable.email = 'derektesting11+126@gmail.com'
GlobalVariable.nameSurname = 'Ilya Panushkin';
GlobalVariable.expectedEmail = WebUI.getText(findTestObject("Object Repository/Login/strong_derektesting11126gmailcom"));
GlobalVariable.expectedNameSurname = WebUI.getText(findTestObject("Object Repository/Login/strong_Ilya Panushkin"));

login.Login.loginPositive(GlobalVariable.email, GlobalVariable.nameSurname, GlobalVariable.expectedEmail,GlobalVariable.expectedNameSurname);
Thread.sleep(1000);



WebUI.closeBrowser();




