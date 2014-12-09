package edu.learn.webdesktop.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class WebMvcInitializer implements WebApplicationInitializer {

	@Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(Application.class);
	        ctx.setServletContext(servletContext); 
	        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
	        servlet.addMapping("/");
	        servlet.setLoadOnStartup(1);
	    }
}
