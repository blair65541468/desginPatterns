package com.citi.util;

import lombok.Data;

@Data
public class AlertNotify {

    public void notifyAlert(String msg){
        System.out.println("Error with "  + msg);
    }

}
