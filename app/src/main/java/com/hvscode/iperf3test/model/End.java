package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class End {

    @SerializedName("streams")
    @Expose
    private List<Stream_> streams = null;
    @SerializedName("sum")
    @Expose
    private Sum_ sum;
    @SerializedName("cpu_utilization_percent")
    @Expose
    private CpuUtilizationPercent cpuUtilizationPercent;

}