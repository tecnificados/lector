package org.tecnificados.com.lector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tecnificados.com.lector.util.Messages;

/**
 * Lector de ficheros linea a linea
 */
public class App 
{


	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	
	
	private static void configuration() {
		Properties prop = new Properties();
    	try 
    	{
    		InputStream input = new FileInputStream(Constant.CONF_PROPERTIES);
    		prop.load(input);    	         	    
    	} 
    	catch (IOException ex) {
    	    log.error(Messages.getString("App.3"),ex); 
    	}
    	
    	if (prop.getProperty(Constant.PATH_TO_FILE)!=null) {
    		Constant.filePath=prop.getProperty(Constant.PATH_TO_FILE);
    	}else {
    		log.info(Constant.PATH_TO_FILE+Messages.getString("App.4")+Constant.CONF_PROPERTIES); 
    	}
		
	}
	
    public static void main( String[] args )
    {    	
    	Locale.setDefault(new Locale("es_ES"));
    
    	
    	log.info(Messages.getString("App.5")); 
    	    	  	
    	configuration();    	
    	
    	List<String> readedLines = new ArrayList<String>();
        try {
        	readedLines = FileUtils.readLines(new File(Constant.filePath),Constant.UTF_8);
        	log.info(Messages.getString("App.7")+readedLines.size()); 
			
		} catch (IOException e) {
			log.error(Messages.getString("App.8"),e); 
		}
        for (String actual:readedLines)
        {
			log.info(actual);
        }
        log.info(Messages.getString("App.9")); 
    }

	
}
