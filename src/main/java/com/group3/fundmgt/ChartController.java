package com.group3.fundmgt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartController {

    @RequestMapping("/fund")
    public String show() {
        System.out.println("这里是fund入口");
        return "fund";
    }
}
