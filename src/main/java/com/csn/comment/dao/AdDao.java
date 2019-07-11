package com.csn.comment.dao;

import com.csn.comment.bean.Ad;

import java.util.List;

public interface AdDao {
    int insert(Ad ad);

    List<Ad> selectByPage(Ad condition);
}
