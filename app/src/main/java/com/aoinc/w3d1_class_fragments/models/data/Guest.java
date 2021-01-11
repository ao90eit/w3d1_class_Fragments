package com.aoinc.w3d1_class_fragments.models.data;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Guest")
public class Guest {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "guest_id")
    private int guestID;

    @ColumnInfo(name = "guest_name")
    private String guestName;

    @ColumnInfo(name = "room_number")
    private String roomNumber;

    @ColumnInfo(name = "guest_photo")
    private String guestPhoto;

    @Ignore
    public Guest(String guestName, String roomNumber, String guestPhoto) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.guestPhoto = guestPhoto;
    }

    public Guest(int guestID, String guestName, String roomNumber, String guestPhoto) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.guestPhoto = guestPhoto;
    }

    public int getGuestID() {
        return guestID;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestPhoto() {
        return guestPhoto;
    }

    public void setGuestPhoto(String guestPhoto) {
        this.guestPhoto = guestPhoto;
    }
}
