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
import android.view.View;
import android.view.WindowManager;

import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;
import io.github.kexanie.quiz.QuizBab2;

public class bab2 extends AppCompatActivity {
    MathView texbab2;
    Intent svc;
    //Konsep dasar sudut
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
            "<p><strong>Konsep Dasar Sudut</strong></p>\n" +
            "<p>Dalam kajian geometris, sudut didefinisikan sebagai hasil rotasi dari sisi awal (intial side) ke sisi akhir (terminal side). Selain itu, arah putaran memiliki makna dalam sudut. Suatu bertanda positif jika arah putarannya berlawanan dengan arah jarum jam, dan bertanda negatif jika arah putarannya searah dengan jarum jam.</p>" +
            "<img src=\"file:///android_res/mipmap/g5.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g6.png\" style=\"width:50%; margin:10px\" />" +
            "<p><strong>Ingat</strong></p>" +
            "<ul>" +
            "<li>Sudut standar (baku) adalah sudut sisi awal suatu garis berimpit dengan dengan sumbu x dan sisi terminalnya terletak pada salah satu kuadran pada koordinat kartesius.</li>\n" +
            "<li>Sudut pembatas kuadran adalah sudut sisi akhir berada pada salah satu sumbu pada koordinat tersebut, yaitu: 0°, 90°, 180°, 270° dan 360°.</li>\n" +
            "<li>Sudut-sudut koterminal adalah dua sudut standar, memiliki sisi-sisi akhir yang berimpit. Jika sudut yang dihasilkan sebesar α (sudut standar). Maka sudut β disebut sebagai sudut koterminal, sehingga α + β = 360°.</li></ul>\n" +
            "<img src=\"file:///android_res/mipmap/g7.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g8.png\" style=\"width:50%; margin:10px\" />" +
            "<p><strong>Definisi:</strong> Sudut-sudut koterminal adalah dua sudut standart, memiiki sisi-sisi akhir (terminal side) yang berimpit.</p>" +
            "<br>Contoh:</br>" +
            "<ol>\n" +
            "<li>Tentukan besar sudut koterminal dari sudut-sudut berikut:\n" + // 1.
            "<ol type=\"a\">" +
            "<li>A = 90°</li>\n" + // a
            "<li>B = 115°</li>\n" + // b
            "<li>C = 200°</li>\n" + // c
            "</ol>\n" +
            "<br>Penyelesaian:</br>\n" +
            "<br>Misalkan sudut koterminalnya adalah K</br>\n" +
            "<ol type=\"a\">" +
            "<li>A = 90°\n" + // a
            "<br>A + K =360° → 90° + K = 360° → K = 270°</br></li>\n" +
            "<li>B = 115°\n" + // b
            "<br>B + K = 360° → 115° + K = 360° → K = 245°</br></li>\n" +
            "<li>C = 200°\n" + //c
            "<br>C + K = 360° → 200° + K = 360° → K = 160°</br></li>" +
            "</ol>" +
            "</li>\n" +
            "<li>Gambarkanlah sudut-sudut standar dibawah ini, dan tentukan setiap posisi setap sudut pada koordinat cartesius\n" +
            "<ol type=\"a\">" + // 2.
            "<li>60°</li>\n" + //a
            "<li>-45°</li>\n" + //b
            "<li>120°</li>\n" + //c
            "<li>600°</li>\n" + //d
            "</ol>" +
            "<br>Penyelesaian:</br></li>" +
            "<img src=\"file:///android_res/mipmap/g9.png\" style=\"width:50%; margin:10px\" />\n" + //a
            "<img src=\"file:///android_res/mipmap/g10.png\" style=\"width:50%; margin:10px\" />\n" + //b
            "<img src=\"file:///android_res/mipmap/g11.png\" style=\"width:50%; margin:10px\" />\n" + //c
            "<img src=\"file:///android_res/mipmap/g12.png\" style=\"width:50%; margin:10px\" />\n" +
            "</body>\n" +
            "</html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        toolbar2.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        MediaPlayer instrumen = MediaPlayer.create(this, R.raw.instrumen);
        instrumen.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bab, menu);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        texbab2 = (MathView) findViewById(R.id.tex_bab2);
        texbab2.setText(tex);
        texbab2.setVerticalScrollBarEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item2){
        switch (item2.getItemId()){
            case R.id.kuis:
                buttonmusic();
                Intent intentkuisbab2 = new Intent(bab2.this, QuizBab2.class);
                startActivity(intentkuisbab2);
                return true;

            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(bab2.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);

            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(bab2.this, beranda.class);
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
        return super.onOptionsItemSelected(item2);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(bab2.this, materi.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
