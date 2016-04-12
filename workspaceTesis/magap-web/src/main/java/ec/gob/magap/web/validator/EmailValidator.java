package ec.gob.magap.web.validator;

import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator, ClientValidator {

	private final Pattern pattern;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		if (!pattern.matcher(value.toString()).matches()) {
			String clientId = component.getClientId(context);
			HtmlInputText inputText = (HtmlInputText) context.getViewRoot()
					.findComponent(clientId);
			inputText.setValid(Boolean.FALSE);
			inputText.setStyle("border: 1px solid #cd0a0a;");
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Validation Error", value
							+ " is not a valid email;"));
		}
	}

	public Map<String, Object> getMetadata() {
		return null;
	}

	public String getValidatorId() {
		return "custom.emailValidator";
	}
}