package org.spring.redis.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.spring.redis.dao.UserMapper;
import org.spring.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SuppressWarnings("deprecation")
@RunWith(value = org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootApplication.class)
public class TestRedisConfig {
	private static final Logger logger = Logger.getLogger(TestRedisConfig.class);
	
	@Autowired
	private DataSourcePool dataSource;
	@Autowired
	private RedisConfig redisConfig;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private UserMapper userMapper;
	@Test
	public void test() {
		System.out.println(redisConfig.getHost());
		System.out.println(redisConfig.getMaxActive());
		System.out.println(redisConfig.getMaxIdle());
		System.out.println(redisConfig.getMaxWait());
		System.out.println(redisConfig.getPort());
	}
	@Test
	public void test2() {
		System.out.println(dataSource.initDataSource());
	}
	@Test
	public void test3() throws Exception{
		
	/*	String sql = "INSERT INTO USER VALUES (2,'祝雄伟','zxw1994');";
		Connection conn = dataSource.initDataSource().getConnection();
		Statement smt = conn.createStatement();
		int count = smt.executeUpdate(sql);
		if(count > 0){
			logger.info("保存数据成功");
		}*/
		/*sqlSessionFactory.openSession().insert("INSERT INTO USER VALUES (3,'祝雄伟','zxw1994')");
		System.out.println(sqlSessionTemplate);*/
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", "不知道");
		map.put("password", "123456");
		userMapper.insert(map);
		User user = userMapper.findByName("不知道");
		Assert.assertEquals("123456", user.getPassword());
		logger.info(user);
	}
}
