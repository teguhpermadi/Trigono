package io.github.kexanie.musik;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import io.github.kexanie.mathviewtest.R;

/**
 * Created by Teguh Permadi on 24/07/2016.
 */
public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.instrumen);
        player.setLooping(true);
        player.setVolume(100,100);
    }

    public int onStartCommand(Intent i, int flags, int startId){
        player.start();
        return 2;
    }

    public void onStart(Intent intent, int startId){

    }

    public IBinder onUnBind(Intent arg0){
        return null;
    }

    public void onStop(){

    }

    public void onPause(){

    }

    @Override
    public void onDestroy(){
        player.stop();
        player.release();
    }

    public void onLowMemory(){

    }
}
