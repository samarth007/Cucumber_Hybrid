package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config_Reader {

	public Properties prop;
	
	public Properties getProp() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/utils/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
}
