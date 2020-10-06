<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Board Read</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Board Read Page </h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <form role="form" action="/board/register" method="post" >
						<div class="form-group">
							<label>글 번호</label> 
							<input type="text" name='title' class="form-control" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label>제목</label> 
							<input type="text" name='title' class="form-control" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" name="content" rows="3"
								placeholder="Enter ..."></textarea>
						</div>
						<div class="form-group">
							<label>작성자</label> 
							<input type="text" name="writer" class="form-control" placeholder="Enter Writer">
						</div>
					<!-- /.box-body -->

						<button type="submit" class="btn btn-primary">글쓰기</button>
						<button type="reset" class="btn btn-primary">다시 작성</button>
				</form>
              </div>
            </div>
          </div>

        <%@include file="../includes/footer.jsp"%>
       