package TstCses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AmznTest;
import Base.navigationMenuButton;

public class NavMenuTst extends AmznTest{
	@BeforeMethod
	public void initial() {
		start();
	}
	@Test(priority = 1)
	public void TC1() {
		navigationMenuButton v = new navigationMenuButton();
		v.NavMenuButtonVisibility();
	}
	@Test(priority = 2)
	public void TC2() {
		navigationMenuButton e = new navigationMenuButton();
		e.ExpandingMenu();
	}
	@Test(priority = 3)
	public void TC3() throws InterruptedException {
		navigationMenuButton t = new navigationMenuButton();
		t.Trending();
	}
	@Test(priority = 4)
	public void TC4() throws InterruptedException {
		navigationMenuButton s = new navigationMenuButton();
		s.ScrollMain();
	}
	
	@Test(priority = 5)
	public void TC5() {
		navigationMenuButton c = new navigationMenuButton();
		c.Collapse();
	}
	@Test(priority = 6)
	public void TC6() {
		navigationMenuButton cl = new navigationMenuButton();
		cl.ClseBtn();
	}
	@Test(priority = 7)
	public void TC7() {
		navigationMenuButton i = new navigationMenuButton();
		i.Icons();
	}
	@Test(priority = 8)
	public void TC8() {
		navigationMenuButton sm = new navigationMenuButton();
		sm.SubToMain();
	}
	@Test(priority = 9)
	public void TC9() {
		navigationMenuButton d = new navigationMenuButton();
		d.SubMenuEle();
	}
	@Test(priority = 10)
	public void TC10() {
		navigationMenuButton k = new navigationMenuButton();
		k.Keyboard();
	}
	@AfterMethod
	public void closure() {
		end();
	}

}
