package cn.dyan;

import cn.dyan.services.DemoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
@MapperScan(basePackages = {"cn.dyan.mybatis.mapper"})
public class Application {
    public static void main(String[] args){
        ApplicationContext context =  SpringApplication.run(Application.class,args);
        DemoService service = context.getBean(DemoService.class);

        try {
            service.createUser("test123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        service.queryAll().stream().forEach(tbUser -> {
//            System.out.println("uid:"+tbUser.getUuid()+" uname:"+tbUser.getUname());
//        });

    }
}
