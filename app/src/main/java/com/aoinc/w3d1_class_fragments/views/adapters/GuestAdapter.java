package com.aoinc.w3d1_class_fragments.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aoinc.w3d1_class_fragments.R;
import com.aoinc.w3d1_class_fragments.models.data.Guest;
import com.bumptech.glide.Glide;

import java.util.Currency;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {

    private List<Guest> guestList;

    public GuestAdapter(List<Guest> guests) {
        guestList = guests;
    }

    public void updateGuests(List<Guest> guests) {
        guestList = guests;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guest_item_layout, parent, false);
        return new GuestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        Guest curGuest = guestList.get(position);

        holder.guestName.setText(curGuest.getGuestName());
        holder.guestRoom.setText(curGuest.getRoomNumber());
        Glide.with(holder.itemView.getContext()).load(curGuest.getGuestPhoto()).into(holder.guestAvatar);
    }

    @Override
    public int getItemCount() {
        return guestList.size();
    }

    class GuestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.guest_name_textView)
        TextView guestName;

        @BindView(R.id.guest_room_textView)
        TextView guestRoom;

        @BindView(R.id.guest_avatar_imageView)
        ImageView guestAvatar;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
