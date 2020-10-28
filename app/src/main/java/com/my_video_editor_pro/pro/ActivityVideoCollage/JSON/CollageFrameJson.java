package com.my_video_editor_pro.pro.ActivityVideoCollage.JSON;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollageFrameJson {
    @SerializedName("collageframes")
    public List<CollageFrameInfo> imgInfo;
}
