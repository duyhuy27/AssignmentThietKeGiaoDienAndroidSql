package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.PayModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ItemPayBinding;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.PayViewHolder> {
    private final Ipay ipay;
    int row_id = -1;

    public PayAdapter(Ipay ipay) {
        this.ipay = ipay;
    }

    @NonNull
    @Override
    public PayAdapter.PayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPayBinding binding = ItemPayBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PayViewHolder(binding);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull PayAdapter.PayViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PayModels payModels = ipay.getDataPay(position);
        holder.binding.imgIconPay.setImageResource(payModels.getIconPay());
        holder.binding.txtTitlePay.setText(payModels.getNamePay());
        holder.itemView.setOnClickListener(v -> {
            ipay.onClickItemPay(position);
            row_id = position;
            notifyDataSetChanged();
        });
        holder.binding.imgDelete.setOnClickListener(v -> ipay.onClickDeletePay(position));

        if (row_id == position) {
            holder.binding.backgroundItem.setBackgroundResource(R.drawable.selected_item_background);
        } else {
            holder.binding.backgroundItem.setBackgroundResource(R.drawable.unselected_item_background);
        }

    }

    @Override
    public int getItemCount() {
        return ipay.getCountPay();
    }

    public interface Ipay{
        int getCountPay();
        PayModels getDataPay(int position);
        void onClickItemPay(int position);
        void onClickDeletePay(int position);
    }

    public static class PayViewHolder extends RecyclerView.ViewHolder {
        ItemPayBinding binding;
        public PayViewHolder(@NonNull ItemPayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
