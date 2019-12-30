package com.superlcb.main;

import java.util.HashMap;
import java.util.Stack;

/**
 * author: lcb
 * datetime: 2019/12/30 9:45
 */
public class JsonParser {
    public static HashMap<String,Object> toMap(int begin,int end,String jValue){
        HashMap<String,Object> map=new HashMap<>();
        for(;begin<=end;){
            //解析Key
            System.out.println(jValue);
            StringBuilder key=new StringBuilder();
            while (!(jValue.charAt(begin)=='\''||jValue.charAt(begin)=='\"')){//到达第一个字符串的分割点
                begin++;
            }
            while(jValue.charAt(begin)!=':'){                                 //到达Key 和 Value 的分割点':'
                key.append(jValue.charAt(begin));
                begin++;
            }
            int temp=begin;                                                   //保存begin
            begin--;
            while(!(jValue.charAt((begin))=='\''||jValue.charAt(begin)=='\"')){  //去除可能存在的空格
                key.deleteCharAt(key.length());
                begin--;
            }
            //----------------
            //解析value
            StringBuilder value=new StringBuilder();
            begin=temp;                                                      //恢复begin
            begin++;                                                         //跳过':'
            while (jValue.charAt(begin)==' '){                               //跳过可能存在的空格
                begin++;
            }
            if(jValue.charAt(begin)=='{'){                                     //判断是否为复合对象
                Stack<Character> stack=new Stack<>();
                stack.push(jValue.charAt(begin));
                value.append(jValue.charAt(begin));
                while (!stack.isEmpty()){                                    //栈式匹配防止内部{ }干扰
                    begin++;
                    if(jValue.charAt(begin)=='}'){
                        stack.pop();
                    }else if(jValue.charAt(begin)=='{'){
                        stack.push(jValue.charAt(begin));
                    }
                    value.append(jValue.charAt(begin));
                }
                begin++;                                                    //跳过与第一个匹配的}
            }else {
                while(jValue.charAt(begin)!=','&&begin<=end){               //解析简单类型
                    value.append(jValue.charAt(begin));
                    begin++;
                }
            }
            while(jValue.charAt(begin)==' '){
                begin++;
            }
            if(value.charAt(0)=='{'&&value.charAt(value.length()-1)=='}'){
                map.put(key.toString(),toMap(1,value.length()-2,value.toString()));  //递归解析复合类型

            }else {
                map.put(key.toString(),value.toString());                      //简单类型直接输出
            }
        }
        return map;
    }
}
