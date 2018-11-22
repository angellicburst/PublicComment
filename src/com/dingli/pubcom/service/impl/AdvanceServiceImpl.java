package com.dingli.pubcom.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.pubcom.bean.Advance;
import com.dingli.pubcom.bean.AdvanceDto;
import com.dingli.pubcom.dao.AdvanceMapper;
import com.dingli.pubcom.service.AdvanceService;

@Service
public class AdvanceServiceImpl implements AdvanceService {

	@Autowired
	private AdvanceMapper adMapper;
	
	@Value("${ad_img_save_path}")
	private String imgPath;
	
	@Value("${ad_img_url}")
	private String imgUrl;
	
	@Override
	public List<Advance> adlist(String titleInput) {
		Advance advance = new Advance();
		if (titleInput !=null && !"".equals(titleInput)) {
			advance.setTitle("%" + titleInput + "%");
		}		
		return adMapper.selectAll(advance);
	}

	@Override
	public boolean insertAd(AdvanceDto aDto) {
		Advance ad = new Advance();		
		//文件对象
		MultipartFile imgFile = aDto.getImgFile();
		String filename = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
		
		//判断
		if (imgFile == null || imgFile.getSize() == 0) {
			return false;
		}
		
		//加上时间毫秒避免重名
		File file = new File(imgPath + filename);
		
		//不存在新建
		if (!file.exists()) {
			file.mkdirs();
		}
		
		//上传文件到指定路径
		try {
			imgFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//将AdvanceDto复制给Advance
		BeanUtils.copyProperties(aDto, ad);
		
		ad.setImgFileName(filename);
		
		adMapper.insert(ad);
		return true;
	}

	@Override
	public AdvanceDto loadAd(int id) {
		Advance ad = adMapper.selectByPrimaryKey(id);
		AdvanceDto aDto = new AdvanceDto();
		BeanUtils.copyProperties(ad, aDto);
		aDto.setImgUrl(imgUrl + ad.getImgFileName());
		return aDto;
	}

	@Override
	public boolean updateAd(AdvanceDto aDto) {
		Advance advance = new Advance();
		AdvanceDto oldAd = this.loadAd(aDto.getId());
				
		MultipartFile imgFile = aDto.getImgFile();
		String filename = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
		//System.out.println(1);
		if (imgFile == null || imgFile.getSize() == 0) {
			filename = oldAd.getImgFileName();
			//return false;
		} else {
			File file = new File(imgPath + filename);
			
			if (!file.exists()) {
				file.mkdirs();
			}
			
			try {
				imgFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			//删除原先上传的图片
			
			File oldFile = new File(imgPath + oldAd.getImgFileName());
			oldFile.delete();
		}
		
		BeanUtils.copyProperties(aDto, advance);
		advance.setImgFileName(filename);
		//System.out.println(advance);
		adMapper.updateByPrimaryKey(advance);
		return true;
	}

	@Override
	public void deleteAd(int id) {
		AdvanceDto oldAd = this.loadAd(id);
		File oldFile = new File(imgPath + oldAd.getImgFileName());
		oldFile.delete();
		adMapper.deleteByPrimaryKey(id);		
	}

	@Override
	public List<AdvanceDto> adlistForApi() {
		List<Advance> ads = adMapper.selectAll(null);
		List<AdvanceDto> aDtos = new ArrayList<AdvanceDto>();
		
		AdvanceDto aDto = null;
		
		for (Advance advance : ads) {
			aDto = new AdvanceDto();
			//System.out.println(advance);
			BeanUtils.copyProperties(advance,aDto);
			aDto.setImg(imgUrl + advance.getImgFileName());
			aDtos.add(aDto);
		}
		return aDtos;
	}
	
}
