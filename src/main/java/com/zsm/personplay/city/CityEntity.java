package com.zsm.personplay.city;

/**
 * created by zsm on 2020/4/17
 */
public class CityEntity {
    private String code;
    private String name;
    public CityEntity(){}
    public CityEntity(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
