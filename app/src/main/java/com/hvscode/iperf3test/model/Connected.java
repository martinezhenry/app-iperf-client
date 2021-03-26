package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connected {

    @SerializedName("socket")
    @Expose
    private Integer socket;
    @SerializedName("local_host")
    @Expose
    private String localHost;
    @SerializedName("local_port")
    @Expose
    private Integer localPort;
    @SerializedName("remote_host")
    @Expose
    private String remoteHost;
    @SerializedName("remote_port")
    @Expose
    private Integer remotePort;

}