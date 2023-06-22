package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Input;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.viewpager2.PageAdaperInInput;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentInputBinding;

public class InputFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentInputBinding binding = FragmentInputBinding.inflate(inflater, container, false);

        PageAdaperInInput inputTabAdapter = new PageAdaperInInput(requireActivity());

        binding.viewpageInput.setAdapter(inputTabAdapter);

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
