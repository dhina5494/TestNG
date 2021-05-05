package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	public static WebDriver driver;
	public static Actions ac;
	public static Alert al;
	public static Select s;
	public static JavascriptExecutor js;
	public static Robot rb;

	public static void getDriver() {
		System.setProperty("webdriver.chrome.driver",

				"C:\\Users\\Dhina\\eclipse-workspace\\ExcelSample\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	public static void launchUrl(String data) {
		driver.get(data);
		driver.manage().window().maximize();

	}

	public static void enterText(WebElement element, String data) {
		element.sendKeys(data);

	}

	public static void pageTitle() {
		driver.getTitle();

	}

	public static String text(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;

	}

	public static void getUserEntry(WebElement element) {
		element.getAttribute("value");

	}

	public static void webpageClose() {
		driver.quit();
	}

	public static void btnClick(WebElement element) {
		element.click();

	}

	public static void currentPageClose() {
		driver.close();

	}

	public static void currentPageUrl() {
		driver.getCurrentUrl();

	}

	public static void moveToElement(WebElement target) {
		Actions ac = new Actions(driver);
		ac.moveToElement(target).perform();
	}

	public void rightClick(WebElement target) {
		ac.contextClick(target).perform();

	}

	public void dragAndDrop(WebElement source, WebElement target) {
		ac.dragAndDrop(source, target).perform();

	}

	public void doubleClick(WebElement target) {
		ac.doubleClick(target).perform();
	}

	public void simpleAlert() {
		al = driver.switchTo().alert();
		al.accept();

	}

	public void conformAlert() {
		al.dismiss();
	}

	public void promptAlert(String data) {
		al.sendKeys(data);
	}

	public static void visibleText(WebElement element, String data) {
		s = new Select(element);
		s.selectByVisibleText(data);

	}

	public static void selectByValue(WebElement element, String data) {
		s.selectByValue(data);
	}

	public static void selectByIndex(WebElement element, int index) {
		s.selectByIndex(index);
	}

	public void deselectByindex(WebElement element, int index) {
		s.deselectByIndex(index);
	}

	public void getAllValue(WebElement element) {
		s.getOptions();
	}

	public void getAllSelectedValue(WebElement element) {
		s.getAllSelectedOptions();
	}

	public WebElement elementById(String data) {
		WebElement findElement = driver.findElement(By.id(data));
		return findElement;

	}

	public WebElement elementByName(String data) {
		WebElement findElement = driver.findElement(By.name(data));
		return findElement;

	}

	public WebElement elementByClass(String data) {
		WebElement findElement = driver.findElement(By.className(data));
		return findElement;

	}

	public WebElement elementByXpath(String data) {
		WebElement findElement = driver.findElement(By.xpath(data));
		return findElement;
	}

	public WebElement elementByTagName(String data) {
		WebElement findElement = driver.findElement(By.tagName(data));
		return findElement;
	}

	public WebElement elementByLinkTest(String data) {
		WebElement findElement = driver.findElement(By.linkText(data));
		return findElement;
	}

	public WebElement elementByPartiallyLinkTest(String data) {
		WebElement findElement = driver.findElement(By.partialLinkText(data));
		return findElement;
	}

	public WebElement elementByCssSelector(String data) {
		WebElement findElement = driver.findElement(By.cssSelector(data));
		return findElement;
	}

	// javascriptExecutor
	public void enterTextByJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void clickByJs(WebElement element) {
		js.executeScript("arguments[0].click()", element);

	}

	public void getUserEnterByjs(WebElement element) {
		js.executeScript("return arguments[0].getattribute('value')", element);
	}

	public void scrollDownByJs(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollUpByJs(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public void visibletext(WebElement element, String valueString) {

		s.deselectByVisibleText(valueString);
	}

	public void deSelectVisibleText(WebElement element, String valueString) {

		s.deselectByVisibleText(valueString);
	}
	// Screenshot

	public void screenshot(String data, String data1, String data2) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.setProperty(data1, data2));
	}

	// Frame
	public void frame(WebElement element, Integer data) {
		driver.switchTo().frame(0);
	}

	public void switchto() {
		driver.switchTo();
	}

	public void to(WebElement element) {
		driver.toString();
	}

	// navigation method
	public void back() {
		driver.navigate().back();
	}

	public void to(String data) {
		driver.navigate().to(data);
	}

	public void refersh() {
		driver.navigate().refresh();
	}

	// Data Driven Content
	public void celltype(Cell c) {
		c.getCellType();
	}

	public void numericalcellvalue(Cell c) {
		c.getNumericCellValue();
	}

	public void valueof(String s, Double valueDouble) {
		String.valueOf(valueDouble);
	}

	public void Stringcellvalue(Cell c) {
		c.getStringCellValue();
	}

	public void createcell(Row r, Integer valueInteger) {
		r.createCell(valueInteger);
	}

	// File methods
	public void createFolder(File F) {
		F.mkdir();
	}

	public void createMultipleFolder(File F) {
		F.mkdirs();
	}

	public void delete(File F) {
		F.delete();

	}

	public void createFile(File F) throws IOException {
		F.createNewFile();
	}

	public String getCurrentWindow() {
		String handle = driver.getWindowHandle();
		return handle;
	}

	public Set<String> getAllWindows() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}

	public void keyPress(int keycode) throws AWTException {
		rb = new Robot();
		rb.keyPress(keycode);

	}

	public void keyRelease(int keycode) {
		rb.keyRelease(keycode);

	}

	public String getDataFromExcel(String pathname, String name, int rowno, int cellno) throws IOException {
		File file = new File(pathname);
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(rowno);
		Cell c = r.getCell(cellno);
		
		int type = c.getCellType();
		String value ="";
		if (type == 1) {
			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date cellValue = c.getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			value = format.format(cellValue);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;

	}

	public void writeNewExcel(String pathname, String sheetname, int rowNo, int cellNo, String data2)
			throws IOException {
		File file = new File(pathname);
		Workbook w = new XSSFWorkbook();
		Sheet s1 = w.createSheet(sheetname);

		Row r = s1.createRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(data2);
		FileOutputStream outputStream = new FileOutputStream(file);
		w.write(outputStream);

	}

}
