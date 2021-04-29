package com.hvscode.iperf3test.service;

import com.hvscode.iperf3test.Iperf;

import java.util.HashMap;

public interface IperfService {


    String buildCommand(Iperf iperf);
    String validateParams() throws Exception;



}
