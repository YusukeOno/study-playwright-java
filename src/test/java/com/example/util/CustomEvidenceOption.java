package com.example.util;

import com.example.TestBase;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.TestInfo;

/**
 * CustomEvidenceOption.
 */
public final class CustomEvidenceOption {

  /** TestBase. */
  private TestBase testBase;

  /** BrowserContext. */
  private BrowserContext context;

  /** Page. */
  private Page page;

  /** screenshotFilename. */
  private String screenshotFilename;

  /** tracingFilename. */
  private String tracingFilename;

  /** TestInfo. */
  private TestInfo testInfo;

  public CustomEvidenceOption() {
  }

  public CustomEvidenceOption(TestBase testBase) {
    this.testBase = testBase;
  }

  public TestBase getTestBase() {
    return testBase;
  }

  public void setTestBase(TestBase testBase) {
    this.testBase = testBase;
  }

  public BrowserContext getContext() {
    return context;
  }

  public void setContext(BrowserContext context) {
    this.context = context;
  }

  public Page getPage() {
    return page;
  }

  public void setPage(Page page) {
    this.page = page;
  }

  public String getScreenshotFilename() {
    return screenshotFilename;
  }

  public void setScreenshotFilename(final String evidenceFilename) {
    this.screenshotFilename = evidenceFilename;
  }

  public String getTracingFilename() {
    return tracingFilename;
  }

  public void setTracingFilename(final String tracingFilename) {
    this.tracingFilename = tracingFilename;
  }

  /**
   * getTestInfo.
   *
   * @return testInfo
   */
  public TestInfo getTestInfo() {
    return testInfo;
  }

  /**
   * setTestInfo.
   *
   * @param testInfo testInfo
   */
  public void setTestInfo(final TestInfo testInfo) {
    this.testInfo = testInfo;
  }
}
