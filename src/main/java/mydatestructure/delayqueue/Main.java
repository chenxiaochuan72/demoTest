package mydatestructure.delayqueue;

/**
 * @Author cxc
 * @Date 2023/8/31 4:45 PM
 * @Version 1.0
 * @Description:
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Job> queue = new DelayQueue<>();
        queue.add(new Job("1 号", 1000L));
        queue.add(new Job("3 号", 3000L));
        queue.add(new Job("5 号", 5000L));
        queue.add(new Job("11 号", 11000L));
        queue.add(new Job("4 号", 4000L));
        queue.add(new Job("6 号", 6000L));
        queue.add(new Job("7 号", 7000L));
        queue.add(new Job("12 号", 12000L));
        queue.add(new Job("15 号", 15000L));
        queue.add(new Job("10 号", 10000L));
        queue.add(new Job("9 号", 9000L));
        queue.add(new Job("8 号", 8000L));
        while (true) {
            Job poll = queue.poll();
            if (null == poll) {
                Thread.sleep(10);
                continue;
            }
            System.out.println(poll.getName());
        }
    }
}
