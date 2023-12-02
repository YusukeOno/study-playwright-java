package com.example.util;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import java.nio.file.Paths;
import java.util.Optional;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

/**
 * CustomEvidence.
 */
public class CustomEvidence implements TestWatcher {

  private static final String TARGET_DIR = "target";

  /** CustomEvidenceOption. */
  private CustomEvidenceOption customEvidenceOption;

  /**
   * CustomEvidence.
   */
  public CustomEvidence() {
  }

  /**
   * CustomEvidence.
   *
   * @param page           page
   * @param browserContext browserContext
   * @param testInfo       testInfo
   */
  public CustomEvidence(
      final Page page,
      final BrowserContext browserContext,
      final TestInfo testInfo) {
    this.init(page, browserContext, testInfo);
    this.startTracing();
  }

  private void init(
      final Page page,
      final BrowserContext browserContext,
      final TestInfo testInfo) {
    this.customEvidenceOption = new CustomEvidenceOption();
    this.customEvidenceOption.setPage(page);
    this.customEvidenceOption.setContext(browserContext);
    this.customEvidenceOption.setTestInfo(testInfo);
    this.customEvidenceOption.setScreenshotFilename(
        getEvidenceFilename("screenshot", "png"));
    this.customEvidenceOption.setTracingFilename(
        getEvidenceFilename("trace", "zip"));
  }

  private void startTracing() {
    BrowserContext context = this.customEvidenceOption.getContext();
    context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
  }

  /**
   * takeScreenshot.
   */
  public void takeScreenshot() {
    Page page = this.customEvidenceOption.getPage();
    String screenshotFilename = customEvidenceOption.getScreenshotFilename();
    page.screenshot(
        new Page.ScreenshotOptions().setPath(
            Paths.get(TARGET_DIR, screenshotFilename)).setFullPage(true));
  }

  /**
   * stopTracing.
   */
  public void stopTracing() {
    BrowserContext context = this.customEvidenceOption.getContext();
    context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get(TARGET_DIR, this.customEvidenceOption.getTracingFilename())));
  }

  private String getEvidenceFilename(
      final String prefix, final String extenstion) {
    TestInfo testInfo = customEvidenceOption.getTestInfo();
    return prefix + "-" + testInfo.getDisplayName() + "." + extenstion;
  }

  @Override
  public void testDisabled(
      final ExtensionContext context,
      final Optional<String> reason) {
    /* no-op */
  }

  @Override
  public void testSuccessful(
      final ExtensionContext context) {
    /* no-op */
    this.takeScreenshot();
  }

  @Override
  public void testAborted(
      final ExtensionContext context,
      final Throwable cause) {
    /* no-op */
  }

  @Override
  public void testFailed(
      final ExtensionContext context,
      final Throwable cause) {
    /* no-op */
  }
}
