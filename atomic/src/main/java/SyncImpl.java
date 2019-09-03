/**
 * @author Kent
 * @date 2019-09-03.
 */
public class SyncImpl {

    private int balance = 0;

    public static void main(String[] args) throws InterruptedException {
        SyncImpl syncIMPL = new SyncImpl();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                syncIMPL.transfer();
            }).start();
        }
        Thread.sleep(1000 * 8);
        System.out.println(syncIMPL.balance);
    }

    private void transfer() {
        balance++;
    }
}
