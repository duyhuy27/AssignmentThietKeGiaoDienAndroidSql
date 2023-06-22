package huyndph30375.fpoly.huyndph30375_assignment_full.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.signIn.SignActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;

public class GuideActivity extends AppCompatActivity {
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        onCreateTableSQlite();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GuideActivity.this, SignActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 5000 is the delay in milliseconds for 5 seconds


    }
    private void onCreateTableSQlite(){
        sqLiteHelper = new SQLiteHelper(GuideActivity.this, "pay.db", null, 1);// khoi tao sqlite

        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS PAY (IdPay INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "NamePay NVARCHAR(100)," +
                "ImagePay INTEGER)");

        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS PAYMENT (IdPayment INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Date NVARCHAR(100)," +
                "Note NVARCHAR(100)," +
                "Money NVARCHAR(100)," +
                "Category NVARCHAR(100)," +
                "Sum NVARCHAR(100))");

        sqLiteHelper = new SQLiteHelper(GuideActivity.this, "revenue.db", null, 1);// khoi tao sqlite

        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS REVENUE ( IdRevenue INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NameRevenue NVARCHAR(100)," +
                "ImageRevenue INTEGER)");

        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS REVENUEMENT (IdRevenuement INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Date NVARCHAR(100)," +
                "Note NVARCHAR(100)," +
                "Money NVARCHAR(100)," +
                "Category NVARCHAR(100)," +
                "Sum NVARCHAR(100))");
    }
}