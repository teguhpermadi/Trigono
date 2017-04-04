package io.github.kexanie.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelperBab3 extends SQLiteOpenHelper {
 private static final int DATABASE_VERSION = 30;
 // Database Name
 private static final String DATABASE_NAME = "QuizBab3";
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
 public DbHelperBab3(Context context) {
  super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }
 @Override
 public void onCreate(SQLiteDatabase dbbab3) {
  dbase = dbbab3;
  String sqlbab3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
  dbbab3.execSQL(sqlbab3);
  addQuestionBab3();
  //dbbab3.close();
 }

    private void addQuestionBab3() {
        Question q1 = new Question("1. Nilai csc A adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 5/4", "d. 5/4");
        this.addQuestionBab3(q1);
        Question q2 = new Question("2. Nilai csc B adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 5/4", "c. 5/3");
        this.addQuestionBab3(q2);
  Question q3 = new Question("3. Nilai tan A adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 3/4", "b. 4/5");
        this.addQuestionBab3(q3);
  Question q4 = new Question("4. Nilai tan B adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 3/4", "d. 3/4");
        this.addQuestionBab3(q4);
  Question q5 = new Question("5. Nilai cot A adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 3/4", "d. 3/4");
        this.addQuestionBab3(q5);
  Question q6 = new Question("6. Nilai cot B adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 3/4", "b. 4/5");
        this.addQuestionBab3(q6);
  Question q7 = new Question("7. Nilai sec A adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 5/4", "c. 5/3");
        this.addQuestionBab3(q7);
  Question q8 = new Question("8. Nilai sec B adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 5/4", "d. 5/4");
        this.addQuestionBab3(q8);
  Question q9 = new Question("9. Nilai cos A adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 5/4", "a. 3/5");
        this.addQuestionBab3(q9);
  Question q10 = new Question("10. Nilai cos B adalah ...","a. 3/5" , "b. 4/5" , "c. 5/3" , "d. 5/4", "b. 4/5");
        this.addQuestionBab3(q10);
    }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
  // Drop older table if existed
  db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
  // Create tables again
  onCreate(db);
 }
 // Adding new question

    public void addQuestionBab3(Question quest) {
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

    public List<Question> getAllQuestionsBab3() {
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
