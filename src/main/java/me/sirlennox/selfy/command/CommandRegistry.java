package me.sirlennox.selfy.command;

import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.command.commands.*;
import me.sirlennox.selfy.command.commands.base64.Base64Command;
import me.sirlennox.selfy.registry.Registry;

public class CommandRegistry extends Registry<Command> {

    public CommandRegistry(Selfy selfy) {
        super(selfy);
        this.init();
    }

    public void init() {
        register(new EmbedCommand());
        register(new HelpCommand());
        register(new ASCIICommand());
        register(new ToggleCommand());
        register(new ModulesCommand());
        register(new AdCommand());
        register(new ResolveIPCommand());
        register(new UptimeCommand());
        register(new MemeCommand());
        register(new AvatarCommand());
        register(new HastebinCommand());
        register(new MediaCommand());
        register(new Base64Command());
        register(new YouTubeCommentFaker());
        //registerCommand(new FakeUserCommand());
        register(new ActivityCommand());
        register(new RemoveActivityCommand());
        register(new JokeCommand());
        register(new CurlCommand());
        register(new AnimalCommand());
        register(new ClearCommand());
        register(new URLScreenshotCommand());
        register(new SetCommand());
        register(new SettingsCommand());
        register(new ConfigCommand());
        register(new ProxiesCommand());
    }

}
