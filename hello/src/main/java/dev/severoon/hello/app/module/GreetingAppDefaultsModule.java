package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import java.io.PrintWriter;

public final class GreetingAppDefaultsModule extends AbstractModule {

  private static final String GREETING = "Hello, world!";

  @Override
  protected void configure() {
    bind(PrintWriter.class).annotatedWith(Output.class).toInstance(new PrintWriter(System.out));
    bind(String.class).annotatedWith(Greeting.class).toInstance(GREETING);
  }
}
