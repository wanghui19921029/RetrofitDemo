package com.example.wh.retrofitdemo;

import java.util.List;

public class WeatherBean {
    @Override
    public String toString() {
        return "day1 = " + data.getForecast().get(2).notice + ", day2 = " + data.getForecast().get(3).notice;
    }

    /**
     * time : 2019-03-09 13:01:02
     * cityInfo : {"city":"天津市","cityId":"101030100","parent":"天津","updateTime":"12:23"}
     * date : 20190309
     * message : Success !
     * status : 200
     * data : {"shidu":"22%","pm25":62,"pm10":78,"quality":"良","wendu":"13","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"08","sunrise":"06:36","high":"高温 16.0℃","low":"低温 5.0℃","sunset":"18:10","aqi":85,"ymd":"2019-03-08","week":"星期五","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},"forecast":[{"date":"09","sunrise":"06:35","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:11","aqi":104,"ymd":"2019-03-09","week":"星期六","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10","sunrise":"06:33","high":"高温 12.0℃","low":"低温 3.0℃","sunset":"18:12","aqi":85,"ymd":"2019-03-10","week":"星期日","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"11","sunrise":"06:32","high":"高温 12.0℃","low":"低温 3.0℃","sunset":"18:13","aqi":51,"ymd":"2019-03-11","week":"星期一","fx":"西北风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"12","sunrise":"06:30","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:14","aqi":28,"ymd":"2019-03-12","week":"星期二","fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","sunrise":"06:29","high":"高温 16.0℃","low":"低温 4.0℃","sunset":"18:15","aqi":36,"ymd":"2019-03-13","week":"星期三","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"14","sunrise":"06:27","high":"高温 17.0℃","low":"低温 6.0℃","sunset":"18:16","aqi":38,"ymd":"2019-03-14","week":"星期四","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"15","sunrise":"06:26","high":"高温 18.0℃","low":"低温 3.0℃","sunset":"18:17","ymd":"2019-03-15","week":"星期五","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","sunrise":"06:24","high":"高温 15.0℃","low":"低温 6.0℃","sunset":"18:18","ymd":"2019-03-16","week":"星期六","fx":"北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"17","sunrise":"06:23","high":"高温 16.0℃","low":"低温 6.0℃","sunset":"18:19","ymd":"2019-03-17","week":"星期日","fx":"南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","sunrise":"06:21","high":"高温 18.0℃","low":"低温 7.0℃","sunset":"18:20","ymd":"2019-03-18","week":"星期一","fx":"南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"19","sunrise":"06:19","high":"高温 21.0℃","low":"低温 10.0℃","sunset":"18:21","ymd":"2019-03-19","week":"星期二","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"20","sunrise":"06:18","high":"高温 21.0℃","low":"低温 4.0℃","sunset":"18:22","ymd":"2019-03-20","week":"星期三","fx":"东风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"21","sunrise":"06:16","high":"高温 5.0℃","low":"低温 0.0℃","sunset":"18:23","ymd":"2019-03-21","week":"星期四","fx":"东风","fl":"3-4级","type":"雨夹雪","notice":"道路湿滑，步行开车要谨慎"},{"date":"22","sunrise":"06:15","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:24","ymd":"2019-03-22","week":"星期五","fx":"西风","fl":"4-5级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"23","sunrise":"06:13","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:25","ymd":"2019-03-23","week":"星期六","fx":"西北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]}
     */


    private String time;
    private CityInfoBean cityInfo;
    private String date;
    private String message;
    private int status;
    private DataBean data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 天津市
         * cityId : 101030100
         * parent : 天津
         * updateTime : 12:23
         */

        private String city;
        private String cityId;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {

        /**
         * shidu : 22%
         * pm25 : 62.0
         * pm10 : 78.0
         * quality : 良
         * wendu : 13
         * ganmao : 极少数敏感人群应减少户外活动
         * yesterday : {"date":"08","sunrise":"06:36","high":"高温 16.0℃","low":"低温 5.0℃","sunset":"18:10","aqi":85,"ymd":"2019-03-08","week":"星期五","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}
         * forecast : [{"date":"09","sunrise":"06:35","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:11","aqi":104,"ymd":"2019-03-09","week":"星期六","fx":"东南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"10","sunrise":"06:33","high":"高温 12.0℃","low":"低温 3.0℃","sunset":"18:12","aqi":85,"ymd":"2019-03-10","week":"星期日","fx":"东风","fl":"<3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"11","sunrise":"06:32","high":"高温 12.0℃","low":"低温 3.0℃","sunset":"18:13","aqi":51,"ymd":"2019-03-11","week":"星期一","fx":"西北风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"12","sunrise":"06:30","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:14","aqi":28,"ymd":"2019-03-12","week":"星期二","fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"13","sunrise":"06:29","high":"高温 16.0℃","low":"低温 4.0℃","sunset":"18:15","aqi":36,"ymd":"2019-03-13","week":"星期三","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"14","sunrise":"06:27","high":"高温 17.0℃","low":"低温 6.0℃","sunset":"18:16","aqi":38,"ymd":"2019-03-14","week":"星期四","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"15","sunrise":"06:26","high":"高温 18.0℃","low":"低温 3.0℃","sunset":"18:17","ymd":"2019-03-15","week":"星期五","fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","sunrise":"06:24","high":"高温 15.0℃","low":"低温 6.0℃","sunset":"18:18","ymd":"2019-03-16","week":"星期六","fx":"北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"17","sunrise":"06:23","high":"高温 16.0℃","low":"低温 6.0℃","sunset":"18:19","ymd":"2019-03-17","week":"星期日","fx":"南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","sunrise":"06:21","high":"高温 18.0℃","low":"低温 7.0℃","sunset":"18:20","ymd":"2019-03-18","week":"星期一","fx":"南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"19","sunrise":"06:19","high":"高温 21.0℃","low":"低温 10.0℃","sunset":"18:21","ymd":"2019-03-19","week":"星期二","fx":"西南风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"20","sunrise":"06:18","high":"高温 21.0℃","low":"低温 4.0℃","sunset":"18:22","ymd":"2019-03-20","week":"星期三","fx":"东风","fl":"4-5级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"21","sunrise":"06:16","high":"高温 5.0℃","low":"低温 0.0℃","sunset":"18:23","ymd":"2019-03-21","week":"星期四","fx":"东风","fl":"3-4级","type":"雨夹雪","notice":"道路湿滑，步行开车要谨慎"},{"date":"22","sunrise":"06:15","high":"高温 8.0℃","low":"低温 2.0℃","sunset":"18:24","ymd":"2019-03-22","week":"星期五","fx":"西风","fl":"4-5级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"23","sunrise":"06:13","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:25","ymd":"2019-03-23","week":"星期六","fx":"西北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]
         */


        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 08
             * sunrise : 06:36
             * high : 高温 16.0℃
             * low : 低温 5.0℃
             * sunset : 18:10
             * aqi : 85.0
             * ymd : 2019-03-08
             * week : 星期五
             * fx : 西南风
             * fl : 3-4级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String ymd;
            private String week;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

        }

        public static class ForecastBean {
            /**
             * date : 09
             * sunrise : 06:35
             * high : 高温 13.0℃
             * low : 低温 4.0℃
             * sunset : 18:11
             * aqi : 104.0
             * ymd : 2019-03-09
             * week : 星期六
             * fx : 东南风
             * fl : <3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String ymd;
            private String week;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
