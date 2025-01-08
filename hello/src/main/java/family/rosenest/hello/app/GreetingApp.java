package family.rosenest.hello.app;

import family.rosenest.hello.app.Annotation.Greeting;
import jakarta.inject.Inject;
import java.io.PrintWriter;

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
