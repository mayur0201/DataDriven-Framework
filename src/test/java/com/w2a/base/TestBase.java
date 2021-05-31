package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TestBase");
	public static WebDriverWait wait;

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setUp() throws IOException {

		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\java\\log4j.properties");

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				config.load(fis);
				log.debug("Config file loaded");
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.out.println(config.getProperty("browser"));
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

			driver = new ChromeDriver();
			log.debug("Chrome Launched");
		} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.get(config.getProperty("testsite"));
		log.debug("navigated to" + config.getProperty("testsite"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}

		catch (NoSuchElementException e) {

			return false;

		}

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
