package com.smart24x7.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.smart24x7.utils.XmlParserUtil;

@Configuration
public class OrganizationConfig {

	@Autowired
	private XmlParserUtil xmlParserUtil;

	@PostConstruct
	private void init() {
		String oid = "000";
		xmlParserUtil.xmlParser(oid);
	}

}
