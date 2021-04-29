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

        iperf.setHost("127.0.0.1");
        iperf.setPort("2021");
        iperf.setInterval("10");

        iperf.setUdp(true);

        String command = iperfService.buildCommand(iperf);

        System.out.println(command);

    }
}