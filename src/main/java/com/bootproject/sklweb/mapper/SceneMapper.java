package com.bootproject.sklweb.mapper;

import com.bootproject.sklweb.entity.Scene;
import com.bootproject.sklweb.entity.SceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SceneMapper {
    int countByExample(SceneExample example);

    int deleteByExample(SceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scene record);

    int insertSelective(Scene record);

    List<Scene> selectByExample(SceneExample example);

    Scene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scene record, @Param("example") SceneExample example);

    int updateByExample(@Param("record") Scene record, @Param("example") SceneExample example);

    int updateByPrimaryKeySelective(Scene record);

    int updateByPrimaryKey(Scene record);
}