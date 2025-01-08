package family.rosenest.hello.app.module.testing;

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

public final class GreetingAppTestModule extends AbstractModule {

  private final String greeting;

  private GreetingAppTestModule(String greeting) {
    this.greeting = greeting;
  }

  @Override
  protected void configure() {
    StringWriter out = new StringWriter();
    bind(StringWriter.class).toInstance(out);
    bind(PrintWriter.class).toInstance(new PrintWriter(out));
    bind(String.class).annotatedWith(Greeting.class).toInstance(greeting);
  }

  public static GreetingAppTestModule newGreetingAppTestModule(String greeting) {
    return new GreetingAppTestModule(greeting);
  }
}
