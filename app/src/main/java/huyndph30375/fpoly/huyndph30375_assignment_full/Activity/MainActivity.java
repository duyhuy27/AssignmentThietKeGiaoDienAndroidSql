package huyndph30375.fpoly.huyndph30375_assignment_full.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2.MyViewPageAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.options.HelpFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.options.PolicyFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.options.SettingFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.options.SetupPocketFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyViewPageAdapter myViewPageAdapter;
    private  Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myViewPageAdapter = new MyViewPageAdapter(this);
        binding.viewPager.setAdapter(myViewPageAdapter);
        getSupportActionBar();
        HandleSwipeEvent();
        getSupport();
    }

    private void HandleSwipeEvent() {
        binding.bottomNavigationBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    binding.viewPager.setCurrentItem(0);
                }
                else if (id == R.id.input){
                    binding.viewPager.setCurrentItem(1);
                }
                else if (id == R.id.statics){
                    binding.viewPager.setCurrentItem(2);
                }
                return true;
            }
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        binding.bottomNavigationBar.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNavigationBar.getMenu().findItem(R.id.input).setChecked(true);
                        break;
                    case 2:
                        binding.bottomNavigationBar.getMenu().findItem(R.id.statics).setChecked(true);
                        break;
                }
            }
        });
    }

    private void getSupport(){
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){
                    case R.id.dashboard:
                    case R.id.Notifications:
                    case R.id.setup:
                    case R.id.setting:
                    case R.id.policy:
                        Opendialog1();
                        AppCompatButton negative_action = dialog.findViewById(R.id.negative_action);
                        negative_action.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        break;
                    case R.id.help:
                        startActivity(new Intent(getApplicationContext(), WebActivity.class));
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    private void Opendialog1() {
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_maintacne);
        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
    }

    private void ReplayFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.framLayout, fragment);
        ft.commit();
    }

}