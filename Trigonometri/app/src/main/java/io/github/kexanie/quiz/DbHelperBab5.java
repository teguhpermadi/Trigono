package io.github.kexanie.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelperBab5 extends SQLiteOpenHelper {
 private static final int DATABASE_VERSION = 30;
 // Database Name
 private static final String DATABASE_NAME = "QuizBab5";
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
 public DbHelperBab5(Context context) {
  super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }
 @Override
 public void onCreate(SQLiteDatabase dbbab5) {
  dbase = dbbab5;
  String sqlbab5 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
    + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
    +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
  dbbab5.execSQL(sqlbab5);
  addQuestionBab5();
  //dbbab5.close();
 }

    private void addQuestionBab5() {
        Question q1 = new Question("1. Jika sin A = 6/7, maka nilai dari tan A adalah ...","a. 6/√13" , "b. 7/√13" , "c. 7/6" , "d. √13/7", "a. 6/√13");
        this.addQuestionBab5(q1);
        Question q2 = new Question("2. Jika tan B = 12/13, maka nilai dari cos B adalah ...","a. 12/√313" , "b. 5/13" , "c. 13/√313" , "d. 5/12", "c. 13/√313");
        this.addQuestionBab5(q2);
  Question q3 = new Question("3. Jika cot D = 7/5, maka nilai dari csc D adalah ...","a. √74/5" , "b. √24/5" , "c. 5/√24" , "d. 5/√74", "a. √74/5");
        this.addQuestionBab5(q3);
  Question q4 = new Question("4. Jika sec F = 15/4, maka nilai dari sin F adalah ...","a. √212/15" , "b. 15/√221" , "c. 4/√221" , "d. √221/15", "d. √221/15");
        this.addQuestionBab5(q4);
  Question q5 = new Question("5. Jika sin A = 1/2, maka nilai dari A adalah ...°","a. 60" , "b. 45" , "c.	30" , "d. 0", "c. 30");
        this.addQuestionBab5(q5);
  Question q6 = new Question("6. Jika tan B = 0, maka nilai dari B adalah ...°" , "a. 0" , "b. 30" , "c.	45" , "d. 60", "a. 0");
        this.addQuestionBab5(q6);
  Question q7 = new Question("7. Jika cos C = 1/2 √2, maka nilai dari C adalah ...°","a. 30" , "b. 45" , "c. 60" , "d. 90", "b. 45");
        this.addQuestionBab5(q7);
  Question q8 = new Question("8. Jika csc E = 2/3 √3, maka nilai dari E adalah ...°","a. 90" , "b. 60" , "c. 45" , "d. 0", "b. 60");
        this.addQuestionBab5(q8);
  Question q9 = new Question("9. Nilai dari sin 600° adalah ...","a. -√2/3" , "b. -√3/2" , "c. √2/3" , "d. √3/2", "b. -√3/2");
        this.addQuestionBab5(q9);
  Question q10 = new Question("10. Nilai dari cos 450° adalah ...","a. √3/2" , "b. 0" , "c. √2/2" , "d. 1", "b. 0");
        this.addQuestionBab5(q10);
    }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
  // Drop older table if existed
  db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
  // Create tables again
  onCreate(db);
 }
 // Adding new question

    public void addQuestionBab5(Question quest) {
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

    public List<Question> getAllQuestionsBab5() {
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
