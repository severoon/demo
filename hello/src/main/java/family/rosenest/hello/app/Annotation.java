package family.rosenest.hello.app;

import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import jakarta.inject.Qualifier;

public final class Annotation {

  @Qualifier
  @Target(PARAMETER)
  @Retention(RUNTIME)
  public @interface Greeting {}

  /** Private constructor to prevent instantiation. */
  private Annotation() {}
}
