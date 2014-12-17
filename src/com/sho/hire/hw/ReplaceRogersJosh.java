package com.sho.hire.hw;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 12/16/14
 * Time: 10:10 PM
 * # TODO
 */
public class ReplaceRogersJosh {
    public static class MyStringBuffer{
        int insertPos = 0;
        private final StringBuffer buf;
        MyStringBuffer(int capacity){
            buf = new StringBuffer(capacity);
        }
        public void insert(String s){
            buf.insert(insertPos,s);
            insertPos += s.length();
        }
        public void insert(char c){
            buf.insert(insertPos,c);
            insertPos++;
        }
        public void insertSpace(){
            buf.insert(0,' ');
            insertPos = 0;
        }
        public String toString(){
            return buf.toString();
        }
    }
    public static void addInReverse(String s, MyStringBuffer buf){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            addInReverse(c,buf);
        }
    }
    public static void addInReverse(char c, MyStringBuffer buf){
        if(c == ' '){
            buf.insertSpace();
        }else{
            buf.insert(c);
        }
    }
    public static String ecalpeResrever(String haystack, String needle, String replacement){
        int needlepos = 0;
        boolean isMarked = false;
        StringBuffer needlebuf = new StringBuffer(needle.length());
        MyStringBuffer buf = new MyStringBuffer(haystack.length());
        int i = 0;
        while(i < haystack.length()){
            char c = haystack.charAt(i);
            if(isMarked && needlebuf.length() == needle.length()){
                isMarked = false;
                addInReverse(replacement,buf);
            }else if(isMarked && c == needle.charAt(needlepos)){
                needlebuf.append(c);
                needlepos++;
                i++;
            }else if(isMarked){
                isMarked = false;
                addInReverse(needlebuf.toString(),buf);
            }else if (!isMarked && c == needle.charAt(0)){
                needlebuf = new StringBuffer(needle.length());
                needlepos = 0;
                isMarked = true;
            }else{
                addInReverse(c,buf);
                i++;
            }
        }
        if(isMarked && needlebuf.length() == needle.length()){
            isMarked = false;
            addInReverse(replacement,buf);
        }
        return buf.toString();
    }
    public static void print(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        System.out.println(ecalpeResrever("ABC", "A", "a"));
        System.out.println(ecalpeResrever("AAA AAB BAA", "AA", "a"));
        System.out.println(ecalpeResrever("I Work.", "Work", "Play"));
        System.out.println(ecalpeResrever("Tests are the best!","the best!","just ok."));
        System.out.println(ecalpeResrever("blergl hello world", "ld", "mer bur"));

    }

}
