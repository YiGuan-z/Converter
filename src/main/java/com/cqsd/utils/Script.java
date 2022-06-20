package com.cqsd.utils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Script {
    ScriptEngine engine;

    public Script() {
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
    }

    Object run(String script,String function,Object... args) {
        try {
            engine.eval(script);
            Invocable inv2 = (Invocable) engine;
            return inv2.invokeFunction(function, args);
        } catch (ScriptException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
