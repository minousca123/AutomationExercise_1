package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;

public class ScreenshotUtil {

    public static String captureScreenshot(String name) {  
    
    	   try {
               File src = ((TakesScreenshot) DriverManager.getDriver())
                       .getScreenshotAs(OutputType.FILE);

               String path = "reports/screenshots/" + name + ".png";

               FileUtils.copyFile(src, new File(path));
               return path;

           } catch (Exception e) {
               return null;
           }
       }
}
