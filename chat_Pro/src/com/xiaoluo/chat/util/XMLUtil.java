package com.xiaoluo.chat.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLUtil
{
	public static Document constructXML()
	{
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("message");
		document.setRootElement(root);
		
		return document;
	}
	/**
	 * �û���¼ʱ���û������͸������
	 */
	public static String constructLoginXML(String username)
	{
		Document document = constructXML();
		Element root = document.getRootElement();
		
		Element element = root.addElement("type");
		element.setText("1");
		
		Element element2 = root.addElement("username");
		element2.setText(username);
		
		return document.asXML();
	}
	
	/**
	 * ����˽��û��������û���xml���н���
	 */
	public static String extractLoginXML(String loginXML)
	{
		try
		{
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(new StringReader(loginXML));
			Element root = doc.getRootElement();
			
			String username = root.element("username").getText();
			return username;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �������������пͻ��˷��͵������û��б�
	 */
	public static String constructUserList(Set<String> set)
	{
		try
		{
			Document doc = constructXML();
			Element root = doc.getRootElement();
			Element type = root.addElement("type");
			type.setText("4");
			for(String users : set)
			{
				Element user = root.addElement("username");
				user.setText(users);
			}
			return doc.asXML();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �ͻ��˽���������˷�����xml
	 */
	@SuppressWarnings("unchecked")
	public static List<String> extractServerUserListXML(String userXML)
	{
		List<String> list = new ArrayList<String>();
		
		try
		{
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(new StringReader(userXML));
			
			Element root = doc.getRootElement();
			for(Iterator<Element> ite = root.elementIterator("username"); ite.hasNext();)
			{
				Element e = ite.next();
				list.add(e.getText());
			}
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
