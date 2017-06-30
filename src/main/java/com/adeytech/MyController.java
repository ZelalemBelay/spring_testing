package com.adeytech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zelalem on 6/30/2017.
 */

@RestController
public class MyController {

    public final static String URL = "/getCustomer/{custID}";

    @Autowired
    MyService myService;

    @RequestMapping(URL)
    public String getCustomer(@PathVariable int custID)
    {
        return this.myService.getCustomer(custID);
    }
}
