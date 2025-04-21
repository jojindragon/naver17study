package bit.day0417.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bit.day0417.data.UserEntity;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

	private UserRepository userRepository;
	
	// 로그인 시 Spring SecurityConfig가 검증을 위해서 username을 넣어준다
	
	// "/login" 경로 POST 요청이 오면
	// 스프링 시큐리티 내부적으로 UsernamePasswordAuthenticationFilter가 동작
	// 이때 AuthenticationProvider에 의해 CustomUserDetailsService의
	// loadUserByUsername을 호출해 DB 유저 조회
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userData = userRepository.findByUsername(username);
		if(userData == null) {
			System.out.println(username + " 아이디는 DB에 존재 X");
		} else {
			System.out.println(username + " 아이디 로그인!");
			return new CustomUserDetail(userData);
		}
		
		return null;
	}

}
