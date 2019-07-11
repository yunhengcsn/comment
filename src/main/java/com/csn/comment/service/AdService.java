package com.csn.comment.service;

import com.csn.comment.dto.AdDto;

import java.util.List;

/**
 * Description:将上层传入的dto转为数据库能识别的bean后调用dao
 *
 * @author csn
 */
public interface AdService {
    /**
     * 新增广告
     * @param adDto
     * @return 新增成功返回true，失败false
     */
    boolean add(AdDto adDto);

    List<AdDto> searchByPage(AdDto adDto);
}
