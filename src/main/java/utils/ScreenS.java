package utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenS {
    static public void takeScreenShot(WebDriver driver, String fileName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File DestFile = new File("pictureS/"+new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime()) + fileName + ".png");
//Copy file at destination
        try {
            FileUtils.copyFile(file, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getWebElementPNG(WebElement searchField, WebDriver driver, String search) {
    }
}