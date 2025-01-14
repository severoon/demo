package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Greeting;
import java.io.PrintWriter;

public final class GreetingAppModule extends AbstractModule {

  private static final String GREETING = "Hello, world!";

  @Override
  protected void configure() {
    bind(PrintWriter.class).toInstance(new PrintWriter(System.out));
    bind(String.class).annotatedWith(Greeting.class).toInstance(GREETING);
  }
}