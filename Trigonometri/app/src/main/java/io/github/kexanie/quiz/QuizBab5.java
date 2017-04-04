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
import io.github.kexanie.mathviewtest.bab4;
import io.github.kexanie.mathviewtest.bab5;
import io.github.kexanie.mathviewtest.bab6;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.musik.BackgroundSoundService;

public class QuizBab5 extends AppCompatActivity {

    List<Question> quesListBab5;
    ArrayList<String> soal,jawab,kunci;
    ArrayList<Integer> gambar;
    int score=0;
    int qid=0;
    Question currentQbab5;
    TextView soalbab5;

    RadioButton rda, rdb, rdc, rdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bab5);

        Toolbar toolbarkuisbab5 = (Toolbar) findViewById(R.id.toolbarkuisbab5);
       // toolbarkuisbab5.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarkuisbab5);
        toolbarkuisbab5.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuisbab5.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DbHelperBab5 dbbab5 = new DbHelperBab5(this);
        quesListBab5 = dbbab5.getAllQuestionsBab5();
        currentQbab5 = quesListBab5.get(qid);

        soalbab5 = (TextView) findViewById(R.id.soalbab5);

        rda=(RadioButton)findViewById(R.id.radio0bab5);
        rdb=(RadioButton)findViewById(R.id.radio1bab5);
        rdc=(RadioButton)findViewById(R.id.radio2bab5);
        rdd=(RadioButton)findViewById(R.id.radio3bab5);

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
        soalbab5.setText(currentQbab5.getQUESTION());
        rda.setText(currentQbab5.getOPTA());
        rdb.setText(currentQbab5.getOPTB());
        rdc.setText(currentQbab5.getOPTC());
        rdd.setText(currentQbab5.getOPTD());
        qid++;
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

    @Override
    protected void onResume(){
        setQuestionView();
        super.onResume();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.instrumen);
        mp.start();
    }
    Intent svc;
    public boolean onOptionsItemSelected(MenuItem item5){
        final RadioGroup grp5 = (RadioGroup)findViewById(R.id.radioGroup1bab5);
        switch (item5.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp5.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp_5 = (RadioGroup)findViewById(R.id.radioGroup1bab5);
                    RadioButton answer = (RadioButton)findViewById(grp_5.getCheckedRadioButtonId());
                    Log.d("yourans", currentQbab5.getANSWER()+" "+answer.getText());

                    if (currentQbab5.getANSWER().equals(answer.getText())){
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab5.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQbab5.getANSWER().toString());
                    } else {
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab5.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQbab5.getANSWER().toString());
                    };

                    if(currentQbab5.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);
                    } if(qid < 10){
                        currentQbab5 = quesListBab5.get(qid);
                        setQuestionView();
                        grp_5.clearCheck();
                    } else{
                        Intent intent = new Intent(QuizBab5.this, ResultActivityBab.class);
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
                Intent i = new Intent(QuizBab5.this, bab6.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return super.onOptionsItemSelected(item5);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizBab5.this, bab6.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}
