package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringListener
 *
 */
public class SpringListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SpringListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0)  {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("ac", ac);
    }
	
}
