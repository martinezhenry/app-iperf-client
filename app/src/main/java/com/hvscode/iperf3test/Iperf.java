package com.hvscode.iperf3test;


import com.hvscode.iperf3test.annotations.IperfOption;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Iperf {

    // General
    @NonNull
    @IperfOption(name = "port", command = "-p", withValue = true)
    private String port;
    @IperfOption(name = "format", command = "-f", withValue = true, valuesAllowed = { "Kbits", "Mbits", "Gbits", "Tbits" })
    private String format;
    @IperfOption(name = "interval", command = "-i", withValue = true)
    private String interval;
    @IperfOption(name = "file", command = "-F", withValue = true)
    private String file;
    @IperfOption(name = "affinity", command = "-A", withValue = true)
    private String affinity;
    @IperfOption(name = "bind", command = "-B", withValue = true)
    private String bind;
    @IperfOption(name = "verbose", command = "-V", withValue = false)
    private boolean verbose;
    @IperfOption(name = "json", command = "-J", withValue = false)
    private boolean json;
    @IperfOption(name = "logfile", command = "--logfile", withValue = true)
    private String logfile;
    @IperfOption(name = "force-flush", command = "--forceflush", withValue = false)
    private boolean forceFlush;
    @IperfOption(name = "debug", command = "-d", withValue = false)
    private boolean debug;
    @IperfOption(name = "version", command = "-v", withValue = false)
    private boolean version;
    @IperfOption(name = "help", command = "-p", withValue = false)
    private boolean help;
    // Server Specific
    @IperfOption(name = "server", command = "-s", withValue = false)
    private boolean server;
    @IperfOption(name = "daemon", command = "-D", withValue = false)
    private boolean daemon;
    @IperfOption(name = "pid-file", command = "-I", withValue = true)
    private String pidFile;
    @IperfOption(name = "one-off", command = "-1", withValue = false)
    private boolean oneOff;
    @IperfOption(name = "rsa-private-key", command = "--rsa-private-key-path", withValue = true)
    private String rsaPrivateKeyPath;
    @IperfOption(name = "authorized-users", command = "--authorized-users-path", withValue = true)
    private String authorizedUsersPath;
    // Client Specific
    @IperfOption(name = "host", command = "-c", withValue = true)
    private String host;
    @IperfOption(name = "sctp", command = "--sctp", withValue = false)
    private boolean sctp;
    @IperfOption(name = "xbind", command = "-X", withValue = true)
    private String xbind;
    @IperfOption(name = "streams", command = "--nstreams", withValue = true)
    private String nStreams;
    @IperfOption(name = "udp", command = "-u", withValue = false)
    private boolean udp;
    @IperfOption(name = "connect-timeout", command = "--connect-timeout", withValue = true)
    private String connectTimeout;
    @IperfOption(name = "bit-rate", command = "-b", withValue = true)
    private String bitRate;
    @IperfOption(name = "pacing-timer", command = "--pacing-timer", withValue = true)
    private String pacingTimer;
    @IperfOption(name = "fq-rate", command = "--fq-rate", withValue = true)
    private String fqRate;
    @IperfOption(name = "time", command = "-t", withValue = true)
    private String time;
    @IperfOption(name = "bytes", command = "-n", withValue = true)
    private String bytes;
    @IperfOption(name = "blockcount", command = "-k", withValue = true)
    private String blockCount;
    @IperfOption(name = "length", command = "-l", withValue = true)
    private String length;
    @IperfOption(name = "c-port", command = "--cport", withValue = true)
    private String cPort;
    @IperfOption(name = "parallel", command = "--parallel", withValue = true)
    private String parallel;
    @IperfOption(name = "reverse", command = "-R", withValue = false)
    private boolean reverse;
    @IperfOption(name = "bi.dir", command = "--bidir", withValue = false)
    private boolean bDir;
    @IperfOption(name = "window", command = "-w", withValue = true)
    private String window;
    @IperfOption(name = "congestion", command = "-C", withValue = false)
    private boolean congestion;
    @IperfOption(name = "set-mss", command = "--set-mss", withValue = true)
    private String setMss;
    @IperfOption(name = "no-deplay", command = "-N", withValue = false)
    private boolean noDelay;
    @IperfOption(name = "version-4", command = "-4", withValue = false)
    private boolean version4;
    @IperfOption(name = "version-6", command = "-6", withValue = false)
    private boolean version6;
    @IperfOption(name = "tos", command = "-S", withValue = true)
    private String tos;
    @IperfOption(name = "dscp", command = "-dscp", withValue = true)
    private String dscp;
    @IperfOption(name = "flow-level", command = "-L", withValue = true)
    private String flowLabel;
    @IperfOption(name = "zerocopy", command = "-Z", withValue = false)
    private boolean zeroCopy;
    @IperfOption(name = "omit", command = "-O", withValue = true)
    private String omit;
    @IperfOption(name = "title", command = "-T", withValue = true)
    private String title;
    @IperfOption(name = "extra-data", command = "--extra-data", withValue = true)
    private String extraData;
    @IperfOption(name = "get-server-output", command = "--get-server-output", withValue = false)
    private boolean getServerOut;
    @IperfOption(name = "udp-counters-64bit", command = "--udp-counters-64bit", withValue = false)
    private boolean udpCounters64Bits;
    @IperfOption(name = "repeating-payload", command = "--repeating-payload", withValue = false)
    private boolean repeatingPayload;
    @IperfOption(name = "username", command = "--username", withValue = true)
    private String username;
    @IperfOption(name = "rsa-public-key", command = "--rsa-public-key-path", withValue = true)
    private String rsaPublicKeyPath;


}
