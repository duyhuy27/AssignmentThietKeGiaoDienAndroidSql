package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Pay.PayFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Revenue.RevenueFragment;

public class PageAdaperInInput extends FragmentStateAdapter {

    public PageAdaperInInput(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PayFragment();
            case 1:
                return new RevenueFragment();
            default:
                return new PayFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

