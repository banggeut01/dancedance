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
import com.dance.dto.Play;
import com.dance.dto.Video;
import com.dance.service.IMemberService;
import com.dance.service.IGameService;
import com.dance.service.IJwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000, exposedHeaders = "Authorization", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Api(value = "Dance-Dance", description = "Resouces Management 2020")
public class GameController {

	public static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private IGameService gameservice;
	@Autowired
	private IJwtService jwtService;
	
	@ApiOperation(value = "메인 - 영상 리스트", response = Member.class)
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> main(@RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------main-----------------------------" + new Date());
		
		Map<String, Object> resultMap = new HashMap<>();
	
		Member member = jwtService.get(token);

		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}

		Play play = new Play();
		play.setMember_id(member.getMember_id());

		List<Video> video = gameservice.getVideoList();

		for (int i = 0; i < video.size(); i++) {
			play.setVideo_id(video.get(i).getVideo_id());
			video.get(i).setPoint(gameservice.getVideoMyPoint(play));
		}

		resultMap.put("status", "ok");
		resultMap.put("video", video);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	
}
