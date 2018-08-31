/*
 * 生产者，读取ImageInfo中的每一帧图片
 * 放入阻塞队列中*/

import entity.Frame;
import entity.ImageInfo;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Frame> blockingQueue;
    private ImageInfo imageInfo;//消费者读取的图片

    public Producer(BlockingQueue<Frame> blockingQueue, ImageInfo imageInfo) {
        this.blockingQueue = blockingQueue;
        this.imageInfo = imageInfo;
    }

    @Override
    public void run() {
        for (Frame frame : imageInfo.getFrames()) {
            try {
                doDecoder(frame);
                blockingQueue.put(frame); //将图片每帧放入队列
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //模拟解码
    public void doDecoder(Frame frame){
        //假设完成解码工作,获得该帧的内容
        frame.getContent();
        System.out.println("完成这该帧解码工作");

    }
}
