import entity.ImageInfo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        ImageInfo imageInfo = new ImageInfo();
        BlockingQueue blockingQueue = new ArrayBlockingQueue(30);
        Producer producer = new Producer(blockingQueue,imageInfo);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
