package cn.dyan.services;

import cn.dyan.model.DemoVo;
import cn.dyan.mybatis.domain.TbUser;
import cn.dyan.mybatis.mapper.TbUserMapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.beans.DesignMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@Component
public class DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private DataSource dataSource;

    public void test(){
        DemoVo vo = new DemoVo();
        vo.setName("admin");
        vo.setDesc("description");

        LOGGER.info("DemoVo[{}]",vo);

    }

    public List<TbUser> queryAll(){
        return userMapper.selectAll();
    }

    @Transactional(rollbackFor = MySQLSyntaxErrorException.class)
    public boolean createUser(String uname) throws SQLException {
        TbUser user = new TbUser();
        user.setUname(uname);
        user.setUuid(UUID.randomUUID().toString());
        userMapper.insert(user);

        Connection cnn = DataSourceUtils.getConnection(dataSource);
        Statement stmt = null;
        try{
            stmt = cnn.createStatement();
            stmt.execute("INSERT INTO tb_test(uuid,test) VALUES('1111','test1111')");
        }finally {
            DataSourceUtils.releaseConnection(cnn,dataSource);
        }
        return true;

    }
}
