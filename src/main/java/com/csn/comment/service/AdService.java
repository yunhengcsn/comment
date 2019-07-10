package com.csn.comment.service;

import com.csn.comment.dto.AdDto;

/**
 * Description:将上层传入的dto转为数据库能识别的bean
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
}
