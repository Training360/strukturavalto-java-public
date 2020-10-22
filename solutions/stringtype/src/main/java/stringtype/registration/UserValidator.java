package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return username != null && !"".equals(username);
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1 != null
            && password1.length() >= 8
            && password1.equals(password2);
    }

    public boolean isValidEmail(String email) {
        int atSignIndex = email.indexOf('@');
        String domain = email.substring(atSignIndex + 1);
        int dotInDomainIndex = domain.indexOf('.');
        return atSignIndex > 0
            && dotInDomainIndex > 0
            && dotInDomainIndex < domain.length() - 1;
    }
}
