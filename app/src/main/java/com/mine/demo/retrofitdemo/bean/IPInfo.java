package com.mine.demo.retrofitdemo.bean;

public class IPInfo {
    /**
     * ip : 59.56.83.182
     * country : 中国
     * area :
     * region : 福建
     * city : 福州
     * county : XX
     * isp : 电信
     * country_id : CN
     * area_id :
     * region_id : 350000
     * city_id : 350100
     * county_id : xx
     * isp_id : 100017
     */

    public String ip;
    public String country;
    public String area;
    public String region;
    public String city;
    public String county;
    public String isp;
    public String country_id;
    public String area_id;
    public String region_id;
    public String city_id;
    public String county_id;
    public String isp_id;

    @Override
    public String toString() {
        return "IPInfo{" +
                "ip='" + ip + '\'' +
                ", country='" + country + '\'' +
                ", area='" + area + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", isp='" + isp + '\'' +
                ", country_id='" + country_id + '\'' +
                ", area_id='" + area_id + '\'' +
                ", region_id='" + region_id + '\'' +
                ", city_id='" + city_id + '\'' +
                ", county_id='" + county_id + '\'' +
                ", isp_id='" + isp_id + '\'' +
                '}';
    }
}
