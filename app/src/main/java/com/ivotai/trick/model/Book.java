package com.ivotai.trick.model;

public class Book {

    /**
     * author : 玄无言
     * bid : 15014052
     * categoryName : 东方玄幻
     * catel2name : 玄幻
     * catel3name : 东方玄幻
     * cpushName :
     * discount : null
     * discountChecked : 0
     * discountPrice :
     * exquisite : 0
     * ext : {"unit":"人气","recTitle":"小编力荐","limitPrice":"","discount":"","rent":""}
     * finished : 0
     * from : 0
     * intro : 意志造化世界，肉身破灭寰宇。传承远古至尊秘典的布耀连，顶着侮辱性的名字，在众人嘲讽之下横空出世。平家乱，安国难，震...
     * lastChapter : 222
     * num : null
     * originalPrice :
     * price : 0
     * recTime : 0
     * showPrice :
     * stat_params : {"origin":"908","data_type":0,"alg":"0"}
     * title : 武帝尊
     * totalWords : 493151
     * unitprice : 0
     * updateTime : 0
     */

    private String author;
    private int bid;
    private String categoryName;
    private String catel2name;
    private String catel3name;
    private String cpushName;
    private Object discount;
    private int discountChecked;
    private String discountPrice;
    private int exquisite;
    private ExtBean ext;
    private int finished;
    private int from;
    private String intro;
    private int lastChapter;
    private String num;
    private String originalPrice;
    private int price;
    private int recTime;
    private String showPrice;
    private StatParamsBean stat_params;
    private String title;
    private int totalWords;
    private int unitprice;
    private int updateTime;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatel2name() {
        return catel2name;
    }

    public void setCatel2name(String catel2name) {
        this.catel2name = catel2name;
    }

    public String getCatel3name() {
        return catel3name;
    }

    public void setCatel3name(String catel3name) {
        this.catel3name = catel3name;
    }

    public String getCpushName() {
        return cpushName;
    }

    public void setCpushName(String cpushName) {
        this.cpushName = cpushName;
    }

    public Object getDiscount() {
        return discount;
    }

    public void setDiscount(Object discount) {
        this.discount = discount;
    }

    public int getDiscountChecked() {
        return discountChecked;
    }

    public void setDiscountChecked(int discountChecked) {
        this.discountChecked = discountChecked;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getExquisite() {
        return exquisite;
    }

    public void setExquisite(int exquisite) {
        this.exquisite = exquisite;
    }

    public ExtBean getExt() {
        return ext;
    }

    public void setExt(ExtBean ext) {
        this.ext = ext;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(int lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRecTime() {
        return recTime;
    }

    public void setRecTime(int recTime) {
        this.recTime = recTime;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public StatParamsBean getStat_params() {
        return stat_params;
    }

    public void setStat_params(StatParamsBean stat_params) {
        this.stat_params = stat_params;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public static class ExtBean {
        /**
         * unit : 人气
         * recTitle : 小编力荐
         * limitPrice :
         * discount :
         * rent :
         */

        private String unit;
        private String recTitle;
        private String limitPrice;
        private String discount;
        private String rent;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getRecTitle() {
            return recTitle;
        }

        public void setRecTitle(String recTitle) {
            this.recTitle = recTitle;
        }

        public String getLimitPrice() {
            return limitPrice;
        }

        public void setLimitPrice(String limitPrice) {
            this.limitPrice = limitPrice;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getRent() {
            return rent;
        }

        public void setRent(String rent) {
            this.rent = rent;
        }
    }

    public static class StatParamsBean {
        /**
         * origin : 908
         * data_type : 0
         * alg : 0
         */

        private String origin;
        private int data_type;
        private String alg;

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getData_type() {
            return data_type;
        }

        public void setData_type(int data_type) {
            this.data_type = data_type;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }

}
