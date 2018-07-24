package gssb.controller;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

  @RequestMapping(value="/address", method=RequestMethod.POST)
  public Address create(@Valid @RequestBody Address address) {
    return address;
  }
  
  public static class Address {
    
    @NotEmpty
    @Size(min=7, max=7)
    public String zip;
    
    @NotEmpty
    public String address;
  }
}
