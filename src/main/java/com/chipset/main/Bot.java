package com.chipset.main;

import com.chipset.commands.poll.PollHandler;
import com.chipset.context.Avatar;
import com.chipset.context.Rename;
import com.chipset.listeners.*;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.command.SlashCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.reflections.Reflections;

import java.util.Set;


public class Bot {
    private static final String TOKEN = System.getenv("BOT_TOKEN");
    public static PollHandler pollHandler;

    public static void main(String[] arguments) throws Exception {
        System.out.println(TOKEN);
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(192370343510409216L);
        builder.forceGuildOnly(193117152709050368L);

        Set<Class<? extends SlashCommand>> commands = findCommands("com.chipset.commands");
        for (Class<? extends SlashCommand> command : commands) {
            if (command.getName().contains("Sub"))
                continue;
            SlashCommand temp = command.getConstructor().newInstance();
            builder.addSlashCommand(temp);
        }

        pollHandler = new PollHandler();

        builder.addContextMenus(
                new Avatar(),
                new Rename()
        );

        // Build the CommandClient instance
        CommandClient commandClient = builder.build();

        // Add it as an event listener to JDA
        JDA jda = JDABuilder.createDefault(TOKEN)
                .enableIntents(
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_WEBHOOKS)
                .addEventListeners(
                        commandClient,
                        new ReadyListener(),
                        new ModalListener(),
                        new MenuListener(),
                        new PeopleListener(),
                        new PollListener(),
                        new ReactionListener()
                ).build();
    }

    public static Set<Class<? extends SlashCommand>> findCommands(String packageName) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(SlashCommand.class);
    }
}