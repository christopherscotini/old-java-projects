package br.com.contestacao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.contestacao.controller.cadastros.model.ValueLabelListModel;

@FacesConverter("valueLabelListModelConverter")
public class ValueLabelListModelConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return ValueLabelListModel.parseString(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof ValueLabelListModel) {
			return ((ValueLabelListModel) value).toString();
		}

		return null;
	}

}
