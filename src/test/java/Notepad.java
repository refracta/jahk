import com.github.refracta.jahk.core.AutoHotKey;
import com.github.refracta.jahk.core.JAHK;

import java.awt.*;

public class Notepad {
    public static Rectangle getNotepadRectangle() {
        StringBuffer sb = new StringBuffer();
        sb.append("#persistent\n");
        sb.append("value(){\n");
        sb.append("WinGetPos, X, Y, W, H, ahk_class Notepad\n");
        sb.append("S:=X . \"/\" . Y . \"/\" . W . \"/\" . H\n");
        sb.append("Return, S\n");
        sb.append("}\n");
        AutoHotKey instance = AutoHotKey.getInstance();
        instance.eval(sb.toString());
        String[] result = instance.callFunction("value").split("/");
        if (result.length > 0) {
            return new Rectangle(Integer.parseInt(result[0]), Integer.parseInt(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]));
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        JAHK.init();
        AutoHotKey instance = AutoHotKey.getInstance();
        instance.eval("Run, notepad.exe");
        System.out.println(getNotepadRectangle());
    }
}
