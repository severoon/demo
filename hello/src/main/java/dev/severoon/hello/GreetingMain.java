package dev.severoon.hello;

import static com.google.inject.Guice.createInjector;
import static dev.severoon.hello.app.module.GreetingAppInputsModule.greetingAppInputsModuleFor;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.module.GreetingAppModule;
import java.io.PrintWriter;

/** Main class to configure and run a {@link GreetingApp}. */
public final class GreetingMain {

  /** {@link System#out}, the default output to use if one is not otherwise specified. */
  private static final PrintWriter OUTPUT_DEFAULT = new PrintWriter(System.out, true);

  /** Default greeting to use if one is not otherwise specified. */
  private static final String GREETING_DEFAULT = "Hello, world!";

  private static final Module APP_MODULE =
      new AbstractModule() {
        @Override
        protected void configure() {
          install(new GreetingAppModule());
          install(greetingAppInputsModuleFor(OUTPUT_DEFAULT, GREETING_DEFAULT));
        }
      };

  /** Configure and run a {@link GreetingApp} instance. */
  public static void main(String[] args) {
    createInjector(APP_MODULE).getInstance(GreetingApp.class).run();
  }
}
