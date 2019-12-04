package com.jum.vo.shoppingmall;

import com.dfire.soa.shop.bo.Mall;

/**
 * Created by musi
 * on 2018/3/13.
 */
public class MallVo extends Mall {

    /**
     * 掌柜手机号码
     */
    private String adminMobile;

    /**
     * 掌柜手机号码区号
     */
    private String adminMobileCode;

    /**
     * 地区
     */
    private String district;

    private String[] mytext;

    private String keyword;

    private String queryStatus;

    private String startTime;

    private String endTime;

    private Integer pageIndex;

    private String mallContractId;

    private String mallContractCode;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile;
    }

    public String getAdminMobileCode() {
        return adminMobileCode;
    }

    public void setAdminMobileCode(String adminMobileCode) {
        this.adminMobileCode = adminMobileCode;
    }

    public String[] getMytext() {
        return mytext;
    }

    public void setMytext(String[] mytext) {
        this.mytext = mytext;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    public String getMallContractId() {
        return mallContractId;
    }

    public void setMallContractId(String mallContractId) {
        this.mallContractId = mallContractId;
    }

    public String getMallContractCode() {
        return mallContractCode;
    }

    public void setMallContractCode(String mallContractCode) {
        this.mallContractCode = mallContractCode;
    }
}
