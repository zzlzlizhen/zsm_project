package com.zsm.personplay.common.utils;

import com.alibaba.fastjson.JSON;
import com.zsm.personplay.city.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by zsm on 2020/4/17
 */
public class JsonUtil {
    public static void main(String[] args) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.jsonArr();
        jsonUtil.jsonObject();
        jsonUtil.json();
    }
    public void jsonArr(){
        String city = readFile("G:\\zsm_project\\city.json");
        List<CityEntity> cityEntityList = JSON.parseArray(city,CityEntity.class);
        for(int i =0 ; i < cityEntityList.size();i++){
            System.out.println("code:" + cityEntityList.get(i).getCode());
            System.out.println("name:" + cityEntityList.get(i).getName());
        }
    }
    public String readFile(String path){
        //找到对应的文件
        File file = new File(path);
        //去读取文件中的内容
        BufferedReader reader = null;
        //把文件解析的内容放到此
        StringBuffer sbf = new StringBuffer();
        //读取文件
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null){
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
    public void jsonObject(){
        File file = new File("G:\\zsm_project\\test.json");
        BufferedReader bufferedReader = null;
        StringBuffer sbf = new StringBuffer();
        String tempStr = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while((tempStr=bufferedReader.readLine())!= null){
                sbf.append(tempStr);
            }
            bufferedReader.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
        String sbfStr = sbf.toString();
        Test test = JSON.parseObject(sbfStr,Test.class);
        System.out.println(test.getId());
        System.out.println(test.getName());
        System.out.println(test.getPassword());
    }

    public void json(){
        //获取到json字符串
        String jsonStr = readFile2("G:\\zsm_project\\test2.json");
        //把json串转换为
        List<Test02> test02List = JSON.parseArray(jsonStr,Test02.class);
        List<TestUser> testUsers = new ArrayList<TestUser>();
        House house  = new House();
        for(Test02 test02 : test02List){
            System.out.println(test02.getName());
            testUsers = test02.getUsers();
        }
        for(TestUser testUser:testUsers){
            System.out.println("username:" + testUser.getUsername());
            System.out.println("password:" + testUser.getPassword());
            house = testUser.getHouse();
            System.out.println("address:" + house.getAddress());
        }

    }
    public String readFile2(String path){
        //创建一个文件对象
        File file = new File(path);
        //读取文件
        BufferedReader bufferedReader = null;
        //把文件内容放到stringbuffer中
        StringBuffer sbf = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String tempStr = "";
            while ((tempStr = bufferedReader.readLine()) != null){
                sbf.append(tempStr);
            }
            bufferedReader.close();
            return sbf.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
