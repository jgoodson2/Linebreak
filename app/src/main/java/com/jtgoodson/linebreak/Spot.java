package com.jtgoodson.linebreak;

import java.util.Date;

class Spot {

    private int _id;
    private Date _dateCreated;
    private String _location_desc;
    private String _extra_details;
    private double _latitude;
    private double _longitude;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Date get_dateCreated() {
        return _dateCreated;
    }

    public void set_dateCreated(Date _dateCreated) {
        this._dateCreated = _dateCreated;
    }

    public String get_location_desc() {
        return _location_desc;
    }

    public void set_location_desc(String _location_desc) {
        this._location_desc = _location_desc;
    }

    public String get_extra_details() {
        return _extra_details;
    }

    public void set_extra_details(String _extra_details) {
        this._extra_details = _extra_details;
    }

    public double get_latitude() {
        return _latitude;
    }

    public void set_latitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double get_longitude() {
        return _longitude;
    }

    public void set_longitude(double _longitude) {
        this._longitude = _longitude;
    }
}
