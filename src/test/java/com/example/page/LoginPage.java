package com.example.page;

import com.microsoft.playwright.Page;

/**
 * LoginPage.
 *
 */
public final class LoginPage {

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
  public void doLogin(final String email, final String password) {
    page.getByLabel("メールアドレス").fill(email);
    page.getByLabel("パスワード").fill(password);
    page.locator("#login-button").click();
    page.waitForURL("**/mypage.html");
  }
}
