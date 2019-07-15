package com.csn.comment.dao;

import java.util.List;

import com.csn.comment.bean.Dic;

public interface DicDao {
    List<Dic> select(Dic dic);
}