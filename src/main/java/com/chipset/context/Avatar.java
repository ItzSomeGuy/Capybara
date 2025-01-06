package com.chipset.context;

import com.jagrosh.jdautilities.command.UserContextMenu;
import com.jagrosh.jdautilities.command.UserContextMenuEvent;

public class Avatar extends UserContextMenu {
    public Avatar() {
        this.name = "Avatar";
    }
    @Override
    protected void execute(UserContextMenuEvent event) {
        String url = event.getTargetMember().getEffectiveAvatarUrl();

        event.reply(url).setEphemeral(true).queue();
    }
}
