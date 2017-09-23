package com.bhz.mail.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bhz.mail.entity.MailSend;
import com.bhz.mail.mapper.MailSend1Mapper;					
import com.bhz.mail.mapper.MailSend2Mapper;

@Service
public class MailSendService {

	private static Logger LOGGER = LoggerFactory.getLogger(MailSendService.class);

	@Autowired
	private MailSend1Mapper mailSend1Mapper;

	@Autowired
	private MailSend2Mapper mailSend2Mapper;

	public void insert(MailSend mailSend) throws Exception {
		
		int hashCode = mailSend.getSendId().hashCode();
		if(hashCode % 2 == 0) {
			//插入一表
			mailSend1Mapper.insert(mailSend);
		}else {
			//插入二表
			mailSend2Mapper.insert(mailSend);
		}
	}
}
