package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.QnaVO;
import com.smhrd.model.ReviewVO;

@Mapper
public interface QnaMapper {

	public List<QnaVO> QnaList();
	
	public int write(QnaVO vo);

	public List<QnaVO> QnaSearch(String searchValue, String searchContent);
	
}