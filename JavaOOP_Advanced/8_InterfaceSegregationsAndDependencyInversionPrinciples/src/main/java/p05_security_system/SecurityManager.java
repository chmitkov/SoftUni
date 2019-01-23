package p05_security_system;

import java.io.IOException;
import java.util.Scanner;

public class SecurityManager {

    private SecurityCheck keyCardCheck;
    private SecurityCheck pinCodeCheck;

    public SecurityManager(SecurityCheck keyCardCheck, SecurityCheck pinCodeCheck) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
    }

    public void check() {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println(keyCardCheck.validateUser());
                break;
            case 2:
                System.out.println(pinCodeCheck.validateUser());
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        ScannerUI scannerUI = new ScannerUI();
        KeyCardCheck keyCardCheck = new KeyCardCheck(scannerUI);
        PinCodeCheck pinCodeCheck = new PinCodeCheck(scannerUI);
        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck);
        manager.check();
    }
}
