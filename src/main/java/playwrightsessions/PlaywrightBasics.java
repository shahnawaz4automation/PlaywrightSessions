package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

public class PlaywrightBasics {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		Page page = browser.newPage();
		
		page.navigate("https://www.amazon.com");
		
		String title = page.title();
		System.out.println("Page title is: " + title);
		
		String url = page.url();
		System.out.println("URL is: "+url);
		
		String title1 = page.title();
		System.out.println("Page title is: " + title1);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
