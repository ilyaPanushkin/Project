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


WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/registration')
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'));


// Проверка всех текстов на странице
GlobalVariable.massActualText[0] = "Object Repository/Registration/label_Email";
GlobalVariable.massActualText[1] = "Object Repository/Registration/label_Enter a password";
GlobalVariable.massActualText[2] = "Object Repository/Registration/label_First Name"
GlobalVariable.massActualText[3] = "Object Repository/Registration/label_Last Name"
GlobalVariable.massActualText[4] = "Object Repository/Registration/label_Type it again email"
GlobalVariable.massActualText[5] = "Object Repository/Registration/label_Type it again password"
GlobalVariable.massActualText[6] = "Object Repository/Registration/Text on page verify/a_Login"
GlobalVariable.massActualText[7] = "Object Repository/Registration/Text on page verify/a_Login with facebook"
GlobalVariable.massActualText[8] = "Object Repository/Registration/Text on page verify/a_Privacy Policy"
GlobalVariable.massActualText[9] = "Object Repository/Registration/Text on page verify/button_Create account"
GlobalVariable.massActualText[10] = "Object Repository/Registration/Text on page verify/div_- or -"
GlobalVariable.massActualText[11] = "Object Repository/Registration/Text on page verify/div_Account  activation"
GlobalVariable.massActualText[12] = "Object Repository/Registration/Text on page verify/div_Already have an account"
GlobalVariable.massActualText[13] = "Object Repository/Registration/Text on page verify/div_Email  confirmation"
GlobalVariable.massActualText[14] = "Object Repository/Registration/Text on page verify/div_Register"
GlobalVariable.massActualText[15] = "Object Repository/Registration/Text on page verify/div_This will be your only JH Tackle password"
GlobalVariable.massActualText[16] = "Object Repository/Registration/Text on page verify/label_Join the JH Tackle mailing list for coupons and discounts"
GlobalVariable.massActualText[17] = "Object Repository/Registration/Text on page verify/span_Create A JH Tackle Account"
GlobalVariable.massActualText[18] = "Object Repository/Registration/Text on page verify/span_Protect your information with a password"



GlobalVariable.massExpectedText[0] = "Email*:"
GlobalVariable.massExpectedText[1] = "Enter a password*:"
GlobalVariable.massExpectedText[2] = "First Name*:"
GlobalVariable.massExpectedText[3] = "Last Name*:"
GlobalVariable.massExpectedText[4] = "Type it again*:"
GlobalVariable.massExpectedText[5] = "Type it again*:"
GlobalVariable.massExpectedText[6] = "Login"
GlobalVariable.massExpectedText[7] = "Login with facebook"
GlobalVariable.massExpectedText[8] = "Privacy Policy"
GlobalVariable.massExpectedText[9] = "Create account"
GlobalVariable.massExpectedText[10] = "- or -"
GlobalVariable.massExpectedText[11] = "Account"+ "\n" +"activation"
GlobalVariable.massExpectedText[12] = "Already have an account?"
GlobalVariable.massExpectedText[13] = "Email"+ "\n" + "confirmation"
GlobalVariable.massExpectedText[14] = "Register"
GlobalVariable.massExpectedText[15] = "This will be your only J&H Tackle password"
GlobalVariable.massExpectedText[16] = "Join the J&H Tackle mailing list for coupons and discounts"
GlobalVariable.massExpectedText[17] = "Create A J&H Tackle Account"
GlobalVariable.massExpectedText[18] = "Protect your information with a password"



registration.VerifyText.textPageVerify(GlobalVariable.massActualText, GlobalVariable.massExpectedText);


