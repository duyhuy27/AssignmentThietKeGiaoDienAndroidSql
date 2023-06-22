package huyndph30375.fpoly.huyndph30375_assignment_full.Activity.signIn;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.UserDatabase;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private UserDatabase database;
    private Dialog dialog;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = new UserDatabase(this);


        binding.buttonSignUp.setOnClickListener(v -> {
            String name = binding.inputName.getText().toString();
            String email = binding.inputEmail.getText().toString();
            String password = binding.inputPassword.getText().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Opendialog2();
                TextView title1 = dialog.findViewById(R.id.title);
                title1.setText("Data id not Empty");
            }
            else {
                Boolean checkUserEmail = database.checkEmail(email);
                    if (!checkUserEmail){
                        Boolean insert = database.insertData(email, password, name);
                        if (insert){
                            Opendialog();
                            AppCompatButton pogative_action1 = dialog.findViewById(R.id.pogative_action);
                            AppCompatButton negative_action1 = dialog.findViewById(R.id.negative_action);
                            pogative_action1.setOnClickListener(v12 -> startActivity(new Intent(RegisterActivity.this , SignActivity.class)));
                            negative_action1.setOnClickListener(v1 -> dialog.dismiss());
                        }
                        else {
                            Opendialog1();
                            TextView title = dialog.findViewById(R.id.title);
                            AppCompatButton negative_action = dialog.findViewById(R.id.negative_action);
                            title.setText("Registration failed, please try again !");
                            negative_action.setOnClickListener(v13 -> dialog.dismiss());
                        }
                    }
                    else {
                       Opendialog1();
                        TextView title = dialog.findViewById(R.id.title);
                        AppCompatButton negative_action = dialog.findViewById(R.id.negative_action);

                        title.setText("User already exists, please try again!");
                        negative_action.setOnClickListener(v13 -> dialog.dismiss());
                    }
            }
        });
    }
    private void Opendialog() {
        dialog = new Dialog(RegisterActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sign_up);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
    }

    private void Opendialog1() {
        dialog = new Dialog(RegisterActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_maintacne);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
    }

    private void Opendialog2() {
        dialog = new Dialog(RegisterActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ok_primary);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
        new Handler().postDelayed(() -> {
            if (dialog!=null && dialog.isShowing()){
                dialog.dismiss();
            }
        },1000);
    }
}
