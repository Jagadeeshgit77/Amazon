package Base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class navigationMenuButton extends AmznTest {
	
	public void NavMenuButtonVisibility() {
		boolean btnDisplay = driver.findElement(By.id("nav-hamburger-menu")).isDisplayed();
		if (btnDisplay) {
            System.out.println("The Amazon navigation menu is visible and accessible.");
        } else {
            System.out.println("The Amazon navigation menu is not visible or accessible.");
        }
	}
	public void ExpandingMenu() {
		driver.findElement(By.id("nav-hamburger-menu")).click();
		boolean MenuExpanded = driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible']")).isDisplayed();

        if (MenuExpanded) {
            System.out.println("The navigation menu options are expanded.");
        } else {
            System.out.println("The navigation menu options are not expanded.");
        }

	}
	
	public void Trending() throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.xpath("//a[@class='hmenu-item']")).click();
		driver.navigate().back();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.xpath("(//a[@class='hmenu-item'])[2]")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.id("nav-hamburger-menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Movers and Shakers']")).click();
	}
	//Scrolling Main menu
	public void ScrollMain() throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		Thread.sleep(3000);
		WebElement elementToHover = driver.findElement(By.xpath("//a[@data-menu-id='8']"));
		Actions act =new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToHover);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		act.moveToElement(elementToHover).build().perform();
	}
	
	//Able to close menu when clicking outside the menu.
	
	public void Collapse() {
		driver.manage().window().maximize();
		WebElement nm = driver.findElement(By.id("nav-hamburger-menu"));
		nm.click();
		
		//CLicking on background of the web page to collapse the navigation menu 
		
		driver.findElement(By.id("hmenu-canvas-background")).click();
		boolean isCollapsed = nm.isDisplayed();

        if (isCollapsed) {
            System.out.println("The navigation menu collapses when clicking outside the menu.");
        } else if(!isCollapsed) {
        	System.out.println("The navigation menu is still open");
        } 
        else {
            System.out.println("The navigation menu does not collapse when clicking outside the menu.");
        }
	}
	
	//Able to close menu when clicking on close button
	
	public void ClseBtn() {
		driver.manage().window().maximize();
		WebElement nv = driver.findElement(By.id("nav-hamburger-menu"));
		nv.click();
		
		//CLicking on background of the web page to collapse the navigation menu
		
		driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']")).click();
		boolean closed = nv.isDisplayed();

        if (closed) {
            System.out.println("The navigation menu collapses when clicking on close icon.");
        } else if(!closed) {
        	System.out.println("The navigation menu is still open");
        } 
        else {
            System.out.println("The navigation menu does not collapse when clicking on close icon.");
        }
		
	}
	
	public void Icons() {
		driver.manage().window().maximize();
		WebElement navigationMenu = driver.findElement(By.id("nav-hamburger-menu"));
        navigationMenu.click();
        WebElement categoriesContainer = driver.findElement(By.id("hmenu-content"));
        List<WebElement> categoryElements = categoriesContainer.findElements(By.tagName("a"));
        boolean isIconsCorrect = true;
        for (WebElement categoryElement : categoryElements) {
            String categoryIcon = categoryElement.getAttribute("class");

            if (categoryElement.getText().equals("Category1")) {
                if (!categoryIcon.contains("icon-category1")) {
                    isIconsCorrect = false;
                    break;
                }
            } else if (categoryElement.getText().equals("Category2")) {
                if (!categoryIcon.contains("icon-category2")) {
                    isIconsCorrect = false;
                    break;
                }
            }
            if (isIconsCorrect) {
                System.out.println("The navigation menu displays appropriate icons or indicators for each category.");
            } else {
                System.out.println("The navigation menu does not display correct icons or indicators for each category.");
            }
        }
	}
	public void SubToMain() {
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Clicking Echo & Alexa button(Sub-menu)
		
		driver.findElement(By.xpath("//a[@data-menu-id='2']")).click();
		boolean sub = driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']")).isDisplayed();
		if(sub) {
			System.out.println("Sub menu is displayed");
		}else {
			System.out.println("Sub menu is not displayed");
		}
		//a[@aria-label='Back to main menu']
		driver.findElement(By.xpath("//a[@aria-label='Back to main menu']")).click();
		
		boolean main = driver.findElement(By.id("hmenu-content")).isDisplayed();
		if(main) {
			System.out.println("Returned back to main-menu");
		}else {
			System.out.println("Not returned back to main-menu");
		}
		
	//Clicks the element in the sub menu
	
	}
	//Clicks the element in the sub menu
	public void SubMenuEle(){
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Clicking Fire TV button(Sub-menu)
		
		driver.findElement(By.xpath("//a[@data-menu-id='3']")).click();
		//Clicking an element in the sub menu
		driver.findElement(By.xpath("//a[text()='Amazon Prime Video']")).click();
		
	}
	
	//Clicking navigation menu element using Keyboard
	public void Keyboard() {
		driver.manage().window().maximize();
		WebElement Menu = driver.findElement(By.id("nav-hamburger-menu"));
		Menu.click();
        Actions a = new Actions(driver);
        //a.moveToElement(Menu).sendKeys(Keys.RETURN).perform();
        List<WebElement> menuOptions = driver.findElements(By.xpath("//ul[@class='hmenu hmenu-visible']//a"));
        for (WebElement menuOption : menuOptions) {
            String text = menuOption.getText();
            System.out.println("Menu Option: "+ text);
            a.sendKeys(Keys.TAB).perform();
        }
		a.sendKeys(Keys.RETURN).perform();
		boolean menu = driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible']")).isDisplayed();
		if(menu) {
			System.out.println("Navigation-Menu is clicked via Keyboard");
		}else {
			System.out.println("Navigation-Menu is not clicked via Keyboard");
		}
	}
	
	/*  

    // Open the navigation menu using keyboard
  WebElement navigationMenu = driver.findElement(By.id("nav-hamburger-menu"));
    Actions actions = new Actions(driver);
    actions.moveToElement(navigationMenu).sendKeys(Keys.RETURN).perform();

    // Navigate and interact with the navigation menu options using keyboard
    WebElement firstMenuItem = driver.findElement(By.cssSelector(".hmenu-item[data-menu-id='1']"));
    actions.sendKeys(Keys.ARROW_DOWN).perform(); // Navigate to the first menu item
    actions.sendKeys(Keys.RETURN).perform(); // Select the first menu item

    // Perform other actions with the navigation menu options using keyboard as needed

    // Verify that the user is able to navigate and interact with the navigation menu using the keyboard
    // Add appropriate assertions or checks based on the expected behavior

    // Close the WebDriver
    driver.quit();
}
}*/

}
