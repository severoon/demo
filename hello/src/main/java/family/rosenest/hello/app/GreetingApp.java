package family.rosenest.hello.app;

import java.io.PrintWriter;

import family.rosenest.hello.app.Annotation.Greeting;
import jakarta.inject.Inject;

public final class GreetingApp implements Runnable {

  private final PrintWriter out;
  private final String greeting;

  @Inject
  GreetingApp(PrintWriter out, @Greeting String greeting) {
    this.out = out;
    this.greeting = greeting;
  }

  @Override
  public void run() {
    out.println(greeting);
  }
}
