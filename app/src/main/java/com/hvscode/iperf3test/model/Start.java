package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Start {

    @SerializedName("connected")
    @Expose
    private List<Connected> connected = null;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("system_info")
    @Expose
    private String systemInfo;
    @SerializedName("timestamp")
    @Expose
    private Timestamp timestamp;
    @SerializedName("connecting_to")
    @Expose
    private ConnectingTo connectingTo;
    @SerializedName("cookie")
    @Expose
    private String cookie;
    @SerializedName("sock_bufsize")
    @Expose
    private Integer sockBufsize;
    @SerializedName("sndbuf_actual")
    @Expose
    private Integer sndbufActual;
    @SerializedName("rcvbuf_actual")
    @Expose
    private Integer rcvbufActual;
    @SerializedName("test_start")
    @Expose
    private TestStart testStart;

}