package com.smart24x7.utils;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smart24x7.bean.OrgnizationInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class XmlParserUtil {

	@Autowired
	private OrgnizationInfo oidInfo;

	public OrgnizationInfo xmlParser(String oid) {
		try {
			HashMap<String, String> orgInfo = new HashMap<>();
			Resource resource = new ClassPathResource("/config-files/" + oid + ".xml");
			File xmlfileObj = resource.getFile();
			DocumentBuilderFactory documentBFObj = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBObj = documentBFObj.newDocumentBuilder();
			Document xmlObj = documentBObj.parse(xmlfileObj);
			xmlObj.normalize();
			log.info("Root Node : {}", xmlObj.getDocumentElement().getNodeName());
			readXmlNode(orgInfo, xmlObj);
			oidInfo.setOrgInfo(orgInfo);
		} catch (Exception e) {
			log.error("get Error in xml : {}", e);
		}
		return oidInfo;
	}

	private void readXmlNode(HashMap<String, String> orgInfo, Document xmlObj) {
		NodeList xmlChildNodeListName = xmlObj.getElementsByTagName("ParametersValues");
		for (int y = 0; y < xmlChildNodeListName.getLength(); y++) {
			Node nName = xmlChildNodeListName.item(y);
			log.info("Next Chile Node - {}", nName.getNodeName());
			readChildNode(orgInfo, nName);
		}
	}

	private void readChildNode(HashMap<String, String> orgInfo, Node nName) {
		if (nName.getNodeType() == Node.ELEMENT_NODE) {
			Element nNodeEl = (Element) nName;
			int getnNodeEl = nNodeEl.getElementsByTagName("Parameter").getLength();
			for (int x = 0; x < getnNodeEl; x++) {
				NamedNodeMap nodeAttr = nNodeEl.getElementsByTagName("Parameter").item(x).getAttributes();
				int first = 1;
				String getF = "";
				for (int g = 0; g < nodeAttr.getLength(); g++) {
					Node node = nodeAttr.item(g);
					log.info("Node name  - {}", node.getNodeName());
					log.info("Node value - {}", node.getNodeValue());
					if (first == 1) {
						getF = node.getNodeValue();
						first++;
					} else if (first == 2) {
						orgInfo.put(getF, node.getNodeValue());
						first--;
					}
				}
			}
		}
	}

}
