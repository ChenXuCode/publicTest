package com.train.biz.basic.entity;

public class Dorm {
    private String dormitoryId;

    private String buildingName;

    private String dormitoryName;


    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId == null ? null : dormitoryId.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName == null ? null : dormitoryName.trim();
    }

   
}