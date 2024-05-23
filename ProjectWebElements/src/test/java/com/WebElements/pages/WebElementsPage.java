package com.WebElements.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.WebElements.base.BaseClass;

public class WebElementsPage extends BaseClass {

	public WebElementsPage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver = new ChromeDriver();

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\java\\com\\WebElements\\resources\\Drivers\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
	}

	public void selectRadioButton(String radioButton) {
		WebElement SignInbutton = driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]"));
		waitForWebElement(SignInbutton);
		WebElement radioButtonTitle = driver.findElement(By.xpath("//legend[text()='Radio Button Example']"));
		if (radioButtonTitle.isDisplayed()) {
			WebElement selectRadio = driver.findElement(By.xpath("//input[@value='" + radioButton + "']"));
			selectRadio.click();

		}

	}

	public void printRadioButton(String radioButton) {
		WebElement radioString = driver.findElement(By.xpath("//label[@for='" + radioButton + "']"));
		String radioButtonFetched = radioString.getText();
		System.out.println("\n"+"Selected Radio button is: " + radioButtonFetched+"\n");
	}

	public void enterAndSelectCountry(String country) throws InterruptedException {
		WebElement clickCountry = driver.findElement(By.id("autocomplete"));
		clickCountry.click();
		clickCountry.sendKeys(country);
		Thread.sleep(1000);
		WebElement suggestedCountry = driver.findElement(By.xpath("//div[text()='" + country + "']"));
		suggestedCountry.click();
		// Thread.sleep(2000);
		String selectedCountry = clickCountry.getAttribute("value");
		System.out.println("\n"+"Selected Country is: " + selectedCountry+"\n");
	}

	public void selectDropdownValue(String dropDownValue) {
		WebElement dropDownExample = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(dropDownExample);
		dropdown.selectByVisibleText(dropDownValue);
		String selectedDropdownValue = dropDownExample.getAttribute("value");
		System.out.println("\n"+"Selected dropdown value is: " + selectedDropdownValue+"\n");
	}

	public void selectCheckBox(String value) {
		WebElement checkboxValue = driver.findElement(By.xpath("//input[@value = '" + value + "']"));
		checkboxValue.click();
		String valueSelected = checkboxValue.getAttribute("value");
		System.out.println("\n"+"Selected checkbox value is: " + valueSelected+"\n");
	}

	public void windowSwitch() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		WebElement openWindowButton = driver.findElement(By.id("openwindow"));
		openWindowButton.click();
		// Switching to newly opened child window:
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().window().maximize();
		Thread.sleep(2000);
		waitForWebElement(driver.findElement(By.xpath("//a[@class='active']")));
		WebElement subMenuBar = driver.findElement(By.xpath("//div[@id='navbarSupportedContent']"));
		if (subMenuBar.isDisplayed()) {
			System.out.println("\n"+"Child window switching successful"+"\n");
			driver.close();
		}

		else {
			System.out.println("\n"+"Child window switching unsuccessful"+"\n");
		}
		driver.switchTo().window(parentWindow);
		WebElement SignInButtonNew = driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]"));
		if (SignInButtonNew.isDisplayed()) {
			System.out.println("\n"+"Parent window switching successful"+"\n");
		}
		else
		{
			System.out.println("\n"+"Parent window switching unsuccessful"+"\n");
		}

	}

	public void tabSwitch() throws InterruptedException {
		String parentTab = driver.getWindowHandle();
		WebElement openTabButton = driver.findElement(By.id("opentab"));
		openTabButton.click();
		// Switching to newly opened child tab:
		for (String tabHandle : driver.getWindowHandles()) {
			driver.switchTo().window(tabHandle);
		}
		driver.manage().window().maximize();
		Thread.sleep(2000);
		waitForWebElement(driver.findElement(By.xpath("//a[@class='active']")));
		WebElement subMenuBar = driver.findElement(By.xpath("//div[@id='navbarSupportedContent']"));
		if (subMenuBar.isDisplayed()) {
			System.out.println("\n"+"Child tab switching successful"+"\n");
			driver.close();
		}

		else {
			System.out.println("\n"+"Child tab switching unsuccessful"+"\n");
		}
		driver.switchTo().window(parentTab);
		WebElement SignInButtonNew = driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]"));
		if (SignInButtonNew.isDisplayed()) {
			System.out.println("\n"+"Parent tab switching successful"+"\n");
		}
		else
		{
			System.out.println("\n"+"Parent tab switching unsuccessful"+"\n");
		}

	}

	public void alertOperations(String name) throws InterruptedException {
		// Alert button:
		WebElement alertField = driver.findElement(By.id("name"));
		alertField.click();
		alertField.sendKeys(name);
		Thread.sleep(2000);
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
		Thread.sleep(3000);
		String alertOKMessage = driver.switchTo().alert().getText();
		System.out.println("\n"+"Captured Alert OK message is: " + alertOKMessage+"\n");
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

		// Accept - Confirmation button:
		alertField.click();
		alertField.sendKeys(name);
		Thread.sleep(2000);
		WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
		confirmButton.click();
		Thread.sleep(3000);
		String alertConfirmMessage = driver.switchTo().alert().getText();
		System.out.println("\n"+"Captured Alert Confirm message is: " + alertConfirmMessage+"\n");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		// Cancel - Confirmation button:
		alertField.click();
		alertField.sendKeys(name);
		Thread.sleep(2000);
		confirmButton.click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();

	}
	
	public void rowsNum()
	{
		List<WebElement> intRowNum = driver.findElements(By.xpath("//*[@class='table-display']/tbody/tr"));
		int rowSize = intRowNum.size();
		System.out.println("\n"+"Number of rows: "+rowSize+"\n");
		
	}
	
	public void columnsNum()
	{
		List<WebElement> intColumns = driver.findElements(By.xpath("//*[@class='table-display']/tbody/tr[1]/th"));
		int columnsSize = intColumns.size();
		System.out.println("\n"+"Number of rows: "+columnsSize+"\n");
	}
	
	public void enterRowAndColumnNumbers(int row, int column)
	{
		WebElement tableData = driver.findElement(By.xpath("//*[@class='table-display']/tbody/tr["+row+"]/td["+column+"]"));
		String fetchedTableData = tableData.getText();
		System.out.println("\n"+"Fetched record after entering row-column numbers is: "+fetchedTableData+"\n");
		
	}
	
	public void clickHideButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/legend"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		WebElement inputField = driver.findElement(By.id("displayed-text"));
		if(inputField.isDisplayed())
		{
			Thread.sleep(2000);
			System.out.println("\n"+"Field is not hidden. Proceeding to click the 'Hide' button."+"\n");
			hideButton.click();
		}
		else
		{
			System.out.println("\n"+"Field is hidden or not available."+"\n");
			
		}
		
		
		if(inputField.isDisplayed())
		{
			System.out.println("\n"+"Error in hiding the input field."+"\n");
		}
		else
		{
			System.out.println("\n"+"Input field hidden successfully."+"\n");
		}
		
	}
	
	public void clickShowButton()
	{
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		WebElement inputField = driver.findElement(By.id("displayed-text"));
		if(inputField.isDisplayed())
		{
			System.out.println("\n"+"Input field already displaying."+"\n");
		}
		else
		{
			System.out.println("\n"+"Input field is hidden. Proceeding to click the 'Show' button."+"\n");
			showButton.click();
		}
		
		if(inputField.isDisplayed())
		{
			System.out.println("\n"+"Input field shown again successfully."+"\n");
		}
		else
		{
			System.out.println("\n"+"Error in showing the input field."+"\n");
		}
	}
	

	public void closeBrowser() {
		driver.quit();
	}

}
