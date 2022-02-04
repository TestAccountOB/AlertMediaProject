package Utils;

import Testbase.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CommonMethods extends PageInitializer {

    /**
     * Use this method to send text.
     *
     * @param element    Pass the web element.
     * @param textToSend Pass text to send
     */
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * Use this method in need of surrounding an element with Red border.
     *
     * @param element Pass the web element.
     */
    public static void drawRedBorder(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid Red'", element);
    }

    /**
     * Use this method to apply explicit wait.
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * Use this method to apply explicit wait for element to be clickable.
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Use this method to click on WebElement.
     *
     * @param element Pass the web element.
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * Use this method to scroll up using Javascript Executor interface.
     */
    public static void jsScrollUp() {
        getJSExecutor().executeScript("window.scrollBy(0,200)");
    }


    /**
     * Use this method to scroll down using Javascript Executor interface.
     */
    public static void jsScrollDown() {
        getJSExecutor().executeScript("window.scrollBy(0,-200)");
    }


    /**
     * Use this method to click using Javascript Executor interface.
     *
     * @param element Pass the web element.
     */
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     * Use this method to click using Actions class.
     *
     * @param element Pass the web element.
     */
    public static void actionClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    /**
     * Use this method to get selected options from DropDown.
     *
     * @param element Pass the web element.
     */
    public static List<String> getSelectOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        List<String> OptionsList = new ArrayList<>();
        for (int i = 1; i < allOptions.size(); i++) {
            String optionText = allOptions.get(i).getText();
            OptionsList.add(optionText);
        }
        return OptionsList;
    }

    /**
     * Use this method to check if text is enabled in DropDown.
     *
     * @param element Pass the web element.
     * @param text    Pass text.
     */
    public static boolean isTextEnableInDropDown(WebElement element, String text) {
        boolean isTextEnable = false;
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement op : options) {
            if (op.getText().equals(text)) {
                isTextEnable = true;
            }
        }
        return isTextEnable;
    }

    /**
     * Use this method to select element in DropDown by visible text.
     *
     * @param element Pass the web element.
     * @param text    Pass text.
     */
    public static void dropDownSelect(WebElement element, String text) {
        if (isTextEnableInDropDown(element, text)) {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        }
    }

    /**
     * Use this method to take a screenshot.
     *
     * @param fileName Pass the web element.
     */
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    /**
     * Use this method to get a Time Stamp.
     *
     * @param pattern Pass the web element.
     */
    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        //pattern YYYY-MM-DD-HH-MM-SS-MS
        //to format the date according to our choice we have a function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * Use this method to read JsonFile.
     *
     * @param filePath Pass the path to a file.
     */
    public static JSONObject jsonFileData(String filePath) throws IOException {
        File file = new File(filePath);
        String data = new String(Files.readAllBytes(file.toPath()));
        JSONObject json = new JSONObject(data);
        return json;
    }
}
