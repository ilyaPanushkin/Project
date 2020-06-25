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
/*
WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/registration')
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'));
WebUI.setText(findTestObject('Page_JH - JH Tackle/input_First Name_name'), 'Derek')
WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Last Name_surname'), 'Vasya')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Email_email'), 'derekitesting11+09923@gmail.com')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Type it again_confirm_email'), 'derekitesting11+09923@gmail.com')
//Ввод пароля и повторный ввод пароля
registration.Registration.passEnter();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Create account'));
wait.WaitLoad.jQuary();
logs.LogErrors.logFile("/n" + "Валидный email для регистрации: ${GlobalVariable.baseEmail}" + "/n");
*/

ArrayList<String> massSpec = GlobalVariable.massSpec;

/*

for(int i = 0;i<massSpec.size(); i++){
	String a = massSpec.get(i);
	logs.LogErrors.logFile("Невалидные символы: ${a}" + "\n");
}


String massSpeca = GlobalVariable.baseEmailLogin;


	logs.LogErrors.logFile("baseEmailLogin: ${massSpeca}" + "\n");



ArrayList<String> massSpecb = GlobalVariable.spaceSym;

for(int i = 0;i<massSpecb.size(); i++){
	String c = massSpecb.get(i);
	logs.LogErrors.logFile("spaceSym: ${c}" + "\n");
}

ArrayList<String> massSpecc = GlobalVariable.emptySym;

for(int i = 0;i<massSpecc.size(); i++){
	String d = massSpecc.get(i);
	logs.LogErrors.logFile("emptySym: ${d}" + "\n");
}


ArrayList<String> massSpece = GlobalVariable.numSym;

for(int i = 0;i<massSpece.size(); i++){
	String v = massSpece.get(i);
	logs.LogErrors.logFile("numSym: ${v}" + "\n");
}



ArrayList<String> massSpecr = GlobalVariable.nonasciiSym;

for(int i = 0;i<massSpecr.size(); i++){
	String d = massSpecr.get(i);
	logs.LogErrors.logFile("nonasciiSym: ${d}" + "\n");
}


ArrayList<String> massSpect = GlobalVariable.invEmail;

for(int i = 0;i<massSpect.size(); i++){
	String f = massSpect.get(i);
	logs.LogErrors.logFile("invEmail: ${f}" + "\n");
}

ArrayList<String> massSpecy = GlobalVariable.existEmail;

for(int i = 0;i<massSpecy.size(); i++){
	String q = massSpecy.get(i);
	logs.LogErrors.logFile("existEmail: ${q}" + "\n");
}
ArrayList<String> massSpecu = GlobalVariable.massSecondField;

for(int i = 0;i<massSpecu.size(); i++){
	String w = massSpecu.get(i);
	logs.LogErrors.logFile("massSecondField: ${w}" + "\n");
}
ArrayList<String> massSpeci = GlobalVariable.invPass;

for(int i = 0;i<massSpeci.size(); i++){
	String e = massSpeci.get(i);
	logs.LogErrors.logFile("invPass: ${e}" + "\n");
}
ArrayList<String> massSpeco = GlobalVariable.validPass;

for(int i = 0;i<massSpeco.size(); i++){
	String r = massSpeco.get(i);
	logs.LogErrors.logFile("validPass: ${r}" + "\n");
}
String massSpecp = GlobalVariable.baseEmail;


	
	logs.LogErrors.logFile("baseEmail: ${massSpecp}" + "\n");


*/


WebUI.closeBrowser();
