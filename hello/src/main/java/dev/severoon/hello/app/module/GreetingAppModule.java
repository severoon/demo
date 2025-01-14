package dev.severoon.hello.app.module;

import com.google.inject.AbstractModule;
import dev.severoon.hello.app.GreetingApp;
import dev.severoon.hello.app.impl.GreetingAppImpl;

public final class GreetingAppModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(GreetingApp.class).to(GreetingAppImpl.class);
  }
}
