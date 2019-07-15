package com.csn.comment.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author csn
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping
    public String init() {
        return "/system/index";
    }
}
