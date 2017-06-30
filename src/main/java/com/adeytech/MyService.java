package com.adeytech;

import org.springframework.stereotype.Service;

/**
 * Created by Zelalem on 6/30/2017.
 */
@Service
public class MyService
{

    public MyService(){}

    public String getCustomer(int custID)
    {
        return custID>5? "My Customer": "Not My customer";
    }
}
