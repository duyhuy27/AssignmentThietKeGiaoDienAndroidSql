package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Input.InputFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Chart.StaticFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.HomeFragment;

public class MyViewPageAdapter extends FragmentStateAdapter {
    public MyViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new InputFragment();
            case 2:
                return new StaticFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
