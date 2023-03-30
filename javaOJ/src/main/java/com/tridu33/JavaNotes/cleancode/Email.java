package com.tridu33.JavaNotes.cleancode;

import java.util.HashSet;

public class Email {
    public String address;
    public Email(String address){
        this.address = address;
    }
    public int hashCode(){
        int res = address.hashCode();
        return res;
    }

    public static void main(String[] args) {
        HashSet<Email> set = new HashSet<>();
        Email email = new Email("bing.com");
        set.add(email);
        email.address = "baidu.com";// 修改地址hashCode改变，
        System.out.println(set.contains(email));// false
        set.remove(email);// 会导致泄露
    }
}
