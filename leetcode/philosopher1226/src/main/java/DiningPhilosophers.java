import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DiningPhilosophers {

    private Semaphore[] forks = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (true){
            boolean leftFork = false;
            boolean rightFork = false;
            try {
                leftFork = forks[philosopher].tryAcquire(5, TimeUnit.MILLISECONDS);
                if (leftFork) {
                    pickLeftFork.run();
                    rightFork = forks[(philosopher + 4) % 5].tryAcquire(5, TimeUnit.MILLISECONDS);
                    if (rightFork) {
                        pickRightFork.run();

                        eat.run();

                        putRightFork.run();
                        putLeftFork.run();

                        return;
                    } else {
                        putLeftFork.run();
                        leftFork = false;
                    }
                }
            } catch (Exception e) {
            }finally {
                if (rightFork) {
                    forks[(philosopher + 4) % 5].release();
                }

                if (leftFork) {
                    forks[philosopher].release();
                }
            }
        }
    }
}