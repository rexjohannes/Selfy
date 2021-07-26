package me.sirlennox.selfy.command.commands;

import me.sirlennox.selfy.Category;
import me.sirlennox.selfy.Main;
import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.command.Command;
import me.sirlennox.selfy.utils.stat.HttpUtils;
import me.sirlennox.selfy.utils.stat.MathUtils;
import me.sirlennox.selfy.utils.stat.MessageUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;
import java.io.IOException;

public class HypeSquadCommand extends Command {
    public HypeSquadCommand(Selfy selfy) {
        super(selfy, "hypesquad", "Sets your HypeSquad House", Category.FUN);
    }

    private static final String API_URL = "https://discord.com/api/v9/hypesquad/online";

    @Override
    public void onCommand(String[] args, MessageCreateEvent event) {
        if(args.length < 1) {
            StringBuilder sb = new StringBuilder();
            for(HypeSquadHouse h : HypeSquadHouse.values()) sb.append("- ").append(h.getName()).append("\n");
            MessageUtils.editMessage(event.getMessage(), "HypeSquads", sb.toString(), MathUtils.getRandomColor().getRed());
            return;
        }
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(API_URL);
        post.setHeader("Authorization", selfy.token);
        int h;
        HypeSquadHouse h2;
        try {
            h = (h2 = HypeSquadHouse.valueOf(args[0].toUpperCase())).getHouseId();
        } catch (IllegalArgumentException iae) {
            MessageUtils.editMessage(event.getMessage(), "HypeSquad", "The HypeSquad could not be found!", Color.RED.getRGB());
            return;
        }
        post.setEntity(new StringEntity("{\"house_id\":" + h + "}", ContentType.APPLICATION_JSON));
        try {
            client.execute(post);
            MessageUtils.editMessage(event.getMessage(), "HypeSquad", "Your HypeSquad House was successfully changed to `" + h2.getName() + "`", Color.GREEN.getRGB());
        } catch (IOException e) {
            e.printStackTrace();
            MessageUtils.editMessage(event.getMessage(), "HypeSquad", "An unexpected error occurred while trying to set your HypeSquad House!", Color.RED.getRGB());
        }
    }
    
    public enum HypeSquadHouse {
        BRAVERY("Bravery", 1), BRILLIANCE("Brilliance", 2), BALANCE("Balance", 3);
        private final int houseId;
        private final String name;
        HypeSquadHouse(String name, int houseId) {
            this.houseId = houseId;
            this.name = name;
        }
        public int getHouseId() {
            return this.houseId;
        }
        public String getName() {
            return this.name;
        }
    }
}
