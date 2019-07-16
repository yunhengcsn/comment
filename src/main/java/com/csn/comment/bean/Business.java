package com.csn.comment.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 数据库表结构相对应
 * id	int(11)	NO	PRI		auto_increment
 * img_file_name	varchar(100)	YES		***去掉下划线
 * title	varchar(50)	YES
 * subtitle	varchar(100)	YES
 * price	decimal(11,2)	YES
 * distance	int(11)	YES
 * number	int(11)	YES
 * desc	varchar(500)	YES
 * city	varchar(16)	YES
 * category	varchar(16)	YES
 * star_total_num	int(11)	YES
 * comment_total_num	int(11)	YES
 */
@JsonInclude(Include.NON_NULL)
public class Business extends BaseBean {
    
    private Long id;
    private String imgFileName;
    private String title;
    private String subtitle;
    private Double price;
    private Integer distance;
    private Integer number;
    private String desc;
    private String city;
    private String category;
    private Long starTotalNum;
    private Long commentTotalNum;
    
    private Dic cityDic;
    private Dic categoryDic;

    
    public Dic getCityDic() {
        return cityDic;
    }
    public void setCityDic(Dic cityDic) {
        this.cityDic = cityDic;
    }
    public Dic getCategoryDic() {
        return categoryDic;
    }
    public void setCategoryDic(Dic categoryDic) {
        this.categoryDic = categoryDic;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImgFileName() {
        return imgFileName;
    }
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getDistance() {
        return distance;
    }
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
	public Long getStarTotalNum() {
		return starTotalNum;
	}
	public void setStarTotalNum(Long starTotalNum) {
		this.starTotalNum = starTotalNum;
	}
	public Long getCommentTotalNum() {
		return commentTotalNum;
	}
	public void setCommentTotalNum(Long commentTotalNum) {
		this.commentTotalNum = commentTotalNum;
	}
}