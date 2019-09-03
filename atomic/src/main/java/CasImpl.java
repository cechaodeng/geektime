import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kent
 * @date 2019-09-03.
 */
public class CasImpl {
    private AtomicInteger balance = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CasImpl cas = new CasImpl();
//        cas.transfer();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> cas.transfer()).start();
        }
//        Thread thread = new Thread(() -> cas.transfer());

        Thread.sleep(1000 * 7);
//        Thread.currentThread().join();
        System.out.println(cas.balance);

    }

    private void transfer() {
        AtomicInteger old = balance;
        while (!balance.compareAndSet(old.get(), old.get() + 1)) {
            old = balance;
        }
    }
}
