package com.hvscode.iperf3test.service.impl;

import com.hvscode.iperf3test.Iperf;
import com.hvscode.iperf3test.service.IperfService;

import org.junit.Test;
import org.testng.annotations.AfterTest;

import static org.junit.Assert.*;


import java.util.HashMap;


public class IperfServiceImplTest {

    @Test
    public void buildCommand() {

        IperfService iperfService = new IperfServiceImpl();
        Iperf iperf = new Iperf();

        HashMap<String, String> options = new HashMap<>();

        options.put("host", "127.0.0.1");
        options.put("port", "2021");

        String command = iperfService.buildCommand(iperf, options);

        System.out.println(command);

    }
}