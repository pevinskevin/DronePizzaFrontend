package com.pevinskevin.dronepizzafrontend.Model;

import java.util.UUID;

public class Drone {
    private long id;
    private Station station;
    private UUID serialUUID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public UUID getSerialUUID() {
        return serialUUID;
    }

    public void setSerialUUID(UUID serialUUID) {
        this.serialUUID = serialUUID;
    }
}
