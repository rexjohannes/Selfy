package me.sirlennox.selfy.command.commands;

import me.sirlennox.selfy.Category;
import me.sirlennox.selfy.Main;
import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.command.Command;
import me.sirlennox.selfy.utils.stat.MessageUtils;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class AdCommand extends Command {
    public AdCommand(Selfy selfy) {
        super(selfy, "ad", "Send an ad for this selfbot", Category.OTHER);
        this.aliases.add(selfy.name);
    }

    @Override
    public void onCommand(String[] args, MessageCreateEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append("I am running **" + selfy.name + " " + selfy.getVersion() + "**\n");
        sb.append("With this program you can add some really nice commands and modules to discord.\n");
        sb.append("Made by: **" + selfy.getDevelopers() + "**\n");
        sb.append("[Project Site](https://github.com/SirLennox/Selfy)");
        MessageUtils.editMessage(selfy.name + " " + selfy.getVersion(), sb.toString(), Color.DARK_GRAY.getRGB(), event.getMessage());
    }
}
