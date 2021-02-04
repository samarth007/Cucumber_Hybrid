package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> t = new ThreadLocal<WebDriver>();
	
	
	public WebDriver init_driver(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			t.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			t.set(new FirefoxDriver());
		}
		else {
			System.out.println("no browser");
		}
		
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return t.get();
	}
}
