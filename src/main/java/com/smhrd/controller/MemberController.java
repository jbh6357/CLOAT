package com.smhrd.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.MapVO;

@Controller
public class MemberController {

	@Autowired
	MemberMapper mapper;
	
	@RequestMapping("/")
	public String book() {	
		return "main";
	}

	@RequestMapping("/map")
	public String map(Model model) {
		return "map";
	}
	
	@RequestMapping("/searchMap")
	public String searchMap(@RequestParam String searchValue,  @RequestParam String searchKeyword, Model model){
		
		List<MapVO> mapvo = null;
		
		if(searchValue=="1") {
			mapvo = mapper.searchMap1(searchKeyword);
		}else if(searchValue=="2") {
			mapvo = mapper.searchMap2(searchKeyword);
		}else if(searchValue=="3") {
			mapvo = mapper.searchMap3(searchKeyword);
		}else {
			mapvo = mapper.searchMap(searchKeyword);
		}

		model.addAttribute("mapvo", mapvo);
		return "map";
	}
	
	@RequestMapping("/upload")
	public String upload() {
		return "upload_test";
	}
	
	@RequestMapping("/do_upload")
	public void do_upload(@RequestParam(value= "file", required = false)MultipartFile file) {
        ClassPathResource resource = new ClassPathResource("pic");
        String absolutePath = null;
		try {
			absolutePath = resource.getFile().getAbsolutePath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Upload directory: " + absolutePath);
//		return "upload_test2";
	}
	
}
