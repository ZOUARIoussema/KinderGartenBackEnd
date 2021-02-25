package tn.esprit.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical")
@PreAuthorize("hasRole('ROLE_doctor')")
public class MedicalController {

}
