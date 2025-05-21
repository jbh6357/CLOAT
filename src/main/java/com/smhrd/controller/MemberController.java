package com.smhrd.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

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
	
	@RequestMapping("/join")
	public String join() {
		return "Join";
	}
	
	@RequestMapping("/jointest")
	public String joinTest() {
		return "JoinTest";
	}
	
//  수정 전 회원가입
//	@RequestMapping("/join_us")
//	public String join_us(MemberVO vo, Model model) {
//		mapper.join(vo);
//		model.addAttribute("id",vo.getId());
//		return "Join_success";
//	}
	
	@RequestMapping("/join_us")
	public String join_us(@RequestParam(value= "file", required = false)MultipartFile file, MemberVO vo, Model model) {
		String loc = context.getRealPath("/resources/file/");
		FileOutputStream fos;
		String fileDemo = "null";
		if (file != null && !file.isEmpty()) {
			fileDemo = file.getOriginalFilename();
			if(fileDemo.length() > 0) {
				try {
					String baseName = fileDemo.substring(0, fileDemo.lastIndexOf(".")); //4
					String extension = fileDemo.substring(fileDemo.lastIndexOf("."));   //.jpg
					fileDemo = baseName + '_' + UUID.randomUUID().toString() + extension;
					File targetFile = new File(loc, fileDemo);
					fos = new FileOutputStream(targetFile); // 파일저장경로 + 파일저장명
					fos.write(file.getBytes());  // 우리가 진짜 가져온 파일로 쓰기
					fos.close();  // 이건 안써줘도 되는 코드지만 용량 절약을 습관화
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		vo.setProfile_img(fileDemo);
		
		mapper.join(vo);
		model.addAttribute("id",vo.getId());
		return "Join_success";
	}
	
	@RequestMapping("/login")
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
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Main";
	}

}
