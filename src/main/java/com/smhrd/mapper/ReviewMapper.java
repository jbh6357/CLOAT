package com.smhrd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.smhrd.model.ReviewVO;

@Mapper
public interface ReviewMapper {

	public List<ReviewVO> ReviewList();

	public int write(ReviewVO vo);

	public List<ReviewVO> ReviewSearch(String searchValue, String searchContent);
	
}