package com.jxx.control.impl;

import com.jxx.control.GoodControl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "good")
public class GoodControlImpl implements GoodControl {

    @RequestMapping(value = "image")
    @Override
    public ModelAndView getImage(@RequestParam("id") int id) {
        return new ModelAndView("redirect:/img/goods/" + id + ".jpg");
    }
}
