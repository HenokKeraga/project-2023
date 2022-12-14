package com.example.beanvlaidation.controller;

import jakarta.validation.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DemoController {
    final DemoService demoService;

    @PostMapping("/")
    public ResponseEntity<?> addDemoModel( @RequestBody DemoModel demoModel) {


        return ResponseEntity.ok(demoService.addDemo(demoModel));

    }
}

record DemoModel(@NotNull (message = "id must not be null") Long id, @NotEmpty(message = "name must not be empty") String name) {
}

@Service
@RequiredArgsConstructor
class DemoService {

    final ObjectValidator objectValidator;

    List<DemoModel> demoModelList = new ArrayList<>();

    public String addDemo(DemoModel demoModel) {
        var validate = objectValidator.validate(demoModel);
        if (!validate.isEmpty()) {

            return String.join(" | ",validate);
        }
        demoModelList.add(demoModel);

        return "done";
    }
}

@Component
class ObjectValidator {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public Set<String> validate(DemoModel demoModel) {
        var validate = validator.validate(demoModel);
        if (!validate.isEmpty()) {
            return validate.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
