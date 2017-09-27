package cn.dyan.services;

import cn.dyan.model.DemoVo;
import cn.dyan.mybatis.domain.TbUser;
import cn.dyan.mybatis.mapper.TbUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.DesignMode;
import java.util.List;

@Component
public class DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private TbUserMapper userMapper;

    public void test(){
        DemoVo vo = new DemoVo();
        vo.setName("admin");
        vo.setDesc("description");

        LOGGER.info("DemoVo[{}]",vo);

    }

    public List<TbUser> queryAll(){
        return userMapper.selectAll();
    }
}
