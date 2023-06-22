package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Chart.PieChartFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Chart.PireChartRevenueFragment;

public class PageAdapterStatic extends FragmentStateAdapter {

    public PageAdapterStatic(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PieChartFragment();
            case 1:
                return new PireChartRevenueFragment();
            default:
                return new PieChartFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
