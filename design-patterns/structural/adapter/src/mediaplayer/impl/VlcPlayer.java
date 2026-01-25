package mediaplayer.impl;

import mediaplayer.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void vlcPlay(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void mp4Play(String fileName) {
        // Do nothing
    }
}
