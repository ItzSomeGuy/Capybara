package com.chipset.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

import java.util.concurrent.TimeUnit;

public class Ping extends SlashCommand {

    public Ping() {
        this.name = "ping"; // This has to be lowercase
        this.help = "Performs a ping to see the bot's delay";
    }

    @Override
    public void execute(SlashCommandEvent event) {
        // Sends a "<bot> is thinking..." response and allows you a delayed response.
        event.deferReply().queue(
                hook -> hook.editOriginal("pong!").queueAfter(5, TimeUnit.SECONDS)
        );
    }
}
