package com.smhrd.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.mapper.MapMapper;
import com.smhrd.model.MapVO;

@Controller
public class MapController {

	@Autowired 
	MapMapper mapper;
	
	@RequestMapping("/map")
	public String map(@RequestParam String type) {
		
		String encodedType = "";
		try {
			encodedType = URLEncoder.encode(type, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:/searchMap?searchValue=0&type=" + encodedType + "&searchKeyword=";
	}
	
	@RequestMapping("/searchMap")
	public String searchMap(@RequestParam String searchValue,  @RequestParam String searchKeyword, 
							@RequestParam String type, Model model){
		
		
		List<MapVO> mapvo = null;
		
		if(searchValue=="1") {
			mapvo = mapper.searchMap1(searchKeyword, type);
		}else if(searchValue=="2") {
			mapvo = mapper.searchMap2(searchKeyword, type);
		}else if(searchValue=="3") {
			mapvo = mapper.searchMap3(searchKeyword, type);
		}else {
			mapvo = mapper.searchMap(searchKeyword, type);
		}
		model.addAttribute("type", type);
		model.addAttribute("mapvo", mapvo);
		return "Map";
	}
	
	
}
