package test;

import java.util.Scanner;

public class Main {
	static Scanner scanner;
	public static void main(String[] args) {
		System.out.println("Sign In/ Login?");
		System.out.print("Answer (S/L): ");
		scanner = new Scanner(System.in);
        String proses = scanner. nextLine();
		
		if(proses.equalsIgnoreCase("S"))
				signup();
		else
			login();
		scanner.close();
	}
	
	
	public static void signup() {
		System.out.println("Start Signing Up");
		try {
			System.out.print("Input Prefix : ");
	        String inputString = scanner. nextLine();
			var data = new Data(inputString);
			var driver = new WebDriverHelper();
			driver.open("https://hotfix.student.cakap.com/login/register/email");
			
			//TC validasi field kosong
			driver.clickByClass("btn-sign-up");
			var error = driver.getTextByClass("messageerror");
			//System.out.println(error);
			if(error == "")
			{
				System.out.println("Belum terdapat validasi untuk mandatory field");
			}else {
				if(error.equalsIgnoreCase("Please fill the required field before continue"))
					System.out.println("Validasi sesuai untuk mandatory field");
				else
					System.out.println("Validasi tidak sesuai untuk mandatory field");
			}
			
			driver.sendKeysById("inputemail", data.email);
			driver.getParent(driver.findByCSS("input[ng-reflect-value='wanita']", false)).click();;
			driver.sendKeysById("inputfirst", data.firstname);
			driver.sendKeysById("inputlast", data.lastname);
			driver.sendKeysByCSS("input[ng-reflect-name='user_password']",data.password);
			driver.sendKeysByCSS("input[ng-reflect-name='user_password_confirm']",data.password);
			driver.clickByClass("eye");
			driver.nextByXpath(driver.findByClass("textpassoff"), "following-sibling::a//img[@class='eye']").click();
			driver.clickByClass("btn-sign-up");
			
			//TC validasi registered email
			try {
			error = driver.getTextByClass("messageerror"); System.out.println(error);
			if(error.equalsIgnoreCase("Email is registered"))
			{
			  System.out.println("Validasi sesuai untuk email sudah terdaftar");
			  System.out.println("Finish");
			  return ;
			}
			}catch(Exception ex) {}
			
			//TC validasi next tanpa select course
			driver.clickByClass("next");
			error = driver.getTextByClass("toast-error");
			//System.out.println(error);
			if(error.equalsIgnoreCase("Please select course"))
				System.out.println("Validasi sesuai untuk mandatory course");
			driver.setWait(3);
			driver.getParent(driver.findByXpath("//span[text()='English Course']")).click();
			driver.clickByClass("next");
			
			//TC validasi next tanpa input phone number
			driver.clickByClass("next");
			error = driver.getTextByClass("toast-error");
			//System.out.println(error);
			if(error.equalsIgnoreCase("Phone Number is required"))
				System.out.println("Validasi sesuai untuk mandatory phone number");
			driver.setWait(3);
			driver.nextByXpath(driver.findById("Country"), "following-sibling::*").click();
			driver.getParent(driver.findByXpath("//span[text()='India (+91)']", false)).click();
			driver.sendKeysById("input-phone", data.phone);
			driver.clickByClass("next");
			driver.setWait(3);
			driver.clickByClass("btn-godashboard");
			
			driver.setWait(3);
			driver.nextByXpath(driver.findById("Timezoneedit"), "following-sibling::*").click(); 
			driver.setWait(3);
			driver.findByXpath("//li[text()='(GMT+09:00) Japan Standard Time, Korea Standard Time, Yakutsk Time']", false).click();
			driver.clickByClass("submit-tm");
			 
			System.out.println("finish");
			//driver.quit();
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static void login() {
		System.out.print("Input Prefix : ");
		Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();
		var data = new Data(inputString);
		scanner.close();
		var driver = new WebDriverHelper();		
		driver.open("http://hotfix.student.cakap.com/");
		driver.sendKeysByCSS("input[ng-reflect-name='email']",data.email);
		driver.sendKeysByCSS("input[ng-reflect-name='password']",data.password);
		driver.clickByClass("eye");
		driver.clickByClass("btn-login");
		System.out.println("finish");
		 
	}
}
