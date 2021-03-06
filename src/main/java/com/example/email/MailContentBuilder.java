package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {
	
	private TemplateEngine templateEngine;
	
	@Autowired
	public MailContentBuilder(TemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}
	
	public String build(String recipientName) {
		Context context = new Context();
		context.setVariable("name", recipientName);
		return templateEngine.process("demoMail", context);
	}

}
