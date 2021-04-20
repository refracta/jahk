package com.github.refracta.jahk.core;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.WString;

public interface AutoHotKeyDLL extends Library {
    void ahkExec(WString s);

    void ahkdll(WString s, WString o, WString p);

    void addFile(WString s, int a);

    void ahktextdll(WString s, WString o, WString p);

    Pointer ahkFunction(WString f, WString p1, WString p2, WString p3, WString p4, WString p5, WString p6, WString p7, WString p8, WString p9, WString p10);
}
