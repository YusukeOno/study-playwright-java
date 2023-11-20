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

  public String getName() {
    return page.locator("#username").innerText();
  }

  public String getRank() {
    return page.locator("#rank").innerText();
  }

  public String getAddress() {
    return page.locator("#address").innerText();
  }

  public String getTel() {
    return page.locator("#tel").innerHTML();
  }

  public String getGender() {
    return page.locator("#gender").innerHTML();
  }

  public String getBirthday() {
    return page.locator("#birthday").innerText();
  }

  public String getNotification() {
    return page.locator("#notification").innerText();
  }
}