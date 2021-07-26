package me.sirlennox.selfy.command.commands.ping;

import me.sirlennox.selfy.Category;
import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.command.Command;
import me.sirlennox.selfy.utils.stat.MessageUtils;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingCommand extends Command {
    public PingCommand(Selfy selfy) {
        super(selfy, "ping", "Ping a server", Category.UTIL);
    }

    @Override
    public void onCommand(String[] args, MessageCreateEvent event) {
        if (args.length < 2) {
            sendUsage("<IP> <Port>", event);
            return;
        }
        try {
            int p = Integer.parseInt(args[1]);
            if (p > 65535 || p < 1) {
                MessageUtils.editMessage(event.getMessage(), "Ping", "Port must be higher than 0 and lower than 65536", Color.RED.getRGB());
                return;
            }

            MessageUtils.editMessage(event.getMessage(), "Ping", "Pinging...", Color.YELLOW.getRGB());

            new Thread(() -> {
                try {
                    Socket s = new Socket();
                    s.setSoTimeout(20000);
                    long begin = System.currentTimeMillis();
                    s.connect(new InetSocketAddress(args[0], p));
                    MessageUtils.editMessage(event.getMessage(), "Ping", "Connected to `" + args[0] + ":" + p + "` after " + (System.currentTimeMillis() - begin) + "ms", Color.GREEN.getRGB());
                    s.close();
                } catch (IOException e) {
                    MessageUtils.editMessage(event.getMessage(), "Ping", "An error occurred while trying to connect to the target host, is it online?", Color.RED.getRGB());
                }
            }).start();

        } catch (NumberFormatException e) {
            MessageUtils.editMessage(event.getMessage(), "Ping", "Port must be a number!", Color.RED.getRGB());
            return;
        }


    }

}
