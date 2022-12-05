package com.xxx.springsecuritydemo.service;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class Singleton {
    /*//e
    private static final Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton(){
        return singleton;
    }*/

    /*//l
    private static Singleton singleton = null;
    private Singleton(){}
    public synchronized static Singleton getSingleton(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }*/
    public static void main(String[] args) {
        int[] a = {1231241, 45436, 4643};
        int temp;
        /*for(int i = 0,i<a.length - 1, i++){
            for(j = 0,j<a.length-1,j++){
                tem =
            }

        }*/
    }
}
