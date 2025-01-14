package dev.severoon.hello.app.impl;

import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import jakarta.inject.Inject;
import java.io.PrintWriter;

public final class GreetingAppImpl implements GreetingApp {

  private final PrintWriter out;
  private final String greeting;

  @Inject
  GreetingAppImpl(@Output PrintWriter out, @Greeting String greeting) {
    this.out = out;
    this.greeting = greeting;
  }

  @Override
  public String getGreeting() {
    return greeting;
  }

  @Override
  public void run() {
    out.println(greeting);
  }
}
