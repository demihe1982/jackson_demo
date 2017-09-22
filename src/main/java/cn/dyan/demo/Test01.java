package cn.dyan.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Test01 {

   private static final String str = "{\"data\":{\"hasnext\":0,\"info\":[{\"id\":\"288206077664983\",\"timestamp\":1371052476},{\"id\":\"186983078111768\",\"timestamp\":1370944068},{\"id\":\"297031120529307\",\"timestamp\":1370751789},{\"id\":\"273831022294863\",\"timestamp\":1369994812}],\"timestamp\":1374562897,\"totalnum\":422},\"errcode\":0,\"msg\":\"ok\",\"ret\":0,\"seqid\":5903702688915195270}";

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
       JsonNode root = mapper.readTree(str);

        JsonNode data =  root.path("data");
        JsonNode info = data.path("info");
        System.out.println(info.size());

        JsonNode item = info.get(0);
        System.out.println(item.get("id"));
        System.out.println(item.get("timestamp"));

    }
}
