package mediaplayer.impl;

import mediaplayer.AdvancedMediaPlayer;

public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void vlcPlay(String fileName) {
        // Do nothing
    }

    @Override
    public void mp4Play(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
