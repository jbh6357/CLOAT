package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.UploadVO;

@Mapper
public interface UploadMapper {

	public int insert(UploadVO vo);
	
}
