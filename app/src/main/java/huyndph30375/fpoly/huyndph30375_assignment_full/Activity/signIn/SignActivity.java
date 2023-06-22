package huyndph30375.fpoly.huyndph30375_assignment_full.Activity.signIn;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.MainActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.UserDatabase;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ActivitySignBinding;

public class SignActivity extends AppCompatActivity {
    private ActivitySignBinding binding;
    private UserDatabase database;
    private Dialog dialog;

    private SharedPreferences sharedPrefs;
    private boolean rememberPassword;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = new UserDatabase(this);
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        binding.textViewSignUp.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));

        binding.buttonSignIn.setOnClickListener(v -> {
            String email = binding.inputEmail.getText().toString();
            String password = binding.inputPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()){
                Opendialog2();
                TextView title1 = dialog.findViewById(R.id.title);
                title1.setText("Data id not Empty");
            }
            else {
                Boolean checkCredentials = database.checkEmailPassword(email, password);

                if (checkCredentials){
                    // Save email and password to shared preferences if checkbox is checked
                    if (rememberPassword) {
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.putBoolean("rememberPassword", rememberPassword);
                        editor.apply();
                    }

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                else{
                    Opendialog1();
                    TextView title = dialog.findViewById(R.id.title);
                    AppCompatButton negative_action = dialog.findViewById(R.id.negative_action);
                    title.setText("Sign in failed, please try again !");
                    negative_action.setOnClickListener(v13 -> dialog.dismiss());
                }
            }
        });

        binding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> rememberPassword = isChecked);

        // Set checkbox state based on shared preferences
        rememberPassword = sharedPrefs.getBoolean("rememberPassword", false);
        binding.checkbox.setChecked(rememberPassword);

        if (rememberPassword) {
            String email = sharedPrefs.getString("email", "");
            String password = sharedPrefs.getString("password", "");
            binding.inputEmail.setText(email);
            binding.inputPassword.setText(password);
        }
    }
    private void Opendialog2() {
        dialog = new Dialog(SignActivity.this);
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

    private void Opendialog1() {
        dialog = new Dialog(SignActivity.this);
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
}
