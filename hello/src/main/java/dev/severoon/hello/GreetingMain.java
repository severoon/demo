package dev.severoon.hello;

import static com.google.inject.Guice.createInjector;
import static dev.severoon.hello.app.module.GreetingAppInputsModule.greetingAppInputsModuleFor;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.module.GreetingAppModule;
import java.io.PrintWriter;

public final class GreetingMain {

  private static final PrintWriter OUTPUT_DEFAULT = new PrintWriter(System.out, true);
  private static final String GREETING_DEFAULT = "Hello, world!";

  private static final Module APP_MODULE =
      new AbstractModule() {
        @Override
        protected void configure() {
          install(new GreetingAppModule());
          install(greetingAppInputsModuleFor(OUTPUT_DEFAULT, GREETING_DEFAULT));
        }
      };

  public static void main(String[] args) {
    createInjector(APP_MODULE).getInstance(GreetingApp.class).run();
  }
}
