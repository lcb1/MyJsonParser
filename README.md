# MyJsonParser
### 一个json解析的工具类
**支持json的递归嵌套解析和基本类型解析,暂不支持json数组解析,且关键字符出现在json**
**字符串中会有一定bug.**
**日后会增加数组解析,以及关键字符容错,反射封装成javabean等功能**


### 测试


```
  /***
   * author by : lcb
   * date : 2019/12/30 9:37
   * message:
   * {
   *     "nam\"e": "BeJson",
   *     "url": "http://www.bejson.com",
   *     "page": 88,
   *     "isNonProfit": true,
   *     "address": {
   *         "street": "科技园路.",
   *         "city": "江苏苏州",
   *         "country": "中国"
   *     },
   *     "links": {
   *         "name": "Google",
   *         "url": "http://www.google.com"
   *     }
   * }
   */

  @Test
  public void testToMap(){
    String json="{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"科技园路.\",\"city\":\"江苏苏州\",\"country\":\"中国\",\"a\":{\"a\":true} },\"links\":{\"name\":\"Google\",\"url\":\"http://www.google.com\"}}";
    HashMap<String, Object> map = JsonParser.toMap(1, json.length() - 2, json);
    Object object = map.get("\"address\"");
    System.out.println(object);


  }
  
  控制台输出
  ---------
  {"street"="科技园路.", "a"={"a"=true}, "country"="中国", "city"="江苏苏州"}
```
