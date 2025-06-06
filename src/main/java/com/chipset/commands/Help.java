package com.chipset.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.Command;

import java.util.Objects;

public class Help extends SlashCommand {
    public Help() {
        this.name = "help";
        this.help = "Shows all commands";
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        StringBuilder msg = new StringBuilder();
        Objects.requireNonNull(event.getGuild()).retrieveCommands().queue(commands -> {
            for (Command command : commands) {
                msg.append(command.getName()).append(" - ").append(command.getDescription()).append("\n");
            }

            event.reply(msg.toString()).setEphemeral(true).queue();
        });
    }
}
