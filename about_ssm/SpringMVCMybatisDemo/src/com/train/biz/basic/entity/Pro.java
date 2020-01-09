package com.train.biz.basic.entity;

public class Pro {
    private String professionId;

    private String professionDepartment;

    private String professionName;

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId == null ? null : professionId.trim();
    }

    public String getProfessionDepartment() {
        return professionDepartment;
    }

    public void setProfessionDepartment(String professionDepartment) {
        this.professionDepartment = professionDepartment == null ? null : professionDepartment.trim();
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName == null ? null : professionName.trim();
    }
}