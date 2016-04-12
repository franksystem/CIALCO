package ec.gob.magap.web.validator;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

import ec.gob.magap.web.util.CedulaValidatorUtil;

@FacesValidator("cedulaValidator")
public class CedulaValidator implements Validator, ClientValidator {

	public Map<String, Object> getMetadata() {
		return null;
	}

	public String getValidatorId() {
		return "cedulaValidator";
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (CedulaValidatorUtil.validateCedula(value.toString())) {
			String clientId = component.getClientId(context);
			HtmlInputText inputText = (HtmlInputText) context.getViewRoot()
					.findComponent(clientId);
			inputText.setValid(Boolean.TRUE);
			inputText.setStyle("border: 1px solid #a8a8a8;width: 100px;");
		} else {
			String clientId = component.getClientId(context);
			HtmlInputText inputText = (HtmlInputText) context.getViewRoot()
					.findComponent(clientId);
			inputText.setValid(Boolean.FALSE);
			inputText.setStyle("border: 1px solid #cd0a0a;width: 100px;");
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"El n\u00FAmero de c\u00E9dula no es v\u00E1lido"));
			return;
		}
	}
}
