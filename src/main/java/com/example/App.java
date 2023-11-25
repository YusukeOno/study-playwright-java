package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

/**
 * Hello Playwirght.
 *
 */
public final class App {
  /**
   * Main method.
   *
   * @param args Arguments
   */
  public static void main(final String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.webkit().launch();
      Page page = browser.newPage();
      page.navigate("https://playwright.dev/");
      page.screenshot(
          new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
    }
  }

  /**
   * App.
   */
  private App() {
  }
}
