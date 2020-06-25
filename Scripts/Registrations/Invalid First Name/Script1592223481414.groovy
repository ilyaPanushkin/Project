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

WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/registration')
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'));

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Last Name_surname'), 'Vasya')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Email_email'), 'derekitesting11+09923@gmail.com')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Type it again_confirm_email'), 'derekitesting11+09923@gmail.com')
//Ввод пароля и повторный ввод пароля
registration.Registration.passEnter();



// 1. Невалидные символы в поле "Имя"

GlobalVariable.firstPartEnterSym = "Derek";
// Название поля в логах 
GlobalVariable.fieldName = "FirstName";
// Путь к обьекту поля в которое вводятся символы для проверки из массива в 36 строке
GlobalVariable.pathField = "Page_JH - JH Tackle/input_First Name_name";
// Путь к ообьекту сообщения об ошибке для проверки 
GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The name may only contain letters";
// Ожидаемый текст с ошибкой
GlobalVariable.expectedText = "The name may only contain letters.";
// Обьект который это все выполнит :)
registration.InvalidSym.InvSym( GlobalVariable.massSpec, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym);




// 2. NON ASII символы в поле Имя

// Обьект который это все выполнит :)
registration.InvalidSym.InvSym( GlobalVariable.nonasciiSym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym);





// 3. Символы чисел в поле Имя

// Обьект который это все выполнит :)
registration.InvalidSym.InvSym( GlobalVariable.numSym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText, GlobalVariable.firstPartEnterSym);




// 4. Исключетельно пробел в поле Имени

// Путь к обьекту сообщения об ошибке для проверки
 GlobalVariable.actualText = "Object Repository/Page_JH - JH Tackle/div_The name field is required";
// Ожидаемый текст с ошибкой
 GlobalVariable.expectedText = "The name field is required.";
// Обьект который это все выполнит :)
registration.InvalidSym.InvSym( GlobalVariable.spaceSym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText);




// 5. Пустое поле Имени

registration.InvalidSym.InvSym(GlobalVariable.emptySym, GlobalVariable.fieldName, GlobalVariable.pathField, GlobalVariable.actualText, GlobalVariable.expectedText);


WebUI.closeBrowser()

