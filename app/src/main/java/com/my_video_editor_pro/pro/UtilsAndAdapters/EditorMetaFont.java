package com.my_video_editor_pro.pro.UtilsAndAdapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class EditorMetaFont extends AppCompatTextView {
    private static final int[] a = {16842901, 16843087, 16842904};

    public EditorMetaFont(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    public EditorMetaFont(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public EditorMetaFont(Context context) {
        super(context);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a);
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "AVENIRLTSTD-MEDIUM.OTF"));
            obtainStyledAttributes.recycle();
        }
    }
}
