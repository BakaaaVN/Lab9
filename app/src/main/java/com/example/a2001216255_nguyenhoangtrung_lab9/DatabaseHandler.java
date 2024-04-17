package com.example.a2001216255_nguyenhoangtrung_lab9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "productsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "products";
    private static String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_QUATITY = "quantity";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_product_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_QUATITY);
        db.execSQL(create_product_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_product_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_product_table);
        onCreate(db);
    }

    public void addProducts(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_QUATITY, product.getQuantity());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Product getProduct(int productID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,KEY_ID + "=?", new String[] {String.valueOf(productID)}, null, null, null);
        if(cursor == null) {
            cursor.moveToFirst();
        }
        Product product = new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        return product;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            Product product = new Product(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            list.add(product);
            cursor.moveToNext();
        }
        return list;
    }
    public void updateProduct(Product product) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,product.getName());
        values.put(KEY_QUATITY,product.getQuantity());
        db.update(TABLE_NAME,values,KEY_ID="?",new String[]{String.valueOf(product.getId())});
        db.close();
    }
    public void deleteProduct(int productID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + "= ?", new String[] {String.valueOf(productID)});
        db.close();
    }
}
