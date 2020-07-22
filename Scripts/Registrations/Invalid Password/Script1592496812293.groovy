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
import org.openqa.selenium.WebElement

WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl("${GlobalVariable.dev1URLRegistration}")
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'));

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Last Name_surname'), 'Vasya')
WebUI.setText(findTestObject('Page_JH - JH Tackle/input_First Name_name'), 'Derek')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Email_email'), 'derekitesting11+09923@gmail.com')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Type it again_confirm_email'), 'derekitesting11+09923@gmail.com')
//Ввод пароля и повторный ввод пароля
registration.Registration.passEnter();



// 1. Пароль и его подтверждение границы невалидный  

ArrayList<String> massSpec = GlobalVariable.invPass;
GlobalVariable.fieldName = "Password";
GlobalVariable.pathField = "Object Repository/Page_JH - JH Tackle/input_Password_password";
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The password must be at least 6 characters";
GlobalVariable.expectedText = "The password must be at least 6 characters.";
GlobalVariable.firstPartEnterSym = "";
GlobalVariable.pathFieldSecond = "Object Repository/Page_JH - JH Tackle/input_Type it again_password_confirmation";
registration.InvalidSym.InvSym( GlobalVariable.invPass, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym, GlobalVariable.pathFieldSecond );




// 2. Пароль и его подтверждение пустые




GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The password field is required";
GlobalVariable.expectedText = "The password field is required.";
registration.InvalidSym.InvSym( GlobalVariable.emptySym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym, GlobalVariable.pathFieldSecond);
//Подтверждение пароля
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The password confirmation field is required";
GlobalVariable.expectedText = "The password confirmation field is required.";
registration.InvalidSym.InvSym( GlobalVariable.emptySym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym, GlobalVariable.pathFieldSecond);



// 3.Пароль валидный подтверждение пустое 



GlobalVariable.secondPartEnterSym ="";
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The password confirmation field is required";
GlobalVariable.expectedText = "The password confirmation field is required.";
registration.InvalidSym.InvSym( GlobalVariable.validPass, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText,GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym,  GlobalVariable.pathFieldSecond, GlobalVariable.secondPartEnterSym, GlobalVariable.emptySym);




// 4. Пароль пустой подтверждение непустое

GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The password field is required";
GlobalVariable.expectedText = "The password field is required.";
registration.InvalidSym.InvSym( GlobalVariable.emptySym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText,GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym,  GlobalVariable.pathFieldSecond, GlobalVariable.secondPartEnterSym, GlobalVariable.validPass);






WebUI.closeBrowser();