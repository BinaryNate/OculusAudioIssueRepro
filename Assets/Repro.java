package com.vuplex.repro;

import android.util.Log;
import com.unity3d.player.UnityPlayer;
import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;

public class Repro {

    public static void createGeckoSession() {

        UnityPlayer.currentActivity.runOnUiThread(() -> {
            _geckoSession = new GeckoSession();
            _geckoRuntime = GeckoRuntime.create(UnityPlayer.currentActivity);
            _geckoSession.open(_geckoRuntime);
            UnityPlayer.UnitySendMessage("Repro", "OnGeckoSessionCreated", "");
        });
    }

    public static void closeGeckoSession() {

        UnityPlayer.currentActivity.runOnUiThread(() -> {
            Log.i(TAG, ">>> closing the GeckoSession");
            _geckoSession.close();
            Log.i(TAG, ">>> finished closing the GeckoSession");
        });
    }

    private static GeckoRuntime _geckoRuntime;
    private static GeckoSession _geckoSession;
    private final static String TAG = "Repro";
}
