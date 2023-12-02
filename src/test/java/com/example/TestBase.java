package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * TestBase.
 */
public class TestBase {

  /** Playwright. */
  static Playwright playwright;

  /** Browser. */
  static Browser browser;

  /** BrowserContext. */
  protected BrowserContext context;

  /** Page. */
  protected Page page;

  /**
   * launchBrowser.
   */
  @BeforeAll
  static void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(
        new BrowserType.LaunchOptions().setHeadless(false));
  }

  /**
   * closeBrowser.
   */
  @AfterAll
  static void closeBrowser() {
    playwright.close();
  }

  /**
   * createContextAndPage.
   */
  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
  }

  /**
   * closeContext.
   */
  @AfterEach
  void closeContext() {
    context.close();
  }
}
