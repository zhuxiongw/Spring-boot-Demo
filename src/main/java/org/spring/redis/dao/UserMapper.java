package org.spring.redis.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.spring.redis.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE username = #{username}")
	User findByName(@Param("username") String username);

	@Insert("INSERT INTO USER(username, password) VALUES(#{username}, #{password})")
	int insert(Map<String,Object> map);
}
