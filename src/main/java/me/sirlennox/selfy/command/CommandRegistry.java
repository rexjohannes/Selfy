package me.sirlennox.selfy.command;

import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.command.commands.*;
import me.sirlennox.selfy.command.commands.base64.Base64Command;
import me.sirlennox.selfy.command.commands.ping.PingCommand;
import me.sirlennox.selfy.registry.Registry;

public class CommandRegistry extends Registry<Command> {

    public CommandRegistry(Selfy selfy) {
        super(selfy);
        this.init();
    }

    public void init() {
        register(new EmbedCommand(this.getSelfy()));
        register(new HelpCommand(this.getSelfy()));
        register(new ASCIICommand(this.getSelfy()));
        register(new ToggleCommand(this.getSelfy()));
        register(new ModulesCommand(this.getSelfy()));
        register(new AdCommand(this.getSelfy()));
        register(new ResolveIPCommand(this.getSelfy()));
        register(new UptimeCommand(this.getSelfy()));
        register(new MemeCommand(this.getSelfy()));
        register(new AvatarCommand(this.getSelfy()));
        register(new HastebinCommand(this.getSelfy()));
        register(new MediaCommand(this.getSelfy()));
        register(new Base64Command(this.getSelfy()));
        register(new YouTubeCommentFaker(this.getSelfy()));
        //registerCommand(new FakeUserCommand());
        register(new ActivityCommand(this.getSelfy()));
        register(new RemoveActivityCommand(this.getSelfy()));
        register(new JokeCommand(this.getSelfy()));
        register(new CurlCommand(this.getSelfy()));
        register(new AnimalCommand(this.getSelfy()));
        register(new ClearCommand(this.getSelfy()));
        register(new URLScreenshotCommand(this.getSelfy()));
        register(new SetCommand(this.getSelfy()));
        register(new SettingsCommand(this.getSelfy()));
        register(new ConfigCommand(this.getSelfy()));
        register(new ProxiesCommand(this.getSelfy()));
        register(new HypeSquadCommand(this.getSelfy()));
        register(new PingCommand(this.getSelfy()));
    }

}
