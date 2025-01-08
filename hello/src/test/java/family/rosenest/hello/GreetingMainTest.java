package family.rosenest.hello;

import java.io.StringWriter;
import static java.lang.String.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Inject;
import com.google.inject.Injector;

import family.rosenest.hello.app.Annotation.Greeting;
import family.rosenest.hello.app.GreetingApp;
import static family.rosenest.hello.app.module.testing.GreetingAppTestModule.newGreetingAppTestModule;

class GreetingMainTest {

  private final Injector injector = createInjector(newGreetingAppTestModule("Test greeting"));

  @Inject @Greeting private String greeting;
  @Inject private StringWriter out;
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
