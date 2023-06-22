package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.SeeAll;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay.ShowPaymentAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Update.UpdatePayragment;
import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.MainActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentSeeAllPayBinding;

public class SeeAllPayFragment extends Fragment implements ShowPaymentAdapter.Ipays{
    private FragmentSeeAllPayBinding binding;
    private SQLiteHelper sqLiteHelper;
    private Dialog dialog;

    private PayInforModels payInforModels;
    private ShowPaymentAdapter showPaymentAdapter;
    private ArrayList<PayInforModels> payInforModelsArrayList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSeeAllPayBinding.inflate(inflater, container, false);

        payInforModels = new PayInforModels();
        showPaymentAdapter = new ShowPaymentAdapter(this);
        payInforModelsArrayList = new ArrayList<>();


        sqLiteHelper = new SQLiteHelper(getContext(), "pay.db", null, 1);

        getDatafromDatabase();
        initRecyclerview();
        listener();

        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getDatafromDatabase() {
        payInforModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM PAYMENT ");
        while (cursor.moveToNext()){
            int idPayInfor = cursor.getInt(0);
            String title = cursor.getString(1);
            String date = cursor.getString(2);
            String money = cursor.getString(3);
            String category = cursor.getString(4);
            String sumPay = cursor.getString(5);
            payInforModelsArrayList.add(new PayInforModels(idPayInfor, title, date, money, category, sumPay));

            showPaymentAdapter.notifyDataSetChanged();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Collections.sort(payInforModelsArrayList, Comparator.comparing(PayInforModels::getDate));
        }
        Collections.reverse(payInforModelsArrayList);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerview() {
        binding.recyclerviewSeeAllPay.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerviewSeeAllPay.setAdapter(showPaymentAdapter);
        showPaymentAdapter.notifyDataSetChanged();
        getTotalAmount();
    }

    private void getTotalAmount() {
        Cursor cursor = sqLiteHelper.getData("SELECT SUM(Money) FROM PAYMENT");
        if (cursor.moveToFirst()) {
            double totalAmount = cursor.getDouble(0);
            Locale vietnamLocale = new Locale("vi", "VN");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
            String formattedAmount = currencyFormatter.format(totalAmount);
            binding.totalPay.setText(formattedAmount);
        }
        cursor.close();
    }

    @Override
    public int getCountPay() {
        return payInforModelsArrayList.size();
    }

    @Override
    public PayInforModels getDataPay(int position) {
        return  payInforModelsArrayList.get(position);
    }

    @Override
    public void onClickItemPay(int position) {
        payInforModels = payInforModelsArrayList.get(position);
        UpdatePayragment updateFragment = new UpdatePayragment();

        Bundle bundle = new Bundle();
        bundle.putInt("id", payInforModels.getIdPayment());
        updateFragment.setArguments(bundle);
        Log.d("Intent Data", "onClickItemPay: " + payInforModels.getIdPayment());

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContaner, updateFragment, "update_fragment")
                .addToBackStack(UpdatePayragment.ROOT_FRAGMENT_TAG)
                .commit();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClickDeletePay(int position) {
       payInforModels = payInforModelsArrayList.get(position);
       OpenDialogDelete();
        TextView details = dialog.findViewById(R.id.details);
        AppCompatButton delete_action = dialog.findViewById(R.id.delete_action);
        AppCompatButton cancel_action = dialog.findViewById(R.id.cancel_action);

        cancel_action.setOnClickListener(v -> dialog.dismiss());

        delete_action.setOnClickListener(v -> {
            sqLiteHelper.QueryData("DELETE FROM PAYMENT WHERE IdPayment = '" + payInforModels.getIdPayment() + "' ");
            dialog.dismiss();
            getDatafromDatabase();
            initRecyclerview();
            dialog.dismiss();
        });

        details.setText("' " + payInforModels.getNote() + " '");
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

    private void listener(){
        binding.imageBack.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        showPaymentAdapter.notifyDataSetChanged();
    }
}