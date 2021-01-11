package com.aoinc.w3d1_class_fragments.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.aoinc.w3d1_class_fragments.R;
import com.aoinc.w3d1_class_fragments.models.data.Guest;
import com.aoinc.w3d1_class_fragments.views.adapters.GuestAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestListFragment extends Fragment {

    @BindView(R.id.guest_recyclerView)
    public RecyclerView guestRecyclerView;

    private GuestAdapter guestAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedFragmentView = inflater.inflate(R.layout.guest_list_fragment_layout, container, false);
        return inflatedFragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        guestAdapter = new GuestAdapter(new ArrayList<>()); // empty for placeholder
        guestRecyclerView.setAdapter(guestAdapter);
    }

    public void displayList(List<Guest> allGuests) {
        guestAdapter.updateGuests(allGuests);
    }
}
