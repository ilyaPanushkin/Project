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

ArrayList<String> massCity =  new ArrayList<>();
massCity.add("Object Repository/City/Second");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[3]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[4]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[5]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[6]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[7]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[8]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[9]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[10]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[11]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[12]");

massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[13]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[14]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[15]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[16]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[17]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[18]");
massCity.add("/html/body/div[8]/div[1]/div/div[6]/form/div[2]/div[3]/div[2]/div[3]/div/div/div/ul/li[19]");
for(int i = 0; i<massCity.size(); i++){
WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/signin')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Email_email'), 'derektesting11+126@gmail.com')

WebUI.setText(findTestObject('Page_JH - JH Tackle/input_Password_password'), '111111')

WebUI.click(findTestObject('Page_JH - JH Tackle/button_Login'))
wait.WaitLoad.jQuery();
Thread.sleep(5000);
WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/search?man%5B%5D=&q=Huk%20Ladies%20Packable%20Jacket%20Huk%20Ladies%20Packable%20Jacket%09');
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Pay/a_Huk Ladies Packable Jacket Huk Ladies Pac_cdb7d2'))
wait.WaitLoad.jQuery();

WebUI.click(findTestObject('Object Repository/Page_Huk Ladies Packable JacketH6400001 - J_492e8c/button_Add to Cart'))
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Proceed to Checkout'))
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Shipping Address_change change_shipping_address'))
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Edit'))
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/span_New York'))
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/b'));
WebUI.selectOptionByIndex(findTestObject('Object Repository/City/Second'), 4)
wait.WaitLoad.jQuery();


WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Ok'))
wait.WaitLoad.jQuery();
WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Place                            your order'))
wait.WaitLoad.jQuery();
WebUI.waitForElementPresent(findTestObject('Page_JH - JH Tackle/div_Thank you Your order has been placed   _620785'), 0)
WebUI.closeBrowser()

}
