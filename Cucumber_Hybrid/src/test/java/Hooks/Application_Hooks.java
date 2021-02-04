package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.Config_Reader;
import Utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Application_Hooks {

	private Properties p;
	private Config_Reader read;
	private DriverFactory driverFactory;
	private WebDriver driver;

	@Before(order = 0)
	public void setProp() {
		read = new Config_Reader();
		p = read.getProp();
	}

	@Before(order = 1)
	public void setDriver() {
		String b = p.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(b);
	}

	@After(order = 1)
	public void ifFailed(Scenario sc) {
		if (sc.isFailed()) {
			
			String screenshot = sc.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte [] src = ts.getScreenshotAs(OutputType.BYTES);
           sc.embed(src, "image/png");
		}
	}

	@After(order = 0)
	public void terminate() {
		driver.quit();
	}
}
