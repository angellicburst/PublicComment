package com.dingli.pubcom.service;

import java.util.List;

import com.dingli.pubcom.bean.Business;
import com.dingli.pubcom.bean.BusinessDto;

public interface BusinessService {
	public List<Business> busList(String titleInput);
	
	public boolean insertBus(BusinessDto bDto);
	
	public BusinessDto loadBus(int id);
	
	public Boolean updateBus(BusinessDto bDto);

	public void deleteBus(int id);

	public List<BusinessDto> buslistForApi(BusinessDto bDto);
	
	public BusinessDto busDetailForApi(Integer id);
}
