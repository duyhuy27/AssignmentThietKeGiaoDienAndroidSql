package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Update;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue.IconRevenueAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.IconRevenueModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue.RevenueAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueCategoryModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.SeeAllActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentUpdateIncomeBinding;


public class UpdateIncomeFragment extends Fragment implements IconRevenueAdapter.Irevenue, RevenueAdapter.Irevenue {

    private FragmentUpdateIncomeBinding  binding;
    private Dialog dialog;
    private SQLiteHelper sqLiteHelper;


    private ArrayList<IconRevenueModels> iconRevenueModelsArrayList;
    private IconRevenueModels iconRevenueModels;
    private IconRevenueAdapter iconRevenueAdapter;

    private ArrayList<RevenueCategoryModels> revenueCategoryModelsArrayList;
    private RevenueCategoryModels revenueCategoryModels;
    private RevenueAdapter revenueAdapter;

    private ArrayList<RevenueInforModels> revenueInforModelsArrayList;
    private RevenueInforModels revenueInforModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateIncomeBinding.inflate(inflater, container, false);

        iconRevenueModelsArrayList  = new ArrayList<>();
        iconRevenueModels = new IconRevenueModels();
        iconRevenueAdapter = new IconRevenueAdapter(this);

        revenueCategoryModels = new RevenueCategoryModels();
        revenueCategoryModelsArrayList = new ArrayList<>();
        revenueAdapter = new RevenueAdapter(this);

        revenueCategoryModelsArrayList = new ArrayList<>();
        revenueInforModels = new RevenueInforModels();

        sqLiteHelper = new SQLiteHelper(getContext(), "revenue.db", null, 1);

        binding.ButtonAddCategory.setOnClickListener(v -> {
            Opendialog();
            ImageView imgClose = dialog.findViewById(R.id.imgClose);
            RecyclerView recyclerviewIconPay = dialog.findViewById(R.id.recyclerviewIconPay);
            AppCompatButton btnAddPay = dialog.findViewById(R.id.btnAddPay);
            AppCompatEditText inputNameCategory = dialog.findViewById(R.id.inputNameCategory);
            imgClose.setOnClickListener(v1 -> dialog.dismiss());
            recyclerviewIconPay.setLayoutManager(new GridLayoutManager(getContext(), 4));
            recyclerviewIconPay.setAdapter(iconRevenueAdapter);
            btnAddPay.setOnClickListener(v12 -> {
                String NameCategory = Objects.requireNonNull(inputNameCategory.getText()).toString().trim();
                if (NameCategory.isEmpty()){
                    Toast.makeText(getContext(), "No Empyt", Toast.LENGTH_SHORT).show();
                }
                else {
                    sqLiteHelper.QueryData("INSERT INTO REVENUE VALUES(null,'" + NameCategory + "' , '" + iconRevenueModels.getImageIcon() + "')");
                    getDataPayFromDatabase();
                    initRecyclerview();
                    dialog.dismiss();
                }
            });
        });


        getDataFromRecyclerview();
        addIconCategory();
        getDataPayFromDatabase();
        initRecyclerview();
        UpdatePayMentInfor();
        listener();
        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void UpdatePayMentInfor() {
        assert getArguments() != null;
        int id = getArguments().getInt("id");
        Log.d("id receive", "UpdatePaymentInfo: " + id);

// Retrieve the payment record from the database based on the ID
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM REVENUEMENT WHERE IdRevenuement = " + id);
        RevenueInforModels revenueInforModels = null;
        if (cursor.moveToNext()){
            String title = cursor.getString(1);
            String date = cursor.getString(2);
            String money = cursor.getString(3);
            String category = cursor.getString(4);
            String sumPay = cursor.getString(5);

            revenueInforModels = new RevenueInforModels(id, title, date, money, category, sumPay);
        }

        if (revenueInforModels != null) {
            // Set the values of the input fields based on the retrieved payment record
            binding.inputDate.setText(revenueInforModels.getDate());
            binding.inputNote.setText(revenueInforModels.getNote());
            binding.inputCash.setText(revenueInforModels.getMoney());
            binding.inputCategory.setText(revenueInforModels.getCategory());

            RevenueInforModels revenueInforModels1 = revenueInforModels;
            binding.buttonAddPay.setOnClickListener(v -> {

                // Update the values of the payment record with the new values from the input fields
                revenueInforModels1.setDate(binding.inputDate.getText().toString());
                revenueInforModels1.setNote(binding.inputNote.getText().toString());
                revenueInforModels1.setMoney(binding.inputCash.getText().toString());
                revenueInforModels1.setCategory(binding.inputCategory.getText().toString());

                // Update the payment record in the database
                String updateQuery = "UPDATE REVENUEMENT SET " +
                        "Date = '" + revenueInforModels1.getDate() + "', " +
                        "Note = '" + revenueInforModels1.getNote() + "', " +
                        "Money = '" + revenueInforModels1.getMoney() + "', " +
                        "Category = '" + revenueInforModels1.getCategory() + "' " +
                        "WHERE IdRevenuement = " + id;
                sqLiteHelper.QueryData(updateQuery);
                Log.d("Update category", "Update Cateogry: " + revenueInforModels1.getCategory());

                // Display a success message to the user
                Opendialog2();
                TextView title = dialog.findViewById(R.id.title);
                TextView details = dialog.findViewById(R.id.details);
                Button negative_action = dialog.findViewById(R.id.negative_action);
                Button positive_action = dialog.findViewById(R.id.pogative_action);
                positive_action.setText("Continue");
                negative_action.setOnClickListener(v12 -> dialog.dismiss());
                title.setText("Update Successfully");
                details.setText(revenueInforModels1.getNote());
                positive_action.setOnClickListener(v1 -> startActivity(new Intent(getContext(), SeeAllActivity.class)));

                // Notify the adapter and update the RecyclerView with the new data
                revenueAdapter.notifyDataSetChanged();
                getDataPayFromDatabase();
                initRecyclerview();
            });
        } else {
            // Handle the case where the payment record could not be found
            Log.d("data receive", "Payment record with ID " + id + " not found in database");
        }
    }
    private void Opendialog2() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ok);
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

    private void getDataFromRecyclerview() {
        if (getArguments() != null){
            String date = getArguments().getString("date");
            String note = getArguments().getString("note");
            String money = getArguments().getString("money");
            String category = getArguments().getString("category");
            Log.d("TAG", "getDataFromRecyclerview: " + date + note + money + category);
            binding.inputDate.setText(date);
            binding.inputNote.setText(note);
            binding.inputCash.setText(money);
            binding.inputCategory.setText(category);
        }
    }

    private void Opendialog() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_categorypay);
        Window window = dialog.getWindow();
        if (window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override
    public int getCount() {
        return iconRevenueModelsArrayList.size();
    }

    @Override
    public IconRevenueModels getDataImage(int position) {
        return iconRevenueModelsArrayList.get(position);
    }

    @Override
    public void OnClickItem(int position) {
        iconRevenueModels = iconRevenueModelsArrayList.get(position);
    }

    @Override
    public int getCountRevenue() {
        return revenueCategoryModelsArrayList.size();
    }

    @Override
    public RevenueCategoryModels getDataCategoryRevenue(int position) {
        return revenueCategoryModelsArrayList.get(position);
    }

    @Override
    public void OnclickItemCategoryRevenue(int position) {
        revenueCategoryModels = revenueCategoryModelsArrayList.get(position);
        binding.inputCategory.setText(revenueCategoryModels.getNameCategory());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerview() {
        binding.recyclerviewCategory.setLayoutManager(new GridLayoutManager(getContext(), 4));
        binding.recyclerviewCategory.setAdapter(revenueAdapter);
    }

    private void getDataPayFromDatabase() {
        revenueCategoryModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM REVENUE ");
        while (cursor.moveToNext()){
            int idRevenue = cursor.getInt(0);
            String nameCategoryRevenue = cursor.getString(1);
            int IconCategoryRevenue = cursor.getInt(2);
            revenueCategoryModelsArrayList.add(new RevenueCategoryModels(idRevenue, nameCategoryRevenue, IconCategoryRevenue));

        }

    }
    private void listener() {
        binding.inputDate.setOnClickListener(v -> {
            MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();//khởi tạo builder để hiển thị date picker
            builder.setTitleText("Select a date");
            MaterialDatePicker<Long> materialDatePicker = builder.build();
            materialDatePicker.show(getParentFragmentManager(),"DATE_PICKER");
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                //convert date to string
                String myFormat = "yyyy-MM-dd";// định dạng ngày tháng năm
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);// định dạng ngày tháng năm
                binding.inputDate.setText(sdf.format(selection));
            });
        });
    }

    private void addIconCategory() {
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.mot));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.hai));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_cafe));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_contact));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_fitness));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_flat));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_flight));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_health));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_insgit));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_redem));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_saving));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_shipping));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_shopping));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_soccer));
        iconRevenueModelsArrayList.add(new IconRevenueModels(R.drawable.ic_school));
    }

    @Override
    public void ClickToDeleteCategory(int position) {
        revenueCategoryModels = revenueCategoryModelsArrayList.get(position);
        sqLiteHelper.QueryData("DELETE FROM REVENUE WHERE IdRevenue = '" + revenueCategoryModels.getiDCategory() + "' ");
        getDataPayFromDatabase();
        initRecyclerview();
    }
}