package effectivejava.threadlocal;

public class ThreadLocalSample {

    //https://www.javatpoint.com/java-threadlocal-class
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(123);
        Integer integer = (Integer)threadLocal.get();
        System.out.println(integer);

        threadLocal.set(456);
        Integer integer2 = (Integer)threadLocal.get();
        System.out.println(integer2);

        Integer integer3 = (Integer)threadLocal.get();
        System.out.println(integer3);

        ThreadLocal<Double> doubleThreadLocal = new ThreadLocal<>();
        doubleThreadLocal.set(Double.valueOf(12345));

        Double d = doubleThreadLocal.get();
        System.out.println(d);

        ThreadLocal<Integer> threadLocalINT = ThreadLocal.withInitial(() -> {
            return Integer.valueOf(123);
        });
        System.out.println(threadLocalINT.get());
    }
}
