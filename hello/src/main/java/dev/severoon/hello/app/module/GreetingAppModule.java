package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.impl.GreetingAppImpl;
import java.io.PrintWriter;

/** Module that binds a {@link GreetingApp} to a {@link GreetingAppImpl}. */
public final class GreetingAppModule extends AbstractModule {

  private static final Key<PrintWriter> OUTPUT_KEY = Key.get(PrintWriter.class, Output.class);
  private static final Key<String> GREETING_KEY = Key.get(String.class, Greeting.class);

  @Override
  protected void configure() {
    requireBinding(OUTPUT_KEY);
    requireBinding(GREETING_KEY);

    bind(GreetingApp.class).to(GreetingAppImpl.class);
  }
}
