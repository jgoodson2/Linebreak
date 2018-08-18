package com.jtgoodson.linebreak;

import java.util.Date;

class Spot {

    private int _id;
    private Date _dateCreated;
    private String _location_desc;
    private String _extra_details;
    private double _latitude;
    private double _longitude;
    private int _isAvailable;
    private double _askingPrice;

    public double get_askingPrice() {
        return _askingPrice;
    }

    public void set_askingPrice(double _askingPrice) {
        this._askingPrice = _askingPrice;
    }

    public Spot(String _location_desc, String _extra_details, double _latitude, double _longitude, double _askingPrice) {
        this._dateCreated = new Date();
        this._location_desc = _location_desc;
        this._extra_details = _extra_details;
        this._latitude = _latitude;
        this._longitude = _longitude;
        this._isAvailable = 1;
        this._askingPrice = _askingPrice;
    }

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

    public int get_isAvailable() {
        return _isAvailable;
    }

    public void set_isAvailable(int _isAvailable) {
        this._isAvailable = _isAvailable;
    }
}
