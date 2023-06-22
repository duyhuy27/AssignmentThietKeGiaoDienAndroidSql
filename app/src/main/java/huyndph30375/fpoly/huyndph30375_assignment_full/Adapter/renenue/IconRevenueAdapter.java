package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.renenue;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.revenue.IconRevenueModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ItemIconRenenueBinding;

public class IconRevenueAdapter extends RecyclerView.Adapter<IconRevenueAdapter.IconRevenueViewHolder> {
    private final Irevenue irevenue;
    int row_id = -1;

    public IconRevenueAdapter(Irevenue irevenue) {
        this.irevenue = irevenue;
    }

    @NonNull
    @Override
    public IconRevenueAdapter.IconRevenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIconRenenueBinding binding = ItemIconRenenueBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new IconRevenueViewHolder(binding);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull IconRevenueAdapter.IconRevenueViewHolder holder,  @SuppressLint("RecyclerView") int position) {
            IconRevenueModels iconRevenueModels = irevenue.getDataImage(position);
            holder.binding.imgIconRevenue.setImageResource(iconRevenueModels.getImageIcon());
            holder.itemView.setOnClickListener(v -> {
                irevenue.OnClickItem(position);
                row_id = position;
                notifyDataSetChanged();
            });
        if (row_id == position) {
            holder.binding.backgroundItem.setBackgroundResource(R.drawable.selected_item_background);
        } else {
            holder.binding.backgroundItem.setBackgroundResource(R.drawable.unselected_item_background);
        }
    }

    @Override
    public int getItemCount() {
        return irevenue.getCount();
    }

    public interface Irevenue{
        int getCount();
        IconRevenueModels getDataImage(int position);
        void OnClickItem(int position);
    }

    public static class IconRevenueViewHolder extends RecyclerView.ViewHolder {
        ItemIconRenenueBinding binding;
        public IconRevenueViewHolder(@NonNull ItemIconRenenueBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
