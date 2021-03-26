package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sum_ {

    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("end")
    @Expose
    private Double end;
    @SerializedName("seconds")
    @Expose
    private Double seconds;
    @SerializedName("bytes")
    @Expose
    private Double bytes;
    @SerializedName("bits_per_second")
    @Expose
    private Double bitsPerSecond;
    @SerializedName("jitter_ms")
    @Expose
    private Double jitterMs;
    @SerializedName("lost_packets")
    @Expose
    private Integer lostPackets;
    @SerializedName("packets")
    @Expose
    private Double packets;
    @SerializedName("lost_percent")
    @Expose
    private Double lostPercent;
    @SerializedName("sender")
    @Expose
    private Boolean sender;

}