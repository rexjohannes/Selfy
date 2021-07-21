package me.sirlennox.selfy.registry;

import com.sun.istack.internal.NotNull;
import me.sirlennox.selfy.Selfy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Registry<T> {

    private final Selfy selfy;
    
    @NotNull
    private final List<T> registered;

    public Registry(Selfy selfy) {
        this.registered = Collections.synchronizedList(new LinkedList<>());
        this.selfy = selfy;
    }

    public abstract void init();

    public void register(T o) {
        this.registered.add(o);
    }

    public void unregister(T o) {
        this.registered.remove(o);
    }

    @NotNull
    public List<T> getRegistered() {
        return this.registered;
    }

    public Selfy getSelfy() {
        return selfy;
    }
}
