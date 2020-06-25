package logs
import java.*
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import internal.GlobalVariable
import io.appium.java_client.functions.ExpectedCondition
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.io.FileWriter;
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class LogErrors {
    //Кастомный лог ошибок вывод в консоль при фейле и отметка шага зафейленного
    public static void markStepFailed(String errMsg) {
	//ArrayList<String> symValue = GlobalVariable.massSpec;
	KeywordLogger log = new KeywordLogger();

	log.logFailed(errMsg);
	KeywordUtil.markFailed("One or more failed steps present. Check test report for details.");
    }




    //Запись фейлов в текстовый доккумент


    public static String logFile(String log, String folderTextError){


	File file = new File("D:\\Test\\File\\${folderTextError}\\fail.txt");
	file.createNewFile();
	FileWriter writer = new FileWriter(file, true);
	writer.write(log);
	writer.flush();
	writer.close();

    }






    //Скриншот экрана
    // take screenshot and save a PNG file into Reports dir
    public static void logScreen(String name, String folderScreen){

	Path projectDir = Paths.get(RunConfiguration.getProjectDir())
	Path reportDir = projectDir.resolve('Screenshots')
	Files.createDirectories(reportDir)
	Path pngFile = reportDir.resolve("D:\\Test\\Screen\\${folderScreen}\\${name}.png")
	WebDriver driver = DriverFactory.getWebDriver()
	takeEntirePage(driver, pngFile.toFile(), 1000)
	
    }
    
    // take screenshot of entire web page
    public static void takeEntirePage(WebDriver webDriver, File file, Integer timeout = 300) {
	Screenshot screenshot = new AShot().
		coordsProvider(new WebDriverCoordsProvider()).
		shootingStrategy(ShootingStrategies.viewportPasting(timeout)).
		takeScreenshot(webDriver)
	ImageIO.write(screenshot.getImage(), "PNG", file)

    }






    // Текущее время
    public static String timeStamp(){
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	return timeStamp;
    }


}



