
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class InvalidSym {

    /* massSpec = массив с спец символами или любыми стринговыми массивами  
     * fieldName = Название поля для упоминания его в логах
     * pathField = Путь к полю над которым проводится тест
     * actualText = Путь к обьекту смообщения об ошибке 
     * expectedText = Ожидаемый текст
     */
    public static void InvSym(ArrayList<String> massSpec, String fieldName, String pathField, String actualText, String expectedText){

	for(int i = 0; i < massSpec.size() ; i++) {
	    //обход массива
	    GlobalVariable.timeStamp = logs.LogErrors.timeStamp();                   			         							 //время которое будет записоватся в logs.LogErrors.logFile
	    String symSpec = massSpec.get(i);                                          											 //Получаем элемент массива в текущей итерации
	    WebUI.setText(findTestObject("${pathField}"), "${symSpec}");            			  							         //вставляем в обьект который прислали в метод символ из текущей итерации
	    WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Create account')); 								 // клик на кнопку создать аккаунт
	    wait.WaitLoad.jQuery(); 																	 //Ожидать выполнения JQuery, если фейлится продолжить
	    WebUI.comment(WebUI.getUrl()); 																 // URL на котором нахожусь в консоль

	    if (WebUI.getUrl().contains("confirm")) {
		// если URL содержит "confirm" то
		logs.LogErrors.markStepFailed("Failed with symbol \"${symSpec}\" "); 											 //отметить в логах тест как зафейленный с указанным сообщением и символом при котором он зафейлился
		logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\" ${GlobalVariable.timeStamp} "+"\n" , "Registration"); 			 //Указать данное сообщение с спец символом для конретной итерации и поле в которое он был введен в кастомный лог
		WebUI.back(); 																		 // ернутся на страницу назад
		registration.Registration.passEnter(); 															 // ввод пароля и повторноый его ввод
		logs.LogErrors.logScreen("${fieldName} have spec [${i}]", "Registration");

	    } else {

		String actualTextLocal = WebUI.getText(findTestObject(actualText));
		WebUI.comment(symSpec); 														       	         // символ при котором появлется сообщение
		if(WebUI.verifyMatch(expectedText ,actualTextLocal, false, FailureHandling.CONTINUE_ON_FAILURE ) == false) { 				 	         // сравнение фактического и ожидаемого текста false сли не является регулярный выражением и продолжать если зафейлится

		    logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\" with text \"${actualTextLocal}\" expected text \"${expectedText}\"  ${GlobalVariable.timeStamp}" + "\n", "Registration"); 			//аписать в кастомны лог поле имени символ в этом поле фактический и ожидаемый текст
		    logs.LogErrors.logScreen("${fieldName} have wrong error massage, expected \'${expectedText}\' with symbol [${i}] ", "Registration");

		}  else { continue; } 																        // если совпадает текст и все ок продолжить и перейти к следующей итерации
	    }
	}
    }

    public static void InvSym(ArrayList<String> massSpec, String fieldName, String pathField, String actualText, String expectedText,String firstPartEnterSym){

	for(int i = 0; i<massSpec.size() ;i++) {

	    GlobalVariable.timeStamp = logs.LogErrors.timeStamp();
	    String symSpec = massSpec.get(i);
	    WebUI.setText(findTestObject("${pathField}"), "${firstPartEnterSym}${symSpec}");
	    WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Create account'));
	    wait.WaitLoad.jQuery(); 																	//Ожидать выполнения JQuery, если фейлится продолжить
	    WebUI.comment(WebUI.getUrl())

	    if (WebUI.getUrl().contains("confirm") ) {

		logs.LogErrors.markStepFailed("Failed with symbol \"${symSpec}\" ");
		logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\" ${GlobalVariable.timeStamp} "+"\n", "Registration");
		WebUI.back();
		registration.Registration.passEnter();
		logs.LogErrors.logScreen("${fieldName} have spec [${i}]", "Registration");

	    } else {

		String actualTextLocal = WebUI.getText(findTestObject(actualText));
		WebUI.comment(symSpec);
		if(WebUI.verifyMatch(expectedText ,actualTextLocal, false, FailureHandling.CONTINUE_ON_FAILURE ) == false) {

		    logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\" with text \"${actualTextLocal}\" expected text \"${expectedText}\"  ${GlobalVariable.timeStamp}" + "\n", "Registration");
		    logs.LogErrors.logScreen("${fieldName} have wrong error massage, expected \'${expectedText}\' with symbol [${i}] ", "Registration");

		} else { continue; }
	    }

	}
    }


    // Перегрузка метода для изменения нескольких строк одинаковыми элементами

    public static void InvSym(ArrayList<String> massSpec, String fieldName, String pathField, String actualText, String expectedText,String firstPartEnterSym, String pathFieldSecond){

	for(int i = 0 ; i < massSpec.size() ; i++) {

	    GlobalVariable.timeStamp = logs.LogErrors.timeStamp();
	    String symSpec = massSpec.get(i);
	    WebUI.setText(findTestObject("${pathField}"), "${firstPartEnterSym}${symSpec}"); //Этой
	    WebUI.setText(findTestObject("${pathFieldSecond}"), "");
	    WebUI.setText(findTestObject("${pathFieldSecond}"), "${firstPartEnterSym}${symSpec}"); // И этой
	    WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Create account'));
	    wait.WaitLoad.jQuery();
	    WebUI.comment(WebUI.getUrl())

	    if (WebUI.getUrl().contains("confirm") ) {
		logs.LogErrors.markStepFailed("Failed with symbol \"${symSpec}\" ");
		logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\"  ${GlobalVariable.timeStamp} "+"\n", "Registration");
		WebUI.back();
		registration.Registration.passEnter();
		logs.LogErrors.logScreen("${fieldName} have spec [${i}]");

	    } else {

		WebUI.comment(symSpec);
		String actualTextLocal = WebUI.getText(findTestObject(actualText));

		if(WebUI.verifyMatch(expectedText ,actualTextLocal, false, FailureHandling.CONTINUE_ON_FAILURE  ) == false) {

		    logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\" with text \"${actualText}\" expected text \"${expectedText}\"   ${GlobalVariable.timeStamp}"+"\n", "Registration");
		    logs.LogErrors.logScreen("${fieldName} have wrong error massage, expected \'${expectedText}\' with symbol [${i}] ");

		} else { continue; }
	    }

	}

    }


    // Перегрузка метода для изменения строк разными значениями


    public static void InvSym(ArrayList<String> massSpec, String fieldName, String pathField, String actualText, String expectedText,String firstPartEnterSym, String pathFieldSecond, String secondPartEnterSym, ArrayList<String> massSecondField){

	for(int i=0; i<massSecondField.size(); i++){

	    GlobalVariable.timeStamp = logs.LogErrors.timeStamp();
	    String symSpec1 = massSecondField.get(i);
	    WebUI.setText(findTestObject("${pathFieldSecond}"), "");
	    WebUI.setText(findTestObject("${pathFieldSecond}"), "${secondPartEnterSym}${symSpec1}"); // И этой

	}


	for(int i = 0; i<massSpec.size(); i++)  {
	    GlobalVariable.timeStamp = logs.LogErrors.timeStamp();
	    String symSpec = massSpec.get(i);
	    WebUI.setText(findTestObject("${pathField}"), "${firstPartEnterSym}${symSpec}"); //Этой
	    WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Create account'));
	    wait.WaitLoad.jQuery();
	    WebUI.comment(WebUI.getUrl())

	    if (WebUI.getUrl().contains("confirm") ) {

		logs.LogErrors.markStepFailed("Failed with symbol \"${symSpec}\" ");
		logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\"  ${GlobalVariable.timeStamp}"+"\n");
		WebUI.back();
		registration.Registration.passEnter();
		logs.LogErrors.logScreen("${fieldName} have spec [${i}]");

	    } else {

		WebUI.comment(symSpec);
		String actualTextLocal = WebUI.getText(findTestObject(actualText));

		if(WebUI.verifyMatch(expectedText ,actualTextLocal, false, FailureHandling.CONTINUE_ON_FAILURE  ) == false) {

		    logs.LogErrors.logFile("Failed with symbol \"${symSpec}\" on field \"${fieldName}\" with text \"${actualTextLocal}\" expected text \"${expectedText}\"   ${GlobalVariable.timeStamp}"+"\n", "Registration");
		    logs.LogErrors.logScreen("${fieldName} have wrong error massage, expected \'${expectedText}\' with symbol [${i}] ", "Registration");

		} else {continue;}
	    }

	}

    }






















}
