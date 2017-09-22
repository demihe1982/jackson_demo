package cn.dyan.demo;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        //构建JSON文件
        JsonFactory factory = new JsonFactory();
        JsonGenerator g = factory.createGenerator(new File("user.json"), JsonEncoding.UTF8);
        g.writeStartObject();
        g.writeObjectFieldStart("name");
        g.writeObjectField("first","Joe");
        g.writeObjectField("last","Hankcs");
        g.writeEndObject();
        g.close();

    }
}
