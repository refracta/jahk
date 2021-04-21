package com.github.refracta.jahk.core;

import com.sun.jna.Native;
import com.sun.jna.WString;

public class AutoHotKey {
    private static String AHK_DLL_PATH = "ahk/AutoHotKey.dll";
    private static AutoHotKey instance = new AutoHotKey();

    private AutoHotKeyDLL autoHotKeyDLL;

    private AutoHotKey() {
        init();
    }

    public static AutoHotKey getInstance() {
        return instance;
    }

    private void init() {
        this.autoHotKeyDLL = Native.load(AHK_DLL_PATH, AutoHotKeyDLL.class);
    }

    public void eval(String ahk) {
        autoHotKeyDLL.ahktextdll(new WString(ahk), new WString(""), new WString(""));
    }

    public String callFunction(String functionName, String... args) {
        WString[] wargs = new WString[10];
        int argsLength = args.length;
        for (int i = 0; i < 10; i++) {
            if (i < argsLength) {
                wargs[i] = new WString(args[i]);
            } else {
                wargs[i] = new WString("");
            }
        }
        int i = 0;
        return autoHotKeyDLL.ahkFunction(new WString(functionName), wargs[i++], wargs[i++], wargs[i++], wargs[i++], wargs[i++], wargs[i++], wargs[i++], wargs[i++], wargs[i++], wargs[i++]).getWideString(0);
    }
}
