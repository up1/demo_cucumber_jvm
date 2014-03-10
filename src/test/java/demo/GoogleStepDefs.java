package demo;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDefs {
	private WebConnector connector;

	public GoogleStepDefs(WebConnector connector) {
		this.connector = connector;
	}

	@Before
	public void beforeScenario() {
		System.out.println(" *** Before");
	}

	@After
	public void afterScenario() {
		System.out.println(" *** After");
	}

	@Given("^I am a visitor on google.com$")
	public void I_am_a_visitor_on_google() {
		connector.openAndWait("http://google.com");
	}

	@When("^I search up1$")
	public void I_search_up1() {
		connector.fillInData("gbqfq", "Up1");
		connector.clickAndWait("gbqfb");
	}

	@Then("^I should see up1$")
	public void I_should_see_up1() {
		assertTrue(connector.isTextPresent("Up1"));
	}

}
