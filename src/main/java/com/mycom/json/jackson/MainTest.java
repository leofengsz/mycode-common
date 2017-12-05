package com.mycom.json.jackson;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class MainTest {

  public static void main(String[] args) throws Exception{
    Person person = new Person();
    person.setUsername("张三");
    person.setSex("男");
    person.setAge(16);

    // object to json
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter objectWriter = mapper.writerWithView(person.getClass());
    System.out.println(objectWriter.writeValueAsString(person));

    // json to object
    String json = "{\"username\":\"李四\",\"sex\":\"女\",\"age\":26}";
    ObjectReader reader = mapper.reader(Person.class);
    Person ps = reader.readValue(json);
    System.out.println(ps.getUsername()+" == "+ps.getSex()+" == "+ps.getAge());
    
    System.out.println(BigDecimal.ONE);
    
    Map<String,String> map = new HashMap<String,String>();
    map.put("aaa", "bbb");
    System.out.println((String)map.get("bbb"));
  }

}
