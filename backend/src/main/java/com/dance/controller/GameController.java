package com.dance.controller;

import java.util.ArrayList;
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
import com.dance.dto.Icon;
import com.dance.dto.Member;
import com.dance.dto.Play;
import com.dance.dto.Rank;
import com.dance.dto.Ranking;
import com.dance.dto.Result;
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
	
	@ApiOperation(value = "메인 - 영상 리스트", response = Video.class)
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
			video.get(i).setMyPoint(gameservice.getVideoMyPoint(play));
		}

		resultMap.put("status", "ok");
		resultMap.put("video", video);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
		
	@ApiOperation(value = "게임 play", response = Map.class)
	@RequestMapping(value = "/play/{video_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> play(@PathVariable int video_id, @RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------play-----------------------------" + new Date());
		
		Map<String, Object> resultMap = new HashMap<>();
	
		Member member = jwtService.get(token);

		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		String video = gameservice.getVideoLink(video_id);
		String avatar = gameservice.getMyAvatarName(member.getAvatar_now());
		List<Icon> icon = gameservice.getIcon(video_id);

		resultMap.put("status", "ok");
		resultMap.put("video", video);
		resultMap.put("avatar", avatar);
		resultMap.put("icon", icon);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "곡별 랭킹", response = Ranking.class)
	@RequestMapping(value = "/ranking/video", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> rankingByVideo(@RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------rankingByVideo-----------------------------" + new Date());
		
		Map<String, Object> resultMap = new HashMap<>();
	
		Member member = jwtService.get(token);

		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		List<Rank> rank = new ArrayList<>();
		List<Video> video = gameservice.getVideoList();
		
		for (int i = 0; i < video.size(); i++) {
			List<Ranking> allRanking = gameservice.getRankingByVideo(video.get(i).getVideo_id());
			List<Ranking> ranking = new ArrayList<>();
			Ranking myRanking = null;
			
			int size = allRanking.size();
			if(size>10) 
				size=10;
			
			for (int j = 0; j < size; j++) {
				ranking.add(allRanking.get(j));
				if(ranking.get(j).getMember_id()==member.getMember_id()) {
					myRanking = ranking.get(j);
				}
			}
			if(myRanking==null) {
				for (int j = 0; j < ranking.size(); j++) {
					if(ranking.get(j).getMember_id()==member.getMember_id()) {
						myRanking = ranking.get(j);
					}
				}
			}
			rank.add(new Rank(video.get(i), ranking, myRanking));
		}
		
		resultMap.put("status", "ok");
		resultMap.put("ranking", rank);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "총 score 랭킹", response = Ranking.class)
	@RequestMapping(value = "/ranking/score", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> rankingByScore(@RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------rankingByScore-----------------------------" + new Date());
		
		Map<String, Object> resultMap = new HashMap<>();
	
		Member member = jwtService.get(token);

		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		List<Rank> rank = new ArrayList<>();
		
		List<Ranking> ranking = gameservice.getRankingByScore();
		Ranking myRanking = null;
		for (int i = 0; i < ranking.size(); i++) {
			if(ranking.get(i).getMember_id()==member.getMember_id()) {
				myRanking = ranking.get(i);
			}
		}
		
		resultMap.put("status", "ok");
		resultMap.put("ranking", ranking);
		resultMap.put("myRanking", myRanking);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "결과 저장", response = Map.class)
	@RequestMapping(value = "/play/result", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> result(@RequestBody Result result, @RequestHeader(value="Authorization") String token) throws Exception {
		logger.info("1-------------result-----------------------------" + new Date());
		
		Map<String, Object> resultMap = new HashMap<>();
	
		Member member = jwtService.get(token);

		if(member==null) {
			resultMap.put("status", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		Play play = new Play(result.getVideo_id(), result.getPerfect(), result.getGreat(), result.getGood(), result.getBad());
		play.setMember_id(member.getMember_id());
		int point = result.getPerfect()*500 + result.getGreat()*300 + result.getGood()*150;
		play.setPoint(point);
		gameservice.setPlayResult(play);
		
		resultMap.put("status", "ok");

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
}
