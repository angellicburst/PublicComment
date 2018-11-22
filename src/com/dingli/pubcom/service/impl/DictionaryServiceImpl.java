package com.dingli.pubcom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.pubcom.bean.DicType;
import com.dingli.pubcom.dao.DicTypeMapper;
import com.dingli.pubcom.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService {
	
	@Autowired
	private DicTypeMapper dtm;

	@Override
	public List<DicType> dicList(String type) {
		DicType dicType = new DicType();
		dicType.setType(type);		
		return dtm.selectByType(dicType);
	}

}
