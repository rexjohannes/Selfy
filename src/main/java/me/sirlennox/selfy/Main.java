package me.sirlennox.selfy;

import me.sirlennox.selfy.utils.stat.TokenUtils;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// Main class where the instance of selfy will be created
public class Main {
    // The instance of Selfy
    public static Selfy selfy;

    public static void main(String[] args) {

        System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.NoOpLog");
        ArrayList<String> tokens = new ArrayList<>();
        if(args.length == 1) {
            tokens.add(args[0]);
        }else {
            System.out.println("No token defined. Trying to find your token in your level.db's...");
            tokens = TokenUtils.findTokens();
        }
        if(tokens.size() == 0) throw new IllegalStateException("No tokens found!");
        initSelfy(tokens);
    }

    // Initialize Selfy
    public static void initSelfy(ArrayList<String> tokens) {
        for(String token : tokens) {
            try {
                selfy = new Selfy("Selfy", "2.2", ".", token, new ArrayList<>(Arrays.asList("SirLennox", "f1nniboy")), AccountType.PREMIUM);
                System.out.println(selfy.getStartupMessage());
                break;
            }catch (LoginException e) {
                selfy = null;
                System.err.println("Failed to login with token: " + token);
                try {
                    Thread.sleep(2500L);
                } catch (InterruptedException interruptedException) {
                }
            }
        }

    }

}
