package com.dingli.pubcom.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.pubcom.bean.Business;
import com.dingli.pubcom.bean.BusinessDto;
import com.dingli.pubcom.dao.BusinessMapper;
import com.dingli.pubcom.dao.CommentMapper;
import com.dingli.pubcom.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	private BusinessMapper bm;
	
	@Autowired
	private CommentMapper cm;
		
	@Value("${bus_img_save_path}")
	private String savepath;
	
	@Value("${bus_img_url}")
	private String imgUrl;

	@Override
	public List<Business> busList(String titleInput) {
		Business bus = new Business();
		if (titleInput != null && !"".equals(titleInput)) {
			bus.setTitle("%" + titleInput + "%");
		}	
		return bm.selectAll(bus);
	}

	@Override
	public boolean insertBus(BusinessDto bDto) {
		MultipartFile savefile = bDto.getImgFile();
		
		if (savefile == null || savefile.getSize() == 0) {
			return false;
		}
		
		String filename = System.currentTimeMillis() + "_" +savefile.getOriginalFilename();
		
		File file = new File(savepath + filename);
		
		if (!file.exists()) {
			file.mkdirs();
		}
		
		try {
			savefile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		Business bus = new Business();
		
		BeanUtils.copyProperties(bDto, bus);
		
		bus.setImgFileName(filename);
		bus.setNumber(0);
		bus.setStarTotalNum(0);
		bus.setCommentTotalNum(0);
		
		//System.out.println(bus);
		
		bm.insert(bus);
		
		return true;
	}

	@Override
	public BusinessDto loadBus(int id) {	
		Business bus = bm.selectByPrimaryKey(id);
		BusinessDto bDto = new BusinessDto();
		BeanUtils.copyProperties(bus, bDto);
		bDto.setImgUrl(imgUrl + bus.getImgFileName());
		if (cm.selectStar(id) == null) {
			bDto.setStar(0);
		} else {
			bDto.setStar(cm.selectStar(id).getStar());
		}
		return bDto;
	}

	@Override
	public Boolean updateBus(BusinessDto bDto) {
		MultipartFile imgFile = bDto.getImgFile();
		BusinessDto oldDto = this.loadBus(bDto.getId());
		
		String filename = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
		if (imgFile == null || imgFile.getSize() == 0) {
			filename = oldDto.getImgFileName();
			//return false;
		} else {
			File file = new File(savepath + filename);
			
			if (!file.exists()) {
				file.mkdirs();
			}
			
			try {
				imgFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File oldfile = new File(savepath + oldDto.getImgFileName());
			oldfile.delete();
		}	
				
		Business business = new Business();
		BeanUtils.copyProperties(bDto, business);
		business.setImgFileName(filename);
		
		//System.out.println(business);
		
		bm.updateByPrimaryKey(business);
		
		return true;
	}

	@Override
	public void deleteBus(int id) {
		BusinessDto oldDto = this.loadBus(id);
		File oldfile = new File(savepath + oldDto.getImgFileName());
		oldfile.delete();
		bm.deleteByPrimaryKey(id);
	}

	@Override
	public List<BusinessDto> buslistForApi(BusinessDto bDto) {
		List<BusinessDto> bDtos = bm.selectAllForApi(bDto);
		for (BusinessDto businessDto : bDtos) {
			businessDto.setImg(imgUrl +businessDto.getImgFileName());
			businessDto.setId(businessDto.getbId());
		}
		return bDtos;
	}

	@Override
	public BusinessDto busDetailForApi(Integer id) {
		BusinessDto bDto = this.loadBus(id);
		bDto.setImg(imgUrl + bDto.getImgFileName());
		return bDto;
	}
	
	

}
