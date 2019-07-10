package com.csn.comment.service.impl;

import com.csn.comment.bean.Ad;
import com.csn.comment.dao.AdDao;
import com.csn.comment.dto.AdDto;
import com.csn.comment.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 *
 * @author csn
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    /**
     * 新增广告
     *
     * @param adDto
     * @return 新增成功返回true，失败false
     */
    @Override
    public boolean add(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());

        File file = new File("");
        try {
            adDto.getImgFile().transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
