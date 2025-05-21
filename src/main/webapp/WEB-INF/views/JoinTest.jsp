<%@include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="content join">
	<div class="inner inner_500">
		<h2 class="page_name2">회원가입</h2>
		<form action="join_us" method="post" enctype="multipart/form-data">
			<ul class="form_ul">
				<li>
					<small class="s_info c_red">* 필수</small>
					<input type="hidden" name="user_type" value="NORMAL" placeholder="">
					<span class="form_label">ID</span>
					<input id="inputId" type="text" name="id" placeholder="ID를 입력하세요" class="ipt_tt" required>
					<span id="idCheckMsg"></span>
				</li>
				<li>
					<span class="form_label">PW</span>
					<input id="inputPw" type="password" name="pw" placeholder="영문/숫자/특수문자 조합 8자 이상" class="ipt_tt" required>
				</li>
				<li>
					<span class="form_label">이름</span>
					<input type="text" name="name" placeholder="이름을 입력하세요" class="ipt_tt" required>
				</li>
				<li>
					<small class="s_info c_main">* 선택</small>
					<span class="form_label">이메일</span>
					<input type="text" name="email" placeholder="이메일을 입력하세요" class="ipt_tt">
				</li>
				<li>
					<span class="form_label">연락처</span>
					<input type="text" name="phone" placeholder="전화번호를 입력하세요" class="ipt_tt">
				</li>
				<li class="profile">
					<span class="form_label">프로필 이미지 등록</span>
					<div class="filebox preview-image">
						<!-- 개발완료되면 label for="profile_img"로 바꿔주세요, 파일업로드 여는 스위치 역할! -->
						<label for="profile_img" class="label_hidden"></label>
						<div class="upload-display">
							<img src="resources/images/user.png" alt="">
						</div>
						<input class="upload-name" value="파일선택" disabled="disabled" style="width: 200px;">
						<input type="file" name = "file" id="profile_img" class="upload-hidden" accept="image/*">
					
					</div>						
				</li>
				<li>
					<div class="agree_box">
						약관동의 넣을거임..
					</div>
				</li>	
				<li>
					<input type="submit" value="JoinUs" class="bttn bttn_sbm2">
				</li>	
			</ul>	
		</form>		
	</div>
</section>		
<script>
function chkPW(){

	 var pw = $("#inputPw").val();
	 var num = pw.search(/[0-9]/g);
	 var eng = pw.search(/[a-z]/ig);
	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

	 if(pw.length < 8 || pw.length > 20){

	  alert("8자리 ~ 20자리 이내로 입력해주세요.");
	  return false;
	 }else if(pw.search(/\s/) != -1){
	  alert("비밀번호는 공백 없이 입력해주세요.");
	  return false;
	 }else if(num < 0 || eng < 0 || spe < 0 ){
	  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
	  return false;
	 }else {
		//console.log("통과"); 
	    return true;
	 }

}
	
$(document).ready(function() {
    var fileTarget = $('.filebox .upload-hidden');

    fileTarget.on('change', function() {
        if (window.FileReader) {
            var filename = $(this)[0].files[0]?.name;
        } else {
            var filename = $(this).val().split('/').pop().split('\\').pop();
        }

        $(this).siblings('.upload-name').val(filename);
    });

    // 이미지 미리보기 및 유효성 검사 (확장자 & 용량)
    var imgTarget = $('.preview-image .upload-hidden');

    imgTarget.on('change', function() {
        var file = $(this)[0].files[0];

        if (!file) return;

        // 이미지 MIME 타입 허용 리스트
        var validTypes = ['image/jpeg', 'image/png', 'image/gif', 'image/webp', 'image/bmp'];
        var maxSize = 5 * 1024 * 1024; // 5MB

        // MIME 타입 검사
        if (!validTypes.includes(file.type)) {
            alert('이미지 파일만 업로드할 수 있습니다. (jpg, png, gif, webp 등)');
            $(this).val('');
            $(this).siblings('.upload-name').val(''); // 파일명 초기화
            return;
        }

        // 파일 용량 검사
        if (file.size > maxSize) {
            alert('5MB 이하의 이미지만 업로드할 수 있습니다.');
            $(this).val('');
            $(this).siblings('.upload-name').val('');
            return;
        }

        var parent = $(this).parent();
        var uploadDisplay = parent.find('.upload-display');
        var imgTag = uploadDisplay.find('.upload-thumb');

        if (window.FileReader) {
            var reader = new FileReader();
            reader.onload = function(e) {
                var src = e.target.result;

                if (imgTag.length > 0) {
                    imgTag.attr('src', src);
                } else {
                    uploadDisplay.html(
                        '<div class="upload-thumb-wrap"><img src="' + src + '" class="upload-thumb"></div>'
                    );
                }
            }
            reader.readAsDataURL(file);
        } else {
            // 구형 브라우저 (IE 대응)
            $(this)[0].select();
            $(this)[0].blur();
            var imgSrc = document.selection.createRange().text;

            if (imgTag.length > 0) {
                imgTag[0].style.filter =
                    "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\"" +
                    imgSrc +
                    "\")";
            } else {
                uploadDisplay.html('<div class="upload-thumb-wrap"><img class="upload-thumb"></div>');
                uploadDisplay.find('.upload-thumb')[0].style.filter =
                    "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\"" +
                    imgSrc +
                    "\")";
            }
        }
    });
});
</script>

<%@include file="/WEB-INF/views/includes/footer.jsp" %>