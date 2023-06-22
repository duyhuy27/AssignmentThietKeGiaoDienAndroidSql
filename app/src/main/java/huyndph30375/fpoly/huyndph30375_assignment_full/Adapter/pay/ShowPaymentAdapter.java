package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.Locale;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ItemPaymentSwipeBinding;

public class ShowPaymentAdapter extends RecyclerView.Adapter<ShowPaymentAdapter.ShowPaymentViewHolder> {
    private final Ipays ipays;

    public ShowPaymentAdapter(Ipays ipays) {
        this.ipays = ipays;
    }

    @NonNull
    @Override
    public ShowPaymentAdapter.ShowPaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaymentSwipeBinding binding = ItemPaymentSwipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShowPaymentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowPaymentAdapter.ShowPaymentViewHolder holder,@SuppressLint("RecyclerView") int position) {
        PayInforModels payInforModels = ipays.getDataPay(position);
        holder.binding.textTitle.setText(payInforModels.getNote());
        holder.binding.textDate.setText(payInforModels.getDate());
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
        double money = Double.parseDouble(payInforModels.getMoney());
        String formattedAmount = currencyFormatter.format(money);
        holder.binding.Money.setText(formattedAmount);
        holder.binding.Icon.setImageResource(R.drawable.ic_change);
        holder.binding.update.setOnClickListener(v -> ipays.onClickItemPay(position));
        holder.binding.delete.setOnClickListener(v -> ipays.onClickDeletePay(position));
    }

    @Override
    public int getItemCount() {
        return ipays.getCountPay();
    }

    public interface Ipays{
        int getCountPay();
        PayInforModels getDataPay(int position);
        void onClickItemPay(int position);
        void onClickDeletePay(int position);
    }

    public static class ShowPaymentViewHolder extends RecyclerView.ViewHolder {
        ItemPaymentSwipeBinding binding;
        public ShowPaymentViewHolder(@NonNull ItemPaymentSwipeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
