package br.com.todo.gpes.view.converter.basic;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.todo.gpes.model.basic.ChaveEstado;

@FacesConverter(value="chaveEstadoConverter")
public class ChaveEstadoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value == null || value.trim().equals("")) {
			return null;
		}

		String[] chave = value.split(";");
		if (chave == null || chave.length != 2) {
			return null;
		}

		ChaveEstado chaveEstado = new ChaveEstado();
		if (chave[0] != null && !chave[0].trim().equals("")) {
			chaveEstado.setCodigoEstado(Integer.parseInt(chave[0]));
		}
		if (chave[1] != null && !chave[1].trim().equals("")) {
			chaveEstado.setCodigoPais(Integer.parseInt(chave[1]));
		}
		return chaveEstado;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (!(value instanceof ChaveEstado)) {
			return null;
		}

		ChaveEstado chaveEstado = (ChaveEstado) value;

		StringBuilder chaveEstadoAsString = new StringBuilder();
		chaveEstadoAsString.append(chaveEstado.getCodigoEstado());
		chaveEstadoAsString.append(";");
		chaveEstadoAsString.append(chaveEstado.getCodigoPais());
		return chaveEstadoAsString.toString();
	}

}
