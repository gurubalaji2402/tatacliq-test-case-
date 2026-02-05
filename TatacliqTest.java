package Marathon1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TatacliqTest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver  driver = new ChromeDriver();
		//load the url
		driver.get("https://www.tatacliq.com/");
		//maximize the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions action = new Actions(driver);
		
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
	    action.moveToElement(brands).perform();
	    
	    Thread.sleep(3000);
	    
	    WebElement watches = driver.findElement(
        By.xpath("//div[text()='Watches & Accessories']"));
        action.moveToElement(watches).perform();
        
        driver.findElement(By.xpath("//div[text()='Casio']")).click();
        
        driver.findElement(
        By.xpath("//select[contains(@class, 'SelectBoxDesktop__hideSelect')]/option[4]")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(
        By.xpath("//div[contains(@class, 'FilterDesktop__newFilName') and text()='Men']")).click();
        
        Thread.sleep(5000);
        
        List<WebElement> prices = driver.findElements(
        By.xpath("//h3[@class='ProductDescription__boldText']"));
		
		List<Integer> numericPrice1=new ArrayList<Integer>();
		 for (WebElement each : prices) {
			 String text = each.getText();
			 String numeric = text.replaceAll("[^0-9]", "");
			 if (!numeric.isEmpty()) {
			        int price = Integer.parseInt(numeric);
			        numericPrice1.add(price);
			    }
		 }
		 System.out.println("price list ="+numericPrice1);	
		 
		Thread.sleep(4000);
		 
		driver.findElement(
	    By.xpath("(//a[contains(@class,'ProductModule__base')])[1]")).click();
		
		Set<String>child=driver.getWindowHandles();
		List<String> listwindow = new ArrayList<String>(child);
		driver.switchTo().window(listwindow.get(1));
		
	System.out.println(driver.getTitle());	
	
	WebElement productprice = driver.findElement(By.xpath("//h3[contains(text(),'MRP')]"));
	String mrpprice = productprice.getText();
    String numeric = mrpprice.replaceAll("[^0-9]", "");
    int  numericprice2 = Integer.parseInt(numeric);
	System.out.println("Price: " + numericprice2);
	
	int  num =  numericPrice1.get(0);
	
	if(num== numericprice2) {
		System.out.println("equal");
	}
	else
		System.out.println("not equal");

	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
	WebElement count = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
	String countofaddtocart = count.getText();
	System.out.println("countofaddtocart ="+countofaddtocart);
	}
	
	
	

}
