package com.hvscode.iperf3test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestStart {

    @SerializedName("protocol")
    @Expose
    private String protocol;
    @SerializedName("num_streams")
    @Expose
    private Integer numStreams;
    @SerializedName("blksize")
    @Expose
    private Integer blksize;
    @SerializedName("omit")
    @Expose
    private Integer omit;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("bytes")
    @Expose
    private Integer bytes;
    @SerializedName("blocks")
    @Expose
    private Integer blocks;
    @SerializedName("reverse")
    @Expose
    private Integer reverse;
    @SerializedName("tos")
    @Expose
    private Integer tos;


}