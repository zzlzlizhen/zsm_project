package com.zsm.personplay.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * created by zsm on 2020/5/13
 */
public class ListTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Person(110,"张三"));
        c.add(new Person(111,"李四"));
        c.add(new Person(112,"王五"));
        System.out.println("判断集合中是否存在指定的元素" + c.contains(new Person(110,"李四") ));
        Collection c2 = new ArrayList();
        c2.add(new Person(90,"李子博"));
        c2.add(new Person(110,"张三"));
        System.out.println("c集合有包含c2集合中的所有元素吗？" + c.containsAll(c2));
        Object[] arr = c.toArray();
        for(int i=0; i < arr.length; i++){
            Person person = (Person) arr[i];
            if(person.id == 110){
                System.out.println(person.name);
            }
        }
    }
}
