package com.ssamz.jblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.dto.ResponseDTO;
import com.ssamz.jblog.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private ModelMapper modelMapper;
//	
//	@Value("${kakao.default.password}")
//	private String kakaoPassword;
//
//	@Value("${google.default.password}")
//	private String googlePassword;
//	
//	@PutMapping("/user")
//	public @ResponseBody String updateUser(@RequestBody User user) {
//		User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
//			return new JBlogException(user.getId() + "번 회원이 없습니다");
//		});
//		findUser.setUsername(user.getUsername());
//		findUser.setPassword(user.getPassword());
//		findUser.setEmail(user.getEmail());
//		
//		userRepository.save(findUser);
//		return "회원 수정 성공";
//		if(principal.getUser().getOauth().equals(OAuthType.KAKAO)) {
//			// 카카오 회원인 경우 비밀번호를 고정한다.
//			user.setPassword(kakaoPassword);
//		} else if(principal.getUser().getOauth().equals(OAuthType.GOOGLE)) {
//			// 구글 회원인 경우 비밀번호를 고정한다.
//			user.setPassword(googlePassword);
//		}
//		
//		// 회원정보 수정과 동시에 세션 갱신
//		principal.setUser(userService.updateUser(user));
//	
//		return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + 
//		" 수정 완료");
//	}
//
//	
//	@GetMapping("/user/updateUser") 
//	public String updateUser() {
//		return "user/updateUser";
//	}
//
//	
//	@GetMapping("/auth/login")
//	public String login() {
//		return "system/login";
//	}
	
	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	
//	@GetMapping("/user/get/{id}")
//	public @ResponseBody User getUser(@PathVariable int id) {
//		User findUser = userRepository.findById(id).orElseThrow(new Supplier<JBlogException>() {
//			@Override
//			public JBlogException get() {
//				return new JBlogException(id + "번 회원이 없습니다");
//			}
//		});
//		return findUser;
//	}
	
//	@GetMapping("/user/list")
//	public @ResponseBody List<User> getUserList() {
//		return userRepository.findAll();
//	}
//	
//	@GetMapping("/user/page/{page}")
//	public @ResponseBody Page<User> getUserListPaging(@PathVariable int page) {
//		Pageable pageable = PageRequest.of(page, 2, Sort.Direction.DESC, "id", "username");
//		return userRepository.findAll(pageable);
//	}
	
//	@GetMapping("/user/page")
//	public @ResponseBody Page<User> getUserListPaging(@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC,
//		sort = {"id", "username"}) Pageable pageable) {
//		return userRepository.findAll(pageable);
//	}
	
	@PostMapping("/auth/inserUser")
	public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user) {
//		user.setRole(RoleType.USER);
//		userService.insertUser(user);
//		return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공!");
//		User user = modelMapper.map(userDTO, User.class);
		User findUser = userService.getUser(user.getUsername());
	
		if(findUser.getUsername() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), 
			user.getUsername() + " 가입 성공.");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), 
			user.getUsername() + "님은 이미 회원입니다.");
		}

	}
	
//	@DeleteMapping("/user/{id}")
//	public @ResponseBody String deleteUser(@PathVariable int id) {
//		userRepository.deleteById(id);
//		return "회원 삭제 성공";
//	}
}
