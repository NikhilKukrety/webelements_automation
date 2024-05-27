package com.WebElements.stepDefinitions;

import org.openqa.selenium.WebDriver;
import com.WebElements.pages.WebElementsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebElements_Step {

	WebDriver driver;

	WebElementsPage webElementPage = new WebElementsPage(driver);

	@Given("User is on the Web Elements practice page")
	public void user_is_on_the_web_elements_practice_page() throws InterruptedException {

		webElementPage.launchBrowser();

	}

	@When("User selects a radio button")
	public void user_selects_a_radio_button() throws InterruptedException {

		// Thread.sleep(2000);
		// Provide which radio button you want to select
		webElementPage.selectRadioButton("radio1");
	}

	@Then("Selected radio button should be printed as a string")
	public void selected_radio_button_should_be_printed_as_a_string() throws InterruptedException {

		// Thread.sleep(2000);
		// Prints the option which we have selected
		webElementPage.printRadioButton("radio1");
	}

	@And("user selects a country from country suggestion field")
	public void user_selects_a_country_from_country_suggestion_field() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.enterAndSelectCountry("India");
	}

	@And("User selects a dropdown value")
	public void user_selects_a_dropdown_value() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.selectDropdownValue("Option2");

	}

	@And("User selects an option from checkbox")
	public void user_selects_an_option_from_checkbox() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.selectCheckBox("option3");
	}

	@And("User performs window switching operation successfully")
	public void user_performs_window_switching_operation_successfully() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.windowSwitch();

	}

	@And("User performs tab switching operation successfully")
	public void user_performs_tab_switching_operation_successfully() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.tabSwitch();
	}

	@And("User performs alert operations successfully")
	public void user_performs_alert_operations_successfully() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.alertOperations("Nikhil");

	}
	
	@And("User enters row and column number to fetch the table content")
	public void user_enters_row_and_column_number_to_fetch_the_table_content() throws InterruptedException {
	    
		Thread.sleep(1000);
		webElementPage.rowsNum();
		webElementPage.columnsNum();
		webElementPage.enterRowAndColumnNumbers(2, 2);
		
	}
	
	@Given("User clicks on Hide button")
	public void user_clicks_on_hide_button() throws InterruptedException {
		
		Thread.sleep(2000);
		webElementPage.clickHideButton();
		
	}
	
	@And("User clicks on Show button")
	public void user_clicks_on_show_button() throws InterruptedException {

		Thread.sleep(2000);
		webElementPage.clickShowButton();
	}
	
	
	@Given("user enters row and column number to fetch the fixed header table content")
	public void user_enters_row_and_column_number_to_fetch_the_fixed_header_table_content() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.fixedrowsNum();
		webElementPage.fixedcolumnsNum();
		webElementPage.fixedenterRowAndColumnNumbers(9, 1);
		
	}
	
	
	@Given("User performs mouse hover activities")
	public void user_performs_mouse_hover_activities() throws InterruptedException {

		webElementPage.performMouseHoverTasks();
		
	}


	@And("User closes the browser")
	public void user_closes_the_browser() throws InterruptedException {

		Thread.sleep(1000);
		webElementPage.closeBrowser();

	}

}
