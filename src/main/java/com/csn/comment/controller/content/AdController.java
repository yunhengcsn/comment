package com.csn.comment.controller.content;

import com.csn.comment.dto.AdDto;
import com.csn.comment.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author csn
 */
@Controller
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @RequestMapping
    public String init() {
        return "/content/adList";
    }

    @RequestMapping("/addInit")
    public String addInit() {
        return "/content/adAdd";
    }
    @RequestMapping("/add")
    public String add(AdDto adDto) {
        adService.add(adDto);
        return "/content/adAdd";
    }
}
