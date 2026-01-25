package adapters;

import mediaplayer.AdvancedMediaPlayer;
import mediaplayer.MediaPlayer;
import mediaplayer.impl.Mp4Player;
import mediaplayer.impl.VlcPlayer;

public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String mediaType) {
        if (mediaType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (mediaType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.vlcPlay(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.mp4Play(fileName);
        }
    }
}
