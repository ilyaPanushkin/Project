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
import java.util.ArrayList;

WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/registration')
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'));

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Last Name_surname'), 'Vasya')
WebUI.setText(findTestObject('Page_JH - JH Tackle/input_First Name_name'), 'Derek')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Email_email'), 'derekitesting11+09923@gmail.com')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Type it again_confirm_email'), 'derekitesting11+09923@gmail.com')
//Ввод пароля и повторный ввод пароля
registration.Registration.passEnter();

// 1.Невалидный email

GlobalVariable.firstPartEnterSym = "derek";
GlobalVariable.secondPartEnterSym = "derek";
// Название поля в логах 
GlobalVariable.fieldName = "Email";
// Путь к обьекту поля в которое вводятся символы для проверки из массива в 36 строке
GlobalVariable.pathField = "Page_JH - JH Tackle/input_Email_email";
// Путь к ообьекту сообщения об ошибке для проверки 
GlobalVariable.actualText  = "Object Repository/Page_JH - JH Tackle/Email/div_The email must be a valid email address";
// Ожидаемый текст с ошибкой
GlobalVariable.expectedText  = "The email must be a valid email address.";
// Обьект который это все выполнит :) 
registration.InvalidSym.InvSym( GlobalVariable.invEmail, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym);




// 2. Существующий email

 // Путь к ообьекту сообщения об ошибке для проверки
 GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/Email/div_The email is already in use";
 // Ожидаемый текст с ошибкой
 GlobalVariable.expectedText = "The email is already in use.";
 registration.InvalidSym.InvSym( GlobalVariable.existEmail, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym);
 
 
 
 
 //3. Пустое поле email
 
GlobalVariable.firstPartEnterSym = "";
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/Email/div_The email field is required";
GlobalVariable.expectedText = "The email field is required.";
registration.InvalidSym.InvSym( GlobalVariable.emptySym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym);

  




//Несколько полей:

//4. Поле Email and Type it again (одинаковые невалидные email с одного массива)
GlobalVariable.firstPartEnterSym = "derek";
GlobalVariable.pathFieldSecond = "Page_JH - JH Tackle/input_Type it again_confirm_email";
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/Email/div_The confirm email must be a valid email address";
GlobalVariable.expectedText = "The confirm email must be a valid email address.";
GlobalVariable.fieldName = "Type it again";
registration.InvalidSym.InvSym( GlobalVariable.invEmail, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym,  GlobalVariable.pathFieldSecond);




// 5. Поле Type it again невалидно и не совпадпет с email

GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The confirm email must be a valid email address The confirm email and email must match";
GlobalVariable.expectedText = "The confirm email must be a valid email address. The confirm email and email must match.";
registration.InvalidSym.InvSym( GlobalVariable.email, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym,  GlobalVariable.pathFieldSecond, GlobalVariable.secondPartEnterSym, GlobalVariable.massSecondField);



// 6. Поле Type it again валидно но не совпадпет с email

GlobalVariable.massSecondField[0]= "testing111@gmail.com";
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/Email/div_The confirm email and email must match";
GlobalVariable.expectedText = "The confirm email and email must match.";
registration.InvalidSym.InvSym( GlobalVariable.email, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym,  GlobalVariable.pathFieldSecond, GlobalVariable.secondPartEnterSym, GlobalVariable.massSecondField);



// 7. Пустое поле Type it again

GlobalVariable.secondPartEnterSym= "";
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/Email/div_The confirm email field is required";
GlobalVariable.expectedText = "The confirm email field is required.";
registration.InvalidSym.InvSym(GlobalVariable.email, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym,  GlobalVariable.pathFieldSecond, GlobalVariable.secondPartEnterSym, GlobalVariable.emptySym);








WebUI.closeBrowser();

