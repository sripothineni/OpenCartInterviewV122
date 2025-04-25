package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	
	@BeforeClass(groups={"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException {
		
		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		logger = LogManager.getLogger(this.getClass()); // log4j
		
		switch(browser.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default: System.out.println("Invalid Browser..."); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Reading URL from properties file
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();	
	}
	
	@AfterClass (groups={"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String ramdomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	@SuppressWarnings("deprecation")
	public String ramdomNumber() {
		return RandomStringUtils.randomNumeric(8);
	}
	
	public String captureScreen(String testName) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
