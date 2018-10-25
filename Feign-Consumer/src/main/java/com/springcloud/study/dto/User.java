package com.springcloud.study.dto;

/**
 * @author chao.shen01@hand-china.com
 * @description
 * @Data 2018/10/24 16:02
 */
public class User {
    private Integer age;
    private String name;

    public User(){
    }

    public User(String name, Integer age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    private void setName(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return "name="+name+ ", age="+age;
    }
}
