package playwrightsessions;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class Example {
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      
	   // Start tracing before creating / navigating a page.
	      context.tracing().start(new Tracing.StartOptions()
	        .setScreenshots(true)
	        .setSnapshots(true)
	        .setSources(true));
	      
	      Page page = context.newPage();
	      page.navigate("https://tutorialsninja.com/demo/");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("apple watch");
	      page.locator("#search").getByRole(AriaRole.BUTTON).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search").setExact(true)).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search").setExact(true)).fill("apple");
	      page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).click();
	      page.getByText("Apple Cinema 30\"").click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Qty")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Qty")).fill("1");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart").setExact(true)).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Shopping Cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("iPhone")).first().click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Qty")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Qty")).fill("10");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();
	      
	   // Stop tracing and export it into a zip archive.
	      context.tracing().stop(new Tracing.StopOptions()
	        .setPath(Paths.get("trace.zip")));
	    }
	  }
	}