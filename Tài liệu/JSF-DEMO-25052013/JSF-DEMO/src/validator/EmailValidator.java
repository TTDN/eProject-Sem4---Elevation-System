package validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {
@Override
public void validate(FacesContext arg0, UIComponent ui, Object arg2)
		throws ValidatorException {
	System.out.println(ui);
	
}
}
