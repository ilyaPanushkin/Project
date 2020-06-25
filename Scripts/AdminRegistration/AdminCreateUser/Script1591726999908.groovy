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

WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/backend/login')

WebUI.setText(findTestObject('Object Repository/Page_Admin/input_Login_login'), 'developer')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Admin/input_Password_password'), '9yQ42Oo1hG4=')

WebUI.click(findTestObject('Object Repository/Page_Admin/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Page_Jandh admin/span_Web Managing'))

WebUI.click(findTestObject('Object Repository/Page_Jandh admin/a_Users'))

WebUI.click(findTestObject('Object Repository/Page_Jandh admin User List/span_AddUser'))

WebUI.setText(findTestObject('Object Repository/Page_Jandh admin User List/input__email'), GlobalVariable.baseEmailLogin)

WebUI.setText(findTestObject('Object Repository/Page_Jandh admin User List/input__name'), 'Derek')

WebUI.setText(findTestObject('Object Repository/Page_Jandh admin User List/input__surname'), 'Derek')

WebUI.setText(findTestObject('Object Repository/Page_Jandh admin User List/input_Password _password'), '666666')

WebUI.click(findTestObject('Object Repository/Page_Jandh admin User List/span'))

WebUI.click(findTestObject('Object Repository/Page_Jandh admin User List/span_1'))

WebUI.setText(findTestObject('Object Repository/Page_Jandh admin User List/input__verification'), '1')

WebUI.click(findTestObject('Object Repository/Page_Jandh admin User List/input_delete_form-button-save'))

Thread.sleep(5000);


