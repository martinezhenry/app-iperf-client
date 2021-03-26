package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IperfResult {

    @SerializedName("start")
    @Expose
    private Start start;
    @SerializedName("intervals")
    @Expose
    private List<Interval> intervals = null;
    @SerializedName("end")
    @Expose
    private End end;
    @SerializedName("title")
    @Expose
    private String title;

}