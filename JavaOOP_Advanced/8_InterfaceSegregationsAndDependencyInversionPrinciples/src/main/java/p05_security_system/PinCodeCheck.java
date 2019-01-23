package p05_security_system;

public class PinCodeCheck implements SecurityCheck {

    private SecurityUI securityUI;

    public PinCodeCheck(SecurityUI securityUI) {
        this.securityUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        int pin = securityUI.requestPinCode();
        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }
}
