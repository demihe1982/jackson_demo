package cn.dyan.services;

import cn.dyan.model.DemoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.beans.DesignMode;

@Component
public class DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    public void test(){
        DemoVo vo = new DemoVo();
        vo.setName("admin");
        vo.setDesc("description");

        LOGGER.info("DemoVo[{}]",vo);

    }
}
