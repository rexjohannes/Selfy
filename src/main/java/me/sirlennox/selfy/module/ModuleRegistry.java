package me.sirlennox.selfy.module;

import me.sirlennox.selfy.Selfy;
import me.sirlennox.selfy.module.modules.*;
import me.sirlennox.selfy.registry.Registry;

import java.util.ArrayList;

public class ModuleRegistry extends Registry<Module> {

    public ModuleRegistry(Selfy selfy) {
        super(selfy);
        this.init();
    }


    public void init() {
        register(new Bot4Everyone());
        this.startAutostart();
    }

    public void startAutostart() {
        this.getRegistered().forEach(m -> {
            if(m.autoStart) {
                m.toggle(null);
            }
        });
    }

}
