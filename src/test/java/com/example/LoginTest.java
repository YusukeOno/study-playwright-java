package com.example;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.example.page.LoginPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    assertThat(page.getByRole(AriaRole.HEADING,
        new Page.GetByRoleOptions().setName("マイページ"))).hasText("マイページ");
    ;
  }
}
