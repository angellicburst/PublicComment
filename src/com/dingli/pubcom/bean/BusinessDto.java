package com.dingli.pubcom.bean;

import org.springframework.web.multipart.MultipartFile;

public class BusinessDto extends Business {
	private Integer bId;
	
	private MultipartFile imgFile;
	
	private String imgUrl;

	private String img;
	
	private Integer mumber;
	
	private Integer page;
	
	private String keyword;
	
	private Integer star;
	
	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

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

	public Integer getMumber() {
		return mumber;
	}

	public void setMumber(Integer mumber) {
		this.mumber = mumber;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "BusinessDto [bId=" + bId + ", imgFile=" + imgFile + ", imgUrl=" + imgUrl + ", img=" + img + ", mumber="
				+ mumber + ", page=" + page + ", keyword=" + keyword + ", star=" + star + "]";
	}
	
}
