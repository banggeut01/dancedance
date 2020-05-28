package com.dance.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dance.dto.Avatar;
import com.dance.dto.Member;
import com.dance.dto.SignUpCheck;
import com.dance.service.IMemberService;
import com.dance.service.IJwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000, exposedHeaders = "Authorization", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Api(value = "Dance-Dance", description = "Resouces Management 2020")
public class MemberController {

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private IMemberService memberservice;
	@Autowired
	private IJwtService jwtService;
	
	@ApiOperation(value = "로그인", response = Member.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestBody Member member) throws Exception {
		logger.info("1-------------login-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		Member login = memberservice.login(member);
		
		if(login==null)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
		String token = jwtService.create(login);
		headers.set("Authorization", token);
		
		resultMap.put("memberid", login.getMember_id());
		resultMap.put("email", login.getEmail());
		resultMap.put("nickname",login.getNickname()); 

		return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "이메일, 닉네임 중복 체크", response = Member.class)
	@RequestMapping(value = "/signup/check", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> signupcheck(@RequestBody SignUpCheck member) throws Exception {
		logger.info("1-------------signupcheck-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		int emailCheck = memberservice.emailcheck(member.getEmail());
		int nicknameCheck = memberservice.nicknamecheck(member.getNickname());

		if(emailCheck==0 && nicknameCheck==0) {
			resultMap.put("email", true);
			resultMap.put("nickname", true);
		}else if(emailCheck>0 && nicknameCheck==0){
			resultMap.put("email", false);
			resultMap.put("nickname", true);
		}else if(emailCheck==0 && nicknameCheck>0) {
			resultMap.put("email", true);
			resultMap.put("nickname", false);
		}else {
			resultMap.put("email", false);
			resultMap.put("nickname", false);
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원가입", response = Member.class)
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> signup(@RequestBody Member member) throws Exception {
		logger.info("1-------------signup-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		memberservice.signup(member);
		
		String token = jwtService.create(member);
		headers.set("Authorization", token);

		resultMap.put("signup", "ok");

		return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "아바타 페이지", response = Member.class)
	@RequestMapping(value = "/avatar", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> avatar(@RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------avatar-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		Member member = jwtService.get(token);
		
		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		Avatar myavatar = memberservice.myavatar(member.getAvatar_now());
		List<Avatar> obtained = memberservice.obtained(member.getMember_id());
		List<Avatar> not_obtained = memberservice.not_obtained(member.getMember_id());

		resultMap.put("status", "ok");
		resultMap.put("myavatar", myavatar);
		resultMap.put("obtained", obtained);
		resultMap.put("not_obtained", not_obtained);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "아바타 페이지", response = Member.class)
	@RequestMapping(value = "/avatar/{avatar_id}", method = RequestMethod.PATCH)
	public ResponseEntity<Map<String, Object>> updateAvatar(@PathVariable int avatar_id, @RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------updateAvatar-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		Member member = jwtService.get(token);
		
		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		member.setAvatar_now(avatar_id);
		memberservice.updateMyAvatar(member);
		
		Avatar myavatar = memberservice.myavatar(member.getAvatar_now());
		List<Avatar> obtained = memberservice.obtained(member.getMember_id());
		List<Avatar> not_obtained = memberservice.not_obtained(member.getMember_id());

		resultMap.put("status", "ok");
		resultMap.put("myavatar", myavatar);
		resultMap.put("obtained", obtained);
		resultMap.put("not_obtained", not_obtained);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
}
