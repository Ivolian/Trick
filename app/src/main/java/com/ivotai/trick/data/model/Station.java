package com.ivotai.trick.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Station {

    @Id
    private String train_id;
    private String station_name;
    private String arrived_time;
    private String leave_time;
    private String mileage;
    private String fsoftSeat;
    private String ssoftSeat;
    private String hardSead;
    private String softSeat;
    private String hardSleep;
    private String softSleep;
    private String wuzuo;
    private String swz;
    private String tdz;
    private String gjrw;
    private String stay;
    @Generated(hash = 991682325)
    public Station(String train_id, String station_name, String arrived_time,
            String leave_time, String mileage, String fsoftSeat, String ssoftSeat,
            String hardSead, String softSeat, String hardSleep, String softSleep,
            String wuzuo, String swz, String tdz, String gjrw, String stay) {
        this.train_id = train_id;
        this.station_name = station_name;
        this.arrived_time = arrived_time;
        this.leave_time = leave_time;
        this.mileage = mileage;
        this.fsoftSeat = fsoftSeat;
        this.ssoftSeat = ssoftSeat;
        this.hardSead = hardSead;
        this.softSeat = softSeat;
        this.hardSleep = hardSleep;
        this.softSleep = softSleep;
        this.wuzuo = wuzuo;
        this.swz = swz;
        this.tdz = tdz;
        this.gjrw = gjrw;
        this.stay = stay;
    }
    @Generated(hash = 833410198)
    public Station() {
    }
    public String getTrain_id() {
        return this.train_id;
    }
    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }
    public String getStation_name() {
        return this.station_name;
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
    public String getArrived_time() {
        return this.arrived_time;
    }
    public void setArrived_time(String arrived_time) {
        this.arrived_time = arrived_time;
    }
    public String getLeave_time() {
        return this.leave_time;
    }
    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }
    public String getMileage() {
        return this.mileage;
    }
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
    public String getFsoftSeat() {
        return this.fsoftSeat;
    }
    public void setFsoftSeat(String fsoftSeat) {
        this.fsoftSeat = fsoftSeat;
    }
    public String getSsoftSeat() {
        return this.ssoftSeat;
    }
    public void setSsoftSeat(String ssoftSeat) {
        this.ssoftSeat = ssoftSeat;
    }
    public String getHardSead() {
        return this.hardSead;
    }
    public void setHardSead(String hardSead) {
        this.hardSead = hardSead;
    }
    public String getSoftSeat() {
        return this.softSeat;
    }
    public void setSoftSeat(String softSeat) {
        this.softSeat = softSeat;
    }
    public String getHardSleep() {
        return this.hardSleep;
    }
    public void setHardSleep(String hardSleep) {
        this.hardSleep = hardSleep;
    }
    public String getSoftSleep() {
        return this.softSleep;
    }
    public void setSoftSleep(String softSleep) {
        this.softSleep = softSleep;
    }
    public String getWuzuo() {
        return this.wuzuo;
    }
    public void setWuzuo(String wuzuo) {
        this.wuzuo = wuzuo;
    }
    public String getSwz() {
        return this.swz;
    }
    public void setSwz(String swz) {
        this.swz = swz;
    }
    public String getTdz() {
        return this.tdz;
    }
    public void setTdz(String tdz) {
        this.tdz = tdz;
    }
    public String getGjrw() {
        return this.gjrw;
    }
    public void setGjrw(String gjrw) {
        this.gjrw = gjrw;
    }
    public String getStay() {
        return this.stay;
    }
    public void setStay(String stay) {
        this.stay = stay;
    }


}
