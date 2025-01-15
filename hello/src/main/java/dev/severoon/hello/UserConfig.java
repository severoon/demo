package dev.severoon.hello;

import java.io.PrintWriter;
import java.util.Optional;

/** Encapsulates user-specified configuration to {@link GreetingMain}. */
public record UserConfig(Optional<PrintWriter> output, Optional<String> greeting) {}
