package com.board.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.board.user.domain.UserVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
        
		// 1. 세션에서 회원정보를 검색
		HttpSession session = request.getSession();
		Object       obj    = session.getAttribute("login");
		
		// 요청한 주소정보 확인
		String requestUrl = request.getRequestURL().toString();
		
		// /login 페이지는 체크에서 제외한다( 제외 설정 )
		//  Interface 설정하는 곳에서 해당 경로를 제외할 때 if() 필요 없다 
		//  if( requestUrl.contains("/login")) {
		//	return true;    // 로그인 체크를 중단
		//}
		
		/*
		if( obj == null) {
			// 로그인되어 있지 않다면 /loginForm 으로 이동
			response.sendRedirect("/loginForm");
			return false;
		}
		*/
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
