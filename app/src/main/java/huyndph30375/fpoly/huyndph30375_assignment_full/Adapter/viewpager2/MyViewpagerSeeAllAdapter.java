package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.SeeAll.SeeAllIcomeFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.SeeAll.SeeAllPayFragment;

public class MyViewpagerSeeAllAdapter extends FragmentStateAdapter {

    public MyViewpagerSeeAllAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new SeeAllPayFragment();
            case 1:
                return new SeeAllIcomeFragment();
            default:
                return new SeeAllPayFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
