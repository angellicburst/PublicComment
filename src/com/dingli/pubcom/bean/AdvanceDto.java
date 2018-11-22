package com.dingli.pubcom.bean;

import org.springframework.web.multipart.MultipartFile;

public class AdvanceDto extends Advance {
	private MultipartFile imgFile;
	
	private String imgUrl;
	
	private String img;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "AdvanceDto [imgFile=" + imgFile + ", imgUrl=" + imgUrl + ", img=" + img + "]";
	}

}
