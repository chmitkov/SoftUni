package p05_security_system;

public class KeyCardCheck implements SecurityCheck {

    private SecurityUI securityUI;

    public KeyCardCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        String code = securityUI.requestKeyCard();
        return isValid(code);
    }

    private boolean isValid(String code) {
        return true;
    }
}
