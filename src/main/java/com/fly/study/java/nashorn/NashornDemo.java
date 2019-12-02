package com.fly.study.java.nashorn;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.junit.Test;

import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2019-12-02-12:35
 * @description 学习 Nashorn
 */
public class NashornDemo {

    @Test
    public void run11() throws IOException, ScriptException, NoSuchMethodException {
        NashornScriptEngineFactory nashornScriptEngineFactory = new NashornScriptEngineFactory();
        System.out.println(nashornScriptEngineFactory.getEngineName());
        NashornScriptEngine nashorn = (NashornScriptEngine) nashornScriptEngineFactory.getScriptEngine("nashorn");
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("target/classes/nashorn/demo2.js"));
        CompiledScript compile = nashorn.compile(bufferedReader);
        System.out.println(compile.eval());
    }


    @Test
    public void run22() throws Exception {
        NashornScriptEngineFactory nashornScriptEngineFactory = new NashornScriptEngineFactory();
        System.out.println(nashornScriptEngineFactory.getEngineName());
        NashornScriptEngine nashorn = (NashornScriptEngine) nashornScriptEngineFactory.getScriptEngine("nashorn");
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/main/resources/nashorn/demo2.js"));
        nashorn.eval(bufferedReader);
        Object o = nashorn.invokeFunction("run2", "测试");
        System.out.println(o);
    }

}
