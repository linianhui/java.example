# 并发底层核心实现

1. volatile关键字保证变量的多线程可见性。
2. CAS(Compare And Swap)使得修改volatile变量称为原子操作（依赖CPU原子指令实现），底层是通过Unsafe类的compareAndSwap实现的。
3. LookSupport类提供阻塞和恢复线程的支持，底层是通过Unsafe类的pack和unpack实现的。

# volatile 关键字

# cas(compare and swap)

# aqs(abstract queued synchronizer)

# synchronized 关键字


参考资料

1. 1
1. <https://github.com/RedSpider1/concurrent>
