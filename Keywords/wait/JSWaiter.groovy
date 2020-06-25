package wait

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
import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.IOException;
import internal.GlobalVariable
import java.io.*;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.rmi.RemoteException;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

// РАЗОБРАТЬСЯ 

public class JSWaiter {
/*
	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;

	//Get the driver
	public static void setDriver (WebDriver driver) {
		jsWaitDriver = driver;
		jsWait = new WebDriverWait(jsWaitDriver, 10);
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}

	private void ajaxComplete() {
		jsExec.executeScript("var callback = arguments[arguments.length - 1];"
		+ "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
		+ "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
		+ "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
	}

	private void waitForJQueryLoad() {
		try {
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
			.executeScript("return jQuery.active") == 0);

			boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

			if (!jqueryReady) {
				jsWait.until(jQueryLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitForAngularLoad() {
		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
		angularLoads(angularReadyScript);
	}

	private void waitUntilJSReady() {
		try {
			ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
			.executeScript("return document.readyState").toString().equals("complete");

			boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");

			if (!jsReady) {
				jsWait.until(jsLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitUntilJQueryReady() {
		Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
		if (jQueryDefined) {
			poll(20);

			waitForJQueryLoad();

			poll(20);
		}
	}

	public void waitUntilAngularReady() {
		try {
			Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
			if (!angularUnDefined) {
				Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
				if (!angularInjectorUnDefined) {
					poll(20);

					waitForAngularLoad();

					poll(20);
				}
			}
		} catch (WebDriverException ignored) {
		}
	}

	public void waitUntilAngular5Ready() {
		try {
			Object angular5Check = jsExec.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
			if (angular5Check != null) {
				Boolean angularPageLoaded = (Boolean) jsExec.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
				if (!angularPageLoaded) {
					poll(20);

					waitForAngular5Load();

					poll(20);
				}
			}
		} catch (WebDriverException ignored) {
		}
	}

	private void waitForAngular5Load() {
		String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
		angularLoads(angularReadyScript);
	}

	private void angularLoads(String angularReadyScript) {
		try {
			ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
			.executeScript(angularReadyScript).toString());

			boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

			if (!angularReady) {
				jsWait.until(angularLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	public void waitAllRequest() {
		waitUntilJSReady();
		ajaxComplete();
		waitUntilJQueryReady();
		waitUntilAngularReady();
		waitUntilAngular5Ready();
	}

	/*
	 * Method to make sure a specific element has loaded on the page
	 *
	 * @param by
	 * @param expected
	 */
	
	
	
	/*
	public void waitForElementAreComplete(By by, int expected) {
		ExpectedCondition<Boolean> angularLoad = driver -> {
			int loadingElements = this.driver.findElements(by).size();
			return loadingElements >= expected;
		};
		jsWait.until(angularLoad);
	}

	/**
	 * Waits for the elements animation to be completed
	 * @param css
	 */
	
	
	/*
	public void waitForAnimationToComplete(String css) {
		ExpectedCondition<Boolean> angularLoad = driver -> {
			int loadingElements = this.driver.findElements(By.cssSelector(css)).size();
			return loadingElements == 0;
		};
		jsWait.until(angularLoad);
	}

	private void poll(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/
}