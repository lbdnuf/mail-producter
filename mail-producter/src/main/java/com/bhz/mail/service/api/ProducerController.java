package com.bhz.mail.service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhz.mail.entity.MailSend;
import com.bhz.mail.service.MailSendService;

@RestController
public class ProducerController {

	private static Logger LOGGER = LoggerFactory.getLogger(MailSendService.class);

	@Autowired
	private MailSendService mailSendService;

	//send 
	@RequestMapping(value = "/send",produces = {"application/json;charest=UTF-8"})
	public void send(@RequestBody(required = false) MailSend mailSend) throws Exception{
		
		System.out.println("--------------------------");

		
	}
}
