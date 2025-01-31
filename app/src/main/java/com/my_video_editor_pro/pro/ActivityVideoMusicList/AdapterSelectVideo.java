package com.my_video_editor_pro.pro.ActivityVideoMusicList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.my_video_editor_pro.pro.ActivityVideoCutter.ActivityVideoCutter;
import com.my_video_editor_pro.pro.UtilsAndAdapters.EditorHelper;
import com.my_video_editor_pro.pro.R;
import com.my_video_editor_pro.pro.ActivityVideoCompressor.ActivityVideoCompressor;
import com.my_video_editor_pro.pro.ActivityVideoToAudio.ActivityVideoToAudio;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class AdapterSelectVideo extends BaseAdapter {
    ImageLoader imageLoader;
    ArrayList<VideoData> videoData = new ArrayList<>();
    ArrayList<VideoData> videoData1 = new ArrayList<>();
    private LayoutInflater inflater;

    public final Context context;

    private class a {
        ImageView imageView;
        TextView textView;
        TextView textView1;

        private a() {
        }
    }

    public long getItemId(int i) {
        return i;
    }

    public AdapterSelectVideo(Context context, ArrayList<VideoData> arrayList, ImageLoader imageLoader) {
        this.context = context;
        this.imageLoader = imageLoader;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.videoData1.addAll(arrayList);
        this.videoData.addAll(arrayList);
    }

    public int getCount() {
        return this.videoData1.size();
    }

    public Object getItem(int i) {
        return this.videoData1.get(i);
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.inflater.inflate(R.layout.row_video, null);
            aVar = new a();
            aVar.imageView = view.findViewById(R.id.image_preview);
            aVar.textView1 = view.findViewById(R.id.file_name);
            aVar.textView = view.findViewById(R.id.duration);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        this.imageLoader.displayImage(this.videoData1.get(i).VideoUri.toString(), aVar.imageView, new Builder().showImageForEmptyUri(0).cacheInMemory(true).showStubImage(R.color.trans).cacheOnDisk(true).resetViewBeforeLoading(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(Config.ARGB_8888).delayBeforeLoading(100).postProcessor(new BitmapProcessor() {
            public Bitmap process(Bitmap bitmap) {
                return Bitmap.createScaledBitmap(bitmap, 100, 100, false);
            }
        }).displayer(new SimpleBitmapDisplayer()).build());
        view.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View view) {
                if (EditorHelper.ModuleId == 1) {
                    Intent intent = new Intent(AdapterSelectVideo.this.context, ActivityVideoCutter.class);
                    intent.setFlags(67108864);
                    intent.putExtra("path", AdapterSelectVideo.this.videoData1.get(i).videoPath);
                    AdapterSelectVideo.this.context.startActivity(intent);
                } else if (EditorHelper.ModuleId == 2) {
                    Intent intent2 = new Intent(AdapterSelectVideo.this.context, ActivityVideoCompressor.class);
                    intent2.setFlags(67108864);
                    intent2.putExtra("videouri", AdapterSelectVideo.this.videoData1.get(i).videoPath);
                    AdapterSelectVideo.this.context.startActivity(intent2);
                } else if (EditorHelper.ModuleId == 3) {
                    Intent intent3 = new Intent(AdapterSelectVideo.this.context, ActivityVideoToAudio.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("videopath", AdapterSelectVideo.this.videoData1.get(i).videoPath);
                    intent3.putExtras(bundle);
                    AdapterSelectVideo.this.context.startActivity(intent3);
                }
            }
        });
        if (i % 2 == 0) {
            view.setBackgroundResource(R.drawable.divider_1);
        } else {
            view.setBackgroundResource(R.drawable.divider_2);
        }
        TextView textView = aVar.textView1;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.videoData1.get(i).videoName);
        textView.setText(sb.toString());
        TextView textView2 = aVar.textView;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(this.videoData1.get(i).Duration);
        textView2.setText(sb2.toString());
        return view;

    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.videoData1.clear();
        if (lowerCase.length() == 0) {
            this.videoData1.addAll(this.videoData);
        } else {
            Iterator it = this.videoData.iterator();
            while (it.hasNext()) {
                VideoData videoData = (VideoData) it.next();
                if (videoData.videoName.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.videoData1.add(videoData);
                }
            }
        }
        notifyDataSetChanged();
    }
}
