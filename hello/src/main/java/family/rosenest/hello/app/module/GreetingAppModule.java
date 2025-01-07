package family.rosenest.hello.app.module;

import java.io.PrintWriter;

import com.google.inject.AbstractModule;

public final class GreetingAppModule extends AbstractModule {

  private static final String GREETING = "Hello, world!";

  @Override
  protected void configure() {
    bind(PrintWriter.class).toInstance(new PrintWriter(System.out));
    bind(String.class).toInstance(GREETING);
  }
}
