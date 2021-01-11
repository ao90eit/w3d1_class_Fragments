package com.aoinc.w3d1_class_fragments.models.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.aoinc.w3d1_class_fragments.models.data.Guest;

import java.util.List;

@Dao
public interface GuestDAO {
    @Insert
    void checkInGuest(Guest... newGuest); // var args -> '...' for any number of args

    @Delete
    void checkOutGuest(Guest... outgoingGuest);

    @Query("SELECT * FROM Guest WHERE guest_id = :guestID")
    public Guest getGuest(int guestID);

    @Query("SELECT * FROM Guest")
    public List<Guest> getAllGuests();

    @Update
    public void updateGuest(Guest guest);
}
