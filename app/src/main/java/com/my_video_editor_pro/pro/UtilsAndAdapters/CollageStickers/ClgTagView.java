package com.my_video_editor_pro.pro.UtilsAndAdapters.CollageStickers;

public class ClgTagView {
    int a = -1;
    String b = "";

    public ClgTagView(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getPos() {
        return this.a;
    }

    public String getText() {
        return this.b;
    }
}
