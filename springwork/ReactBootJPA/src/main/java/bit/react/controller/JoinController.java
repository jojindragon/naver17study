package bit.react.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import bit.react.repository.JoinService;
import bit.react.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/member")
public class JoinController {
	private final JoinService joinService;
	private final UserRepository userRepository;
	
	@GetMapping("/member/idcheck")
	public String idCheck(@RequestParam("username") String username) {
		Boolean isExist = userRepository.existsByUsername(username);
		if(isExist) {
			System.out.println("db 에 이미 존재함!! 가입 안됨!");
			return "fail";
		}
		return "success";
	}
	
	@PostMapping("/member/join")
	public String joinProcess(@RequestBody JoinDto dto) {
		joinService.joinProcess(dto);
		return "success";
	}
	
	@GetMapping("/auth/member/list")
	public List<UserEntity> getMembers() {
		return joinService.getAllMembers();
	}
	
	@DeleteMapping("/member/delete")
	public void deleteMemer(@RequestParam("id") int id) {
		joinService.deleteMember(id);
	}
}
