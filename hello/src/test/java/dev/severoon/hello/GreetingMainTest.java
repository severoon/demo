package dev.severoon.hello;

import static com.google.common.truth.Truth.assertThat;
import static com.google.inject.Guice.createInjector;
import static dev.severoon.hello.app.module.testing.GreetingAppTestModule.newGreetingAppTestModule;
import static java.lang.String.format;

import com.google.inject.Inject;
import com.google.inject.Injector;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import java.io.StringWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test for {@link GreetingMain}. */
class GreetingMainTest {

  private final Injector injector = createInjector(newGreetingAppTestModule("Test greeting"));

  @Inject @Output private StringWriter out;
  @Inject @Greeting private String greeting;
  @Inject private GreetingApp app;

  @BeforeEach
  void setUp() {
    injector.injectMembers(this);
  }

  @Test
  void main() {
    app.run();
    assertThat(out.toString()).isEqualTo(format(greeting + "%n"));
  }
}
