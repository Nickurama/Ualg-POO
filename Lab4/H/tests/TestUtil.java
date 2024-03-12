package tests;

import java.io.*;

public class TestUtil
{
    static public ByteArrayOutputStream setIOstreams(String input)
    {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);
        return output;
    }
}
