package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Timestamp {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("timesecs")
    @Expose
    private Integer timesecs;

}