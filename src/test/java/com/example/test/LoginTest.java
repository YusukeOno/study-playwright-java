package com.example.test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.example.TestBase;
import com.example.page.LoginPage;
import com.example.util.CustomEvidence;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CustomEvidence.class)
class LoginTest extends TestBase {

  /** CustomEvidence. */
  private CustomEvidence evidence;

  @BeforeEach
  void setup(final TestInfo testInfo) {
    evidence = new CustomEvidence(super.page, super.context, testInfo);
  }

  @AfterEach
  void teardown(final TestInfo testInfo) {
    evidence.takeScreenshot();
  }

  @Test
  @Tag("Authentication")
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
  }
}
