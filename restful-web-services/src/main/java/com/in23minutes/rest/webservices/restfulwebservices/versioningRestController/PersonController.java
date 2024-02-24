package com.in23minutes.rest.webservices.restfulwebservices.versioningRestController;

import com.in23minutes.rest.webservices.restfulwebservices.versioningRestController.model.Name;
import com.in23minutes.rest.webservices.restfulwebservices.versioningRestController.model.PersonV1;
import com.in23minutes.rest.webservices.restfulwebservices.versioningRestController.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/person/")
public class PersonController {
    @GetMapping("v1")
    public PersonV1 getPerson(){
        return new PersonV1("Bob charli");
    }

    @GetMapping("v2")
    public PersonV2 getPersonV2(){
        return  new PersonV2(new Name( "Adarsh" , "tripathi"));
    }

    @GetMapping(path = "v2",params = "version = 2")
    public PersonV2 getUsingRequestParamPersonV2(){
        return  new PersonV2(new Name( "Adarsh" , "tripathi"));
    }

    @GetMapping(path = "v1",params = "version = 1")
    public PersonV1 getUsingRequestParamPersonV1(){
        return new PersonV1("Bob charli");
    }
}
