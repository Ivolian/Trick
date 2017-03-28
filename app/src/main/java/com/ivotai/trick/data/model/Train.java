package com.ivotai.trick.data.model;

import java.util.List;

public class Train {

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {

        private TrainInfoBean train_info;
        private List<Station> station_list;

        public TrainInfoBean getTrain_info() {
            return train_info;
        }

        public void setTrain_info(TrainInfoBean train_info) {
            this.train_info = train_info;
        }

        public List<Station> getStation_list() {
            return station_list;
        }

        public void setStation_list(List<Station> station_list) {
            this.station_list = station_list;
        }

        public static class TrainInfoBean {

            private String name;
            private String start;
            private String end;
            private String starttime;
            private String endtime;
            private String mileage;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getMileage() {
                return mileage;
            }

            public void setMileage(String mileage) {
                this.mileage = mileage;
            }
        }

    }
}
