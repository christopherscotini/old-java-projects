package br.com.contestacao.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.omnifaces.util.Messages;

import br.com.contestacao.utils.CnpjUtils;
import br.com.contestacao.utils.MessagesConstants;

@FacesValidator("cnpjValidator")
public class CnpjValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value instanceof String && !CnpjUtils.isValido((String) value)) {
			throw new ValidatorException(Messages.createError(MessagesConstants.CNPJ_INVALIDO));
		}
	}

}
