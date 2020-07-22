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

String urlProduct ='https://jh3.v2.php-cd.attractgroup.com/products/huk-h6400001-ladies-packable-jacket.html'
String user = 'derektesting11+128@gmail.com'
urlProdust = 'https://jh3.v2.php-cd.attractgroup.com/products/chatterlures-the-tuna-bomber-weighted-bigeye-chain.html'
urlProduct = 'https://jh3.v2.php-cd.attractgroup.com/products/tsunami-five-star-spinning-rods.html'

// Отмечен чекбокс "This address is also my shipping address"

// 1. Обязательные поля Visa 

pay.CreditCard.proceedToCheckoutOneProduct(urlProduct, user)
String name = "Vlad"
String surname = "Verest"
String phone = "0633912160"
String address = "47 W 13th St, New York, NY 10011, USA"
String zipcode = "10001"
pay.CreditCard.fillFieldBillingingAddressRequired(name,  surname,  phone,  address,  zipcode)
String cardnumber = "4007000000027"
String cvv = "123"
pay.CreditCard.fillCreditCardField( cardnumber,  cvv)
pay.CreditCard.verifyOrderSummeryAndFinishOrder( urlProduct)
WebUI.closeBrowser()

// 2. MasterCard 

pay.CreditCard.proceedToCheckoutOneProduct(urlProduct, user)
pay.CreditCard.fillFieldBillingingAddressRequired(name,  surname,  phone,  address,  zipcode)
cardnumber = "5424000000000015"
cvv = "1234"
pay.CreditCard.fillCreditCardField( cardnumber,  cvv)
pay.CreditCard.verifyOrderSummeryAndFinishOrder( urlProduct)

// 3. Discover card  

pay.CreditCard.proceedToCheckoutOneProduct(urlProduct, user)
pay.CreditCard.fillFieldBillingingAddressRequired(name,  surname,  phone,  address,  zipcode)
cardnumber = "6011000000000012"
cvv = "123"
pay.CreditCard.fillCreditCardField( cardnumber,  cvv)
pay.CreditCard.verifyOrderSummeryAndFinishOrder( urlProduct)

// 4. American Express 	card 

pay.CreditCard.proceedToCheckoutOneProduct(urlProduct, user)
pay.CreditCard.fillFieldBillingingAddressRequired(name,  surname,  phone,  address,  zipcode)
cardnumber = "370000000000002"
cvv = "1234"
pay.CreditCard.fillCreditCardField( cardnumber,  cvv)
pay.CreditCard.verifyOrderSummeryAndFinishOrder( urlProduct)

// 5. Discover card 

pay.CreditCard.proceedToCheckoutOneProduct(urlProduct, user)
pay.CreditCard.fillFieldBillingingAddressRequired(name,  surname,  phone,  address,  zipcode)
cardnumber = "6011000000000012"
cvv = "123"
pay.CreditCard.fillCreditCardField( cardnumber,  cvv)
pay.CreditCard.verifyOrderSummeryAndFinishOrder( urlProduct)

// 6. 


// Все поля 

pay.CreditCard.proceedToCheckoutOneProduct(urlProduct, user)
pay.CreditCard.fillFieldBillingingAddressRequired(name,  surname,  phone,  address,  zipcode)
pay.CreditCard.fillCreditCardField( cardnumber,  cvv)
String company = "Attract Group"
String apartment = "entrance 1, building 234, floor 2, apartment 8"
pay.CreditCard.fillFieldBillingingAddressOptional(company, apartment)
pay.CreditCard.verifyOrderSummeryAndFinishOrder(urlProduct)
WebUI.closeBrowser()
////


