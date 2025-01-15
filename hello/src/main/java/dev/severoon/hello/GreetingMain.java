package dev.severoon.hello;

import static com.google.inject.Guice.createInjector;
import static dev.severoon.hello.module.GreetingMainModule.greetingMainModuleFor;
import static java.lang.String.format;

import dev.severoon.hello.app.GreetingApp;
import java.util.Optional;

/** Main class to configure and run a {@link GreetingApp}. */
public final class GreetingMain {

  /** Exit code of {@link GreetingMain}. */
  private enum ExitCode {
    SUCCESS,
    INVALID_ARGUMENTS;
  }

  /** Configure and run a {@link GreetingApp} instance. */
  public static void main(String[] args) {
    createInjector(greetingMainModuleFor(parseConfig(args))).getInstance(GreetingApp.class).run();
  }

  /** Parses specified command line {@code args} into a {@link UserConfig} record. */
  private static UserConfig parseConfig(String[] args) {
    if (args.length > 1) {
      System.err.println(format("Usage: %s [greeting]", GreetingMain.class.getSimpleName()));
      System.err.println(
          format("Example: java %s \"Hello, Guice world!\"", GreetingMain.class.getSimpleName()));
      System.exit(ExitCode.INVALID_ARGUMENTS.ordinal());
    }
    return new UserConfig(
        Optional.empty(), // User-configured output not supported in this example.
        args.length > 0 ? Optional.of(args[0]) : Optional.empty());
  }
}
