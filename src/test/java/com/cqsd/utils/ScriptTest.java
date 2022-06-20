package com.cqsd.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScriptTest {

    @Test
    void run() {
        Script script = new Script();
        String scriptStr = "const add = (a, b) => a + b;";
        var result = script.run(scriptStr, "add",2,3);
        System.out.println(result);
        assertEquals(5, result);
    }
}