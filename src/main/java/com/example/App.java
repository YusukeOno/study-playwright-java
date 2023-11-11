package com.example;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Hello Playwirght!
 *
 */
public class App {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.webkit().launch();
      Page page = browser.newPage();
      page.navigate("https://playwright.dev/");
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
    }
  }
}
