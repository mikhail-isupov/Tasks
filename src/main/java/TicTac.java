public class TicTac {
    public static void main(String[] arguments) {
        Object synchronizator = new Object();
        Runnable left = new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    synchronized (synchronizator) {
                        System.out.print("L");
                        try {
                            synchronizator.notify();
                            Thread.sleep(1000);
                            synchronizator.wait();
                        } catch (InterruptedException e) {
                            return;
                        }                        ;
                    }
                }
            }
        };

        Runnable right = new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    synchronized (synchronizator) {
                        System.out.print("R");
                        try {
                            synchronizator.notify();
                            Thread.sleep(1000);
                            synchronizator.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            }
        };

        new Thread(left).start();
        new Thread(right).start();

    }

}
