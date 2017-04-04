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
import io.github.kexanie.mathviewtest.bab1;
import io.github.kexanie.mathviewtest.bab4;
import io.github.kexanie.mathviewtest.bab5;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.musik.BackgroundSoundService;

public class QuizBab4 extends AppCompatActivity {

    List<Question> quesListBab4;
    ArrayList<String> soal,jawab,kunci;
    ArrayList<Integer> gambar;
    int score=0;
    int qid=0;
    Question currentQbab4;
    ImageView img1, img2, img3;
    TextView soalbab4;

    RadioButton rda, rdb, rdc, rdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bab4);

        Toolbar toolbarkuisbab4 = (Toolbar) findViewById(R.id.toolbarkuisbab4);
       // toolbarkuisbab4.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarkuisbab4);
        toolbarkuisbab4.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuisbab4.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DbHelperBab4 dbbab4 = new DbHelperBab4(this);
        quesListBab4 = dbbab4.getAllQuestionsBab4();
        currentQbab4 = quesListBab4.get(qid);

        soalbab4 = (TextView) findViewById(R.id.soalbab4);

        rda=(RadioButton)findViewById(R.id.radio0bab4);
        rdb=(RadioButton)findViewById(R.id.radio1bab4);
        rdc=(RadioButton)findViewById(R.id.radio2bab4);
        rdd=(RadioButton)findViewById(R.id.radio3bab4);

        img1 = (ImageView)findViewById(R.id.img1bab4);
        img2 = (ImageView)findViewById(R.id.img2bab4);
        img3 = (ImageView)findViewById(R.id.img3bab4);

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
        soalbab4.setText(currentQbab4.getQUESTION());
        rda.setText(currentQbab4.getOPTA());
        rdb.setText(currentQbab4.getOPTB());
        rdc.setText(currentQbab4.getOPTC());
        rdd.setText(currentQbab4.getOPTD());
        qid++;

        if(qid < 7){
            img1.setImageResource(R.mipmap.soal1_6_1);
            img2.setImageResource(R.mipmap.soal1_6_2);
            img3.setImageResource(R.mipmap.soal1_6_3);
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
        } else {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
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
    public boolean onOptionsItemSelected(MenuItem item4){
        final RadioGroup grp4 = (RadioGroup)findViewById(R.id.radioGroup1bab4);
        switch (item4.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp4.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp_4 = (RadioGroup)findViewById(R.id.radioGroup1bab4);
                    RadioButton answer = (RadioButton)findViewById(grp_4.getCheckedRadioButtonId());
                    Log.d("yourans", currentQbab4.getANSWER()+" "+answer.getText());

                    if (currentQbab4.getANSWER().equals(answer.getText())){
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab4.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQbab4.getANSWER().toString());
                    } else {
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab4.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQbab4.getANSWER().toString());
                    };

                    if(currentQbab4.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);

                    } if(qid < 10){
                        currentQbab4 = quesListBab4.get(qid);
                        setQuestionView();
                        grp_4.clearCheck();

                    } else{
                        Intent intent = new Intent(QuizBab4.this, ResultActivityBab.class);
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
                Intent i = new Intent(QuizBab4.this, bab5.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return super.onOptionsItemSelected(item4);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizBab4.this, bab5.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}
