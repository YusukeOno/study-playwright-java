package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.page.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginTest extends TestBase {

  @Test
  @DisplayName("testプレミアム会員でログインする")
  void testLogin() {
    // Given
    LoginPage loginPage = new LoginPage(page);
    loginPage.navigate();

    // When
    loginPage.doLogin("ichiro@example.com", "password");

    // Then
    assertTrue(page.url().contains("https://hotel.testplanisphere.dev/ja/mypage.html"));
  }
}
