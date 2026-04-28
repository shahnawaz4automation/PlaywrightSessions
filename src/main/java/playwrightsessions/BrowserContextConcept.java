package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brcx1 = browser.newContext();
		Page p1 = brcx1.newPage();
		p1.navigate("https://omayo.blogspot.com/");
		p1.fill("#ta1", "automation by sam");
		System.out.println(p1.title());
		
		BrowserContext brcx2 = browser.newContext();
		Page p2 = brcx2.newPage();
		p2.navigate("https://omayo.blogspot.com/");
		p2.fill("#ta1", "automation by sam");
		System.out.println(p2.title());
	}

}
