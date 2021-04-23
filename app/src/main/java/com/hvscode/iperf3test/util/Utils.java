package com.hvscode.iperf3test.util;

public class Utils {

    public static long MEGA_BASE = 1000000;


    public static double byteToMega(double bytes) {


        double result = (bytes/MEGA_BASE);

        return result;



    }


}
