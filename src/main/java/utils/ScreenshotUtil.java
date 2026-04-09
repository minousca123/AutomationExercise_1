package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {

		String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
		File folder = new File(folderPath);

		// ✅ Ensure folder exists
		if (!folder.exists()) {
			folder.mkdirs();
		}

		String filePath = folderPath + testName + "_" + System.currentTimeMillis() + ".png";

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ✅ IMPORTANT → return RELATIVE path
		return "screenshots/" + new File(filePath).getName();
	}
}
