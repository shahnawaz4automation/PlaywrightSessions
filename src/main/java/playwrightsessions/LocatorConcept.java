package playwrightsessions;

import com.microsoft.playwright.*;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		Locator contactSales = page.locator("text=Login").first();
		System.out.println(contactSales.count());
		
		contactSales.hover();
		contactSales.click();
		
	}

}
