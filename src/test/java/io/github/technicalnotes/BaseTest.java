package io.github.technicalnotes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class BaseTest {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    protected final PrintStream originalOut = System.out;
    protected final PrintStream originalErr = System.err;

    protected void setUpStreams() {
        OutputStream outputStreamCombinerOut = new OutputStreamCombiner(Arrays.asList(originalOut, outContent));
        OutputStream outputStreamCombinerErr = new OutputStreamCombiner(Arrays.asList(originalErr, errContent));
        System.setOut(new PrintStream(outputStreamCombinerOut));
        System.setErr(new PrintStream(outputStreamCombinerErr));
    }

    protected void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    public void init() {
        setUpStreams();
    }

    @AfterEach
    public void destroy() {
        restoreStreams();
    }
}
