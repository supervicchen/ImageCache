/*
* 消费者，从阻塞队列中读取解码好的每一帧图片
* 当收集到30帧后，输出30帧的图片*/

import entity.Frame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<Frame> blockingQueue;
    List<Frame> frames  = new ArrayList<>();

    private int frameNum = 0;

    public Consumer(BlockingQueue<Frame> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        //队列中不为空，说明还有图片帧
        while (!blockingQueue.isEmpty()){
            try {
                Frame frame = blockingQueue.take();
                saveFrame(frame);
                frameNum++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



    private void saveFrame(Frame frame){
        frames.add(frame);
        if (frameNum%30 == 0){
            showFrame(frames);
            frames.clear();
        }
    }

    //连续展示30帧的内容
    private void showFrame(List<Frame> frames){
        System.out.println("displaying frames 30");
    }
}
