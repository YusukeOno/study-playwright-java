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
   * @param email    メールアドレス
   * @param password パスワード
   */
  public void doLogin(String email, String password) {
    page.getByLabel("メールアドレス").fill(email);
    page.getByLabel("パスワード").fill(password);
    page.locator("#login-button").click();
    page.waitForURL("**/mypage.html");
  }
}
