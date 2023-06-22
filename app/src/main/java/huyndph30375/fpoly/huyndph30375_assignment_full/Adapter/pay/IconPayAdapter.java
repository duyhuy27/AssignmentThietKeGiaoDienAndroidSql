package huyndph30375.fpoly.huyndph30375_assignment_full.Adapter.pay;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import huyndph30375.fpoly.huyndph30375_assignment_full.Models.pay.IconPayModels;
import huyndph30375.fpoly.huyndph30375_assignment_full.R;
import huyndph30375.fpoly.huyndph30375_assignment_full.databinding.ItemIconPayBinding;

public class IconPayAdapter extends RecyclerView.Adapter<IconPayAdapter.IconViewHolder> {
    private final IPays iPays;
    int row_id = -1;

    public IconPayAdapter(IPays iPays) {
        this.iPays = iPays;
    }

    @NonNull
    @Override
    public IconPayAdapter.IconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIconPayBinding bind = ItemIconPayBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new IconViewHolder(bind);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull IconPayAdapter.IconViewHolder holder, @SuppressLint("RecyclerView") int position) {
        IconPayModels iconPayModels = iPays.getDataImagePay(position);
        holder.bind.imgIconPay.setImageResource(iconPayModels.getImageIcon());
        holder.itemView.setOnClickListener(v -> {
            iPays.onClickItem(position);
            row_id = position;
            notifyDataSetChanged();
        });
        if (row_id == position) {
            holder.bind.backgroundItem.setBackgroundResource(R.drawable.selected_item_background);
        } else {
            holder.bind.backgroundItem.setBackgroundResource(R.drawable.unselected_item_background);
        }

    }

    @Override
    public int getItemCount() {
        return iPays.getCount();
    }

    public interface IPays{
        int getCount();
        IconPayModels getDataImagePay(int position);
        void onClickItem(int position);
    }

    public static class IconViewHolder extends RecyclerView.ViewHolder {
        ItemIconPayBinding bind;
        public IconViewHolder(@NonNull ItemIconPayBinding bind) {
            super(bind.getRoot());
            this.bind = bind;
        }
    }
}
