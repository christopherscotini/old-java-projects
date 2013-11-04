package br.com.contestacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.omnifaces.util.Messages;

import br.com.contestacao.utils.CpfUtils;
import br.com.contestacao.utils.MessagesConstants;

@FacesConverter("cpfConverter")
public class CpfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.trim().equals("")) {
			if (!CpfUtils.isValido(value)) {
				throw new ConverterException(Messages.createError(MessagesConstants.CPF_INVALIDO));
			}

			return CpfUtils.parseLong(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Long) {
			return CpfUtils.parseString((Long) value);
		}

		return "";
	}

}
