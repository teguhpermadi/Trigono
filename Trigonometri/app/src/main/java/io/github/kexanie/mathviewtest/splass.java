package io.github.kexanie.mathviewtest;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import io.github.kexanie.musik.BackgroundSoundService;

public class splass extends AppCompatActivity {

   // private static int splassInterval = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splass);
       // MediaPlayer instrumen = MediaPlayer.create(getApplicationContext(), R.raw.tesmusik);
       // instrumen.start();

       // new Handler().postDelayed(new Runnable() {
       //     @Override
       //     public void run() {
       //          Intent i = new Intent(splass.this, beranda.class);
       //         i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
       //        startActivity(i);
       //         this.finish();
       //    }
       //     private void finish(){
       //    }
     //  }, splassInterval);
    }

   public void onClickMasuk(View view){
       switch (view.getId()){
           case R.id.button:
               buttonmusic();
               Intent i = new Intent(splass.this, beranda.class);
               i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
               startActivity(i);
               Intent svc = new Intent(this, BackgroundSoundService.class);
               startService(svc);
               this.finish();
               break;
      }
   }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }
}
