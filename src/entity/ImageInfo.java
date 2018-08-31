package entity;/*
* 图片类，图片下有许多帧*/

import entity.Frame;

import java.util.ArrayList;
import java.util.List;

public class ImageInfo {
    private List<Frame> frames;

    public ImageInfo() {
        frames = new ArrayList<>();
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
