package com.dingli.pubcom.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.pubcom.bean.Legend;
import com.dingli.pubcom.bean.Option;
import com.dingli.pubcom.bean.Series;
import com.dingli.pubcom.bean.XAxis;
import com.dingli.pubcom.dao.ReportMapper;
import com.dingli.pubcom.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportMapper rm;
	
	@Override
	public Option getReport() {
		Option o = new Option();
		
		List<Map<Object, Object>> datas = rm.reportCount();
		
		Map<String,Integer> reportNum = new HashMap<String,Integer>();
		
		Legend le = new Legend();
		Set<String> categories = new HashSet<String>();
		for (Map<Object, Object> map : datas) {
			reportNum.put(map.get("category").toString() + "_" + map.get("hour"), Integer.parseInt(map.get("num").toString()));
			categories.add(map.get("category").toString());
		}
		le.setData(categories);
		o.setLegend(le);
		
		XAxis xAxis = new XAxis();
		List<String> hours = new ArrayList<String>();
		for(int i = 0 ; i < 24 ; i++) {
			hours.add(String.format("%02d", i));
		}
		xAxis.setData(hours);
		o.setxAxis(xAxis);
		
		List<Series> s = new ArrayList<Series>();
		for (String category : le.getData()) {
			Series series = new Series();
			series.setName(category);
			series.setType("bar");
			//series.setStack("总量");
			//series.setAreaStyle(areaStyle);
			List<Integer> d = new ArrayList<Integer>();
			for (Object hour : xAxis.getData()) {
				String key = category + "_" + hour.toString();
				if (reportNum.containsKey(key)) {
					//System.out.println(key);
					d.add(Integer.parseInt(reportNum.get(key).toString()));
				}
				else {
					d.add(0);
				}
			}
			series.setData(d);
			s.add(series);
		}
		o.setSeries(s);
		
		return o;
	}

}
