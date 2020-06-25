package com.liusx.multithreading.threadpool;

import java.util.List;
import java.util.concurrent.*;

/**
 * description: ThreadPoolApiTest 线程池的使用<br>
 * date: 2020/6/25 14:05 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class ThreadPoolApiTest {

    public void testCommon(ThreadPoolExecutor threadPoolExecutor)throws Exception{
        for (int i = 0; i < 15; i++) {
            int n = i;
            //submit除了提交任务之外，还可以执行任务。所以这里使用
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("开始执行：" + n);
                        Thread.sleep(3000L);
                        System.out.println("执行结束：" + n);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("任务提交成功：" + i);
        }
        //查看线程数量，查看队列等到数量
        Thread.sleep(500L);
        System.out.println("当前线程池线程数量为："+threadPoolExecutor.getPoolSize());
        System.out.println("当前线程池任务队列等待任务数量为："+ threadPoolExecutor.getQueue().size());

        Thread.sleep(15000L);
        System.out.println("当前线程池线程数量为："+threadPoolExecutor.getPoolSize());
        System.out.println("当前线程池任务队列等待任务数量为："+ threadPoolExecutor.getQueue().size());
    }

    //线程池测试1，核心线程数量5，最大线程数量10，任务队列为无界队列，核心线程数量外开辟线程存活时间：5秒，未指定拒绝策略
    public void threadPoolExecutorTest1() throws Exception{
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        testCommon(threadPoolExecutor);

    }

    /**
     * 线程池测试2： 线程池信息： 核心线程数量5，最大线程数量10，任务队列大小3，超出核心线程数量的线程存活时间：5秒， 指定了自定义的拒绝策略
     *
     * 通过这个测试，我们可以知道：execute的执行策略
     * @throws Exception
     */
    private void threadPoolExecutorTest2() throws Exception {
        // 创建一个 核心线程数量为5，最大数量为10,等待队列最大是3 的线程池，也就是最大容纳13个任务。
        // 默认的策略是抛出RejectedExecutionException异常，java.util.concurrent.ThreadPoolExecutor.AbortPolicy
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.err.println("有任务被拒绝执行了");
            }
        });
        testCommon(threadPoolExecutor);
        // 预计结果：
        // 1、 5个任务直接分配线程开始执行
        // 2、 3个任务进入等待队列
        // 3、 队列不够用，临时加开5个线程来执行任务(5秒没活干就销毁)
        // 4、 队列和线程池都满了，剩下2个任务，没资源了，被拒绝执行。
        // 5、 任务执行，5秒后，如果无任务可执行，销毁临时创建的5个线程
    }

    /** 通过Executors提供的API：newFixedThreadPool(int nThreads)，创建一个线程池。这个入参指的是核心线程和最大线程数量，他们是一样的
     * 线程池测试3、 线程池信息： 核心线程数量5，最大数量5，无界队列，超出核心线程数量的线程存活时间：5秒，没有指定拒绝策略
     *
     * @throws Exception
     */
    private void threadPoolExecutorTest3() throws Exception {
        // 和Executors.newFixedThreadPool(int nThreads)一样的
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        testCommon(threadPoolExecutor);
        // 预计结：线程池线程数量为：5，超出数量的任务，其他的进入队列中等待被执行
    }

    /**  缓存线程池的使用 可以通过Executors.newCachedThreadPool()直接创建，这样创建出来的线程最大数量是int的最大值。
     *   缓存线程池适用于，任务的数量大小不好控制的时候，有时多有时少，这样的情况可以使用缓存线程池，但是建议不要通过Executors提供的api来创建
     *   而是自己手动通过ThreadPoolExecutor来创建，将线程池的最大值指定一下，因为int的最大值不安全，一旦真的达到最大值了，那么系统就会崩溃了
     * 4、 线程池信息：
     * 核心线程数量0，最大数量Integer.MAX_VALUE，任务队列是SynchronousQueue队列，超出核心线程数量的线程存活时间：60秒，拒绝策略没有
     *
     * 这种线程池，适用于快速的去执行任务
     *
     * @throws Exception
     */
    private void threadPoolExecutorTest4() throws Exception {

        // SynchronousQueue，实际上它不是一个真正的队列，因为它不会为队列中元素维护存储空间。与其他队列不同的是，它维护一组线程，这些线程在等待着把元素加入或移出队列。
        // 在使用SynchronousQueue作为工作队列的前提下，客户端代码向线程池提交任务时，
        // 而线程池中又没有空闲的线程能够从SynchronousQueue队列实例中取一个任务，
        // 那么相应的offer方法调用就会失败（即任务没有被存入工作队列）。
        // 此时，ThreadPoolExecutor会新建一个新的工作者线程用于对这个入队列失败的任务进行处理（假设此时线程池的大小还未达到其最大线程池大小maximumPoolSize）。

        // 和Executors.newCachedThreadPool()一样的
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        testCommon(threadPoolExecutor);
        // 预计结果：
        // 1、 线程池线程数量为：15，超出数量的任务，其他的进入队列中等待被执行
        // 2、 所有任务执行结束，60秒后，如果无任务可执行，所有线程全部被销毁，池的大小恢复为0
        Thread.sleep(60000L);
        System.out.println("60秒后，再看线程池中的数量：" + threadPoolExecutor.getPoolSize());
    }

    /**
     * 5、 定时执行线程池信息：一次性任务，到点就执行 。示例中是3秒后执行，这个执行时间是在schedule这个方法的入参中指定的，时间的单位也可以指定。<br/>
     * 核心线程数量5，最大数量Integer.MAX_VALUE，DelayedWorkQueue延时队列，超出核心线程数量的线程存活时间：0秒
     * 需要注意的是我们在创建这个定时任务线程池的时候，指定了核心线程为5.那意思就是下面的定时任务中的任务会有五个线程去执行他。这个可以根据具体情况来设定
     * @throws Exception
     */
    private void threadPoolExecutorTest5() throws Exception {
        // 和Executors.newScheduledThreadPool()一样的
        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        threadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务被执行，现在时间：" + System.currentTimeMillis());
            }
        }, 3000, TimeUnit.MILLISECONDS);
        System.out.println(
                "定时任务，提交成功，时间是：" + System.currentTimeMillis() + ", 当前线程池中线程数量：" + threadPoolExecutor.getPoolSize());
        // 预计结果：任务在3秒后被执行一次
    }

    /**
     * 6、 定时执行线程池信息：线程固定数量5 ，这个是周期性的定时任务，不是一次性<br/>
     * 核心线程数量5，最大数量Integer.MAX_VALUE，DelayedWorkQueue延时队列，超出核心线程数量的线程存活时间：0秒
     *
     * @throws Exception
     */
    private void threadPoolExecutorTest6() throws Exception {
        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        // 周期性执行某一个任务，线程池提供了两种调度方式，这里单独演示一下。测试场景一样。
        // 测试场景：提交的任务需要3秒才能执行完毕。看两种不同调度方式的区别
        // 效果1： scheduleAtFixedRate()提交后，2秒后开始第一次执行，之后每间隔1秒，固定执行一次(如果发现上次执行还未完毕，则等待完毕，完毕后立刻执行)。
        // 也就是说这个代码中是，3秒钟执行一次（计算方式：每次执行三秒，间隔时间1秒，执行结束后马上开始下一次执行，无需等待）
        threadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务-1 被执行，现在时间：" + System.currentTimeMillis());
            }
        }, 2000, 1000, TimeUnit.MILLISECONDS);

        // 效果2：scheduleWithFixedDelay()提交后，2秒后开始第一次执行，之后每间隔1秒，固定执行一次(如果发现上次执行还未完毕，则等待完毕，等上一次执行完毕后再开始计时，等待1秒)。
        // 也就是说这个代码钟的效果看到的是：4秒执行一次。 （计算方式：每次执行3秒，间隔时间1秒，执行完以后再等待1秒，所以是 3+1）
        threadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务-2 被执行，现在时间：" + System.currentTimeMillis());
            }
        }, 2000, 1000, TimeUnit.MILLISECONDS);
    }

    /**
     * 7、 终止线程：shutdown方法的使用。线程池信息： 核心线程数量5，最大数量10，队列大小3，超出核心线程数量的线程存活时间：5秒， 指定拒绝策略的
     *
     * @throws Exception
     */
    private void threadPoolExecutorTest7() throws Exception {
        // 创建一个 核心线程数量为5，最大数量为10,等待队列最大是3 的线程池，也就是最大容纳13个任务。
        // 默认的策略是抛出RejectedExecutionException异常，java.util.concurrent.ThreadPoolExecutor.AbortPolicy
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.err.println("有任务被拒绝执行了");
            }
        });
        // 测试： 提交15个执行时间需要3秒的任务，看超过大小的2个，对应的处理情况
        for (int i = 0; i < 15; i++) {
            int n = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("开始执行：" + n);
                        Thread.sleep(3000L);
                        System.err.println("执行结束:" + n);
                    } catch (InterruptedException e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                }
            });
            System.out.println("任务提交成功 :" + i);
        }
        // 1秒后终止线程池
        Thread.sleep(1000L);
        threadPoolExecutor.shutdown();
        // 再次提交提示失败
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("追加一个任务");
            }
        });
        // 结果分析
        // 1、 10个任务被执行，3个任务进入队列等待，2个任务被拒绝执行
        // 2、调用shutdown后，不接收新的任务，等待13任务执行结束
        // 3、 追加的任务在线程池关闭后，无法再提交，会被拒绝执行
    }

    /**
     * 8、 立刻终止线程：shutdownNow方法的使用，立刻停止，停止后会返回未执行线程信息。
     *     线程池信息： 核心线程数量5，最大数量10，队列大小3，超出核心线程数量的线程存活时间：5秒， 指定拒绝策略的
     *
     * @throws Exception
     */
    private void threadPoolExecutorTest8() throws Exception {
        // 创建一个 核心线程数量为5，最大数量为10,等待队列最大是3 的线程池，也就是最大容纳13个任务。
        // 默认的策略是抛出RejectedExecutionException异常，java.util.concurrent.ThreadPoolExecutor.AbortPolicy
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.err.println("有任务被拒绝执行了");
            }
        });
        // 测试： 提交15个执行时间需要3秒的任务，看超过大小的2个，对应的处理情况
        for (int i = 0; i < 15; i++) {
            int n = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("开始执行：" + n);
                        Thread.sleep(3000L);
                        System.err.println("执行结束:" + n);
                    } catch (InterruptedException e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                }
            });
            System.out.println("任务提交成功 :" + i);
        }
        // 1秒后终止线程池
        Thread.sleep(1000L);
        List<Runnable> shutdownNow = threadPoolExecutor.shutdownNow();
        // 再次提交提示失败
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("追加一个任务");
            }
        });
        System.out.println("未结束的任务有：" + shutdownNow.size());

        // 结果分析
        // 1、 10个任务被执行，3个任务进入队列等待，2个任务被拒绝执行
        // 2、调用shutdownnow后，队列中的3个线程不再执行，10个线程被终止
        // 3、 追加的任务在线程池关闭后，无法再提交，会被拒绝执行
    }


    public static void main(String[] args) throws Exception{
//        new ThreadPoolApiTest().threadPoolExecutorTest1();
//        new ThreadPoolApiTest().threadPoolExecutorTest2();
//        new ThreadPoolApiTest().threadPoolExecutorTest3();
//        new ThreadPoolApiTest().threadPoolExecutorTest4();
        new ThreadPoolApiTest().threadPoolExecutorTest5();
//        new ThreadPoolApiTest().threadPoolExecutorTest6();
        new ThreadPoolApiTest().threadPoolExecutorTest7();
        new ThreadPoolApiTest().threadPoolExecutorTest8();
    }
}
