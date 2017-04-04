package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;

public class bab3 extends AppCompatActivity {
    MathView texbab3;
    //Hubungan derajat, menit, detik
    String tex = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
            "<title>Ukuran Derajat</title>\n" +
            "<style type=\"text/css\">\n" +
            ".ukuran-huruf {\n" +
            "\tfont-size: 12pt;\n" +
            "\tline-height: 24px;\n" +
            "}\n" +
            "</style>" +
            "</head>\n" +
            "\n" +
            "<body class=\"ukuran-huruf\">" +
            "<strong>Hubungan Derajat, Menit, dan Detik</strong>" +
			"<ol>" +
            "<li>Ubahlah bentuk derajat berikut ke dalam bentuk menit dan detik 30,23°\n" + //1
            "<br>Penyelesaian:</br>\n" +
            "30,23° = 30° + 0,23 (60') = 30° + 13,8'\n" +
            "= 30° + 13' + 0,8 (60')\n" +
            "=30° + 13' + 48\"\n" +
            "=30° 13' 48\"\n" +
            "</li>" +
            "<li>Hitunglah operasi berikut\n" + //2
            "<ol type=\"a\">" +
            "<li>37° 45' + 60° 48'</li>\n" + //a
            "<li>50° 37' - 23° 33' 45\"</li></ol>" +
            "</ol>\n" + //b
            "<br>Penyelesaian:</br>\n" +
            "<ol type=\"a\">" +
            "<li>37° 45' + 60° 48' = 90° 93'\n" + //a
            "<br>Jadi, 90° 93' = 90° 60' + 33\" = 90° 1' + 33' = 91° 33'</br></li>\n" +
            "<li>50° 37' - 23° 33' 45\"<br/>\n" + //b
            "50° 37' → 50° 36' 60\"<br/>\n" +
            "23° 33' 45\" → 23° 33' 45\"<br/>\n" +
            "=23° 3' 15\"<br/>\n" +
            "Jadi 50° 37' - 23° 33' 45\" = 23° 3' 15\"<br/></li>\n" +
            "</ol>" +
            "</body>\n" +
            "</html>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3);
        Toolbar toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar3);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        MediaPlayer instrumen = MediaPlayer.create(this, R.raw.instrumen);
        instrumen.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bab3, menu);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        texbab3 = (MathView) findViewById(R.id.tex_bab3);
        texbab3.setText(tex);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(bab3.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(bab3.this, beranda.class);
                intentberanda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentberanda);
                return true;
            case R.id.keluar:
                buttonmusic();
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
        Intent back = new Intent(bab3.this, materi.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }


}
