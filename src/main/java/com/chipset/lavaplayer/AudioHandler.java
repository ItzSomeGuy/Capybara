package com.chipset.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import dev.lavalink.youtube.YoutubeAudioSourceManager;
import dev.lavalink.youtube.clients.MusicWithThumbnail;
import dev.lavalink.youtube.clients.WebWithThumbnail;
import dev.lavalink.youtube.clients.skeleton.Client;

public class AudioHandler {
    private final AudioPlayerManager playerManager;

    public AudioHandler() {
        playerManager = new DefaultAudioPlayerManager();
        YoutubeAudioSourceManager youtube = new YoutubeAudioSourceManager(/*allowSearch:*/ true, new Client[] { new MusicWithThumbnail(), new WebWithThumbnail() });
        AudioSourceManagers.registerRemoteSources(playerManager);
    }
}
