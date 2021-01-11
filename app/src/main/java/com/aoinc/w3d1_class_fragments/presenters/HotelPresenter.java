package com.aoinc.w3d1_class_fragments.presenters;

import androidx.room.Room;

import com.aoinc.w3d1_class_fragments.models.data.Guest;
import com.aoinc.w3d1_class_fragments.models.db.HotelDatabase;
import com.aoinc.w3d1_class_fragments.presenters.HotelViewPresenterContract.*;

public class HotelPresenter implements HotelPresenterI {
    private HotelViewI hotelView;
    private HotelDatabase hotelDatabase;

    public HotelPresenter(HotelViewI hotelView) {
        this.hotelView = hotelView;

        hotelDatabase = Room.databaseBuilder(hotelView.getContext(),
                HotelDatabase.class, HotelDatabase.DATABASE_NAME
        ).build();
    }

    @Override
    public void checkInGuest(Guest guest) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                hotelDatabase.getGuestDAO().checkInGuest(guest);
                hotelView.displaySuccess(guest.getGuestName() + " checked in");
            }
        }.start();
    }

    @Override
    public void checkOutGuest(Guest guest) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                hotelDatabase.getGuestDAO().checkOutGuest(guest);
                hotelView.displaySuccess(guest.getGuestName() + " checked out");
            }
        }.start();
    }

    @Override
    public void getAllGuests() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                hotelView.displayAllGuests(hotelDatabase.getGuestDAO().getAllGuests());
            }
        }.start();
    }
}
