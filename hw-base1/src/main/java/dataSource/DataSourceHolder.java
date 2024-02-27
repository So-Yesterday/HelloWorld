package dataSource;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DataSourceHolder {

    private static final ThreadLocal<Queue<String>> LOCAL = ThreadLocal.withInitial(ConcurrentLinkedDeque::new);


    public static String get() {
        Queue<String> queue = LOCAL.get();
        return queue.peek();
    }

    public static void set(String key) {
        Queue<String> queue = LOCAL.get();
        queue.add(key);
    }

    public static void clear() {
        LOCAL.get().remove();
    }
}
