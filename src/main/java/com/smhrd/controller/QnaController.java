package com.smhrd.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.mapper.QnaMapper;
import com.smhrd.model.QnaVO;
import com.smhrd.model.ReviewVO;

@Controller 
public class QnaController {
	
	@Autowired
	QnaMapper mapper;

	//업로드용
	@Autowired
	ServletContext context;
		
	@RequestMapping("/QnaList")
	public String QnaList(Model model) {
	    List<QnaVO> list = mapper.QnaList();

	    // 여기서 데이터 개수 로그 찍기
	    System.out.println("가져온 데이터 개수: " + list.size());

	    model.addAttribute("list", list);
	    return "Qna";
	}
	
	@RequestMapping("/QnaSearch")
	public String QnaSearch(@RequestParam String searchValue, @RequestParam String searchContent ,Model model) {
		
		List<QnaVO> list = mapper.QnaSearch(searchValue, searchContent);
		System.out.println(searchValue + " " + searchContent);
		model.addAttribute("list", list);
		return "Qna";
	}
	
	@RequestMapping("/QnaWrite")
	public String QnaWrite() {
		return "QnaWrite";
	}

	@RequestMapping("/QnaUpload")
	public String QnaUpload(QnaVO vo, @RequestParam(value= "file", required = false)MultipartFile file) {
		String loc = context.getRealPath("/resources/file/");
		FileOutputStream fos;
		String fileDemo = "null";
		if (file != null && !file.isEmpty()) {
			fileDemo = file.getOriginalFilename();
			if(fileDemo.length() > 0) {
				try {
					String baseName = fileDemo.substring(0, fileDemo.lastIndexOf("."));
					String extension = fileDemo.substring(fileDemo.lastIndexOf("."));
					fileDemo = baseName + '_' + UUID.randomUUID().toString() + extension;
					File targetFile = new File(loc, fileDemo);
					fos = new FileOutputStream(targetFile);
					fos.write(file.getBytes());
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		vo.setQna_file(fileDemo);
		vo.setQna_views(0);
		
		int result = mapper.write(vo);
		
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return "redirect:/QnaList";
	}
}