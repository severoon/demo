package dev.severoon.hello;

import static com.google.common.truth.Truth.assertThat;
import static com.google.inject.Guice.createInjector;
import static dev.severoon.hello.app.module.GreetingAppModule.greetingAppModuleFor;
import static java.lang.String.format;

import com.google.inject.Inject;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.module.testing.GreetingAppOutputTestModule;
import java.io.StringWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test for {@link GreetingMain}. */
class GreetingMainTest {

  private static final String TEST_GREETING = "Testing, testing, 1, 2, 3…";

  @Inject @Output private StringWriter out;
  @Inject @Greeting private String greeting;
  @Inject private GreetingApp app;

  @BeforeEach
  void setUp() {
    createInjector(greetingAppModuleFor(new GreetingAppOutputTestModule(), TEST_GREETING))
        .injectMembers(this);
  }

  @Test
  void main() {
    app.run();
    assertThat(out.toString()).isEqualTo(format(greeting + "%n"));
  }
}
