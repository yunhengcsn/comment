package com.csn.comment.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 与数据库中的表对应
 * id	int(11)	NO	PRI		auto_increment
 * title	varchar(50)	YES
 * img_file_name	varchar(100)	YES		***** 名称要去掉下划线
 * link	varchar(200)	YES
 * weight	int(11)	YES
 */
@JsonInclude(Include.NON_NULL)
public class Ad extends BaseBean {
    //用封装类型而不是基本类型方便判断空
    private Long id;
    private String title;
    private String imgFileName;
    private String link;
    private Long weight;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImgFileName() {
        return imgFileName;
    }
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getWeight() {
        return weight;
    }
    public void setWeight(Long weight) {
        this.weight = weight;
    }


    
}