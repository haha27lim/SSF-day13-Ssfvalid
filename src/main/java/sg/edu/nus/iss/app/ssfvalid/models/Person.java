package sg.edu.nus.iss.app.ssfvalid.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Person {
    // Validation: Name cannot be null and must be between 2 and 32 characters
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters")
    private String name;

    @Email(message = "Must be a valid email")
    private String email;

    private Boolean isMarried;

    // Validation: Age must be between 10 and 100 years old
    @Min(value = 10, message = "Age cannot be less than 10 years old")
    @Max(value = 100, message = "Age cannot be more than 100 years old")
    private Integer age;

    // Validation: Date of birth must not be in the future
    @Past(message = "Date of birth must not be future")
    @NotNull(message = "Date of Birth must be mandatory")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;

    // Validation: Person must have at least one hobby
    @NotEmpty(message = "Please get a life!")
    @Size(min = 2, message = "Must have at least one hobby")
    private List<String> hobbies;

    // Getter and setter
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}