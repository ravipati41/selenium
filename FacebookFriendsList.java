package com.iitjobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookFriendsList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver d=new FirefoxDriver();
		d.get("http://www.facebook.com");
		d.findElement(By.id("email")).sendKeys("rsbchowdary@gmail.com");
		Thread.sleep(3000);
		d.findElement(By.id("pass")).sendKeys("lakshmi2041");
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='u_0_r']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='u_0_4']/div[1]/div[1]/div/a/span")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//a[text()='Friends']")).click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		while(true){
			List<WebElement> friendsListBeforeScroll=d.findElements(By.xpath(".//div[@class='fsl fwb fcb']/a"));
			System.out.println(friendsListBeforeScroll.size());
			WebElement lastFriend=friendsListBeforeScroll.get(friendsListBeforeScroll.size()-1);
			int y=lastFriend.getLocation().y;
			JavascriptExecutor js=(JavascriptExecutor)d;
			js.executeScript("window.scrollTo(0,"+y+")");
			Thread.sleep(3000);
			List<WebElement> friendsListAfterScroll=d.findElements(By.xpath(".//div[@class='fsl fwb fcb']/a"));
			if(friendsListBeforeScroll.size()==friendsListAfterScroll.size()){
				for(WebElement e:friendsListAfterScroll){
					
					System.out.println(e.getText());
					
				}
				break;
			}
			//System.out.println(links.size());
		}
		
		//for(WebElement e:links){
			
			//System.out.println(e.getText());
			
		//}
		Thread.sleep(3000);
		d.close();
		
	

	}

}
