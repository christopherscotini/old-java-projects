package br.com.contestacao.converter;

import java.math.BigDecimal;
import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.omnifaces.util.Messages;

import br.com.contestacao.utils.MessagesConstants;
import br.com.contestacao.utils.NumberUtils;

@FacesConverter("reaisBigDecimalConverter")
public class ReaisBigDecimalConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			try {
				return NumberUtils.converter(value);
			} catch (ParseException e) {
				throw new ConverterException(Messages.createError(MessagesConstants.FORMATO_INVALIDO, component.getClientId()));
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof BigDecimal) {
			return String.format("R$ %s", NumberUtils.formatar((Number) value));
		}

		return "";
	}

}
