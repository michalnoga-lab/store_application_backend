package com.app.adminControllers;

import com.app.dto.UserDTO;
import com.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    public String addGET(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("errors", new HashMap<>());
        return "/admin/users/add";
    }

    @PostMapping("/add")
    public String addPOST(@ModelAttribute UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getCode));
            model.addAttribute("user", userDTO);
            model.addAttribute("errors", errors);
            return "/admin/users/add";
        }

        userService.addUser(userDTO);
        return "/admin/users/added"; // TODO: 2020-01-12 redirect ???
    }
}