package org.cucumberTestng.cucumberTestng;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.github.bingoohuang.pdf.PdfStripper;

import cucumber.runtime.Timeout;
import gherkin.deps.net.iharder.Base64.InputStream;

public class BaseUtils {
	
	public WebDriver driver;
	
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		
		System.out.println(result.getStatus());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Wait wa = new FluentWait(driver).ignoring(NoSuchElementException.class).pollingEvery(5, TimeUnit.SECONDS).withTimeout(50, TimeUnit.SECONDS);
		
		
				
		wa.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(""))));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		String linktext;
		for(WebElement e : links)
		{
			linktext = e.getAttribute("href");
			
			URL url = new URL(linktext);
			
			HttpURLConnection hurl = (HttpURLConnection)url.openConnection();
			
			hurl.getResponseCode();
			
			FileInputStream fis = new FileInputStream(new File(""));
			
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			PDDocument docs = PDDocument.load(fis);
			
			String textpdf = new PDFTextStripper().getText(docs);
			
			
			
			
		}
		
	}

	
	
	
	
}
