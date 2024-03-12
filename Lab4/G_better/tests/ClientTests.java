package tests;

import src.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClientTests
{
    static final private String EXPECTED_TRUE = "true\r\n";
    static final private String EXPECTED_FALSE = "false\r\n";

    static private ByteArrayOutputStream setIOstreams(String input)
    {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);
        return output;
    }

    @Test
    public void ShouldPrintTrueWhenIntercepts()
    {
        //Arrange
        String input = "4\n1 1\n3 1\n3 3\n1 3\n" + "3\n2 4\n4 0\n4 4\n";

        //Act
        ByteArrayOutputStream os = setIOstreams(input);
        Client.main(null);
        String output = os.toString();

        //Assert
        assertEquals(EXPECTED_TRUE, output);
    }

    @Test
    public void ShouldPrintFalseWhenDoesntIntercept()
    {
         //Arrange
        String input = "4\n1 1\n3 1\n3 3\n1 3\n" + "4\n2 4\n4 4\n4 6\n2 6\n";

        //Act
        ByteArrayOutputStream os = setIOstreams(input);
        Client.main(null);
        String output = os.toString();

        //Assert
        assertEquals(EXPECTED_FALSE, output);
    }

    @Test
    public void ShouldPrintFalseWhenBoxesInterceptButPolygonsDont()
    {
        //Arrange
        String input = "4\n1 6\n2 9\n3 6\n2 8\n" + "4\n1 4\n2 7\n3 4\n2 6\n";

        //Act
        ByteArrayOutputStream os = setIOstreams(input);
        Client.main(null);
        String output = os.toString();

        //Assert
        assertEquals(EXPECTED_FALSE, output);
    }
}
