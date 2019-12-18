package com.bootproject.sklweb.mapper;

import com.bootproject.sklweb.entity.Sugges;
import com.bootproject.sklweb.entity.SuggesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuggesMapper {
    int countByExample(SuggesExample example);

    int deleteByExample(SuggesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sugges record);

    int insertSelective(Sugges record);

    List<Sugges> selectByExample(SuggesExample example);

    Sugges selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sugges record, @Param("example") SuggesExample example);

    int updateByExample(@Param("record") Sugges record, @Param("example") SuggesExample example);

    int updateByPrimaryKeySelective(Sugges record);

    int updateByPrimaryKey(Sugges record);
}