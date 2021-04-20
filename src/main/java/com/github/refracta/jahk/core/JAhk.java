package com.github.refracta.jahk.core;

import com.sun.jna.Platform;

import java.io.*;

public class JAhk {
    private static boolean init = false;

    public static void init() {
        if (!init) {
            File ahk = new File("ahk");
            if (!ahk.exists()) {
                ahk.mkdir();
                String version = Platform.is64Bit() ? "x64w_MT" : "Win32w_MT";
                copyFromPath("ahk/" + version + "/AutoHotkey.exe", "ahk/AutoHotkey.exe");
                copyFromPath("ahk/" + version + "/AutoHotkey.dll", "ahk/AutoHotkey.dll");
                copyFromPath("ahk/" + version + "/AutoHotkeyMini.dll", "ahk/AutoHotkeyMini.dll");
                copyFromPath("ahk/" + version + "/AutoHotkeySC.bin", "ahk/AutoHotkeySC.bin");
            }
            init = true;
        }
    }

    private static void copyFromPath(String src, String dest) {
        try {
            copy(JAhk.class.getClassLoader().getResourceAsStream(src), new FileOutputStream(dest), new byte[8192]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long copy(InputStream input, OutputStream output, byte[] buffer) throws IOException {
        long count = 0L;
        int n;
        if (input != null) {
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
                count += (long) n;
            }
        }
        output.close();
        return count;
    }
}
