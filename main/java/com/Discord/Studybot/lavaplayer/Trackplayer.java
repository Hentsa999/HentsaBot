package com.Discord.Studybot.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Trackplayer extends AudioEventAdapter {

    public final AudioPlayer audioPlayer;
    public final BlockingQueue<AudioTrack> queue;

    public Trackplayer(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
        this.queue = new LinkedBlockingQueue<>();
    }
        public void nextTrack(){
        this.audioPlayer.startTrack(this.queue.poll(), false);
        }
    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        if(endReason.mayStartNext){
           nextTrack();
        }
    }

    public void queue(AudioTrack track){
        if (!this.audioPlayer.startTrack(track, true)){
            this.queue.offer(track);
        }

        }
}
