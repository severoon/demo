package dev.severoon.hello.app.module.testing;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.module.GreetingAppModule;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class GreetingAppTestModule extends AbstractModule {

  private final String greeting;

  private GreetingAppTestModule(String greeting) {
    this.greeting = greeting;
  }

  @Override
  protected void configure() {
    install(new GreetingAppModule());

    StringWriter out = new StringWriter();
    bind(StringWriter.class).toInstance(out);
    bind(PrintWriter.class).annotatedWith(Output.class).toInstance(new PrintWriter(out));
    bind(String.class).annotatedWith(Greeting.class).toInstance(greeting);
  }

  public static GreetingAppTestModule newGreetingAppTestModule(String greeting) {
    return new GreetingAppTestModule(greeting);
  }
}
