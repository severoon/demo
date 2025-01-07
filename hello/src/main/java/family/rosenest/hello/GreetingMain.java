package family.rosenest.hello;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Module;

import family.rosenest.hello.app.GreetingApp;
import family.rosenest.hello.app.module.GreetingAppModule;

public final class GreetingMain {

  private static final Module APP_MODULE = new GreetingAppModule();

  public static void main(String[] args) {
    createInjector(APP_MODULE).getInstance(GreetingApp.class).run();
  }
}
