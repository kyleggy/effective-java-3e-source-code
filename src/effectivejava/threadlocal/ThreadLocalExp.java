package effectivejava.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExp {
    public static class MyRunnable implements Runnable
    {
        // Initially value as 0
        AtomicInteger val
                = new AtomicInteger(0);

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();
        private ThreadLocal<Integer> threadLocalINT = ThreadLocal.withInitial(() -> {
            return Integer.valueOf((int) (Math.random() * 80D));
        });

        private ThreadLocal threadLocalOverridInitialValue = new ThreadLocal<Integer>() {
            @Override protected Integer initialValue()
            {
                return val.getAndIncrement();
            }
        };

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 50D) );
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("threadLocal: " + threadLocal.get());
            System.out.println("threadLocalINT: " + threadLocalINT.get());
            System.out.println("threadLocalOverridInitialValue: " + threadLocalOverridInitialValue.get());

            System.out.println("After removing thread locals");
            threadLocal.remove();
            threadLocalINT.remove();
            threadLocalOverridInitialValue.remove();

            System.out.println("threadLocal: " + threadLocal.get());
            System.out.println("threadLocalINT: " + threadLocalINT.get());
            System.out.println("threadLocalOverridInitialValue: " + threadLocalOverridInitialValue.get());
        }
    }
    public static void main(String[] args)
    {
        MyRunnable runnableInstance = new MyRunnable();

        Thread t1 = new Thread(runnableInstance);
        Thread t2 = new Thread(runnableInstance);
        // this will call run() method
        t1.start();
        t2.start();
    }
}
