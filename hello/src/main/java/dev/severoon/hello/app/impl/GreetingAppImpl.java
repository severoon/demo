package dev.severoon.hello.app.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import dev.severoon.hello.app.Annotation.Greeting;
import dev.severoon.hello.app.Annotation.Output;
import dev.severoon.hello.app.GreetingApp;
import jakarta.inject.Inject;
import java.io.PrintWriter;

/** Implementation of a {@link GreetingApp}. */
public final class GreetingAppImpl implements GreetingApp {

  private final PrintWriter out;
  private final String greeting;

  @Inject
  GreetingAppImpl(@Output PrintWriter out, @Greeting String greeting) {
    this.out = checkNotNull(out);
    this.greeting = checkNotNull(greeting);
  }

  /** Returns the greeting output by this app. */
  @Override
  public String getGreeting() {
    return greeting;
  }

  /** Outputs a greeting. */
  @Override
  public void run() {
    out.println(greeting);
  }
}
