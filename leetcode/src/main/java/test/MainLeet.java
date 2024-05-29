package test;


import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 */
public class MainLeet {

    @Test
    public void test() throws ParseException {
        DateFormat df = new SimpleDateFormat("HH:mm");
        System.out.println("df = " + df.parse("23:59").getTime());
    }

}
