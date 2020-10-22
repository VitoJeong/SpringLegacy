<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}
</style>

	<h1>Upload with Ajax</h1>

	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	
	<div class='uploadResult'>
		<ul>
		
		</ul>
	</div>
	
	<button id='uploadBtn'>Upload</button>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){

			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5MB

			function checkExtension(fileName, fileSize) {

				if (fileSize >= maxSize) {
					alert("파일 사이즈 초과");
					return false;
				}

				if (regex.test(fileName)) {
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}

			var cloneObj = $(".uploadDiv").clone();
			
			$("#uploadBtn").on("click", function(e){
				var formData = new FormData();

				var inputFile = $("input[name='uploadFile']");

				var files = inputFile[0].files;

				console.log(files);
				
				//add filedate to formdata
				for(var i = 0; i < files.length; i++){

					if(!checkExtension(files[i].name, files[i].size) ) {
						return false;
					}
				
					formData.append("uploadFile", files[i]);
				
				}
				
				/* 
				$.ajax({
					 url: '/uploadAjaxAction',
					 processData: false,
					 contentType: false,
					 data: formData,
					 type: 'POST',
					 success: function(result){
					 alert("Uploaded");
					 }
				}); // $.ajax 끝
				 */

				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					dataType : 'json',
					success : function(result) {

						console.log(result);

						// input 초기화
						$(".uploadDiv").html(cloneObj.html());

						// 파일 이름 출력
						showUploadedFile(result);

					}
				}); //$.ajax	
		
		}); // $("#uploadBtn").on("click") function 끝
			
	}); // $(document).ready 끝

	var uploadResult = $(".uploadResult ul");

	/* 
	function showUploadedFile(uploadResultArr) {

		var str = "";

		$(uploadResultArr).each(
			function(i, obj) {

				if (!obj.image) {
					str += "<li><img src='/resources/img/attach.png'>"
						+ obj.fileName + "</li>";
				} else {
					str += "<li>" + obj.fileName + "</li>";
				}
			});

		uploadResult.append(str);
	} // showUploadedFile 끝
 	*/
	
	function showUploadedFile(uploadResultArr) {

		var str = "";

		$(uploadResultArr).each(
			function(i, obj) {

			  if(!obj.image){
			        str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
			      }else{
			        //str += "<li>"+ obj.fileName+"</li>";
			        // 이미지가 아니면 썸네일 출력
			        var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
			        
			        str += "<li><img src='/display?fileName="+fileCallPath+"'><li>";
			      }
			});

		uploadResult.append(str);
	} // showUploadedFile 끝

	
	</script>
	
</body>


</html>


