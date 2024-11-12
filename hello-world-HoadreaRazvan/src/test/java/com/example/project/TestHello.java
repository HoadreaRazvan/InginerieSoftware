package com.example.project;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHello {

    @Test
    public void testHelloWorld() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Hello.main(null);

        // assertion
        boolean outputMatch = bos.toString().equals("Hello, world!\n") || bos.toString().equals("Hello, world!\r\n");
        assertTrue(outputMatch);

        // undo the binding in System
        System.setOut(originalOut);
    }
}
