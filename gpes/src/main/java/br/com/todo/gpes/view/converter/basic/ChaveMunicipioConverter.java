package br.com.todo.gpes.view.converter.basic;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.todo.gpes.model.basic.ChaveMunicipio;

@FacesConverter(value="chaveMunicipioConverter")
public class ChaveMunicipioConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value == null || value.trim().equals("")) {
			return null;
		}

		String[] chave = value.split(";");
		if (chave == null || chave.length != 3) {
			return null;
		}

		ChaveMunicipio chaveMunicipio = new ChaveMunicipio();
		if (chave[0] != null && !chave[0].trim().equals("")) {
			chaveMunicipio.setCodigoEstado(Integer.parseInt(chave[0]));
		}
		if (chave[1] != null && !chave[1].trim().equals("")) {
			chaveMunicipio.setCodigoPais(Integer.parseInt(chave[1]));
		}
		if (chave[1] != null && !chave[2].trim().equals("")) {
			chaveMunicipio.setCodigoMunicipio(Integer.parseInt(chave[2]));
		}
		return chaveMunicipio;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (!(value instanceof ChaveMunicipio)) {
			return null;
		}

		ChaveMunicipio chaveMunicipio = (ChaveMunicipio) value;

		StringBuilder chaveMunicipioAsString = new StringBuilder();
		chaveMunicipioAsString.append(chaveMunicipio.getCodigoEstado());
		chaveMunicipioAsString.append(";");
		chaveMunicipioAsString.append(chaveMunicipio.getCodigoPais());
		chaveMunicipioAsString.append(";");
		chaveMunicipioAsString.append(chaveMunicipio.getCodigoMunicipio());
		return chaveMunicipioAsString.toString();
	}

}
