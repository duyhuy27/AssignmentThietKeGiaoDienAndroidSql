package huyndph30375.fpoly.huyndph30375_assignment_full.Fragment.Chart;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.Sqlite.SQLiteHelper;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.FragmentPieChartBinding;

public class PieChartFragment extends Fragment {

    private SQLiteHelper sqLiteHelper;
    FragmentPieChartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPieChartBinding.inflate(inflater,container,false);
        sqLiteHelper = new SQLiteHelper(getContext(), "pay.db", null, 1);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sqLiteHelper = new SQLiteHelper(getContext(), "pay.db", null,1);

        binding.tvNgayBatDau.setOnClickListener(v -> {
            MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();//khởi tạo builder để hiển thị date picker
            builder.setTitleText("Select a date");
            MaterialDatePicker<Long> materialDatePicker = builder.build();
            materialDatePicker.show(getParentFragmentManager(),"DATE_PICKER");
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                //convert date to string
                String myFormat = "yyyy-MM-dd";// định dạng ngày tháng năm
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);// định dạng ngày tháng năm
                binding.tvNgayBatDau.setText(sdf.format(selection));
            });
        });

        binding.tvNgayKetThuc.setOnClickListener(v -> {
            MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();//khởi tạo builder để hiển thị date picker
            builder.setTitleText("Select a date");
            MaterialDatePicker<Long> materialDatePicker = builder.build();
            materialDatePicker.show(getParentFragmentManager(),"DATE_PICKER");
            materialDatePicker.addOnPositiveButtonClickListener(selection -> {
                //convert date to string
                String myFormat = "yyyy-MM-dd";// định dạng ngày tháng năm
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);// định dạng ngày tháng năm
                binding.tvNgayKetThuc.setText(sdf.format(selection));

                ArrayList<PayInforModels> list = getData(binding.tvNgayBatDau.getText().toString(), binding.tvNgayKetThuc.getText().toString());


                HashMap<String, Float> moneyByCategory = new HashMap<>();
                for (PayInforModels item : list) {
                    String moneyString = item.getMoney().replace(",", ".");
                    float money = Float.parseFloat(moneyString);
                    if (moneyByCategory.containsKey(item.getCategory())) {
                        moneyByCategory.put(item.getCategory(), moneyByCategory.get(item.getCategory()) + money);
                    } else {
                        moneyByCategory.put(item.getCategory(), money);
                    }
                }

                List<PieEntry> entries = new ArrayList<>();
                int[] colors = new int[list.size()]; // create array to hold color for each entry
                for (int i = 0; i < list.size(); i++) {
                    PayInforModels item = list.get(i);
                    String moneyString = item.getMoney().replace(",", ".");
                    float money = Float.parseFloat(moneyString);
                    entries.add(new PieEntry(money, item.getNote()));
                    colors[i] = Color.rgb((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)); // set a random color for each entry
                }

                PieDataSet dataSet = new PieDataSet(entries, "Payments by date");
                dataSet.setColors(colors); // set the colors for the entries
                dataSet.setValueTextSize(16f); // set the font size for the values
                PieData data = new PieData(dataSet);
                binding.barchart.setData(data);
                binding.barchart.invalidate();

                binding.barchart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                    @Override
                    public void onValueSelected(Entry e, Highlight h) {
                        PieEntry entry = (PieEntry) e;
                        String note = entry.getLabel();
                        float value = entry.getValue();
                        String message = "Note: " + note + "\n" + "Expense: " + value;

                        // display the details in a dialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                        builder.setTitle("Details");
                        builder.setMessage(message);
                        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    @Override
                    public void onNothingSelected() {
                        // do nothing
                    }
                });
            });
        });

    }
    //get data from database payment by data nằm giữa ngaybatdau and ngayketthuc
    public ArrayList<PayInforModels> getData(String ngaybatdau, String ngayketthuc){
        ArrayList<PayInforModels> list = new ArrayList<>();
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM PAYMENT WHERE date BETWEEN '"+ngaybatdau+"' AND '"+ngayketthuc+"'");
        double totalPay = 0.0;
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String note = cursor.getString(2);
            String money = cursor.getString(3);
            String total = cursor.getString(5);
            String idCategory = cursor.getString(4);
            totalPay += Double.parseDouble(money);
            list.add(new PayInforModels(id,date,note,money,idCategory,total));
            Locale vietnamLocale = new Locale("vi", "VN");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
            String formattedAmount = currencyFormatter.format(totalPay);
            binding.totalPay.setText(formattedAmount);

        }
        return list;
    }

}