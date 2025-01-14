package dev.severoon.hello;

import static com.google.inject.Guice.createInjector;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.module.GreetingAppDefaultsModule;
import dev.severoon.hello.app.module.GreetingAppModule;
import java.io.PrintWriter;

public final class GreetingMain {

  private static final Key<PrintWriter> OUTPUT_KEY = Key.get(PrintWriter.class, Output.class);

  private static final Module APP_MODULE =
      new AbstractModule() {
        @Override
        protected void configure() {
          install(new GreetingAppModule());
          install(new GreetingAppDefaultsModule());
        }
      };

  public static void main(String[] args) {
    Injector injector = createInjector(APP_MODULE);
    try (PrintWriter out = injector.getInstance(OUTPUT_KEY)) {
      injector.getInstance(GreetingApp.class).run();
      out.flush();
    }
  }
}
