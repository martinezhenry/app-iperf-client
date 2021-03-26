package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CpuUtilizationPercent {

    @SerializedName("host_total")
    @Expose
    private Double hostTotal;
    @SerializedName("host_user")
    @Expose
    private Double hostUser;
    @SerializedName("host_system")
    @Expose
    private Double hostSystem;
    @SerializedName("remote_total")
    @Expose
    private Double remoteTotal;
    @SerializedName("remote_user")
    @Expose
    private Double remoteUser;
    @SerializedName("remote_system")
    @Expose
    private Double remoteSystem;

}