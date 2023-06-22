package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Pay;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay.PayAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.IconPayModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentPayBinding;


public class PayFragment extends Fragment implements IconPayAdapter.IPays, PayAdapter.Ipay{
    private Dialog dialog;
    private FragmentPayBinding binding;
    private SQLiteHelper sqLiteHelper;

    private ArrayList<IconPayModels> iconPayModelsArrayList;
    private IconPayAdapter iconPayAdapter;
    private PayAdapter payAdapter;

    private IconPayModels iconPayModels;
    private PayModels payModels;
    private ArrayList<PayModels> payModelsArrayList;


    private double totalAmount = 0.0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPayBinding.inflate(inflater, container, false);

        iconPayModelsArrayList = new ArrayList<>();
        iconPayAdapter = new IconPayAdapter(this);
        iconPayModels = new IconPayModels();
        payModels = new PayModels();
        payAdapter = new PayAdapter(this);
        payModelsArrayList = new ArrayList<>();

        sqLiteHelper = new SQLiteHelper(getContext(), "pay.db", null, 1);
        binding.ButtonAddCategory.setOnClickListener(v -> {
         OpenDialog();
            ImageView imgClose = dialog.findViewById(R.id.imgClose);
            RecyclerView recyclerviewIconPay = dialog.findViewById(R.id.recyclerviewIconPay);
            AppCompatButton btnAddPay = dialog.findViewById(R.id.btnAddPay);
            AppCompatEditText inputNameCategory = dialog.findViewById(R.id.inputNameCategory);
            imgClose.setOnClickListener(v1 -> dialog.dismiss());
            recyclerviewIconPay.setLayoutManager(new GridLayoutManager(getContext(), 4));
            recyclerviewIconPay.setAdapter(iconPayAdapter);
            btnAddPay.setOnClickListener(v12 -> {
                String txtname = Objects.requireNonNull(inputNameCategory.getText()).toString().trim();
                if (txtname.isEmpty()){
                    showToast("Data is not empty");
                }else {
                    sqLiteHelper.QueryData("INSERT INTO PAY VALUES(null,'" + txtname + "' , '" + iconPayModels.getImageIcon() + "')");
                    showToast("Add data to SQLite successfully");
                    getDataPayFromDatabase();
                    initReclerViewPay();
                    dialog.dismiss();
                }
            });
        });
        addIconPayCategory();
        getDataPayFromDatabase();
        initReclerViewPay();
        onClickAddPaymentInfo();
        listener();
        return binding.getRoot();
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

    private void onClickAddPaymentInfo() {
        binding.buttonAddPay.setOnClickListener(v -> {
            String date = binding.inputDate.getText().toString().trim();
            String note = binding.inputNote.getText().toString().trim();
            String moneyStr = binding.inputCash.getText().toString().trim();
            String category = binding.inputCategory.getText().toString().trim();
            if (date.isEmpty() || note.isEmpty() || moneyStr.isEmpty() || category.isEmpty()){
                showToast("Data is not empty !");}
            else if (moneyStr.equals("0")){
                Opendialog1();
                TextView title = dialog.findViewById(R.id.title);
                TextView details = dialog.findViewById(R.id.details);
                AppCompatButton negative_action = dialog.findViewById(R.id.negative_action);
                AppCompatButton pogative_action = dialog.findViewById(R.id.pogative_action);
                negative_action.setOnClickListener(v1 -> dialog.dismiss());
                pogative_action.setText("Ok");
                details.setText("");
                title.setText("the amount is still 0, do you want to continue?");
                pogative_action.setOnClickListener(v12 -> {
                    double money = Double.parseDouble(moneyStr);
                    totalAmount += money;
                    sqLiteHelper.QueryData("INSERT INTO PAYMENT VALUES(null, '" + date + "' , '" + note + "' , '" + money + "' , '" + category + "' , '" + totalAmount + "' ) ");
                    dialog.dismiss();
                    Opendialog();
                    TextView title1 = dialog.findViewById(R.id.title);
                    title1.setText("Data Imported");
                    binding.inputDate.setText("");
                    binding.inputNote.setText("");
                    binding.inputCash.setText("");
                    binding.inputCategory.setText("");
                });
            }
            else {

                double money = Double.parseDouble(moneyStr);
                totalAmount += money;
                sqLiteHelper.QueryData("INSERT INTO PAYMENT VALUES(null, '" + date + "' , '" + note + "' , '" + money + "' , '" + category + "' , '" + totalAmount + "' ) ");
                Opendialog();
                TextView title = dialog.findViewById(R.id.title);
                title.setText("Data Imported");
                binding.inputDate.setText("");
                binding.inputNote.setText("");
                binding.inputCash.setText("");
                binding.inputCategory.setText("");

            }
        });
    }

    private void Opendialog1() {
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


    private void Opendialog() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ok_primary);
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
        new Handler().postDelayed(() -> {
            if (dialog!=null && dialog.isShowing()){
                dialog.dismiss();
            }
        },1000);
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

    private void initReclerViewPay(){
        binding.recyclerviewCategory.setLayoutManager(new GridLayoutManager(getContext(),4));
        binding.recyclerviewCategory.setAdapter(payAdapter);
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
        initReclerViewPay();

    }

    private void getDataPayFromDatabase(){
        payModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM PAY ");
        while (cursor.moveToNext()){
            int idPay = cursor.getInt(0);
            String namePay = cursor.getString(1);
            int iconPay = cursor.getInt(2);
            payModelsArrayList.add(new PayModels(idPay, namePay, iconPay));
        }
    }
    private void OpenDialog() {
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
    private void showToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}