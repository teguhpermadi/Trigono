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
import io.github.kexanie.quiz.QuizBab4;

public class bab5 extends AppCompatActivity {
    MathView texbab5;
    //Nilai Perbandingan Trigonometri di Berbagai Kuadran
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
            "<strong>Nilai Perbandingan Trigonometri di Berbagai Kuadran</strong>" +
			"<img src=\"file:///android_res/mipmap/g19.png\" style=\"width:50%; margin:10px\" />" +
            "<br>Berdasarkan gambar tersebut kita dapatkan:</br>\n" +
            "$$OP=\\sqrt{x^2+y^2}=r$$\n" +
            "Dengan memutar garis OP maka :\n" +
            "$$\\angle XOP=\\alpha$$" +
            "dapat terletak pada kuadran I, kuadran II, kuadran III atau kuadran IV seperti pada gambar berikut:" +
            "<img src=\"file:///android_res/mipmap/g20.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g21.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g22.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g23.png\" style=\"width:50%; margin:10px\" />" +
            "<img src=\"file:///android_res/mipmap/g26.png\" style=\"width:50%; margin:10px\" />" +
            "<ol>" +
            "<li>Sudut dalam kuadran I  terletak antara 0° dan 90° (0° < x < 90°), semua bernilai positif</li>\n" +
            "<li>Sudut dalam kuadran II terletak antara 90° dan 180° (90° < x < 180°), hanya nilai sinus yang positif (cosinus dan tangent bernilai negatif)</li>\n" +
            "<li>Sudut dalam kuadran III  terletak antara 180° dan 270° (180° < x < 270°), hanya nilai tangen yang positif (cosinus dan sinus bernilai negatif)</li>\n" +
            "<li>Sudut dalam kuadran IV  terletak antara 270° dan 360° (270° < x < 360°), hanya nilai cosinus yang positif (sinus dan tangent bernilai negatif)</li></ol>\n" +
            "Berikut ini tabel nilai perbandibangan trigonometri di berbagai kuadran:" +
            "<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n" +
            "  <tr>\n" +
            "    <td width=\"123\" rowspan=\"2\"><p align=\"center\"><strong>Perbandingan    trigonometri</strong></p></td>\n" +
            "    <td width=\"340\" colspan=\"4\"><p align=\"center\"><strong>Kuadran</strong></p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"76\"><p align=\"center\"><strong>I</strong></p></td>\n" +
            "    <td width=\"85\"><p align=\"center\"><strong>II</strong></p></td>\n" +
            "    <td width=\"95\"><p align=\"center\"><strong>III</strong></p></td>\n" +
            "    <td width=\"85\"><p align=\"center\"><strong>IV</strong></p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"123\" valign=\"top\"><p>Sin</p></td>\n" +
            "    <td width=\"76\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"95\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"123\" valign=\"top\"><p>Cos</p></td>\n" +
            "    <td width=\"76\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"95\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">+</p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"123\" valign=\"top\"><p>Tan</p></td>\n" +
            "    <td width=\"76\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"95\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"123\" valign=\"top\"><p>Sec</p></td>\n" +
            "    <td width=\"76\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"95\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"123\" valign=\"top\"><p>Cosec</p></td>\n" +
            "    <td width=\"76\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"95\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">+</p></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td width=\"123\" valign=\"top\"><p>Cotangen</p></td>\n" +
            "    <td width=\"76\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "    <td width=\"95\"><p align=\"center\">+</p></td>\n" +
            "    <td width=\"85\"><p align=\"center\">-</p></td>\n" +
            "  </tr>\n" +
            "</table>" +
            "<br>Contoh:</br>" +
            "<ol>\n" +
            "<li>A(-12,5) dan \\(\\angle XOA=\\alpha\\)</li>\n" +
            "<li>B(15,8) dan \\(\\angle XOB=\\theta\\)</li>\n" +
            "</ol>" +
            "Alternatif Penyelesaian:<br />" +
            "<ol>\n" +
            "<li>Dengan memperhatikan koordinat titik A (-12,5) sangat jelas bahwa titik tersebut terletak dikuadran II, karena x=-12, dan y-5. Secara geometris, disajikan pada gambar dibawah ini:<br />\n" +
            "\\(AO=\\sqrt{{AX}^2+{XO}^2}\\)<br />\n" +
            "\\(=\\sqrt{5^2+(-12)^2}\\)<br />\n" +
            "\\(=\\sqrt{25+114}\\)<br />\n" +
            "\\(=\\sqrt{169}\\)<br />\n" +
            "= 13<br />\n" +
            "<img src=\"file:///android_res/mipmap/g25.png\" style=\"width:50%; margin:10px\" />" +
            "<br>Dengan teorema pythagoras diperoleh r = 13</br>" +
            "<ul>\n" +
            "<li>sin α =\\(\\frac{y}{r}\\)=\\(\\frac{5}{13}\\)</li>\n" +
            "<li>tan α =\\(\\frac{y}{x}\\)=\\(\\frac{5}{-12}\\)</li>" +
            "</ul>" +
            "</li>" +
            "<li>Titik B (15,-8), berada dikuadran IV. Karena x = 15, dan y = -8 berlaku teorema pythagoras:<br />\n" +
            "\\(OB=\\sqrt{OX^2+XB^2}\\)<br />\n" +
            "\\(=\\sqrt{15^2+(-8)^2}\\)<br />\n" +
            "\\(=\\sqrt{225+68}\\)<br />\n" +
            "\\(=\\sqrt{289}=17\\) <br />\n" +
            "<img src=\"file:///android_res/mipmap/g24.png\" style=\"width:50%; margin:10px\" />" +
            "<ul>" +
            "<li>\\(cos\\theta=\\frac{15}{17}\\)</li>\n" +
            "<li>\\(tan\\theta=\\frac{-18}{17}\\)</li>\n" +
            "</ul>" +
            "</li></ol>" +
            "<p><strong>Perbandingan Trigonometri Sudut Berelasi</strong></p>" +

            "<br><strong>Kuadran I</strong></br>\n" +
            "sin (90 - α)° = cos α°<br />\n" +
            "cos (90 - α)° = sin α°<br />\n" +
            "tan (90 - α)° = cot α°<br />\n" +

            "<br><strong>Kuadran II</strong></br>\n" +
            "sin (180 - α)° = sin α°<br />\n" +
            "cos (180 - α)° = -cos α°<br />\n" +
            "tan (180 - α)° = -tan α°<br />\n" +

            "<br><strong>Kuadran III</strong></br>\n" +
            "sin (180 + α)° = -sin α°<br />\n" +
            "cos (180 + α)° = -cos α°<br />\n" +
            "tan (180 + α)° = tan α°<br />\n" +

            "<br><strong>Kuadran IV</strong></br>\n" +
            "sin (360 - α)° = -sin α°<br />\n" +
            "cos (360 - α)° = cos α°<br />\n" +
            "tan (360 - α)° = -tan α°<br />\n" +
            "<br><strong>Sudut Negatif</strong></br>\n" +
            "sin (-α)° = -sin α°<br />\n" +
            "cos (-α)° = cos α°<br />\n" +
            "tan (-α)° = -tan α°<br />\n" +
            "<br><strong>Perioditas Trigonometri</strong></br>\n" +
            "sin (n.360 + α)° = sin α°<br />\n" +
            "cos (n.360 + α)° = cos α°<br />\n" +
            "tan (n.360 +  α)° = tan α°<br />\n" +
            "<p>Untuk menentukan tanda perbandingan trigonometri di setiap kuadran, ingat kembali perbandingan trigonometri dari siku-siku yang salah satu sudutnya diketahui:\n" +
            "\\(\\sin α=\\frac{y}{r}\\);\\(\\cos α=\\frac{x}{r}\\);\\(\\tan α=\\frac{y}{x}\\)\n" +
            "Tanda x dan y didapat berdasarkan tempat kuadran sudut tersebut berada. Sedangkan tanda r selalu positif.<br /></p>" +
            "<br><strong>Kuadran 1</strong></br>\n" +
            "0°<α°<90°;x positif,y negatif<br />\n" +
            "Besar sudutnya α° atau90°-α°<br />\n" +
            "sin α=\\(\\frac{y}{r}\\) (positif)<br />\n" +
            "cos α=\\(\\frac{x}{r}\\) (positif)<br />\n" +
            "tan α=\\(\\frac{y}{x}\\) (positif)<br />\n" +
            "<br><strong>Kuadran 2</strong></br>\n" +
            "90°<α°<180°;x negatif,y positif<br />\n" +
            "Besar sudutnya 90°+ α° atau 180°-α°<br />\n" +
            "sin α=\\(\\frac{y}{r}\\) (positif)<br />\n" +
            "cos α=\\(\\frac{x}{r}\\) (negatif)<br />\n" +
            "tan α=\\(\\frac{y}{x}\\) (negatif)<br />\n" +
            "<br><strong>Kuadran 3</strong></br>\n" +
            "180°<α°<270°;x negatif,y negatif<br />\n" +
            "Besar sudutnya 180°+α° atau 270°-α°<br />\n" +
            "sin α=\\(\\frac{y}{r}\\) (negatif)<br />\n" +
            "cos α=\\(\\frac{x}{r}\\) (negatif)<br />\n" +
            "tan α=\\(\\frac{y}{x}\\) (positif)<br />\n" +
            "<br><strong>Kuadran 4</strong></br>\n" +
            "270°<α°<360°;x negatif,y negatif<br />\n" +
            "Besar sudutnya 270°+ α° atau 360°-α°<br />\n" +
            "sin α=\\(\\frac{y}{r}\\) (negatif)<br />\n" +
            "cos α=\\(\\frac{x}{r}\\) (positif)<br />\n" +
            "tan α=\\(\\frac{y}{x}\\) (negatif)<br />\n" +
            "<br><strong>Contoh</strong></br>" + "<ol>" +
            "<li>Tentukanlah nilai perbandingan trigonometri berikut ini:<br />"+
            "<ol type='a'>" +
            "<li>sin 210°</li>" +
            "<li>cos 120°</li>" +
            "<li>tan 225°</li>" +
            "<li>cos 300°</li>" +
            "</ol></li>" +
            "<li>Nyatakan perbandingan trigonometri berikut ini dalam perbandingan trigonometri sudut lancip!"+
            "<ol type='a'>"+
            "<li>sin 135°</li>" +
            "<li>cos 150°</li>" +
            "<li>tan 97°</li>" +
            "<li>cot 160°</li>" +
            "<li>sec 130°</li>" +
            "<li>cosec 147°</li>" +
            "</ol></li>" +
            "<li>Dengan menggunakan rumus perbandingan triogonometri untuk sudut (90° + α°) hitunglah nilai dari setiap perbandingan trigonometri berikut ini!" + "<ol type='a'>" +
            "<li>sin 135°</li>" +
            "<li>cos 150°</li>" +
            "<li>tan 120°</li>" +
            "</ol></li></ol>" +

            "<strong>Penyelesaian</strong>\n" +
            "<ol>" +
            "<li>Sin 210°<br />\n" +
            "Sudut 210° terletak pada kuadran III (sin bernilai negatif), sehingga\n" +
            "Sin 210° = sin (180+30)° = -sin 30° = \\(\\frac{-1}{2}\\)<br />\n" +
            "Cos 120°<br />\n" +
            "Sudut 120° terletak pada kuadran II (cos bernilai negatif), sehingga\n" +
            "Cos 120° = cos (180–60)° = -cos 60° = \\(\\frac{-1}{2}\\)<br />\n" +
            "Tan 225°<br />\n" +
            "Sudut 225° terletak pada kuadran III (tan bernilai positif), sehingga\n" +
            "Tan 225° = tan (180+45)° = tan 45 = 1<br />\n" +
            "Cos 300°<br />\n" +
            "Sudut 300° terletak pada kuadran IV (cos bernilai positif), sehingga\n" +
            "Cos 300° = cos (360–60)° = cos 60° = \\(\\frac{1}{2}\\)<br /></li>\n" +
            "<li>Sudut lancip merupakan sudut yang berada pada kuadran I sehingga sudut pada soal harus kita ubah menjadi sudut kuadran I " +
            "dengan mengunakan rumus untuk sudut (90° + α°). Ingat bahwa untuk sudut kuadran II hanya sinus dan cosecan yang bernilai positif<br />" +
            "sin 135° = sin (90°+45°) → 135° = cos 45° jadi sin 135° = cos 45°<br />" +
            "cos 150° = cos (90°+60°) → 150° = -sin 60° jadi cos 150° = -sin 60°<br />" +
            "tan 97° = tan (90°+7°) → 97° = -cot 7° jadi tan 97° = -cot 7°<br />" +
            "cot 160° = cos (90°+70°) → 160° = -tan 60° jadi cot 150° = -tan 70°<br />" +
            "sec 130° = sec (90°+40°) → 130° = -cosec 40° jadi sec 150° = -cosec 40°<br />" +
            "cosec 147° = cosec (90°+57°) → 147° = sec 57° jadi cosec 147° = sec 57°<br /></li>" +
            "<li>Rumus perbandingan triogonometri untuk sudut (90°+α°)<br />" +
            "sin 135° = sin (90°+45°) → 135° = cos 45° jadi, sin 135° = \\(\\frac{1}{2} \\sqrt{2}\\)<br />\n" +
            "cos 150° = -sin (90°+60°) → 150° = -sin 60° jadi, sin 150° = \\(\\frac{-1}{2} \\sqrt{3}\\)\n" +
            "tan 120° = -cot (90°+30°) → 135° = -cot 30° jadi, sin 135° = \\(-\\sqrt{3}\\)</li>" +
            "</body>\n" +
            "</html>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab5);
        Toolbar toolbar5 = (Toolbar) findViewById(R.id.toolbar5);
        toolbar5.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar5);
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
        texbab5 = (MathView) findViewById(R.id.tex_bab5);
        texbab5.setText(tex);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item5){
        switch (item5.getItemId()){
            case R.id.kuis:
                buttonmusic();
                Intent intentkuisbab4 = new Intent(bab5.this, QuizBab4.class);
                startActivity(intentkuisbab4);
                return true;

            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(bab5.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);

            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(bab5.this, beranda.class);
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
        return super.onOptionsItemSelected(item5);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(bab5.this, materi.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
