package com.chipset.context;

import com.jagrosh.jdautilities.command.UserContextMenu;
import com.jagrosh.jdautilities.command.UserContextMenuEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class Rename extends UserContextMenu {
    public Rename() {
        this.name = "Rename";
    }
    @Override
    protected void execute(UserContextMenuEvent event) {
        Long target = event.getTargetMember().getIdLong();
        TextInput newName = TextInput.create("newName", "new name", TextInputStyle.SHORT).build();

        Modal modal = Modal.create("modRename-"+target, "Rename")
                        .addComponents(ActionRow.of(newName))
                                .build();

        event.replyModal(modal).queue();
    }
}
