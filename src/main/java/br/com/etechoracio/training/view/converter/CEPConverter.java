package br.com.etechoracio.training.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component(value = "CEPConverter")
public class CEPConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		String cep = value;

		if (cep != null && !cep.contentEquals("")) {
			cep = value.replaceAll("[^0-9]", "");
		}

		return cep;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub

		String cep = String.valueOf(value);
		if (cep != null && cep.length() == 8) {
			cep = cep.substring(0, 5) + "-" + cep.substring(6, 8);
		}

		return cep;
	}

}
