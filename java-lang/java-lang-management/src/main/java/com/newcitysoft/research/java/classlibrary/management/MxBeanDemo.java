package com.newcitysoft.research.java.classlibrary.management;

import org.junit.Test;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.List;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/29 13:00
 */
public class MxBeanDemo {
    @Test
    public void test() {
        main();
    }

    public static void main() {
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
        String name = mxBean.getName();
        System.out.println("jvm pid:" + Integer.parseInt(name.substring(0, name.indexOf("@"))));
        System.out.println("------------");
        showJvmInfo();
        System.out.println("------------");
        showMemoryInfo();
        System.out.println("------------");
        showSystem();
        System.out.println("------------");
        showClassLoading();
        System.out.println("------------");
        showCompilation();
        System.out.println("------------");
        showThread();
        System.out.println("------------");
        showGarbageCollector();
        System.out.println("------------");
        showMemoryManager();
        System.out.println("------------");
        showMemoryPool();
        System.out.println("------------");
        RuntimeMXBean mxBean2 = ManagementFactory.getRuntimeMXBean();
        String name2 = mxBean2.getName();
        System.out.println("jvm pid:" + Integer.parseInt(name2.substring(0, name2.indexOf("@"))));

    }

    /**
     * Java 虚拟机的运行时系统
     */
    public static void showJvmInfo() {
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
        String vendor = mxBean.getVmVendor();
//        String name = mxBean.getName();
//        System.out.println("jvm pid:" + Integer.parseInt(name.substring(0, name.indexOf("@"))));
        System.out.println("jvm name:" + mxBean.getVmName());
        System.out.println("jvm version:" + mxBean.getVmVersion());
        System.out.println("jvm bootClassPath:" + mxBean.getBootClassPath());
        System.out.println("jvm start time:" + mxBean.getStartTime());
    }

    /**
     * Java 虚拟机的内存系统
     */
    public static void showMemoryInfo() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = mem.getHeapMemoryUsage();
        System.out.println("Heap committed:" + heap.getCommitted() + " init:" + heap.getInit() + " max:"
                + heap.getMax() + " used:" + heap.getUsed());
    }

    /**
     * Java 虚拟机在其上运行的操作系统
     */
    public static void showSystem() {
        OperatingSystemMXBean op = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Architecture: " + op.getArch());
        System.out.println("Processors: " + op.getAvailableProcessors());
        System.out.println("System name: " + op.getName());
        System.out.println("System version: " + op.getVersion());
        System.out.println("Last minute load: " + op.getSystemLoadAverage());
    }

    /**
     * Java 虚拟机的类加载系统
     */
    public static void showClassLoading(){
        ClassLoadingMXBean cl = ManagementFactory.getClassLoadingMXBean();
        System.out.println("TotalLoadedClassCount: " + cl.getTotalLoadedClassCount());
        System.out.println("LoadedClassCount" + cl.getLoadedClassCount());
        System.out.println("UnloadedClassCount:" + cl.getUnloadedClassCount());
    }

    /**
     * Java 虚拟机的编译系统
     */
    public static void showCompilation(){
        CompilationMXBean com = ManagementFactory.getCompilationMXBean();
        System.out.println("TotalCompilationTime:" + com.getTotalCompilationTime());
        System.out.println("name:" + com.getName());
    }

    /**
     * Java 虚拟机的线程系统
     */
    public static void showThread(){
        ThreadMXBean thread = ManagementFactory.getThreadMXBean();
        System.out.println("ThreadCount" + thread.getThreadCount());
        System.out.println("AllThreadIds:" + thread.getAllThreadIds());
        System.out.println("CurrentThreadUserTime" + thread.getCurrentThreadUserTime());
        //......还有其他很多信息
    }

    /**
     * Java 虚拟机中的垃圾回收器。
     */
    public static void showGarbageCollector(){
        List<GarbageCollectorMXBean> gc = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean GarbageCollectorMXBean : gc){
            System.out.println("name:" + GarbageCollectorMXBean.getName());
            System.out.println("CollectionCount:" + GarbageCollectorMXBean.getCollectionCount());
            System.out.println("CollectionTime" + GarbageCollectorMXBean.getCollectionTime());
        }
    }

    /**
     * Java 虚拟机中的内存管理器
     */
    public static void showMemoryManager(){
        List<MemoryManagerMXBean> mm = ManagementFactory.getMemoryManagerMXBeans();
        for(MemoryManagerMXBean eachmm: mm){
            System.out.println("name:" + eachmm.getName());
            System.out.println("MemoryPoolNames:" + eachmm.getMemoryPoolNames().toString());
        }
    }

    /**
     * Java 虚拟机中的内存池
     */
    public static void showMemoryPool(){
        List<MemoryPoolMXBean> mps = ManagementFactory.getMemoryPoolMXBeans();
        for(MemoryPoolMXBean mp : mps){
            System.out.println("name:" + mp.getName());
            System.out.println("CollectionUsage:" + mp.getCollectionUsage());
            System.out.println("type:" + mp.getType());
        }
    }

    /**
     * 访问 MXBean 的方法的三种方法
     */
    public static void visitMxBean(){

        //第一种直接调用同一 Java 虚拟机内的 MXBean 中的方法。
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
        String vendor1 = mxBean.getVmVendor();
        System.out.println("vendor1:" + vendor1);

        //第二种通过一个连接到正在运行的虚拟机的平台 MBeanServer 的 MBeanServerConnection。
        MBeanServerConnection mbs = null;
        // Connect to a running JVM (or itself) and get MBeanServerConnection
        // that has the JVM MXBeans registered in it


        try {
            // Assuming the RuntimeMXBean has been registered in mbs
            ObjectName objectName = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
            String vendor2 = (String) mbs.getAttribute(objectName, "VmVendor");
            System.out.println("vendor2:" + vendor2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //第三种使用 MXBean 代理
        MBeanServerConnection mbs3 = null;
        RuntimeMXBean proxy;
        try {
            proxy = ManagementFactory.newPlatformMXBeanProxy(mbs3,ManagementFactory.RUNTIME_MXBEAN_NAME,
                                                     RuntimeMXBean.class);
            String vendor = proxy.getVmVendor();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
