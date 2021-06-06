package com.cricbuzz.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cricbuzz.pages.CricbuzzPages;
import com.util.ExtentReport;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
@ExtendWith(ExtentReport.class)
public class CricbuzzTest {
	ChromeDriver driver;
	CricbuzzPages cricbuzz_pages;

	@Test()
	public void checkForSchedules(ChromeDriver driver) throws InterruptedException {
		cricbuzz_pages = new CricbuzzPages(driver);
		cricbuzz_pages.navigateTo_Application(driver);
		cricbuzz_pages.nav_To_Schedules();
		cricbuzz_pages.nav_To_Diff_Schedules();
	}
}
