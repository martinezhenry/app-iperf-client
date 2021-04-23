package com.hvscode.iperf3test;

import com.hvscode.iperf3test.util.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }



    @Test
    public void test_utils() {

        double bytes = 1;
        double result = Utils.byteToMega(bytes);

        System.out.println(result);

        assertEquals(4, 2 + 2);
    }

}