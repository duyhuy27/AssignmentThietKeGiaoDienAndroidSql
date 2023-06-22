package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay.ShowPaymentAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue.RevenueInformationAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.SeeAllActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements ShowPaymentAdapter.Ipays, RevenueInformationAdapter.Irevenue {

    private ArrayList<PayInforModels> payInforModelsArrayList;
    private ShowPaymentAdapter showPaymentAdapter;
    private PayInforModels payInforModels;

    private ArrayList<RevenueInforModels> revenueInforModelsArrayList;
    private RevenueInformationAdapter revenueInformationAdapter;
    private RevenueInforModels revenueInforModels;

    private SQLiteHelper sqLiteHelper;
    private SQLiteHelper revenueSQLiteHelper;
    private FragmentHomeBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        payInforModels = new PayInforModels();
        showPaymentAdapter = new ShowPaymentAdapter(this);
        payInforModelsArrayList = new ArrayList<>();

        revenueInformationAdapter = new RevenueInformationAdapter(this);
        revenueInforModels = new RevenueInforModels();
        revenueInforModelsArrayList = new ArrayList<>();

        sqLiteHelper = new SQLiteHelper(getContext(), "pay.db", null, 1);
        revenueSQLiteHelper = new SQLiteHelper(getContext(), "revenue.db", null, 1);
        ChangeToSeeAllTransaction();
        getDatafromDatabase();
        getDataFromDatabaseRevenue();
        innitRecyclerviewPayInfor();
        initRecyclerviewRevenueInformation();
//        ToggleListner();

        return binding.getRoot();
    }

    private void getDatafromDatabase() {
        payInforModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM PAYMENT ");
        double totalAmount = 0.0;
        while (cursor.moveToNext()){
            int idPayInfor = cursor.getInt(0);
            String title = cursor.getString(1);
            String date = cursor.getString(2);
            String money = cursor.getString(3);
            String category = cursor.getString(4);
            String sumPay = cursor.getString(5);
            totalAmount += Double.parseDouble(money);
            payInforModelsArrayList.add(new PayInforModels(idPayInfor, title, date, money, category, sumPay));
            Log.d("category", "getDatafromDatabase: " + category);
        }
        Collections.sort(payInforModelsArrayList, (obj1, obj2) -> obj1.getDate().compareTo(obj2.getDate()));
        Collections.reverse(payInforModelsArrayList);
        binding.totalRevenue.setText(String.format("Total Amount: %.2f", totalAmount));
    }

    private void getDataFromDatabaseRevenue(){
        revenueInforModelsArrayList.clear();
        Cursor cursor = revenueSQLiteHelper.getData("SELECT * FROM REVENUEMENT ");
        double totalRevenue = 0.0;
        while (cursor.moveToNext()){
            int iDrevenue = cursor.getInt(0);
            String note = cursor.getString(1);
            String date = cursor.getString(2);
            String money = cursor.getString(3);
            String category = cursor.getString(4);
            String SumRevenue = cursor.getString(5);
            totalRevenue += Double.parseDouble(money);
            revenueInforModelsArrayList.add(new RevenueInforModels(iDrevenue, note, date, money, category, SumRevenue));
        }
        Collections.sort(revenueInforModelsArrayList, (obj1, obj2) -> obj1.getDate().compareTo(obj2.getDate()));
        Collections.reverse(revenueInforModelsArrayList);
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
        String formattedAmount = currencyFormatter.format(totalRevenue);
        binding.totalRevenue.setText(formattedAmount);
    }


    private void innitRecyclerviewPayInfor() {
        binding.recyclerviewPaymentInformation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerviewPaymentInformation.setAdapter(showPaymentAdapter);
        getTotalAmount();
    }

    private void initRecyclerviewRevenueInformation(){
        binding.recyclerviewRevenuementInformation.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerviewRevenuementInformation.setAdapter(revenueInformationAdapter);
        getTotalRevenue();
    }

    @Override
    public int getCountPay() {
        return payInforModelsArrayList.size();
    }

    @Override
    public PayInforModels getDataPay(int position) {
        return payInforModelsArrayList.get(position);
    }

    @Override
    public void onClickItemPay(int position) {
        payInforModelsArrayList.get(position);
        Toast.makeText(getContext(), "Click oke", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClickDeletePay(int position) {
        int idPayInfor = payInforModelsArrayList.get(position).getIdPayment();
        sqLiteHelper.QueryData("DELETE FROM PAYMENT WHERE ID = " + idPayInfor);
        getDatafromDatabase();
        innitRecyclerviewPayInfor();
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

    private void getTotalRevenue(){
        Cursor cursor = revenueSQLiteHelper.getData("SELECT SUM(Money) FROM REVENUEMENT");
        if (cursor.moveToFirst()){
            double totalRevenue = cursor.getDouble(0);
            Locale vietnamLocale = new Locale("vi", "VN");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
            String formattedAmount = currencyFormatter.format(totalRevenue);
            binding.totalRevenue.setText(formattedAmount);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        revenueInforModelsArrayList.get(position);
        Toast.makeText(getContext(), "Click Revenue Oke", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnClickDeleteItem(int position) {

    }

    private void ChangeToSeeAllTransaction(){
        binding.seeAllTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });

        binding.seeAllPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });

        binding.seeAllRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}