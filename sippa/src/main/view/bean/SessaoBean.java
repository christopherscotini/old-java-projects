package view.bean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="sessao")
public class SessaoBean {
	private String locale;

	public String getLocale() {
		if(locale == null){
			locale = "pt";
		}
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String troca(){
		return "login";
	}
	
	public void setLanguage(ActionEvent event) {
		String localeId = event.getComponent().getId();
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot viewRoot = context.getViewRoot();
		viewRoot.setLocale(new Locale(localeId));
		locale = localeId;
	}
}
