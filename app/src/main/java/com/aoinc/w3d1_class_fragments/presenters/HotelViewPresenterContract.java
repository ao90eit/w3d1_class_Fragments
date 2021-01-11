package com.aoinc.w3d1_class_fragments.presenters;

import android.content.Context;

import com.aoinc.w3d1_class_fragments.models.data.Guest;

import java.util.List;

public interface HotelViewPresenterContract {
    public interface HotelPresenterI {
        void checkInGuest(Guest guest);
        void checkOutGuest(Guest guest);
        void getAllGuests();
    }

    public interface HotelViewI {
        void displayAllGuests(List<Guest> guestList);
        void displaySuccess(String successMessage);
        Context getContext();
    }
}
