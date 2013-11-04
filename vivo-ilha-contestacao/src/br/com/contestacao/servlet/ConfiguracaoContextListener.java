package br.com.contestacao.servlet;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

@WebListener
public class ConfiguracaoContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		Messages.setResolver(new Messages.Resolver() {
		     public String getMessage(String message, Object... params) {
		    	 String messageBundleName = Faces.getApplication().getMessageBundle();

		         ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName);

		         if (bundle == null) {
		        	 throw new IllegalArgumentException("Message não definido: " + messageBundleName);
		         }

		         if (bundle.containsKey(message)) {
		             message = bundle.getString(message);
		         }

		         return MessageFormat.format(message, params);
		     }
		 });
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}
