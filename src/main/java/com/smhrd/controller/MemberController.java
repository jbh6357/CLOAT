package com.smhrd.controller;


import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.MemberVO;

@Controller
public class MemberController {

	@Autowired
	MemberMapper mapper;
	
	//업로드용
	@Autowired
	ServletContext context;
	
//	@RequestMapping("/upload")
//	public String upload() {
//		return "upload_test";
//	}
//	
//	@RequestMapping("/do_upload")
//	public String do_upload(@RequestParam(value= "file", required = false)MultipartFile file, Model model) {
////		String loc = "C:/eGovFrame-4.0.0/workspace.edu/Project/src/main/webapp/resources/upload/";
//		String loc = context.getRealPath("/resources/upload/");
//	    System.out.println("저장 경로: " + loc);
//		FileOutputStream fos;
//		String fileDemo = file.getOriginalFilename();
//		System.out.println(loc);
//		if(fileDemo.length() > 0) {
//			try {
//				File targetFile = new File(loc, fileDemo);
//				fos = new FileOutputStream(targetFile);
//				fos.write(file.getBytes());
//				fos.close();
//				System.out.println("파일 저장 경로: " + targetFile.getAbsolutePath());
//				
//				// 파일명을 모델에 담기
//	            model.addAttribute("fileName", fileDemo);
//	            
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return "upload_test2";
//		
//	}
	
	@RequestMapping("/")
	public String main() {	
		return "Main";
	}
	
	@RequestMapping("join")
	public String join() {
		return "Join";
	}
	
	@RequestMapping("join_us")
	public String join_us(MemberVO vo, Model model) {
		mapper.join(vo);
		model.addAttribute("id",vo.getId());
		return "Join_success";
	}
	
	@RequestMapping("login")
	public String login() {
		return "Login";
	}
	
	@PostMapping("/login_do")
	public String login(MemberVO vo, HttpSession session) {
			
		MemberVO mvo = mapper.login(vo);
				
		session.setAttribute("mvo", mvo);
		 if (mvo != null) {
	            // 로그인 성공 - 세션에 사용자 정보 저장
	            
	            session.setAttribute("mvo", mvo);
	            return "redirect:/"; // 홈 페이지로 이동
	        } else {
	            // 로그인 실패 - 로그인 페이지로 되돌아가기
	        	return "redirect:/login";
	        }
		
		
		}
}
