# 软件包 java.lang.management

提供管理接口，用于监视和管理 Java 虚拟机以及 Java 虚拟机在其上运行的操作系统。

| 接口 | 描述 | 
|:-----:|:-------|
|ClassLoadingMXBean | 用于 Java 虚拟机的类加载系统的管理接口 |
|CompilationMXBean | 用于 Java 虚拟机的编译系统的管理接口 |
|GarbageCollectorMXBean | 用于 Java 虚拟机的垃圾回收的管理接口 |
|MemoryManagerMXBean | 内存管理器的管理接口 |
|MemoryMXBean | Java 虚拟机的内存系统的管理接口。
|MemoryPoolMXBean | 内存池的管理接口 |
|OperatingSystemMXBean | 用于操作系统的管理接口，Java 虚拟机在此操作系统上运行 |
|RuntimeMXBean | Java 虚拟机的运行时系统的管理接口 |
|ThreadMXBean | Java 虚拟机线程系统的管理接口 |

| 类 | 描述 | 
|:-----:|:-------|
|MemoryType | 内存类型（枚举类型） |
|LockInfo | 对象锁信息 |
|ManagementFactory| 用于获取 Java 平台的管理 Bean 每种静态方法都会返回一个或多个表示 Java 虚拟机组件的管理接口的平台 MXBean |
|ManagementPermission|使用 SecurityManager 运行的代码调用 Java 平台的管理接口中定义的方法时，SecurityManager 将要检查的权限。|
|MemoryNotificationInfo|关于内存通知的信息|
|MemoryUsageManagementFactory|表示内存使用量快照的 MemoryUsage |
|MonitorInfo|关于对象监视器锁的信息|
|ThreadInfo|线程信息|

## 参考地址
* [JDK源码-java.lang.management-第一部分-源码学习](https://blog.csdn.net/qxc1281/article/details/53857295)
* [Java API Doc](https://docs.oracle.com/javase/7/docs/api/java/lang/management/package-use.html)