package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.RevenueCategoryModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ItemRevenueBinding;

public class RevenueAdapter extends RecyclerView.Adapter<RevenueAdapter.RevenueItemHolder> {
    private final Irevenue irevenue;
    int row_id = -1;

    public RevenueAdapter(Irevenue irevenue) {
        this.irevenue = irevenue;
    }

    @NonNull
    @Override
    public RevenueAdapter.RevenueItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRevenueBinding binding = ItemRevenueBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RevenueItemHolder(binding);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull RevenueAdapter.RevenueItemHolder holder, @SuppressLint("RecyclerView") int position) {
        RevenueCategoryModels revenueCategoryModels = irevenue.getDataCategoryRevenue(position);
        holder.binding.txtTitleRevenue.setText(revenueCategoryModels.getNameCategory());
        holder.binding.imgIconRevenue.setImageResource(revenueCategoryModels.getIconCategory());
        holder.itemView.setOnClickListener(v -> {
            irevenue.OnclickItemCategoryRevenue(position);
            row_id = position;
            notifyDataSetChanged();
        });
        holder.binding.imgDelete.setOnClickListener(v -> irevenue.ClickToDeleteCategory(position));
        if (row_id == position) {
            holder.binding.backgroundItem.setBackgroundResource(R.drawable.selected_item_background);
        } else {
            holder.binding.backgroundItem.setBackgroundResource(R.drawable.unselected_item_background);
        }

    }

    @Override
    public int getItemCount() {
        return irevenue.getCountRevenue();
    }

    public interface Irevenue {
        int getCountRevenue();
        RevenueCategoryModels getDataCategoryRevenue(int position);
        void OnclickItemCategoryRevenue(int position);
        void ClickToDeleteCategory(int position);
    }

    public static class RevenueItemHolder extends RecyclerView.ViewHolder {
        ItemRevenueBinding binding;
        public RevenueItemHolder(@NonNull ItemRevenueBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
