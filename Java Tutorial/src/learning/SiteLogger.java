package learning;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SiteLogger implements ServletContextListener {
    
	public static Logger logger;
	
	public static Logger getLogger() throws Exception
	{
		return logger;
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContextListener.super.contextDestroyed(sce);
		ServletContext sc=sce.getServletContext();
		sc.removeAttribute("learning.SiteLogger");
		logger=null;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContextListener.super.contextInitialized(sce);
		ServletContext sc=sce.getServletContext();
		logger=Logger.getLogger("Global");
		logger.setLevel(Level.INFO);
		
		try {
			String root= sc.getRealPath("/");
			FileHandler fh=new FileHandler(root+"WEF-INF/log.txt");
			fh.setFormatter(new CustomFormatter());
			logger.addHandler(fh);
		}
		catch(Exception e)
		{
			System.out.print(" Custom_error_message "+e.getMessage());
		}
		sc.setAttribute("learning.SiteLogger", logger);
	}
	
	

}
