package me.sirlennox.selfy.module.modules;

import me.sirlennox.selfy.Category;
import me.sirlennox.selfy.Main;
import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.module.Module;
import me.sirlennox.selfy.module.Setting;
import org.javacord.api.event.message.MessageCreateEvent;

public class Bot4Everyone extends Module {
    public Bot4Everyone(Selfy selfy) {
        super(selfy,"bot4everyone", "A bot for everyone", Category.FUN);
    }


    @Override
    public void initSettings() {
        super.initSettings();
    }

    @Override
    public void onChatMessage(MessageCreateEvent event) {
        if(event.getMessage().getAuthor().getId() != event.getApi().getYourself().getId()) {
            selfy.onMessageSent(event);
        }
        super.onChatMessage(event);
    }
}
