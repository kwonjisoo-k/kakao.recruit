package kakao.recruit.jisoo.mq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kakao.recruit.jisoo.mq.dto.User;
import kakao.recruit.jisoo.mq.error.UnauthorizedException;
import kakao.recruit.jisoo.mq.svc.AuthenticationService;
import kakao.recruit.jisoo.mq.svc.JwtService;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AuthenticationService authenticationService;

	private static final String HEADER_AUTH = "Authorization";
	private static final String HEADER_USER = "X-USER-ID";
	private static final String HEADER_ROOM = "X-ROOM-ID";
	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		request.getHeader(HEADER_AUTH);
		request.getHeader(HEADER_USER);
		request.getHeader(HEADER_ROOM);
		/*
		 * System.out.println("handle====="); // 헤더로부터 토큰을 읽어서 String token =
		 * request.getHeader(HttpHeaders.AUTHORIZATION);
		 * 
		 * final String token = request.getHeader(HEADER_AUTH);
		 * 
		 * if(token != null && jwtService.isUsable(token)){ return true; }else{ throw
		 * new UnauthorizedException(); }
		 */
		
		final String token = request.getHeader(HEADER_AUTH);
		
		if(token != null && jwtService.isUsable(token))
		{ 
			return super.preHandle(request, response, handler);
			
		}
		else
		{ 
			throw new UnauthorizedException();
		}
		
		// 그 결과를 request attribute으로 넘겨준다.
		

		
	}
}
