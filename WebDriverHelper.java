package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverHelper {

	WebDriver driver;
	int timeout = 20;
	WebDriverWait  wait;
	public WebDriverHelper() {
		System.setProperty("webdriver.chrome.driver","D:\\drive\\chromedriver.exe");

		driver = (WebDriver) new ChromeDriver();

		wait = new WebDriverWait(driver, timeout);
	}
	
	public void open(String url){

        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

	public void quit(){

        this.driver.quit();
    }
	

	public WebElement findById(String id){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return this.driver.findElement(By.id(id));
    }

	public void sendKeysById(String id,String txt){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        this.driver.findElement(By.id(id)).clear();
        this.driver.findElement(By.id(id)).sendKeys(txt);
    }

	public void clickById(String id){
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        this.driver.findElement(By.id(id)).click();
    }


	public WebElement findByClass(String css){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(css)));
		return this.driver.findElement(By.className(css));	
    }

	public String getTextByClass(String css){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(css)));
        return this.driver.findElement(By.className(css)).getText();
    }

	public void clickByClass(String css){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(css)));
        this.driver.findElement(By.className(css)).click();
    }

	public WebElement findByCSS(String css){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        return this.driver.findElement(By.cssSelector(css));
    }
	
	public WebElement findByCSS(String css, boolean w){

		if(w) {			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
		}
        return this.driver.findElement(By.cssSelector(css));
    }

	public void sendKeysByCSS(String css,String txt){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        this.driver.findElement(By.cssSelector(css)).clear();
        this.driver.findElement(By.cssSelector(css)).sendKeys(txt);
    }
	
	public WebElement findByXpath(String xpath){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this.driver.findElement(By.xpath(xpath));
    }

	public WebElement findByXpath(String xpath, boolean w){
		if(w) {	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
        return this.driver.findElement(By.xpath(xpath));
    }
	
	public WebElement nextByXpath(WebElement el ,String xpath){

        return el.findElement(By.xpath(xpath));
    }

	public void clickByXPath(String xpath){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        this.driver.findElement(By.xpath(xpath)).click();
    }

	/*
	 * public void clearByXPath(String xpath){
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	 * this.driver.findElement(By.xpath(xpath)).clear(); }
	 */

	public void sendKeysByXPath(String xpath,String txt){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        this.driver.findElement(By.xpath(xpath)).clear();
        this.driver.findElement(By.xpath(xpath)).sendKeys(txt);
    }

	public String getAttributeByXpath(String xpath,String attr){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this.driver.findElement(By.xpath(xpath)).getAttribute(attr);
    }

	public String getTextByXPath(String xpath){

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this.driver.findElement(By.xpath(xpath)).getText();
    }
	
	public Select GetSelectById(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return new Select(this.driver.findElement(By.id(id)));		
	}
	
	public Select GetSelectByXPath(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return new Select(this.driver.findElement(By.xpath(xpath)));		
	}
	
	public void selectOptionByValue(Select el,String value){	
        el.selectByValue(value);
    }
	
	public void selectOptionByText(Select el,String text){		
        el.selectByVisibleText(text);
    }
	
	public void selectOptionByIndex(Select el,int index){	
        el.selectByIndex(index);
    }
	public void sendKeys(WebElement el,String txt){

        el.sendKeys(txt);
    }
	
	public WebElement getParent(WebElement child)
	{
		return child.findElement(By.xpath(".."));
	}
	
	public void setWait(long sec){

        try {
        	Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public Alert switchToAlert(){

        return this.driver.switchTo().alert();
    }


}
