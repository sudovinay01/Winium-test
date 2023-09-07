package Winium.WiniumTest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {

	static DesktopOptions options;
	static WiniumDriverService service;
	static WiniumDriver driver;
	static int winiumPort = 9999;

	@BeforeTest
	public void setupEnvironment() {
		assertEquals(displayScale(), 1.0, "\nChange Display scale to 100% else test may not run propery.\n");

		try {
			Port.killPort(winiumPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		options = new DesktopOptions();
		options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		File driverPath = new File("Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(winiumPort)
				.withVerbose(true).withSilent(false).buildDesktopService();
		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Exception while starting WINIUM service");
			e.printStackTrace();
		}
		driver = new WiniumDriver(service, options);
	}

	@Test
	public void calculatorTest() throws InterruptedException {
		int num1 = 5, num2 = 2;
		Thread.sleep(1000);
		driver.findElement(By.id("clearButton")).click();
		driver.findElement(By.id("num" + num1 + "Button")).click();
		driver.findElement(By.name("Multiply by")).click();
		driver.findElement(By.id("num" + num2 + "Button")).click();
		driver.findElement(By.id("equalButton")).click();
		String results = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		System.out.println("Result is: " + results);
		assertEquals(results, "Display is " + num1 * num2);
	}

	@AfterTest
	public void cleanupEnvironment() {
		driver.findElement(By.name("Close Calculator")).click();
		service.stop();
		try {
			Port.killPort(winiumPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static double displayScale() {
		int res = java.awt.Toolkit.getDefaultToolkit().getScreenResolution();
		return (double) res / 96;
	}

}
