package dev.severoon.hello.app.module.testing;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Module that configures a {@link GreetingApp} for testing.
 *
 * <p>Specifically, this module binds an {@link Output}-annotated {@link StringWriter} that can be
 * injected into tests that captures application output.
 */
public final class GreetingAppOutputTestModule extends AbstractModule {

  @Override
  protected void configure() {
    StringWriter out = new StringWriter();
    bind(StringWriter.class).annotatedWith(Output.class).toInstance(out);
    bind(PrintWriter.class).annotatedWith(Output.class).toInstance(new PrintWriter(out, true));
  }
}
