package family.rosenest.hello;

import java.io.PrintWriter;
import java.io.StringWriter;
import static java.lang.String.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import com.google.inject.AbstractModule;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

import family.rosenest.hello.app.Annotation.Greeting;
import family.rosenest.hello.app.GreetingApp;

class GreetingMainTest {

  private static final String TEST_GREETING = "Test greeting";

  private static final Module TEST_MODULE =
      new AbstractModule() {
        @Override
        protected void configure() {
          StringWriter out = new StringWriter();
          bind(StringWriter.class).toInstance(out);
          bind(PrintWriter.class).toInstance(new PrintWriter(out));
          bind(String.class).annotatedWith(Greeting.class).toInstance(TEST_GREETING);
        }
      };

  private final Injector injector = createInjector(TEST_MODULE);

  @Inject private StringWriter out;
  @Inject private GreetingApp app;

  @BeforeEach
  void setUp() {
    injector.injectMembers(this);
  }

  @Test
  void main() {
    app.run();
    assertThat(out.toString()).isEqualTo(format(TEST_GREETING + "%n"));
  }
}
