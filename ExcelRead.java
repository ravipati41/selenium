package com.iitjobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Constant;
import utility.ExcelUtils;

public class ExcelRead {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
		
		String user=ExcelUtils.getCellData(1,1);
		String pwd=ExcelUtils.getCellData(1, 2);
		
		WebDriver d=new FirefoxDriver();
		d.get(Constant.url);
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='account']/a/span[1]")).click();
		Thread.sleep(3000);
		d.findElement(By.id("log")).sendKeys(user);
		Thread.sleep(3000);
		d.findElement(By.id("pwd")).sendKeys(pwd);
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='login']")).click();
		Thread.sleep(3000);
		//d.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		Thread.sleep(3000);
		d.close();
		ExcelUtils.setCellData("correct", 1, 3);

	}

}
