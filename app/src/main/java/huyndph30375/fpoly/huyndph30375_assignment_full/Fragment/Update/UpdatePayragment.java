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

import androidx.annotation.NonNull;
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

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay.IconPayAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.IconPayModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay.PayAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Activity.SeeAllActivity;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentUpdatePayragmentBinding;


public class UpdatePayragment extends Fragment implements IconPayAdapter.IPays, PayAdapter.Ipay {

    private FragmentUpdatePayragmentBinding binding;
    private Dialog dialog;
    private SQLiteHelper sqLiteHelper;


    private ArrayList<IconPayModels> iconPayModelsArrayList;
    private IconPayAdapter iconPayAdapter;
    private IconPayModels iconPayModels;

    private ArrayList<PayModels> payModelsArrayList;
    private PayModels payModels;
    private PayAdapter payAdapter;


    public static final String ROOT_FRAGMENT_TAG = UpdatePayragment.class.getName();


    public UpdatePayragment() {

    }

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdatePayragmentBinding.inflate(inflater, container, false);

        iconPayModelsArrayList = new ArrayList<>();
        iconPayAdapter = new IconPayAdapter(this);
        iconPayModels = new IconPayModels();

        payModelsArrayList = new ArrayList<>();
        payModels = new PayModels();
        payAdapter = new PayAdapter(this);

        sqLiteHelper = new SQLiteHelper(getContext(), "pay.db", null, 1);

        binding.ButtonAddCategory.setOnClickListener(v -> {
            Opendialog();
            ImageView imgClose = dialog.findViewById(R.id.imgClose);
            RecyclerView recyclerviewIconPay = dialog.findViewById(R.id.recyclerviewIconPay);
            AppCompatButton btnAddPay = dialog.findViewById(R.id.btnAddPay);
            AppCompatEditText inputNameCategory = dialog.findViewById(R.id.inputNameCategory);
            imgClose.setOnClickListener(v1 -> dialog.dismiss());
            recyclerviewIconPay.setLayoutManager(new GridLayoutManager(getContext(), 4));
            recyclerviewIconPay.setAdapter(iconPayAdapter);
            btnAddPay.setOnClickListener(v12 -> {
                String NameCategory = Objects.requireNonNull(inputNameCategory.getText()).toString().trim();
                if (NameCategory.isEmpty()) {
                    showToast("No Empty");
                } else {
                    sqLiteHelper.QueryData("INSERT INTO PAY VALUES(null,'" + NameCategory + "' , '" + iconPayModels.getImageIcon() + "')");
                    showToast("Update oke");
                    Log.d("add category", NameCategory + " " + iconPayModels.getImageIcon());
                    getDataPayFromDatabase();
                    initRecyclerview();
                    dialog.dismiss();
                }
            });
        });

        binding.imageBack.setOnClickListener(v -> {
            if (null == getFragmentManager()) return;
            getFragmentManager().popBackStack();

        });
        getDataFromRecyclerview();
        addIconPayCategory();
        getDataPayFromDatabase();
        initRecyclerview();
        UpdatePayMentInfor();
        listener();


        return binding.getRoot();
    }

    private void listener() {
        binding.inputDate.setOnClickListener(v -> {
            MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();//khởi tạo builder để hiển thị date picker
            builder.setTitleText("Select a date");
            MaterialDatePicker<Long> materialDatePicker = builder.build();
            materialDatePicker.show(getParentFragmentManager(), "DATE_PICKER");
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                //convert date to string
                String myFormat = "yyyy-MM-dd";// định dạng ngày tháng năm
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);// định dạng ngày tháng năm
                binding.inputDate.setText(sdf.format(selection));
            });
        });
    }

    @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
    private void UpdatePayMentInfor() {
        assert getArguments() != null;
        int id = getArguments().getInt("id");
        Log.d("id receive", "UpdatePaymentInfo: " + id);

// Retrieve the payment record from the database based on the ID
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM PAYMENT WHERE IdPayment = " + id);
        PayInforModels payInforModels = null;
        if (cursor.moveToNext()){
            String title = cursor.getString(1);
            String date = cursor.getString(2);
            String money = cursor.getString(3);
            String category = cursor.getString(4);
            String sumPay = cursor.getString(5);

            payInforModels = new PayInforModels(id, title, date, money, category, sumPay);
        }

        if (payInforModels != null) {
            // Set the values of the input fields based on the retrieved payment record
            binding.inputDate.setText(payInforModels.getDate());
            binding.inputNote.setText(payInforModels.getNote());
            binding.inputCash.setText(payInforModels.getMoney());
            binding.inputCategory.setText(payInforModels.getCategory());

            PayInforModels finalPayInforModels = payInforModels;
            binding.buttonAddPay.setOnClickListener(v -> {
                // Update the values of the payment record with the new values from the input fields
                finalPayInforModels.setDate(binding.inputDate.getText().toString());
                finalPayInforModels.setNote(binding.inputNote.getText().toString());
                finalPayInforModels.setMoney(binding.inputCash.getText().toString());
                finalPayInforModels.setCategory(binding.inputCategory.getText().toString());

                // Update the payment record in the database
                String updateQuery = "UPDATE PAYMENT SET " +
                        "Date = '" + finalPayInforModels.getDate() + "', " +
                        "Note = '" + finalPayInforModels.getNote() + "', " +
                        "Money = '" + finalPayInforModels.getMoney() + "', " +
                        "Category = '" + finalPayInforModels.getCategory() + "' " +
                        "WHERE IdPayment = " + id;
                sqLiteHelper.QueryData(updateQuery);
                Log.d("Update category", "Update Cateogry: " + finalPayInforModels.getCategory());

                // Display a success message to the user
                Opendialog2();
                TextView title = dialog.findViewById(R.id.title);
                TextView details = dialog.findViewById(R.id.details);
                Button negative_action = dialog.findViewById(R.id.negative_action);
                Button positive_action = dialog.findViewById(R.id.pogative_action);
                positive_action.setText("Continue");
                negative_action.setOnClickListener(v12 -> dialog.dismiss());
                title.setText("Update Successfully");
                details.setText(finalPayInforModels.getNote());
                positive_action.setOnClickListener(v1 -> startActivity(new Intent(getContext(), SeeAllActivity.class)));

                // Notify the adapter and update the RecyclerView with the new data
                payAdapter.notifyDataSetChanged();
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
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerview() {
        binding.recyclerviewCategory.setLayoutManager(new GridLayoutManager(getContext(), 4));
        binding.recyclerviewCategory.setAdapter(payAdapter);

    }

    private void getDataPayFromDatabase() {
        payModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM PAY ");
        while (cursor.moveToNext()) {
            int idPay = cursor.getInt(0);
            String namePay = cursor.getString(1);
            int iconPay = cursor.getInt(2);
            payModelsArrayList.add(new PayModels(idPay, namePay, iconPay));
        }
    }

    private void addIconPayCategory() {
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.mot));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.hai));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ba));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_cafe));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_contact));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_fitness));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_flat));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_flight));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_health));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_insgit));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_redem));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_saving));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_shipping));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_shopping));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_soccer));
        iconPayModelsArrayList.add(new IconPayModels(R.drawable.ic_school));
    }

    @Override
    public int getCount() {
        return iconPayModelsArrayList.size();
    }

    @Override
    public IconPayModels getDataImagePay(int position) {
        return iconPayModelsArrayList.get(position);
    }

    @Override
    public void onClickItem(int position) {
        iconPayModels = iconPayModelsArrayList.get(position);
    }

    @Override
    public int getCountPay() {
        return payModelsArrayList.size();
    }

    @Override
    public PayModels getDataPay(int position) {
        return payModelsArrayList.get(position);
    }

    @Override
    public void onClickItemPay(int position) {
        payModels = payModelsArrayList.get(position);
        binding.inputCategory.setText(payModels.getNamePay());
    }

    @Override
    public void onClickDeletePay(int position) {
        payModels = payModelsArrayList.get(position);
        sqLiteHelper.QueryData("DELETE FROM PAY WHERE IdPay = '" + payModels.getIdPay() + "' ");
        showToast("Delete oke");
        getDataPayFromDatabase();
        initRecyclerview();
    }

    private void Opendialog() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_categorypay);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        dialog.setCancelable(true);
        dialog.show();
    }

    @SuppressLint("LongLogTag")
    private void getDataFromRecyclerview() {

    }
}