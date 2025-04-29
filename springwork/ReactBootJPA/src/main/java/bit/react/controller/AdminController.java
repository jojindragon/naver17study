package bit.react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bit.react.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AdminController {
	private final JwtUtil jwtUtil;
	
	@GetMapping("/admin")
	public String admin(HttpServletRequest request) {
		
		// header로부터 Authorization 획득
		String auth = request.getHeader("Authorization");
		// Bearer를 제거한 순수 토큰을 얻는다 - 실제 토큰은 7번지부터 시작
		String token = auth.substring(7);
		// 토큰만 있으면 username & role 정보 획득 가능
		String username = jwtUtil.getUsername(token);
		String role = jwtUtil.getRole(token);
		
		return "admin ok!!! username: "+username+", role: "+role;
	}

}
