package com.superlcb.test;

import com.superlcb.main.JsonParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

public class MyTest {

  /***
   * author by : lcb
   * date : 2019/12/30 9:37
   * message:
   */
  @Test
  public void testToMap(){
    String json="{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"科技园路.\",\"city\":\"江苏苏州\",\"country\":\"中国\",\"a\":{\"a\":true} },\"links\":{\"name\":\"Google\",\"url\":\"http://www.google.com\"}}";
    HashMap<String, Object> map = JsonParser.toMap(1, json.length() - 2, json);
    Object o = map.get("\"address\"");
    System.out.println(o);


  }


}
