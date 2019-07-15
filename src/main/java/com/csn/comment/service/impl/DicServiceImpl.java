package com.csn.comment.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.csn.comment.bean.Dic;
import com.csn.comment.dao.DicDao;
import com.csn.comment.service.DicService;
import org.springframework.stereotype.Service;

@Service
public class DicServiceImpl implements DicService {
    
    @Resource
    private DicDao dicDao;
    
    @Override
    public List<Dic> getListByType(String type) {
	Dic dic = new Dic();
	dic.setType(type);
	return dicDao.select(dic);
    }
}
