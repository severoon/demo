package dev.severoon.hello.app;

/** An application that outputs a greeting. */
public interface GreetingApp extends Runnable {

  /** Returns the greeting used by this application. */
  public String getGreeting();

  /** Outputs a greeting. */
  @Override
  public void run();
}
