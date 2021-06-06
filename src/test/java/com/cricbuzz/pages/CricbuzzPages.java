package com.cricbuzz.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ReadPropertiesFileTest;

public class CricbuzzPages {

	private static final String filename = null;
	ReadPropertiesFileTest readfile = new ReadPropertiesFileTest();
	Properties prop = readfile.readPropertiesFile(filename);
	WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Live Scores')]/../a[3]")
	WebElement schedule_Header_Tab;

	@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div[4]/h1")
	WebElement schedule_header;

	@FindBy(xpath = "//a[contains(text(),'Domestic & Others')]")
	WebElement domestic_Schedules;

	@FindBy(xpath = "//a[contains(text(),'T20 Leagues')]")
	WebElement t20_Schedules;

	@FindBy(id = "women-tab")
	WebElement women_Schedules;
	
	public CricbuzzPages(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_Application(ChromeDriver driver) {
		driver.get(prop.getProperty("APP_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void nav_To_Schedules() {
		schedule_Header_Tab.click();
		assertEquals("Cricket Schedule", schedule_header.getText());
	}

	public void nav_To_Diff_Schedules() {
		domestic_Schedules.click();
		t20_Schedules.click();
		women_Schedules.click();
	}
}
