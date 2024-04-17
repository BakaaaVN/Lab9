package com.example.a2001216255_nguyenhoangtrung_lab9.qlsv.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KhoaHandler extends SQLiteOpenHelper {
    public static final String DB_NAME ="qlsv.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME="Khoa";
    private static final String MKHOA_COL="makhoa";
    private static final String TKHOA_COL="tenkhoa";
    public static String path = "/data/data/com.example.a2001216255_nguyenhoangtrung_lab9/db/qlsv.db";
    public KhoaHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
