package com.bogdan.controller;


import com.bogdan.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zoomout on 12/19/16.
 */
@Controller
public class ButtonsController {

    @RequestMapping("/buttons")
    public String buttons() {
        return "buttons";
    }
}
