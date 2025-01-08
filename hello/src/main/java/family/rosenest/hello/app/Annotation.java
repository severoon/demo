package family.rosenest.hello.app;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public final class Annotation {

  @Qualifier
  @Target(PARAMETER)
  @Retention(RUNTIME)
  public @interface Greeting {}

  /** Private constructor to prevent instantiation. */
  private Annotation() {}
}
