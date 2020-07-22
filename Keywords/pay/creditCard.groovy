package pay

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.ArrayList

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

public class CreditCard {

    public static void proceedToCheckoutOneProduct(String urlProduct, String user) {
	WebUI.openBrowser('https://jh3.v2.php-cd.attractgroup.com')
	WebUI.maximizeWindow()
	WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/a_Request_phpdebugbar-close-btn'))
	WebUI.navigateToUrl('https://jh3.v2.php-cd.attractgroup.com/signin')
	WebUI.setText(findTestObject('Object Repository/Page_JH - JH Tackle/input_Email_email'), user)
	WebUI.setText(findTestObject('Object Repository/Page_JH - JH Tackle/input_Password_password'), '111111')
	WebUI.click(findTestObject('Object Repository/Page_JH - JH Tackle/button_Login'))
	wait.WaitLoad.jQuery()
	Thread.sleep(5000)
	WebUI.navigateToUrl(urlProduct)
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Object Repository/Page_Huk Ladies Packable JacketH6400001 - J_492e8c/button_Add to Cart'))
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Object Repository/Pay/a_Proceed to Checkout'))
	wait.WaitLoad.jQuery()
    }

    
    
    public static void fillFieldBillingingAddressRequired(String name, String surname, String phone, String address, String zipcode){
	wait.WaitLoad.jQuery()
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_first_name'), "${name}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_last_name'), "${surname}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_phone_number'), "${phone}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_address1'), "${address}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_required_bill_zip_code'), "${zipcode}")
	wait.WaitLoad.jQuery()
    }
    
    public static void fillFieldBillingingAddressOptional(String company, String apartment){
	
	wait.WaitLoad.jQuery()
	WebUI.setText(findTestObject('Object Repository/Pay/optional_bill_company'), "${company}")
	WebUI.setText(findTestObject('Object Repository/Pay/optional_bill_apartment'), "${apartment}")
	
    }
    
    public static void fillCreditCardField(String cardnumber, String cvv){
	WebUI.click(findTestObject('Object Repository/Pay/input_Credit Card_card_number'))
	WebUI.setText(findTestObject('Object Repository/Pay/input_Credit Card_card_number'), "${cardnumber}")
	WebUI.setText(findTestObject('Object Repository/Pay/input_CVV Number_sid'), "${cvv}")
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Object Repository/Pay/dropdown_click_year_cart'))
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Pay/clickon_year_2023'))
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Pay/dropdown_click_month_cart'))
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Pay/clickon_month'))
    }
    public static void verifyOrderSummery(String urlProduct){
	String items = WebUI.getText(findTestObject('Object Repository/Pay/item_cost'));
	String shipping = WebUI.getText(findTestObject('Pay/shipping_on_checkout_cost'));
	String promocode = WebUI.getText(findTestObject('Object Repository/Pay/promocode_checkout_cost'));

	String totalBeforeTax = WebUI.getText(findTestObject('Object Repository/Pay/total_before_tax'));
	String estimatedTaxToBeCollected = WebUI.getText(findTestObject('Object Repository/Pay/estimatedTaxToBeCollected'));
	String giftCards = WebUI.getText(findTestObject('Object Repository/Pay/gift_Cards_checkout_cost'));
	String credits = WebUI.getText(findTestObject('Object Repository/Pay/credits_checkout_cost'));
	String orderTotal = WebUI.getText(findTestObject('Object Repository/Pay/order_total_checkout_cost'));
	WebUI.comment("${shipping}")
	wait.WaitLoad.jQuery()
	if((shipping == null && (urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/huk-h6400001-ladies-packable-jacket.html' || urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/chatterlures-the-tuna-bomber-weighted-bigeye-chain.html'))
	||
	(shipping == '$0.00' && (urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/huk-h6400001-ladies-packable-jacket.html' || urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/chatterlures-the-tuna-bomber-weighted-bigeye-chain.html'))){

	    logs.LogErrors.markStepFailed("Shipping cost null or \$0.00: \"${shipping}\" ");
	    logs.LogErrors.logFile("Shipping cost null or \$0.00: \"${shipping}\" " + "\n", "Pay", "fail")
	    logs.LogErrors.logScreen("Shipping is null or 0.00", "Pay")
	    
	}
	
	else if(shipping == '$12.99' && urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/tsunami-five-star-spinning-rods.html') {
	    
	    logs.LogErrors.logFile("Shipping cost: \"${shipping}\"" + "\n", "Pay", "ShippingCheckoutPage")
		
	}
	
	else {
	    
	    logs.LogErrors.logFile("Shipping cost: \"${shipping}\"" + "\n", "Pay", "ShippingCheckoutPage")
	    
	}

	
    }
    
    public static void verifyOrderSummeryAndFinishOrder(String urlProduct){
	
	String items = WebUI.getText(findTestObject('Object Repository/Pay/item_cost'));
	String shipping = WebUI.getText(findTestObject('Pay/shipping_on_checkout_cost'));
	String promocode = WebUI.getText(findTestObject('Object Repository/Pay/promocode_checkout_cost'));

	String totalBeforeTax = WebUI.getText(findTestObject('Object Repository/Pay/total_before_tax'));
	String estimatedTaxToBeCollected = WebUI.getText(findTestObject('Object Repository/Pay/estimatedTaxToBeCollected'));
	String giftCards = WebUI.getText(findTestObject('Object Repository/Pay/gift_Cards_checkout_cost'));
	String credits = WebUI.getText(findTestObject('Object Repository/Pay/credits_checkout_cost'));
	String orderTotal = WebUI.getText(findTestObject('Object Repository/Pay/order_total_checkout_cost'));
	WebUI.comment("${shipping}")
	wait.WaitLoad.jQuery()
	if((shipping == null && (urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/huk-h6400001-ladies-packable-jacket.html' || urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/chatterlures-the-tuna-bomber-weighted-bigeye-chain.html'))
	||
	(shipping == '$0.00' && (urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/huk-h6400001-ladies-packable-jacket.html' || urlProduct == 'https://jh3.v2.php-cd.attractgroup.com/products/chatterlures-the-tuna-bomber-weighted-bigeye-chain.html'))){

	    logs.LogErrors.markStepFailed("Shipping cost null or \$0.00: \"${shipping}\" ");
	    logs.LogErrors.logFile("Shipping cost null or \$0.00: \"${shipping}\" " + "\n", "Pay", "fail")
	    logs.LogErrors.logScreen("Shipping is null or 0.00", "Pay")
	}
	else {
	    logs.LogErrors.logFile("Shipping cost: \"${shipping}\"" + "\n", "Pay", "ShippingCheckoutPage")
	}
	
	WebUI.click(findTestObject('Object Repository/Pay/review_your_order'))
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Object Repository/Pay/place_your_order'))
	wait.WaitLoad.jQuery()
	String ordernumber  = WebUI.getText(findTestObject('Object Repository/Pay/order_number'));
	logs.LogErrors.logFile("Order number: \"${ordernumber}\" items: \"${items}\" Shipping & handling: \"${shipping}\" Promo Codes: \"${promocode}\" Total before tax \"${totalBeforeTax}\" Estimated tax to be collected: \"${estimatedTaxToBeCollected}\" Gift Cards: \"${giftCards}\" Credits:	\"${credits}\" Order total: \"${orderTotal}\" URL Product: \"${urlProduct}\"" +"\n","Pay","AllInformationOrderPass")
	//Записывается всегда но валидно только если перед ним лог из if 
	logs.LogErrors.logFile("||Order number \"${ordernumber}\" (not fail if you see only order number)" + "\n", "Pay", "fail")
	
    }
    
    public static void finishOrder(String items, String shipping, String promocode, String totalBeforeTax, String estimatedTaxToBeCollected){
	
	WebUI.click(findTestObject('Object Repository/Pay/review_your_order'))
	wait.WaitLoad.jQuery()
	WebUI.click(findTestObject('Object Repository/Pay/place_your_order'))
	wait.WaitLoad.jQuery()
	
    }
    
   
}
