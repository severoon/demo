package dev.severoon.hello.module;

import static com.google.common.base.Preconditions.checkNotNull;
import static dev.severoon.hello.app.module.GreetingAppModule.greetingAppModuleFor;
import static dev.severoon.hello.app.module.GreetingAppOutputModule.greetingAppOutputModuleFor;

import com.google.inject.AbstractModule;
import dev.severoon.hello.UserConfig;
import java.io.PrintWriter;

public final class GreetingMainModule extends AbstractModule {

  /** {@link System#out}, the default output to use if one is not otherwise specified. */
  private static final PrintWriter OUTPUT_DEFAULT = new PrintWriter(System.out, true);

  /** Default greeting to use if one is not otherwise specified. */
  private static final String GREETING_DEFAULT = "Hello, world!";

  private final UserConfig config;

  private GreetingMainModule(UserConfig config) {
    this.config = checkNotNull(config);
  }

  @Override
  protected void configure() {
    install(
        greetingAppModuleFor(
            greetingAppOutputModuleFor(config.output().orElse(OUTPUT_DEFAULT)),
            config.greeting().orElse(GREETING_DEFAULT)));
  }

  /** Returns a {@code GreetingMainModule} for the specified {@code config}. */
  public static GreetingMainModule greetingMainModuleFor(UserConfig config) {
    return new GreetingMainModule(config);
  }
}
