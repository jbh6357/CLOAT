package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.MapVO;

@Mapper
public interface MapMapper {

	public List<MapVO> map();

	public List<MapVO> searchMap(String searchKeyword);

	public List<MapVO> searchMap1(String searchKeyword);

	public List<MapVO> searchMap2(String searchKeyword);

	public List<MapVO> searchMap3(String searchKeyword);
}
