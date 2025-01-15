package dev.severoon.hello.app.impl;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.String.format;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.Test;

/** Test for {@link GreetingAppImpl}. */
class GreetingAppImplTest {

  private static final String TEST_GREETING = "Test greeting";

  @Test
  void run() {
    StringWriter out = new StringWriter();
    new GreetingAppImpl(new PrintWriter(out), TEST_GREETING).run();
    assertThat(out.toString()).isEqualTo(format(TEST_GREETING + "%n"));
  }
}
