package com.scrolltest.todo;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextsDemo {

	public static void main(String[] args) {
		browserContextsDemo();
	}

	private static void browserContextsDemo() {
		// BrowserContexts provide a way to operate multiple independent browser
		// sessions.
		// Playwright allows creating "incognito" browser contexts with
		// Browser.newContext([options]) method. "Incognito" browse

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions()
							.setDownloadsPath(Paths.get("src/test/java/com/scrolltest/todo/")).setHeadless(false)
							.setSlowMo(200));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
			Page page = context.newPage();
			page.navigate("https://the-internet.herokuapp.com/download");
			page.pause();

		}
	}

}
