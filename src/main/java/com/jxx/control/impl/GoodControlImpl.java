package com.jxx.control.impl;

import com.jxx.control.GoodControl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
@RequestMapping(value = "good")
public class GoodControlImpl implements GoodControl {

    @RequestMapping(value = "image", method = RequestMethod.GET)
    @Override
    public ModelAndView getImage(@RequestParam("id") int id) {
        return new ModelAndView("redirect:/img/goods/" + id + ".jpg");
    }
}
