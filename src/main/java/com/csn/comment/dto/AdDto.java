package com.csn.comment.dto;

import com.csn.comment.bean.Ad;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description:Ad数据传输对象
 *
 * @author csn
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdDto extends Ad {
    //图片路径
    private String img;
    //要与表单中file控件的name相同
    private MultipartFile imgFile;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }
}
