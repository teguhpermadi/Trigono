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
import io.github.kexanie.quiz.QuizBab3;

public class bab4 extends AppCompatActivity {
    MathView texbab4;
    //Perbandingan Trigonometri Pada Segitiga Siku-siku
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
            "<strong>Perbandingan Trigonometri Pada Segitiga Siku-siku</strong>" +
            "<p>Pak yahya adalah seorang penjaga sekolah. Pak yahya adalah 1,6 meter. Dia mempunyai seorang anak, namanya Dani. Dani masih kelas II dasar. Tinggi badannya 1,2 meter. Dani adalah anak yang baik dan suka bertanya. Dia pernah bertanya kepada anaknya tentang tinggi bendera di lapangan itu. Dengan senyum, Ayahnya menjawab 8 meter. Suatu sore, disaat dia menemani Ayahnya membersihkan rumput liar di lapangan, Dani melihat bayangan disetiap denda ditanah. Dia mengambil tali meteran dan mengukur panjang bayangan ayahnya dan panjang bayangan tiap bendera, yaitu 3 Meter dan 4 meter. Tetapi dia tidak dapat mengukur panjang bayangannya sendiri karena bayangannya mengikuti pergerakannya. Jika kamu sebagai Dani, dapatkah kamu mengukur bayangan kamu sendiri?<br />" +
            "Konsep kesebangunan pada segitiga terdapat pada cerita tersebut. Mari kita gambarkan segitiga sesuai cerita diatas.<br /></p>\n" +
            "<img src=\"file:///android_res/mipmap/g13.png\" style=\"width:70%; margin:10px\" />" +
            "<p>Dimana:<br />\n" +
            "AB = tinggi tiang bendera (8m)<br />\n" +
            "BC = panjang bayangan tiang (15m)<br />\n" +
            "DE = tinggi pak Yahya (1,6m)<br />\n" +
            "EC = panjang bayang pak Yahya (3m)<br />\n" +
            "FG = tinggi Dani (1,2m)<br />\n" +
            "GC = panjang bayangan Dani<br />\n" +
            "Berdasarkan gambar segitiga di atas terdapat tiga segitiga, yaitu \\(\\Delta ABC\\),\\(\\Delta DEC\\),dan \\(\\Delta RGC\\). Sebagai berikut:<br /></p>" +
            "<img src=\"file:///android_res/mipmap/g14.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g15.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g16.png\" style=\"width:50%; margin:10px\" />" +
            "<p>Karena \\(\\Delta ABC\\),\\(\\Delta DEC\\),dan \\(\\Delta RGC\\) adalah sebangun, maka berlaku:<br />\n" +
            "\\(\\frac{FG}{DE}=\\frac{GC}{EC}=\\frac{1,2}{1,6}=\\frac{f}{3}\\). Diperoleh f = 2,25<br />\n" +
            "Dengan menggunakan Teorema Pytagoras diperoleh nilai \\(FC=g=\\sqrt{6,5025}=2,55\\) berdasarkan kesebangunan \\(\\Delta ABC\\),\\(\\Delta DEC\\),dan \\(\\Delta RGC\\) diperoleh perbandingan sebagai berikut:<br /></p>\n" +
            "<ol>" +
            "<li>\\(\\frac{FG}{FC}\\)=\\(\\frac{DE}{DC}\\)=\\(\\frac{AB}{AC}\\)=\\(\\frac{1,2}{2,55}\\)=\\(\\frac{1,6}{3,4}\\)=\\(\\frac{8}{17}\\)=\\(\\frac{sisi~di~depan~sudut}{sisi~miring~segitiga}\\)=0,47<br />\n" +
            "Perbandingan ini disebut sinus sudut C,ditulis sin x° atau sin C = \\(\\frac{8}{17}\\)<br /></li>\n" +
            "<li>\\(\\frac{GC}{FC}\\)=\\(\\frac{EC}{DC}\\)=\\(\\frac{BC}{AC}\\)=\\(\\frac{2,25}{2,55}\\)=\\(\\frac{3}{3,4}\\)=\\(\\frac{15}{17}\\)=\\(\\frac{sisi~di~samping~sudut}{sisi~miring~segitiga}\\)=0,88<br />\n" +
            "Perbandingan ini disebut cosinus sudut C,ditulis cos x°  atau cos C = \\(\\frac{15}{17}\\)<br /></li>\n" +
            "<li>\\(\\frac{FG}{GC}\\)=\\(\\frac{DE}{EC}\\)=\\(\\frac{AB}{BC}\\)=\\(\\frac{1,2}{2,25}\\)=\\(\\frac{1,6}{3}\\)=\\(\\frac{8}{15}\\)=\\(\\frac{sisi~di~depan~sudut}{sisi~di~samping~sudut}\\)=0,53<br />\n" +
            "Perbandingan ini disebut tangen sudut C,ditulis tangen x°  atau tan C = \\(\\frac{8}{15}\\)<br /></li></ol>\n" +
            "<p>Satuan yang sering digunakan untuk mengukur besar sudut yaitu derajat (°) dan radian (rad). Hubungan antara derajat dan radian sebagai berikut:</p>" +
            "\\(1°=\\frac{1}{360}\\) putaran \\(=\\frac{2\\pi}{360}\\) rad = \\(\\frac{\\pi}{180}\\)<br />\n" +
            "\\(1°=\\frac{\\pi}{180}\\) rad \\(\\Leftrightarrow 1 rad = \\frac{180}{\\pi}\\)<br />\n" +
            "<br /></p>\n" +
            "<ol>" +
            "<li>Sinus suatu sudut didefinisikan sebagai perbandingan panjang sisi di depan sudut dengan sisi miring, ditulis sin C = \\(\\frac{sisi~di~depan~sudut}{sisi~miring~segitiga}\\)</li>\n" +
            "<li>Cosinus suatu sudut didefinisikan sebagai perbandingan panjang sisi disamping sudut dengan sisi miring, ditulis cos C = \\(\\frac{sisi~di~samping~sudut}{sisi~miring~segitiga}\\)</li>\n" +
            "<li>Tangen suatu sudut didefinisikan sebagai perbandingan panjang sisi depan sudut dengan sisi disamping sudut, ditulis tan C = \\(\\frac{sisi~di~depan~sudut}{sisi~di~samping~sudut}\\)</li>\n" +
            "<li>Cosecan suatu sudut didefinisikan sebagai panjang sisi miring dengan sisi di depan sudut, ditulis, cosec C = \\(\\frac{sisi~miring~segitiga}{sisi~di~depan~sudut}\\) atau cosec C = \\(\\frac{1}{sin C}\\)</li>\n" +
            "<li>Secan suatu sudut didefinisikan sebagai perbandingan panjang sisi miring dengan sisi disamping sudut, ditulis sec C = \\(\\frac{sisi~miring~segitiga}{sisi~di~samping~sudut}\\) sec C = \\(\\frac{1}{cos C}\\)</li>\n" +
            "<li>Cotangen suatu sudut didefinisikan sebagai pertandingan sisi disamping sudut dengan sisi didepan sudut, ditulis cotan C = \\(\\frac{sisi~di~samping~sudut}{sisi~di~depan~sudut}\\) atau cotan C = \\(\\frac{1}{tan C}\\)</li>\n" +
            "</ol>" +
            "<img src=\"file:///android_res/mipmap/g17.png\" style=\"width:50%; margin:10px\" />" +
            "<p>sin a° = \\(\\frac{y}{r}\\)<br />" +
            "cos a° = \\(\\frac{x}{r}\\)<br />\n" +
            "tan a° = \\(\\frac{y}{x}\\)<br />" +
            "cosec a° = \\(\\frac{r}{y}\\)<br />\n" +
            "sec a° = \\(\\frac{r}{x}\\)<br />" +
            "cotan a° = \\(\\frac{x}{y}\\)<br /></p>\n" +
            "<p>Contoh:<br />\n" +
            "Perhatikan gambar dibawah ini, Segitiga ABC siku-siku di B.<br /></p>\n" +
            "<img src=\"file:///android_res/mipmap/g18.png\" style=\"width:50%; margin:10px\" /><br />" +
            "Tentukan:<br />" +
            "<ol type=\"a\">" +
            "<li>Sin a°</li>" +
            "<li>Cos a°</li>\n" +
            "<li>Tan a°</li>\n" +
            "<li>Cosec a°</li>\n" +
            "<li>Sec a°</li>\n" +
            "<li>Cotan a°</li>\n" +
            "</ol>" +
            "Pembahasan:<br />\n" +
            "Menggunakan rumus pythagoras:<br />\n" +
            "AC = \\(\\sqrt{AB^2+BC^2}\\) = \\(\\sqrt{8^2+6^2}\\) = \\(\\sqrt{64+36}\\) = \\(\\sqrt{100}\\) = 10 cm<br />\n" +
            "<ol type=\"a\">" +
            "<li>Sin a° = \\(\\frac{sisi~di~depan~sudut}{sisi~miring~segitiga}\\)=\\(\\frac{BC}{AC}\\)=\\(\\frac{6}{10}\\)=\\(\\frac{3}{5}\\)</li>\n" +
            "<li>Cos a° = \\(\\frac{sisi~di~samping~sudut}{sisi~miring~segitiga}\\)=\\(\\frac{AB}{AC}\\)=\\(\\frac{8}{10}\\)=\\(\\frac{4}{5}\\)</li>\n" +
            "<li>Tan a° = \\(\\frac{sisi~di~depan~sudut}{sisi~di~samping~sudut}\\)=\\(\\frac{BC}{AB}\\)=\\(\\frac{6}{8}\\)=\\(\\frac{3}{4}\\)</li>\n" +
            "<li>Cosec a° = \\(\\frac{sisi~miring~segitiga}{sisi~di~depan~sudut}\\)=\\(\\frac{AC}{BC}\\)=\\(\\frac{10}{6}\\)=\\(\\frac{5}{3}\\)</li>\n" +
            "<li>Sec a° = \\(\\frac{sisi~miring~segitiga}{sisi~di~samping~sudut}\\)=\\(\\frac{AC}{AB}\\)=\\(\\frac{10}{8}\\)=\\(\\frac{5}{4}\\)</li>\n" +
            "<li>Cotangen a° = \\(\\frac{sisi~di~samping~sudut}{sisi~di~depan~sudut}\\)=\\(\\frac{AB}{BC}\\)=\\(\\frac{8}{6}\\)=\\(\\frac{4}{3}\\)</li>\n" +
            "</ol>" +
            "</body>\n" +
            "</html>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab4);
        Toolbar toolbar4 = (Toolbar) findViewById(R.id.toolbar4);
        toolbar4.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar4);
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
        texbab4 = (MathView) findViewById(R.id.tex_bab4);
        texbab4.setText(tex);
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item4){
        switch (item4.getItemId()){
            case R.id.kuis:
                buttonmusic();
                Intent intentkuisbab3 = new Intent(bab4.this, QuizBab3.class);
                startActivity(intentkuisbab3);
                return true;
            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(bab4.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(bab4.this, beranda.class);
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
        return super.onOptionsItemSelected(item4);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(bab4.this, materi.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
