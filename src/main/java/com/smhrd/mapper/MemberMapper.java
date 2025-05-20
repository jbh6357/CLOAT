package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.MemberVO;


@Mapper
public interface MemberMapper {

	public void join(MemberVO vo);

	public MemberVO login(MemberVO vo);
}
