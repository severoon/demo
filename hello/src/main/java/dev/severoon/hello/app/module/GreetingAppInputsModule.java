package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import java.io.PrintWriter;

/** Module that provides inputs required by {@link GreetingAppModule}. */
public final class GreetingAppInputsModule extends AbstractModule {

  private final PrintWriter out;
  private final String greeting;

  private GreetingAppInputsModule(PrintWriter out, String greeting) {
    this.out = out;
    this.greeting = greeting;
  }

  @Override
  protected void configure() {
    bind(PrintWriter.class).annotatedWith(Output.class).toInstance(out);
    bind(String.class).annotatedWith(Greeting.class).toInstance(greeting);
  }

  /** Returns a module for the specified {@code out} and {@code greeting}. */
  public static GreetingAppInputsModule greetingAppInputsModuleFor(
      PrintWriter out, String greeting) {
    return new GreetingAppInputsModule(out, greeting);
  }
}