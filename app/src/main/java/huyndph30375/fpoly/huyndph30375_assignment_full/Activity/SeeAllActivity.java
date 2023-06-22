package huyndph30375.fpoly.huyndph30375_assignment_full.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2.MyViewpagerSeeAllAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.SeeAll.SeeAllIcomeFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.SeeAll.SeeAllPayFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ActivitySeeAllBinding;

public class SeeAllActivity extends AppCompatActivity {

    private ActivitySeeAllBinding binding;
    private MyViewpagerSeeAllAdapter allAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeeAllBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.framLayout, SeeAllPayFragment.class, null).commit();

        binding.bottomNavigationBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.Pay:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framLayout, SeeAllPayFragment.class, null).commit();

                        return true;
                    case R.id.Revenue:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framLayout, SeeAllIcomeFragment.class, null).commit();
                        return true;
                }
                return false;
            }
        });

    }


}