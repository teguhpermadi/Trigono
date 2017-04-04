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
import io.github.kexanie.mathviewtest.bab3;
import io.github.kexanie.mathviewtest.bab4;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.musik.BackgroundSoundService;

public class QuizBab3 extends AppCompatActivity {

    List<Question> quesListBab3;
    ArrayList<String> soal,jawab, kunci;
    ArrayList<Integer> gambar;
    int score=0;
    int qid=0;
    Question currentQbab3;
    TextView soalbab3;

    RadioButton rda, rdb, rdc, rdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bab3);

        Toolbar toolbarkuisbab3 = (Toolbar) findViewById(R.id.toolbarkuisbab3);
      //  toolbarkuisbab3.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarkuisbab3);
        toolbarkuisbab3.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuisbab3.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DbHelperBab3 dbbab3 = new DbHelperBab3(this);
        quesListBab3 = dbbab3.getAllQuestionsBab3();
        currentQbab3 = quesListBab3.get(qid);

        soalbab3 = (TextView) findViewById(R.id.soalbab3);

        rda=(RadioButton)findViewById(R.id.radio0bab3);
        rdb=(RadioButton)findViewById(R.id.radio1bab3);
        rdc=(RadioButton)findViewById(R.id.radio2bab3);
        rdd=(RadioButton)findViewById(R.id.radio3bab3);

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
        soalbab3.setText(currentQbab3.getQUESTION());
        rda.setText(currentQbab3.getOPTA());
        rdb.setText(currentQbab3.getOPTB());
        rdc.setText(currentQbab3.getOPTC());
        rdd.setText(currentQbab3.getOPTD());
        qid++;
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
    public boolean onOptionsItemSelected(MenuItem item3){
        final RadioGroup grp3 = (RadioGroup)findViewById(R.id.radioGroup1bab3);
        switch (item3.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp3.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp_3 = (RadioGroup)findViewById(R.id.radioGroup1bab3);
                    RadioButton answer = (RadioButton)findViewById(grp_3.getCheckedRadioButtonId());
                    Log.d("yourans", currentQbab3.getANSWER()+" "+answer.getText());

                    if (currentQbab3.getANSWER().equals(answer.getText())){
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab3.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQbab3.getANSWER().toString());
                    } else {
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab3.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQbab3.getANSWER().toString());
                    };

                    if(currentQbab3.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);

                    } if(qid < 10){
                        currentQbab3 = quesListBab3.get(qid);
                        setQuestionView();
                        grp_3.clearCheck();

                    } else{
                        Intent intent = new Intent(QuizBab3.this, ResultActivityBab.class);
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
                Intent i = new Intent(QuizBab3.this, bab4.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return super.onOptionsItemSelected(item3);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizBab3.this, bab4.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}
