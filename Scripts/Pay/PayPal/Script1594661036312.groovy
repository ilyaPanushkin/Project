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

WebUI.openBrowser('https://jh3.v2.php-cd.attractgroup.com')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'))
WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/signin')
WebUI.setText(findTestObject('Object Repository/Page_JH - JH Tackle/input_Email_email'), 'derektesting11+127@gmail.com')
WebUI.setText(findTestObject('Object Repository/Page_JH - JH Tackle/input_Password_password'), '111111')
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Login'))
wait.WaitLoad.jQuery()
Thread.sleep(5000)
WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/search?man%5B%5D=&q=Huk%20Ladies%20Packable%20Jacket%20Huk%20Ladies%20Packable%20Jacket%09')
wait.WaitLoad.jQuery()
WebUI.click(findTestObject('Object Repository/Pay/a_Huk Ladies Packable Jacket Huk Ladies Pac_cdb7d2'))
wait.WaitLoad.jQuery()
WebUI.click(findTestObject('Object Repository/Page_Huk Ladies Packable JacketH6400001 - J_492e8c/button_Add to Cart'))
wait.WaitLoad.jQuery()
WebUI.click(findTestObject('Object Repository/Pay/a_Proceed to Checkout'))
wait.WaitLoad.jQuery()

// Обязательные поля

String name = "Vlad"
String surname = "Verest"
String phone = "0633912160"
String address = "47 W 13th St, New York, NY 10011, USA"
String zipcode = "10001"
String cardnumber = "4007000000027"
String cvv = "123"

pay.PayPal.requiredFields( name,  surname,  phone,  address,  zipcode,  cardnumber,  cvv);