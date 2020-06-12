package com.zsm.personplay.collection;

/**
 * created by zsm on 2020/5/13
 */
public class Person {
     int id;
     String name;
    public Person(int id,String name){
        this.id = id;
        this.name = name;
    }
    public boolean equals(Object o){
        Person person = (Person) o;
        return this.id == person.id;
    }
    public int hashCode(){
        return this.id;
    }
}
