package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Module;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.impl.GreetingAppImpl;
import java.io.PrintWriter;

/** Module that binds a {@link GreetingApp} to a {@link GreetingAppImpl}. */
public final class GreetingAppModule extends AbstractModule {

  private final Module outputModule;
  private final String greeting;

  private GreetingAppModule(Module outputModule, String greeting) {
    this.outputModule = outputModule;
    this.greeting = greeting;
  }

  @Override
  protected void configure() {
    requireBinding(Key.get(PrintWriter.class, Output.class));

    install(outputModule);

    bind(GreetingApp.class).to(GreetingAppImpl.class);
    bind(String.class).annotatedWith(Greeting.class).toInstance(greeting);
  }

  /** * Returns a {@code GreetingAppModule} for the specified {@code greeting}. */
  public static GreetingAppModule greetingAppModuleFor(Module outputModule, String greeting) {
    return new GreetingAppModule(outputModule, greeting);
  }
}
