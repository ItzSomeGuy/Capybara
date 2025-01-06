package com.chipset.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

public class YT extends SlashCommand {
    public YT() {
        this.name = "yt"; // must be lowercase
        this.help = "plays a YT video (maybe?)";
        this.ownerCommand = true;
    }

    @Override
    public void execute(SlashCommandEvent event) {

    }
}
