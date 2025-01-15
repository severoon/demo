package dev.severoon.hello.app.module.testing;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.module.GreetingAppModule;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Module that configures a {@link GreetingApp} for testing.
 *
 * <p>Specifically, this module binds an {@link Output}-annotated {@link StringWriter} that can be
 * injected into tests that captures application output.
 */
public final class GreetingAppTestModule extends AbstractModule {

  private final String greeting;

  private GreetingAppTestModule(String greeting) {
    this.greeting = greeting;
  }

  @Override
  protected void configure() {
    install(new GreetingAppModule());

    StringWriter out = new StringWriter();
    bind(StringWriter.class).annotatedWith(Output.class).toInstance(out);
    bind(PrintWriter.class).annotatedWith(Output.class).toInstance(new PrintWriter(out, true));
    bind(String.class).annotatedWith(Greeting.class).toInstance(greeting);
  }

  /** Returns a testing module for the specified {@code greeting}. */
  public static GreetingAppTestModule newGreetingAppTestModule(String greeting) {
    return new GreetingAppTestModule(greeting);
  }
}
