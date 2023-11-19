package com.example.page;

import com.microsoft.playwright.Page;

/**
 * LoginPage.
 *
 */
public class LoginPage {

  private final Page page;

  public LoginPage(Page page) {
    this.page = page;
  }

  public void navigate() {
    page.navigate("https://hotel.testplanisphere.dev/ja/login.html");
  }

  /**
   * doLogin.
   *
   * @param mailAddress メールアドレス
   * @param password    パスワード
   */
  public void doLogin(String mailAddress, String password) {
    page.getByLabel("メールアドレス").fill(mailAddress);
    page.getByLabel("パスワード").fill(password);
    page.locator("#login-button").click();
  }
}