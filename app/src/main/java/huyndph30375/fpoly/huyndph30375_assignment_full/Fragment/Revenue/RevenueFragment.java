package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Revenue;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue.IconRevenueAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue.RevenueAdapter;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.IconRevenueModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueCategoryModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentRevenueBinding;


public class RevenueFragment extends Fragment implements RevenueAdapter.Irevenue, IconRevenueAdapter.Irevenue{

    private Dialog dialog;
    private FragmentRevenueBinding binding;
    private double totalRevenue = 0.0;

    private SQLiteHelper sqLiteHelper;
    private IconRevenueModels iconRevenueModels;
    private ArrayList<IconRevenueModels> iconRevenueModelsArrayList;
    private RevenueCategoryModels revenueCategoryModels;
    private ArrayList<RevenueCategoryModels> revenueCategoryModelsArrayList;
    private IconRevenueAdapter iconRevenueAdapter;
    private RevenueAdapter revenueAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRevenueBinding.inflate(inflater, container, false);

        iconRevenueModelsArrayList = new ArrayList<>();
        revenueCategoryModelsArrayList = new ArrayList<>();
        iconRevenueAdapter = new IconRevenueAdapter(this);

        revenueAdapter = new RevenueAdapter(this);
        revenueCategoryModels = new RevenueCategoryModels();
        iconRevenueModels = new IconRevenueModels();


        sqLiteHelper = new SQLiteHelper(getContext(), "revenue.db", null,1);
        binding.ButtonAddCategory.setOnClickListener(v -> {
            OpenDiaLogAddCategoryRevenue();
            ImageView imgClose = dialog.findViewById(R.id.imgClose);
            AppCompatEditText inputNameCategory = dialog.findViewById(R.id.inputNameCategory);
            AppCompatButton btnAddCategoryRevenue = dialog.findViewById(R.id.btnAddCategoryRevenue);
            RecyclerView recyclerviewIconRevenue = dialog.findViewById(R.id.recyclerviewIconRevenue);
            imgClose.setOnClickListener(v1 -> dialog.dismiss());
            recyclerviewIconRevenue.setLayoutManager(new GridLayoutManager(getContext(), 4));
            recyclerviewIconRevenue.setAdapter(iconRevenueAdapter);
            btnAddCategoryRevenue.setOnClickListener(v12 -> {
                String CategoryRevenueName = Objects.requireNonNull(inputNameCategory.getText()).toString().trim();
                if (CategoryRevenueName.isEmpty()){
                    showToast("Name of Category is not empty");
                }
                else {
                    sqLiteHelper.QueryData("INSERT INTO REVENUE VALUES(null,'" + CategoryRevenueName + "' , '" + iconRevenueModels.getImageIcon() +"')");
                    showToast("Add Category Successfully");
                    GetDataFromDatabase();
                    InitRecyclerViewRevenue();
                    dialog.dismiss();
                }
            });

        });
    addIconCategory();
    GetDataFromDatabase();
    InitRecyclerViewRevenue();
    onClickAddRevenueDetails();
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

    private void onClickAddRevenueDetails() {
        binding.buttonAddRevenue.setOnClickListener(v -> {
            String date = binding.inputDate.getText().toString().trim();
            String note = binding.inputNote.getText().toString().trim();
            String moneyStr = binding.inputCash.getText().toString().trim();
            String category = binding.inputCategory.getText().toString().trim();
            if (date.isEmpty() || note.isEmpty() || moneyStr.isEmpty() || category.isEmpty()){
                showToast("Date is not empty");
            } else if (moneyStr.equals("0")) {
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
                    totalRevenue += money;
                    sqLiteHelper.QueryData("INSERT INTO REVENUEMENT VALUES(null, '" + date + "' , '" + note + "' , '" + money + "' , '" + category + "' , '" + totalRevenue + "' )");
                    dialog.dismiss();
                    Opendialog();
                    TextView title1 = dialog.findViewById(R.id.title);
                    title1.setText("Data Imported");
                    binding.inputDate.setText("");
                    binding.inputNote.setText("");
                    binding.inputCash.setText("");
                    binding.inputCategory.setText("");
                });
            } else {
                double money = Double.parseDouble(moneyStr);
                totalRevenue += money;
                sqLiteHelper.QueryData("INSERT INTO REVENUEMENT VALUES(null, '" + date + "' , '" + note + "' , '" + money + "' , '" + category + "' , '" + totalRevenue + "' )");
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

    private void OpenDiaLogAddCategoryRevenue() {
        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_category_revenue);
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

    @Override
    public void ClickToDeleteCategory(int position) {
            revenueCategoryModels = revenueCategoryModelsArrayList.get(position);
            sqLiteHelper.QueryData("DELETE FROM REVENUE WHERE IdRevenue =  '" + revenueCategoryModels.getiDCategory() + "' ");
            showToast("Delete Category Successfully");
            GetDataFromDatabase();
            InitRecyclerViewRevenue();

    }

    private void GetDataFromDatabase(){
        revenueCategoryModelsArrayList.clear();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM REVENUE ");
        while (cursor.moveToNext()){
            int idRevenue = cursor.getInt(0);
            String nameCategoryRevenue = cursor.getString(1);
            int IconCategoryRevenue = cursor.getInt(2);
            revenueCategoryModelsArrayList.add(new RevenueCategoryModels(idRevenue, nameCategoryRevenue, IconCategoryRevenue));

        }
    }

    private void InitRecyclerViewRevenue(){
        binding.recyclerviewCategoryRevenue.setLayoutManager(new GridLayoutManager(getContext(), 4));
        binding.recyclerviewCategoryRevenue.setAdapter(revenueAdapter);
    }
}