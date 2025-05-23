package com.smhrd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.smhrd.model.NewsVO;

@Mapper
public interface NewsMapper {

	public List<NewsVO> NewsList();
	
	public int write(NewsVO vo);

	public List<NewsVO> NewsSearch(String searchValue, String searchContent);
	
}