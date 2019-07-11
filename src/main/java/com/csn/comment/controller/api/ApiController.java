package com.csn.comment.controller.api;

import com.csn.comment.bean.Ad;
import com.csn.comment.bean.Business;
import com.csn.comment.dto.AdDto;
import com.csn.comment.service.AdService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author csn
 */
//@Controller
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private AdService adService;

    @Value("${ad.number}")
    private int adNumber;

//    @ResponseBody
    @RequestMapping(value = "/homead",method = RequestMethod.GET)
    public List<AdDto> homead() throws IOException {
        AdDto adDto = new AdDto();
        adDto.getPage().setPageNumber(adNumber);

        return adService.searchByPage(adDto);
//        返回假数据，用于将json转为bean
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = "";
//         return objectMapper.readValue(s, new TypeReference<List<Ad>>() {});
    }

    @RequestMapping(value = "/homelist/{city}/{page}" , method = RequestMethod.GET)
    public List<Business> homelist() throws IOException {
        //用于将json转为bean
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "";
        return objectMapper.readValue(s, new TypeReference<List<Ad>>() {});
    }

    @RequestMapping(value = "/submitComment" , method = RequestMethod.POST)
    public Map<String,Object> submitComment() throws IOException {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("errno",0);
        result.put("msg","success");

        return result;
    }

}
