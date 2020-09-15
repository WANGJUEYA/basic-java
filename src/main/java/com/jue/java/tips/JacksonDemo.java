package com.jue.java.tips;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @date 2020/9/15
 */
public class JacksonDemo {

    public static String arrayToString() {
        String[] list = {"a", "b", "c"};
        ObjectMapper mapper = new ObjectMapper();
        String rs = "";
        try {
            rs = mapper.writeValueAsString(list);
            System.out.println(rs);
            return rs;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<String> stringToArray() {
        String str = "[\"a\",\"b\",\"c\"]";
        ObjectMapper mapper = new ObjectMapper();

        List<String> lendReco = null;
        try {
            lendReco = mapper.readValue(str, new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lendReco);
        return lendReco;
    }

    public static String stringToJsonNode() {
        String ipUrl = "http://whois.pconline.com.cn/ipJson.jsp";
        String keyAddr = "addr";
        String keyPro = "pro";
        String keyCity = "city";
        String address = "XX XX";
        Map<String, String> map = new HashMap<String, String>(2) {{
            put("json", "true");
        }};
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonStr = "{\"keyAddr\" : \"test\"}";
            JsonNode node = mapper.readTree(jsonStr);
            node.has("keyAddr");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String jsonStr = RestTemplateUtils.getForObject(ipUrl, String.class, map);
//        JSONObject json = (JSONObject) JSONObject.parse(jsonStr);
//        if (json.containsKey(keyAddr) && StringUtils.isNoneBlank(json.getString(keyAddr))) {
//            return json.getString(keyAddr);
//        } else if (json.containsKey(keyPro) && StringUtils.isNoneBlank(json.getString(keyPro))
//                && json.containsKey(keyCity) && StringUtils.isNoneBlank(json.getString(keyCity))) {
//            return json.getString(keyPro) + " " + json.getString(keyCity);
//        }
        return address;
    }

    public static void testMap() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(2) {{
            put("1", 1);
            put("2", 2);
        }};
        System.out.println((String) map.get("3"));
        System.out.println(map.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(map));
    }

    public static void main(String[] args) throws JsonProcessingException {
        // stringToJsonNode();
        testMap();
    }
}
