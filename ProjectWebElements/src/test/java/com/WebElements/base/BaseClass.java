package com.WebElements.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver;

	public BaseClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// We can use below methods when we use POM in Page Object classes successfully:
	public void waitForWebElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
