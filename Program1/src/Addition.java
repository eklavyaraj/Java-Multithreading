public class Addition {

    long start;
    long end;
    static long limit = Integer.MAX_VALUE;
    long count = 0;

    public Addition(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public void fnc() {
        for(long i = start; i <= end; i++) {
            count += i;
        }
    }

    public static void singleThread() {

        long startTime = System.currentTimeMillis();
        Addition ob1 = new Addition(1, limit);
        ob1.fnc();
        long endTime = System.currentTimeMillis();
        System.out.println("Single Thread : " + " Total Cnt = " + ob1.count + ", Time Taken = " + (endTime - startTime));

    }

    public static void twoThread() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Addition ob1 = new Addition(1, limit/2);
        Addition ob2 = new Addition(limit/2 + 1, limit);
        Thread t1 = new Thread(() -> {
            ob1.fnc();
        });

        Thread t2 = new Thread(() -> {
            ob2.fnc();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Two Threads : " + " Total Cnt = " + (ob1.count + ob2.count) + ", Time Taken = " + (endTime - startTime));
    }

    public static void runTest() throws InterruptedException {
        singleThread();
        twoThread();
    }
}
