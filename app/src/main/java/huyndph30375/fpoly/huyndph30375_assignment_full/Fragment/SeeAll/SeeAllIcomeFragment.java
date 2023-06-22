package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.SeeAll;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue.RevenueInformationAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Update.UpdateIncomeFragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Update.UpdatePayragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.MainActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentSeeAllIcomeBinding;


public class SeeAllIcomeFragment extends Fragment implements RevenueInformationAdapter.Irevenue{

    private FragmentSeeAllIcomeBinding binding;
    private SQLiteHelper sqLiteHelper;
    private Dialog dialog;

    private RevenueInforModels revenueInforModels;
    private ArrayList<RevenueInforModels> revenueInforModelsArrayList;
    private RevenueInformationAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSeeAllIcomeBinding.inflate(inflater, container, false);


        revenueInforModels = new RevenueInforModels();
        revenueInforModelsArrayList = new ArrayList<>();
        adapter = new RevenueInformationAdapter(this);

        sqLiteHelper = new SQLiteHelper(getContext(), "revenue.db", null , 1);
        getDataFromDatabase();
        initRecyclerviewIncome();
        listener();
        return binding.getRoot();
    }

    private void initRecyclerviewIncome() {
        binding.recyclerviewSeeAllIncome.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerviewSeeAllIncome.setAdapter(adapter);
        setTotalIncome();
    }

    private void setTotalIncome() {
        Cursor cursor = sqLiteHelper.getData("SELECT SUM(Money) FROM REVENUEMENT ");
        if (cursor.moveToFirst()){
            double totalInCome = cursor.getDouble(0);
            Locale vietnamLocale = new Locale("vi", "VN");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
            String formattedAmount = currencyFormatter.format(totalInCome);
            binding.seeAllIncome.setText(formattedAmount);
        }
        cursor.close();
    }

    private void getDataFromDatabase() {
        revenueInforModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM REVENUEMENT ");
        while (cursor.moveToNext()){
            int iDrevenue = cursor.getInt(0);
            String note = cursor.getString(1);
            String date = cursor.getString(2);
            String money = cursor.getString(3);
            String category = cursor.getString(4);
            String SumRevenue = cursor.getString(5);
            revenueInforModelsArrayList.add(new RevenueInforModels(iDrevenue, note, date, money, category,SumRevenue));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Collections.sort(revenueInforModelsArrayList, Comparator.comparing(RevenueInforModels::getDate));
        }
        Collections.reverse(revenueInforModelsArrayList);
    }

    private void listener() {
        binding.imageBack.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public int getCountRevueInfor() {
        return revenueInforModelsArrayList.size();
    }

    @Override
    public RevenueInforModels getDataRevenue(int position) {
        return revenueInforModelsArrayList.get(position);
    }

    @Override
    public void OnClickItemRevenueInfor(int position) {
        revenueInforModels = revenueInforModelsArrayList.get(position);
        UpdateIncomeFragment updateIncomeFragment = new UpdateIncomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", revenueInforModels.getIdRevenueInfor());
        updateIncomeFragment.setArguments(bundle);

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContaner, updateIncomeFragment, "update_fragment")
                .addToBackStack(UpdatePayragment.ROOT_FRAGMENT_TAG)
                .commit();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void OnClickDeleteItem(int position) {
        revenueInforModels = revenueInforModelsArrayList.get(position);
        OpenDialogDelete();
        TextView details = dialog.findViewById(R.id.details);
        AppCompatButton delete_action = dialog.findViewById(R.id.delete_action);
        AppCompatButton cancel_action = dialog.findViewById(R.id.cancel_action);

        cancel_action.setOnClickListener(v -> dialog.dismiss());

        delete_action.setOnClickListener(v -> {
            sqLiteHelper.QueryData("DELETE FROM REVENUEMENT WHERE IdRevenuement = '" + revenueInforModels.getIdRevenueInfor() + "' ");
            dialog.dismiss();
            getDataFromDatabase();
            initRecyclerviewIncome();
            dialog.dismiss();
        });

        details.setText("' " + revenueInforModels.getNote() + " '");

    }
    private void OpenDialogDelete() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_delete_item);
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

}