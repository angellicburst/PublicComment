package com.dingli.pubcom.service;

import java.util.List;

import com.dingli.pubcom.bean.Advance;
import com.dingli.pubcom.bean.AdvanceDto;

public interface AdvanceService {
	public List<Advance> adlist(String titleInput);
	
	public List<AdvanceDto> adlistForApi();
	
	public boolean insertAd(AdvanceDto aDto); 
	
	public AdvanceDto loadAd(int id);
	
	public boolean updateAd(AdvanceDto aDto);
	
	public void deleteAd(int id);
}
