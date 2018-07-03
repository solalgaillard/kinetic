package qinetic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/sign-up")
public class SignUp {

    @PostMapping
    public ResponseEntity signingUp(@RequestBody SignUpJSONToObj credentials) {
        return new qinetic.service.SignUp(
                credentials.getFirstName(),
                credentials.getLastName(),
                credentials.getEmail(),
                credentials.getPassword(),
                credentials.getDOB(),
                credentials.getPhoneNumber()
                ).signUp();
    }
}


class SignUpJSONToObj {
    private final String firstName, lastName, email, password, DOB, phoneNumber;

    public SignUpJSONToObj(String firstName, String lastName, String email, String password, String DOB, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDOB() {
        return DOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
