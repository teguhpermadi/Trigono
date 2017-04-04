package io.github.kexanie.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelperBab4 extends SQLiteOpenHelper {
 private static final int DATABASE_VERSION = 30;
 // Database Name
 private static final String DATABASE_NAME = "QuizBab4";
 // tasks table name
 private static final String TABLE_QUEST = "quest";
 // tasks Table Columns names
 private static final String KEY_ID = "id";
 private static final String KEY_QUES = "question";
 private static final String KEY_ANSWER = "answer"; //correct option
 private static final String KEY_OPTA= "opta"; //option a
 private static final String KEY_OPTB= "optb"; //option b
 private static final String KEY_OPTC= "optc"; //option c
 private static final String KEY_OPTD= "optd"; //option d

    private SQLiteDatabase dbase;
 public DbHelperBab4(Context context) {
  super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }
 @Override
 public void onCreate(SQLiteDatabase dbbab4) {
  dbase = dbbab4;
  String sqlbab4 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
  dbbab4.execSQL(sqlbab4);
  addQuestionBab4();
  //dbbab4.close();
 }

    private void addQuestionBab4() {
        Question q1 = new Question("1. Nilai cos α adalah ...","a. -4/5" , "b. -3/5" , "c. 4/5" , "d. 3/5", "a. -4/5");
        this.addQuestionBab4(q1);
        Question q2 = new Question("2. Nilai sin β adalah ...","a. -8/10" , "b. -6/10" , "c. 6/10" , "d. 8/10", "b. -6/10");
        this.addQuestionBab4(q2);
  Question q3 = new Question("3. Nilai tan γ adalah ...","a. -5/12" , "b. -12/5" , "c. 5/12" , "d. 12/5", "d. 12/5");
        this.addQuestionBab4(q3);
  Question q4 = new Question("4. Nilai cot α adalah ...","a. -4/3" , "b. -3/4" , "c. 3/4" , "d. 4/3", "d. 4/3");
        this.addQuestionBab4(q4);
  Question q5 = new Question("5. Nilai sec β adalah ...","a. -10/6" , "b. -10/8" , "c. 10/8" , "d. 10/6", "c. 10/8");
        this.addQuestionBab4(q5);
  Question q6 = new Question("6. Nilai csc γ adalah ...","a. -13/5" , "b. -13/12" , "c. 13/5" , "d. 13/12", "d. 13/12");
        this.addQuestionBab4(q6);
  Question q7 = new Question("7. Titik C(9,-7), nilai csc C adalah ...","a. -√130/7" , "b. -√130/9" , "c. √130/7" , "d. √130/9", "a. -√130/7");
        this.addQuestionBab4(q7);
  Question q8 = new Question("8. Titik D(-7,-2), nilai cos D adalah ...","a. -7/√53" , "b. -2/√53" , "c. 2/√53" , "d. 7/√53", "a. -7/√53");
        this.addQuestionBab4(q8);
  Question q9 = new Question("9. Titik Q berada di kuadran I dan csc Q = 13/12, nilai tan Q adalah ...","a. 5/12" , "b. 12/5" , "c. 5/13" , "d. 13/5", "b. 12/5");
        this.addQuestionBab4(q9);
  Question q10 = new Question("10. Titik R berada di kuadran III dan cot R = 6/8, nilai sin R adalah ...","a. -8/10" , "b. -6/10" , "c. -10/8" , "d. -10/6", "a. -8/10");
        this.addQuestionBab4(q10);
    }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
  // Drop older table if existed
  db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
  // Create tables again
  onCreate(db);
 }
 // Adding new question

    public void addQuestionBab4(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestionsBab4() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

 public int rowcount(){
  int row;
  String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
  SQLiteDatabase db = this.getWritableDatabase();
  Cursor cursor = db.rawQuery(selectQuery, null);
  row=cursor.getCount();
  return row;
 }

}
