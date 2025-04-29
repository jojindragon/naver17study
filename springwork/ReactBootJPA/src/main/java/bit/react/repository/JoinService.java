package bit.react.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JoinService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(JoinDto dto) {
		UserEntity data=UserEntity.builder()
				.username(dto.getUsername())
				.password(bCryptPasswordEncoder.encode(dto.getPassword()))
				.role(dto.getRole())
				.address(dto.getAddress())
				.build();
		
		//db 에 저장
		userRepository.save(data);		
	}
	
	public List<UserEntity> getAllMembers() {
		return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	public void deleteMember(int id) {
		userRepository.deleteById(id);
	}
	
}
