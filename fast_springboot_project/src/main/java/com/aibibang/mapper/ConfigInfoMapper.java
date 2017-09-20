package com.aibibang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aibibang.domain.ConfigInfo;

/**
 * @author：Truman.P.Du
 * @createDate: 2017年8月29日 下午1:34:28
 * @version:1.0
 * @description:
 */
@Mapper
public interface ConfigInfoMapper {
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "maxDay", column = "maxday"), @Result(property = "config", column = "config"),
			@Result(property = "cron", column = "cron"),@Result(property = "status", column = "status") })

	@Select("select * from config_info")
	List<ConfigInfo> findAll();

	@Select("select * from config_info where id = #{id}")
	ConfigInfo findById(Long id);

	@Delete("delete from config_info where id = #{id}")
	void Delete(Long id);

	@Insert("insert into config_info(name,type,maxday,config,status,cron) VALUES(#{name}, #{type},#{maxDay},#{config},#{status},#{cron})")
	void add(ConfigInfo configInfo);

	@Update("update config_info set name=#{name},cron=#{cron},type=#{type},maxday=#{maxDay},config=#{config},status=#{status} where id=#{id}")
	int update(ConfigInfo configInfo);

}
