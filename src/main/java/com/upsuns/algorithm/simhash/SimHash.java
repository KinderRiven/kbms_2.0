package com.upsuns.algorithm.simhash;

import java.util.ArrayList;
import java.util.List;

/* Created by KinderRiven on 2017/3/18.*/
public class SimHash {

    private final static int rand = 31;
    private final static int add = 256;

    public static int hmSize(String hash1, String hash2){

        int length = hash1.length();
        int tmp = 0;
        for(int i = 0; i < length; i++){
            if(hash1.charAt(i) != hash2.charAt(i))
                tmp ++;
        }
        return tmp;
    }

    public static Long hash(String key){

        byte[] bytes = key.getBytes();
        Long ret = 0L;

        for(int i = 0; i < bytes.length; i++){
            ret = ret * rand + (bytes[i] + add);
        }
        return ret;
    }

    public static String getSuffixZero(int size){

        String ret = "";
        for(int i = 0; i < size; i++)
            ret += "0";
        return ret;

    }

    public static String  calculate(List<String> values, List<Integer> weights){

        boolean def = false;
        String hashCode = "";

        for(int i = 0; i < 64; i++){
            Integer tmp = 0;
            for(int j = 0; j < values.size(); j++){
                if(values.get(j).charAt(i) == '0'){
                    tmp -= weights.get(j);

                } else{
                    tmp += weights.get(j);
                }
            }
            if(tmp > 0) hashCode += "1";
            else hashCode += "0";
        }

        return hashCode;
    }

    public static String simHash(List<String> keys, List<Integer> weights){

        List<String> values = new ArrayList<String>();

        for(String key : keys){
            String tmp = Long.toBinaryString(hash(key));
            String value = getSuffixZero(64 - tmp.length()) + tmp;
            values.add(value);
        }

        String codes = calculate(values, weights);
        return codes;
    }
}
