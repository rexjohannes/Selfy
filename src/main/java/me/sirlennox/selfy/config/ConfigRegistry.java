/*
 * Copyright (c) 2020 SirLennox & f1nniboy.
 *
 * This code is copyrighted to SirLennox and f1nniboy.
 *
 * Using this code without privileges is not allowed.
 *
 *
 *
 */

package me.sirlennox.selfy.config;

import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.module.Setting;
import me.sirlennox.selfy.registry.Registry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ConfigRegistry extends Registry<Setting> {

    public File file;
    public ConfigRegistry(File file, Selfy selfy) {
        super(selfy);
        this.file = file;
        this.init();
        try {
            this.read((JSONObject) JSONValue.parse(new FileReader(file)));
        } catch (Exception e) {
        }
    }

    public void init() {

    }
    public Setting getConfigByName(String name) {
        return this.getRegistered().stream().filter(c -> c.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }


    public JSONObject configsToJSONObject() {
        JSONObject obj = new JSONObject();
        JSONArray configsArray = new JSONArray();

            for(Setting setting : this.getRegistered()) {
                JSONObject stg = new JSONObject();
                stg.put("name", setting.name);
                stg.put("value", setting.value);
                configsArray.add(stg);
            }

        obj.put("configs", configsArray);

        return obj;
    }

    public void read(JSONObject obj) {
        JSONArray configsArray = (JSONArray) obj.get("configs");
        for(Object o : configsArray) {
            JSONObject stg = (JSONObject) o;
            for(Setting s : this.getRegistered()) {
                if(s.name.equalsIgnoreCase((String) stg.get("name"))) {
                    s.value = stg.get("value");
                }
            }
        }
    }

}
