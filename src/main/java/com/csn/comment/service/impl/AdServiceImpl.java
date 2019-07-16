package com.csn.comment.service.impl;

import com.csn.comment.bean.Ad;
import com.csn.comment.dao.AdDao;
import com.csn.comment.dto.AdDto;
import com.csn.comment.service.AdService;
import com.csn.comment.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(AdServiceImpl.class);

    @Override
    // TODO 可以改成获取失败详细原因
    public boolean add(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
            File file = new File(adImageSavePath + fileName);
            File fileFolder = new File(adImageSavePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                adDto.getImgFile().transferTo(file);
                ad.setImgFileName(fileName);
                adDao.insert(ad);
                return true;
            } catch (IllegalStateException | IOException e) {
                logger.info("saveImgFile Failed!");
                return false;
            }
        } else {
            return false;
        }
    }

    public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> result = new ArrayList<>();
        Ad condition = new Ad();
        //利用spring提供的方法拷贝对象
        BeanUtils.copyProperties(adDto, condition);
        List<Ad> adList = adDao.selectByPage(condition);
        for (Ad ad : adList) {
            AdDto adDtoTemp = new AdDto();
            //图片路径加上url
            adDtoTemp.setImg(adImageUrl + ad.getImgFileName());
            BeanUtils.copyProperties(ad, adDtoTemp);
            result.add(adDtoTemp);
        }
        return result;
    }

    @Override
    public AdDto getById(Long id) {
        AdDto result = new AdDto();
        Ad ad = adDao.selectById(id);
        BeanUtils.copyProperties(ad, result);
        result.setImg(adImageUrl + ad.getImgFileName());
        return result;
    }

    @Override
    public boolean modify(AdDto adDto) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDto, ad);
        String fileName = null;
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            try {
                fileName = FileUtil.save(adDto.getImgFile(), adImageSavePath);
                ad.setImgFileName(fileName);
            } catch (IllegalStateException | IOException e) {
                logger.info("saveImgFile Failed!");
                return false;
            }
        }
        int updateCount = adDao.update(ad);
        if (updateCount != 1) {
            return false;
        }
        if (fileName != null) {
            return FileUtil.delete(adImageSavePath + adDto.getImgFileName());
        }
        return true;
    }

    @Override
    public boolean remove(Long id) {
        Ad ad = adDao.selectById(id);
        int deleteRows = adDao.delete(id);
        FileUtil.delete(adImageSavePath + ad.getImgFileName());
        return deleteRows == 1;
    }
}
