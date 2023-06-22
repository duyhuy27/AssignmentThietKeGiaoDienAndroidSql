package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.Locale;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueInforModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ItemRenenueSwipeBinding;

public class RevenueInformationAdapter extends RecyclerView.Adapter<RevenueInformationAdapter.RevenueInforHolder> {
    private final Irevenue irevenue;

    public RevenueInformationAdapter(Irevenue irevenue) {
        this.irevenue = irevenue;
    }

    @NonNull
    @Override
    public RevenueInformationAdapter.RevenueInforHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRenenueSwipeBinding binding = ItemRenenueSwipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RevenueInforHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull RevenueInformationAdapter.RevenueInforHolder holder,@SuppressLint("RecyclerView") int position) {
            RevenueInforModels revenueInforModels = irevenue.getDataRevenue(position);
        holder.binding.textTitle.setText(revenueInforModels.getNote());
        holder.binding.textDate.setText(revenueInforModels.getDate());
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
        try {
            double money = Double.parseDouble(revenueInforModels.getMoney());
            String formattedAmount = currencyFormatter.format(money);
            holder.binding.Money.setText(formattedAmount);
        } catch (NumberFormatException e) {
            holder.binding.Money.setText("Invalid input");
        }
        holder.binding.Icon.setImageResource(R.drawable.ic_saving);
        holder.binding.update.setOnClickListener(v -> irevenue.OnClickItemRevenueInfor(position));
        holder.binding.delete.setOnClickListener(v -> irevenue.OnClickDeleteItem(position));
    }

    @Override
    public int getItemCount() {
        return irevenue.getCountRevueInfor();
    }

    public interface Irevenue{
        int getCountRevueInfor();
        RevenueInforModels getDataRevenue(int position);
        void OnClickItemRevenueInfor(int position);
        void OnClickDeleteItem(int position);
    }

    public static class RevenueInforHolder extends RecyclerView.ViewHolder {
        ItemRenenueSwipeBinding binding;
        public RevenueInforHolder(@NonNull ItemRenenueSwipeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
