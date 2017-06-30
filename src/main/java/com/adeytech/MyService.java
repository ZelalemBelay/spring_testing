package com.adeytech;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Zelalem on 6/30/2017.
 */
@Component
public class MyService
{

    public MyService(){}

    public String getCustomer(int custID)
    {
        String val = custID>5? "My Customer": "Not My customer";
        return val;
    }
}
