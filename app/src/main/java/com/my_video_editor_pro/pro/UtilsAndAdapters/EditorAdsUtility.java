package com.my_video_editor_pro.pro.UtilsAndAdapters;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class EditorAdsUtility {

    private static String admBanner = "ca-app-pub-5657577738944896/2454263630";
    public static String Interstitial = "ca-app-pub-5657577738944896/5627221887";


    private static InterstitialAd mInterstitialAd;
    private static int adCount = 0;



    //----------------------------

    public static void admobBannerCall(Activity acitivty,
                                       LinearLayout linerlayout) {

        AdView adView = new AdView(acitivty);
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.BANNER);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);
    }

    public static void admobMediumBannerCall(Activity acitivty,
                                             LinearLayout linerlayout) {

        AdView adView = new AdView(acitivty);
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
    }

    public static void InterstitialAdmob(Context context) {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(Interstitial);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }

    protected static void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public static void showIntestitialAds() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


}

