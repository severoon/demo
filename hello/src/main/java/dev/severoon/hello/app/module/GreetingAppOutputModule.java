package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Output;
import java.io.PrintWriter;

/** Module that provides the output required by {@link GreetingAppModule}. */
public final class GreetingAppOutputModule extends AbstractModule {

  private final PrintWriter out;

  private GreetingAppOutputModule(PrintWriter out) {
    this.out = out;
  }

  @Override
  protected void configure() {
    bind(PrintWriter.class).annotatedWith(Output.class).toInstance(out);
  }

  /** Returns a {@code GreetingAppOutputModule} for the specified {@code out}. */
  public static final GreetingAppOutputModule greetingAppOutputModuleFor(PrintWriter out) {
    return new GreetingAppOutputModule(out);
  }
}
