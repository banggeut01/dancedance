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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dance.dto.Avatar;
import com.dance.dto.Icon;
import com.dance.dto.Member;
import com.dance.dto.Play;
import com.dance.dto.Rank;
import com.dance.dto.Ranking;
import com.dance.dto.Video;
import com.dance.service.IMemberService;
import com.dance.service.IAdminService;
import com.dance.service.IGameService;
import com.dance.service.IJwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000, exposedHeaders = "Authorization", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Api(value = "Dance-Dance", description = "Resouces Management 2020")
public class AdminController {

	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private IAdminService adminservice;
	
	
	@ApiOperation(value = "icon - db 저장", response = Member.class)
	@RequestMapping(value = "/admin/icon", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> setIcon(@RequestBody Icon newIcon) throws Exception {
		logger.info("1-------------setIcon-----------------------------" + new Date());
		
		Map<String, Object> resultMap = new HashMap<>();
		
		List<Icon> icon = new ArrayList<>();
		String img = "https://dancedance.kr/icon/";
		for (int i = 1; i <= newIcon.getIcon_id(); i++) {
			icon.add(new Icon(newIcon.getVideo_id(), i, img+newIcon.getVideo_id()+"-"+i+".png"));
		}
		
		adminservice.setIcon(icon);
		
		resultMap.put("status", "ok");

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
}
