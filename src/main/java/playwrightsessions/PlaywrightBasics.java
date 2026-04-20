package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class PlaywrightBasics {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.amazon.com");

		// wait for title to be non-empty
		page.waitForFunction("() => document.title.length > 0");

		System.out.println("Page title is: " + page.title());
		
		String currentUrl = page.url();
		System.out.println("URL of page is: "+currentUrl);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
