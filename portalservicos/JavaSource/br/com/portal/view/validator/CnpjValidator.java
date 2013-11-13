package br.com.portal.view.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.omnifaces.util.Messages;

import br.com.portal.utils.CnpjUtils;

@FacesValidator("cnpjValidator")
public class CnpjValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value instanceof String && !CnpjUtils.isValido((String) value)) {
			throw new ValidatorException(Messages.createError("CNPJ INVÁLIDO"));
		}
	}

}
