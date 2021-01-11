package com.aoinc.w3d1_class_fragments.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.aoinc.w3d1_class_fragments.R;
import com.aoinc.w3d1_class_fragments.models.data.Guest;
import com.aoinc.w3d1_class_fragments.presenters.HotelPresenter;
import com.aoinc.w3d1_class_fragments.presenters.HotelViewPresenterContract;
import com.aoinc.w3d1_class_fragments.presenters.HotelViewPresenterContract.HotelViewI;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HotelViewI {

    private HotelPresenter hotelPresenter;
    private GuestListFragment guestListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guestListFragment = (GuestListFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);

        hotelPresenter = new HotelPresenter(this);

        // FAKE GUEST CREATION
        Guest g1 = new Guest("Bob Hoskins", "201",
                "https://tinyurl.com/y5oqrmm6");

        Guest g2 = new Guest("Medudesa", "665",
                "https://tinyurl.com/y62gkpm9");

        hotelPresenter.checkInGuest(g1);
        hotelPresenter.checkInGuest(g2);
        // END FAKE GUESTS

        hotelPresenter.getAllGuests();
    }

    @Override
    public void displayAllGuests(List<Guest> guestList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                guestListFragment.displayList(guestList);
            }
        });
    }

    @Override
    public void displaySuccess(String successMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    @Override
    public Context getContext() {
        return this;
    }
}