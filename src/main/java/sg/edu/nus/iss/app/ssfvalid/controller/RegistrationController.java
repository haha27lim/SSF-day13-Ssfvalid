package sg.edu.nus.iss.app.ssfvalid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfvalid.models.Person;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

    // Handling GET request to /register to display the registration form
    @GetMapping
    public String getRegForm(Model model) {
        // Adding an empty Person object to the model to be used in the form
        model.addAttribute("person", new Person());
        return "registration";
    }

    // Handling POST request to /register to submit the form
    @PostMapping
    public String postRegistration(@Valid Person person, BindingResult binding, Model model) {
        // Checking if the form has any validation errors
        if (binding.hasErrors()) {
            // If there are errors, re-display the form
            return "registration";
        }

        // If the form is valid, redirect to the thank you page
        return "thankyou";
    }

}
