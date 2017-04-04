package io.github.kexanie.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.kexanie.mathviewtest.R;
import io.github.kexanie.mathviewtest.bab5;
import io.github.kexanie.mathviewtest.bab6;
import io.github.kexanie.mathviewtest.bab7;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.musik.BackgroundSoundService;

public class QuizBab6 extends AppCompatActivity {

    List<Question> quesListBab6;
    ArrayList<String> soal,jawab, kunci;
    ArrayList<Integer> gambar;
    int score=0;
    int qid=0;
    Question currentQbab6;
    TextView soalbab6;
    ImageView img1, img2, img3, img4;

    RadioButton rda, rdb, rdc, rdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bab6);

        Toolbar toolbarkuisbab6 = (Toolbar) findViewById(R.id.toolbarkuisbab6);
       // toolbarkuisbab6.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarkuisbab6);
        toolbarkuisbab6.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuisbab6.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DbHelperBab6 dbbab6 = new DbHelperBab6(this);
        quesListBab6 = dbbab6.getAllQuestionsBab6();
        currentQbab6 = quesListBab6.get(qid);

        soalbab6 = (TextView) findViewById(R.id.soalbab6);

        rda=(RadioButton)findViewById(R.id.radio0bab6);
        rdb=(RadioButton)findViewById(R.id.radio1bab6);
        rdc=(RadioButton)findViewById(R.id.radio2bab6);
        rdd=(RadioButton)findViewById(R.id.radio3bab6);

        img1 = (ImageView)findViewById(R.id.img1bab6);
        img2 = (ImageView)findViewById(R.id.img2bab6);
        img3 = (ImageView)findViewById(R.id.img3bab6);
        img4 = (ImageView)findViewById(R.id.img4bab6);

        soal = new ArrayList<String>();
        jawab = new ArrayList<String>();
        gambar = new ArrayList<Integer>();
        kunci = new ArrayList<String>();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kuis, menu);
        return true;
    }
    private void setQuestionView()
    {
        soalbab6.setText(currentQbab6.getQUESTION());
        rda.setText(currentQbab6.getOPTA());
        rdb.setText(currentQbab6.getOPTB());
        rdc.setText(currentQbab6.getOPTC());
        rdd.setText(currentQbab6.getOPTD());
        qid++;

        if(qid == 1){
            img1.setImageResource(R.mipmap.soal1bab6);
            img1.setVisibility(View.VISIBLE);
        }else if(qid == 2){
            img1.setImageResource(R.mipmap.soal2bab6);
            img1.setVisibility(View.VISIBLE);
        }else if(qid == 3){
            img1.setImageResource(R.mipmap.soal3bab6);
            img1.setVisibility(View.VISIBLE);
        }else if(qid == 4){
            img1.setImageResource(R.mipmap.soal4abab6);
            img2.setImageResource(R.mipmap.soal4bbab6);
            img3.setImageResource(R.mipmap.soal4cbab6);
            img4.setImageResource(R.mipmap.soal4dbab6);
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);
        }else if(qid == 5){
            img1.setImageResource(R.mipmap.soal5bab6);
            img1.setVisibility(View.VISIBLE);
        }else if(qid == 6){
            img1.setImageResource(R.mipmap.soal6bab6);
            img1.setVisibility(View.VISIBLE);
        }else if(qid == 7){
            img1.setImageResource(R.mipmap.soal7abab6);
            img2.setImageResource(R.mipmap.soal7bbab6);
            img3.setImageResource(R.mipmap.soal7cbab6);
            img4.setImageResource(R.mipmap.soal7dbab6);
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);
        }else if(qid == 8){
            img1.setImageResource(R.mipmap.soal8bab6);
            img1.setVisibility(View.VISIBLE);
        }else if(qid == 9){
            img1.setImageResource(R.mipmap.soal9abab6);
            img2.setImageResource(R.mipmap.soal9bbab6);
            img3.setImageResource(R.mipmap.soal9cbab6);
            img4.setImageResource(R.mipmap.soal9dbab6);
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);
        }else if(qid == 10){
            img1.setImageResource(R.mipmap.soal10abab6);
            img2.setImageResource(R.mipmap.soal10bbab6);
            img3.setImageResource(R.mipmap.soal10cbab6);
            img4.setImageResource(R.mipmap.soal10dbab6);
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);
        } else {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
            img4.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume(){
        setQuestionView();
        super.onResume();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.instrumen);
        mp.start();
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }
    Intent svc;
    public boolean onOptionsItemSelected(MenuItem item6){
        final RadioGroup grp6 = (RadioGroup)findViewById(R.id.radioGroup1bab6);
        switch (item6.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp6.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp_6 = (RadioGroup)findViewById(R.id.radioGroup1bab6);
                    RadioButton answer = (RadioButton)findViewById(grp_6.getCheckedRadioButtonId());
                    Log.d("yourans", currentQbab6.getANSWER()+" "+answer.getText());

                    if (currentQbab6.getANSWER().equals(answer.getText())){
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab6.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQbab6.getANSWER().toString());
                    } else {
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab6.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQbab6.getANSWER().toString());
                    };

                    if(currentQbab6.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);;
                    } if(qid < 10){
                        currentQbab6 = quesListBab6.get(qid);
                        setQuestionView();
                        grp_6.clearCheck();
                    } else{
                        Intent intent = new Intent(QuizBab6.this, ResultActivityBab.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        b.putStringArrayList("soal",soal);
                        b.putStringArrayList("jawab",jawab);
                        b.putIntegerArrayList("gambar",gambar);
                        b.putStringArrayList("kunci",kunci);
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }
                return true;
            case android.R.id.home:
                Intent i = new Intent(QuizBab6.this, bab7.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return super.onOptionsItemSelected(item6);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizBab6.this, bab7.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}
