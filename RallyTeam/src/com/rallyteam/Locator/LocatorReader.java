package com.rallyteam.Locator;


import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class LocatorReader {

	private Document doc;

	public LocatorReader(String xmlName) {		
		SAXReader reader = new SAXReader();
		try {
			//URL url = getClass().getResource("C:\\Documents and Settings\\sadika.SOFTLOGICA\\Desktop\\Kuali\\bin\\com\\kuali\\portal\\Locator\\"+xmlName);
			//File file = new File(url.getFile());
			String path =getPath()+"//Src//com//rallyteam//Locator//";
			doc = reader.read(path+xmlName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  public static String getPath()
		{
			String path ="";		
			File file = new File("");
			String absolutePathOfFirstFile = file.getAbsolutePath();
			path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
			return path;
		}
	
	public String getLocator(String locator){
		return doc.selectSingleNode("//" + locator.replace('.', '/')).getText();
		
	}
}
