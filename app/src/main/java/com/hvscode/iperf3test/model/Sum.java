package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sum {

    @SerializedName("start")
    @Expose
    private Double start;
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
    @SerializedName("packets")
    @Expose
    private Integer packets;
    @SerializedName("omitted")
    @Expose
    private Boolean omitted;
    @SerializedName("sender")
    @Expose
    private Boolean sender;

}