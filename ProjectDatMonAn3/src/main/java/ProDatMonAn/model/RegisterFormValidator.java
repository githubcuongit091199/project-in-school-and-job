package ProDatMonAn.model;


import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;




@Component
public class RegisterFormValidator implements Validator {
	 @Override
	public boolean supports(Class<?> aClass) {
        // Chỉ ra rằng nó sẽ chỉ có hiệu lực đối với RegisterForm.
	
		
		return aClass.equals(Register.class);
	}
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";// cấu trúc 1 email thông thường
 
//    public EmailValidator() {
//        pattern = Pattern.compile(EMAIL_PATTERN);
//    }
 
    // Class kiểm định dạng email
//    public boolean validate(final String hex) {
// 
//        matcher = pattern.matcher(hex);
//        return matcher.matches();
// 
//    }
	 @Override
	public void validate(Object o, Errors errors) {
        // Thực hiện validate ở đây
		
		 Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
		
		Register register = (Register) o;
		System.out.println("validate"+register.getEmail());
		 java.util.regex.Matcher matcher = pattern.matcher(register.getEmail());
		
		if (!matcher.matches()) {
            // Khai báo thêm lỗi vào đối tượng errors
			System.out.println("validate "+matcher.matches());
			errors.rejectValue("email", "attendeeEmail.missing");
			System.out.println("validate1111111 "+matcher.matches());
		}
		
	
		
		
		
	}


}