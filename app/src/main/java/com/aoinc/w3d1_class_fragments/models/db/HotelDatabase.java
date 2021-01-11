package com.aoinc.w3d1_class_fragments.models.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.aoinc.w3d1_class_fragments.models.data.Guest;

@Database(version = 1, entities = {Guest.class})
public abstract class HotelDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "hotel.db";
    public abstract GuestDAO getGuestDAO();
}
