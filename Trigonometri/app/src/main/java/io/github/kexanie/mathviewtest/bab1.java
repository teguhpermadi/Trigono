package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import io.github.kexanie.library.MathView;
import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;
import io.github.kexanie.quiz.QuizActivity;
import io.github.kexanie.quiz.QuizBab1;
import io.github.kexanie.quiz.ResultActivityBab;

public class bab1 extends AppCompatActivity {
    Intent svc;
    MathView texbab1;
    String tex =
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
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
                    "<strong>Ukuran Derajat</strong>\n" +
                    "<p>Kita ketahui besar sudut satu putaran dalam derajat adalah 360°. Jadi, ini berati \\(1°=\\frac{1}{360}\\) putaran. Selain derajat ada ukuran sudut yang lebih kecil dari derajat yaitu menit (‘) dan detik (“). Hubungan dari ukuran-ukuran sudut tersebut adalah sebagai berikut.</br>\n" +
                    "<br>1 derajat = 60 menit atau 1° = 60’</br>\n" +
                    "<br>1 menit = 60 detik atau 1’ = 60”</br></p>\n" +
                    "<p><strong>Ukuran Radian</strong></p>\n" +
                    "<p>Selain ukuran derajat kita juga mengenal istilah ukuran sudut yang lain yaitu ukuran radian (rad). Ukuran sudut radian banyak digunakan dalam matematika terapan. Satu radian didefinisikan sebagai besar sudut pusat busur lingkaran yang panjangnya sama dengan jari-jari.\n" +
                    "Tanda \"°\" dan \"rad\" berturut-turut menyatakan simbol derajat dan radian. Singkatnya satu putaran =360°, atau 1° didefinisikan sebagai besar sudut yang dibentuk oleh \\(\\frac{1}{360}\\) putaran penuh. Cermati gambar dibawah ini:</p>" +
                    "<img src=\"file:///android_res/mipmap/g1.png\" style=\"width:30%\" />" +
                    "<img src=\"file:///android_res/mipmap/g2.png\" style=\"width:30%\" />" +
                    "<img src=\"file:///android_res/mipmap/g3.png\" style=\"width:30%\" />" +
                    "<img src=\"file:///android_res/mipmap/g4.png\" style=\"width:30%\" />" +
                    "<p>Jika panjang busur tidak sama dengan r, maka cara menentukan besar sudut tersebut dalam satuan radian diselesaikan menggunakan definisi perbandingan:\n" +
                    "<br><strong>Definisi:</strong> \\(\\Delta AOB=\\frac{AB}{r}~rad\\)</br>\n" +
                    "<p>Lebih lanjut, hubungan satuan derajat dengan satuan radian, bahwa satu putaran penuh sama dengan \\(2\\pi~rad\\). seperti dinyatakan dalam definisi berikut:</p>\n" +
                    "<br><strong>Definisi:</strong> \\(360°=2\\pi~rad\\) atau \\(1°=\\frac{\\pi}{180}~rad\\) atau \\(1~rad~\\approx~57,3°\\)</br>\n" +
                    "<br>Contoh:</br>" +
                    "<ol>\n" +
                    "<li>\\(\\frac{1}{4}\\)putaran \\(=\\frac{1}{4}\\times\\)360°=90°" +
                    "\\(\\Leftrightarrow\\) 90°=90 \\(\\times \\frac{\\pi}{180}\\)rad=\\(\\frac{1}{2}\\)rad</li>\n" +
                    "<li>\\(\\frac{1}{3}\\)putaran \\(=\\frac{1}{3}\\times\\)360°=120°" +
                    "\\(\\Leftrightarrow\\) 120°=120 \\(\\times\\frac{\\pi}{180}\\)rad=\\(\\frac{2}{3}\\)rad</li>\n" +
                    "<li>\\(\\frac{1}{2}\\)putaran \\(=\\frac{1}{2}\\times\\)360°=180°" +
                    "\\(\\Leftrightarrow\\) 180°=180 \\(\\times\\frac{\\pi}{180}\\)rad=\\(\\pi\\)rad</li>\n" +
                    "<li>\\(\\frac{2}{3}\\)putaran \\(=\\frac{2}{3}\\times\\)360°=240°" +
                    "\\(\\Leftrightarrow\\) 240°=240 \\(\\times\\frac{\\pi}{180}\\)rad=\\(\\frac{4}{3}\\)rad</li>\n" +
                    "<li>\\(\\frac{3}{4}\\)putaran \\(=\\frac{3}{4}\\times\\)360°=270°" +
                    "\\(\\Leftrightarrow\\)270°=270 \\(\\times\\frac{\\pi}{180}\\)rad=\\(\\frac{3}{2}\\)rad</li>" +
                    "</ol>\n" +
                    "<p>Contoh:</p>\n" +
                    "<ol>" +
                    "<li>\\(\\frac{1}{5}~\\pi~rad\\) = ... putaran = ...°</li>\n" +
                    "<li>\\(\\frac{1}{6}\\) putaran = ... rad = ...°</li>\n" +
                    "<li>135° = ... rad = ... putaran</li>\n" +
                    "<li>Berapa radian sudut yang diberikan jarum jam pada pukul 11.00?</li>\n" +
                    "<li>Jika suatu alat pemancar berputar 60 putaran dalam setiap menit, maka tentukanlah banyak putaran dalam satu detik.</li>\n" +
                    "</ol>" +
                    "<p>Alternatif Penyelesaian:</p>\n" +
                    "<ol>" +
                    "<li>1 putaran = 360° = \\(2\\pi~rad\\). Jadi, \\(\\frac{1}{2}\\) putaran = \\(\\pi~rad\\). Oleh karena itu, " +
                    "\\(\\frac{1}{5}\\pi\\) rad = \\(\\frac{1}{5}\\times\\frac{1}{2}\\) putaran = \\(\\frac{1}{10}\\)" +
                    " putaran = \\(\\frac{1}{10}\\times~360°=36°\\)</li>\n" +
                    "<li>Karena 1 putaran = \\(\\pi\\) rad \\(\\frac{1}{6}\\) putaran = \\(\\frac{1}{6}\\times~2\\pi~rad\\)=\\(\\frac{1}{3}\\pi\\times\\frac{180}{\\pi}\\)=60°</li>\n" +
                    "<li>\\(135=135\\times\\frac{\\pi}{180}~rad\\) \\(=\\frac{3}{4}\\times\\frac{1}{2}\\) putaran = \\(\\frac{3}{8}\\) putaran.</li>\n" +
                    "<li>sudut yang terbentuk pada pukul 11.00 adalah 30°(D=30°)\n" +
                    "menentukan nilai radian\n" +
                    "<br>D=180°</br>\n" +
                    "<br>\\(\\frac{R}{30°}=\\frac{\\pi}{180°}\\)</br>\n" +
                    "<br>\\(R=\\frac{\\pi}{180°}\\times~30°~rad\\)</br>\n" +
                    "<br>\\(R=\\frac{1}{6}\\pi~rad\\)</br></li>\n" +
                    "<li>Diketahui: 1 menit ada 60 putaran; 1 menit =  60 detik\n" +
                    "Ditanya: \tputaran tiap detik\n" +
                    "Putaran tiap detik \\(\\frac{1}{6}\\times~60\\) putaran=1</li>" +
                    "</ol>" +
                    "</body>\n" +
                    "</html>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        toolbar1.showOverflowMenu();
        toolbar1.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        MediaPlayer instrumen = MediaPlayer.create(this, R.raw.instrumen);
        instrumen.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bab, menu);
        return true;
    }

    @Override
    protected void onResume() {
        texbab1 = (MathView) findViewById(R.id.tex_bab1);
        texbab1.setText(tex);
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(bab1.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.kuis:
                buttonmusic();
                Intent intentkuisbab1 = new Intent(bab1.this, QuizBab1.class);
                startActivity(intentkuisbab1);
                return true;
            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(bab1.this, beranda.class);
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(bab1.this, materi.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
