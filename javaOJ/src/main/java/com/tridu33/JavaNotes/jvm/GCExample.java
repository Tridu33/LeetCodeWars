package com.tridu33.JavaNotes.jvm;

public class GCExample {
    // -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -Xlog:gc*
    public static final int MB = 1024*1024;

    public static void main(String[] args) {
        System.out.println("1");
        byte[] allocation1 = new byte[2*MB];
        System.out.println("2");
        byte[] allocation2 = new byte[2*MB];
        System.out.println("3");
        byte[] allocation3 = new byte[1*MB];
        System.out.println("4");
        byte[] allocation4 = new byte[4*MB];
    }
    /*
 \jvm>java -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -Xlog:gc* GCExample.java
[0.004s][info][gc] Using Serial
[0.004s][info][gc,init] Version: 17.0.5+8 (release)
[0.004s][info][gc,init] CPUs: 24 total, 24 available
[0.004s][info][gc,init] Memory: 32508M
[0.005s][info][gc,init] Large Page Support: Disabled
[0.005s][info][gc,init] NUMA Support: Disabled
[0.005s][info][gc,init] Compressed Oops: Enabled (32-bit)
[0.005s][info][gc,init] Heap Min Capacity: 20M
[0.005s][info][gc,init] Heap Initial Capacity: 20M
[0.005s][info][gc,init] Heap Max Capacity: 20M
[0.005s][info][gc,init] Pre-touch: Disabled
[0.005s][info][gc,metaspace] CDS archive(s) mapped at: [0x0000000800000000-0x0000000800bc0000-0x0000000800bc0000), size 12320768, SharedBaseAddress: 0x0000000800000000, ArchiveRelocationMode: 0.
[0.005s][info][gc,metaspace] Compressed class space mapped at: 0x0000000800c00000-0x0000000840c00000, reserved size: 1073741824
[0.005s][info][gc,metaspace] Narrow klass base: 0x0000000800000000, Narrow klass shift: 0, Narrow klass range: 0x100000000
[0.180s][info][gc,start    ] GC(0) Pause Young (Allocation Failure)
[0.184s][info][gc,heap     ] GC(0) DefNew: 8192K(9216K)->1024K(9216K) Eden: 8192K(8192K)->0K(8192K) From: 0K(1024K)->1024K(1024K)
[0.184s][info][gc,heap     ] GC(0) Tenured: 0K(10240K)->2089K(10240K)
[0.184s][info][gc,metaspace] GC(0) Metaspace: 7853K(8000K)->7853K(8000K) NonClass: 6935K(7040K)->6935K(7040K) Class: 918K(960K)->918K(960K)
[0.184s][info][gc          ] GC(0) Pause Young (Allocation Failure) 8M->3M(19M) 3.961ms
[0.184s][info][gc,cpu      ] GC(0) User=0.00s Sys=0.00s Real=0.00s
1
[0.246s][info][gc,start    ] GC(1) Pause Young (Allocation Failure)
[0.250s][info][gc,heap     ] GC(1) DefNew: 8000K(9216K)->1023K(9216K) Eden: 6976K(8192K)->0K(8192K) From: 1024K(1024K)->1023K(1024K)
[0.250s][info][gc,heap     ] GC(1) Tenured: 2089K(10240K)->3164K(10240K)
[0.250s][info][gc,metaspace] GC(1) Metaspace: 9102K(9344K)->9102K(9344K) NonClass: 8025K(8192K)->8025K(8192K) Class: 1077K(1152K)->1077K(1152K)
[0.250s][info][gc          ] GC(1) Pause Young (Allocation Failure) 9M->4M(19M) 3.800ms
[0.250s][info][gc,cpu      ] GC(1) User=0.00s Sys=0.00s Real=0.01s
2
3
4
[0.251s][info][gc,start    ] GC(2) Pause Young (Allocation Failure)
[0.253s][info][gc,heap     ] GC(2) DefNew: 6299K(9216K)->0K(9216K) Eden: 5275K(8192K)->0K(8192K) From: 1023K(1024K)->0K(1024K)
[0.253s][info][gc,heap     ] GC(2) Tenured: 3164K(10240K)->9303K(10240K)
[0.253s][info][gc,metaspace] GC(2) Metaspace: 9102K(9344K)->9102K(9344K) NonClass: 8025K(8192K)->8025K(8192K) Class: 1077K(1152K)->1077K(1152K)
[0.253s][info][gc          ] GC(2) Pause Young (Allocation Failure) 9M->9M(19M) 2.694ms
[0.253s][info][gc,cpu      ] GC(2) User=0.00s Sys=0.00s Real=0.00s
[0.254s][info][gc,heap,exit] Heap
[0.254s][info][gc,heap,exit]  def new generation   total 9216K, used 4308K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
[0.254s][info][gc,heap,exit]   eden space 8192K,  52% used [0x00000000fec00000, 0x00000000ff035318, 0x00000000ff400000)
[0.254s][info][gc,heap,exit]   from space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500090, 0x00000000ff600000)
[0.254s][info][gc,heap,exit]   to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
[0.254s][info][gc,heap,exit]  tenured generation   total 10240K, used 9303K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
[0.254s][info][gc,heap,exit]    the space 10240K,  90% used [0x00000000ff600000, 0x00000000fff15f28, 0x00000000fff16000, 0x0000000100000000)
[0.255s][info][gc,heap,exit]  Metaspace       used 9104K, committed 9344K, reserved 1064960K
[0.255s][info][gc,heap,exit]   class space    used 1077K, committed 1152K, reserved 1048576K
    * */
}
