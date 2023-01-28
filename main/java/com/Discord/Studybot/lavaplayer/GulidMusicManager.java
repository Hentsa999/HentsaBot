package com.Discord.Studybot.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class GulidMusicManager {

    public final AudioPlayer audioPlayer;
    public final Trackplayer trackplayer;
    private final AudioPlayerSendHandler sendHandler;

    public GulidMusicManager(AudioPlayerManager manager) {
        this.audioPlayer = manager.createPlayer();
        this.trackplayer = new Trackplayer(this.audioPlayer);
        this.audioPlayer.addListener(this.trackplayer);
        this.sendHandler = new AudioPlayerSendHandler(this.audioPlayer);


    }

    public AudioPlayerSendHandler getSendHandler() {
        return this.sendHandler;
    }

}
