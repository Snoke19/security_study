package com.example.security_study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  @GetMapping("/")
  public String getMessage() {
    return "<h1>Welcome<h1>";
  }

  @GetMapping("/admin")
  public String getMessageAdmin() {
    return "<h1>Welcome ADMIN<h1>";
  }

  @GetMapping("/role")
  public String getMessageRole() {
    return "<h1>Welcome ROLE<h1>";
  }
}
