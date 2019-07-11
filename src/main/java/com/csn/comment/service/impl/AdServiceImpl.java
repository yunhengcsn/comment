package com.csn.comment.service.impl;

import com.csn.comment.bean.Ad;
import com.csn.comment.dao.AdDao;
import com.csn.comment.dto.AdDto;
import com.csn.comment.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author csn
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Value("${adImage.url}")
    private String adImageUrl;

    /**
     * 新增广告
     *
     * @param adDto
     * @return 新增成功返回true，失败false
     */
    @Override
    //TODO 可以获取失败原因
    public boolean add(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());

        //校验，前端校验可被绕过
        if(adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            //加时间戳防止同名
            String fileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
            File file = new File(adImageSavePath + fileName);

            //校验文件夹是否存在，不存在则创建
            File fileFolder = new File(adImageSavePath);
            if(! fileFolder.exists()) {
                fileFolder.mkdirs();
            }

            try {
                adDto.getImgFile().transferTo(file);
                ad.setImgFileName(fileName);
                adDao.insert(ad);
                return true;
            } catch (IOException e) {
                //TODO 打日志
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> result = new ArrayList<>();
        Ad condition = new Ad();
        //bean 拷贝
        BeanUtils.copyProperties(adDto,condition);
        List<Ad> adList = adDao.selectByPage(condition);
        for(Ad ad : adList) {
            AdDto adDto1 = new AdDto();
            BeanUtils.copyProperties(ad,adDto1);
            adDto1.setImg(adImageUrl + ad.getImgFileName());
            result.add(adDto1);
        }
        return result;
    }
}
