package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;
import io.github.kexanie.quiz.QuizBab1;

public class pengantar extends AppCompatActivity {
    Intent svc;
    MathView tex_pengantar;
    String tex = "<p>Puji syukur penulis panjatkan kehadiran Allah SWT karena berkat rahmat dan hidayahnya sehingga penulis dapat menyelesaikan POCKET BOOK INTERAKTIF BERBASIS ANDROID sebagai bahan ajar pembelajaran matermatika untuk kelas X.</p>\n" +
            "<p>Pocket Book Interaktif ini digunakan oleh siswa sebagai bahan ajar untuk memahami materi trigonometri. pocket book Ini disusun berdasarkan kurikulum 2013 yang terdiri dari materi beserta contoh soal, dilengkapi dengan uji kompetensi dan latihan soal. Agar siswa lebih memahami materi trigonometri ini, diharapkan siswa dapat mengerjakan semua latihan-latihan soal yang tersedia dengan benar.</p>\n" +
            "<p>Penyusunan pocket book interaktif ini masih jauh dari sempurna, oleh karena itu penulis mengharapkan kritik dan saran yang bersifat membangun demi kesempurnaan ini. Akhirnya penulis mengucapkan terima kasih, semoga pocket book interaktif ini bermanfaat bagi semua pihak yang menggunakannya.</p>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengantar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_tujuan_putih);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {
        tex_pengantar = (MathView) findViewById(R.id.web_pengantar);
        tex_pengantar.setText(tex);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                buttonmusic();
                svc = new Intent(getApplicationContext(), BackgroundSoundService.class);
                startService(svc);
                Intent i = new Intent(pengantar.this, beranda.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                svc = new Intent(getApplicationContext(), BackgroundSoundService.class);
                startService(svc);
                Intent intentberanda = new Intent(pengantar.this, beranda.class);
                intentberanda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentberanda);
                return true;
            case R.id.keluar:
                buttonmusic();
                svc = new Intent(getApplicationContext(), BackgroundSoundService.class);
                startService(svc);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Apakah anda yakin untuk keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(pengantar.this, beranda.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
