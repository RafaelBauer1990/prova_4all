package prova_4all.core;

import static prova_4all.core.DriverFactory.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class BaseTest {

	private static Relatorio rel;

	@BeforeAll
	public static void inicializaTeste() {
		rel = new Relatorio();
		rel.registraRelatorio();
	}

	@AfterEach
	public void finalizaTeste(TestInfo testInfo) throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File img = ss.getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(img, new File("target" 
				+ File.separator 
				+ "evidencias" 
				+ File.separator 
				+ testInfo.getDisplayName() 
				+ ".jpg"));
		quitDriver();

	}
}
