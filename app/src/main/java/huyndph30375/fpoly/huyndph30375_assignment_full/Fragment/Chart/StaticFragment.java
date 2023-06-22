package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Chart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2.PageAdapterStatic;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentStaticBinding;


public class StaticFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentStaticBinding binding = FragmentStaticBinding.inflate(inflater, container, false);

        PageAdapterStatic adapterStatic = new PageAdapterStatic(requireActivity());

        binding.viewpageInput.setAdapter(adapterStatic);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout, binding.viewpageInput, true, true, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Expense");
                    break;
                case 1:
                    tab.setText("Income");
                    break;
            }
        });
        tabLayoutMediator.attach();


        return binding.getRoot();
    }
}