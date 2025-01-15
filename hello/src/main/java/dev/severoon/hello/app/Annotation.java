package dev.severoon.hello.app;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/** Binding annotations for {@link GreetingApp}. */
public final class Annotation {

  /** Binding annotation for a greeting. */
  @Qualifier
  @Target({FIELD, METHOD, PARAMETER})
  @Retention(RUNTIME)
  public @interface Greeting {}

  /** Binding annotation for output. */
  @Qualifier
  @Target({FIELD, METHOD, PARAMETER})
  @Retention(RUNTIME)
  public @interface Output {}

  /** Private constructor to prevent instantiation. */
  private Annotation() {}
}
