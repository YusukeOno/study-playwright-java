package com.example.page;

import com.microsoft.playwright.Page;

/**
 * MyPage.
 *
 */
public class MyPage {

  private Page page;

  public MyPage(Page page) {
    this.page = page;
  }

  public void navigate() {
    page.navigate("https://hotel.testplanisphere.dev/ja/mypage.html");
  }

  public String getEmail() {
    return page.locator("#email").innerText();
  }
}