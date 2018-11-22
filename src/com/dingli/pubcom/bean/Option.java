package com.dingli.pubcom.bean;

import java.util.List;

public class Option {
	private Legend legend;
	private XAxis xAxis;
	private List<Series> series;
	
	public Legend getLegend() {
		return legend;
	}
	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	public XAxis getxAxis() {
		return xAxis;
	}
	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}
	public List<Series> getSeries() {
		return series;
	}
	public void setSeries(List<Series> series) {
		this.series = series;
	}
	@Override
	public String toString() {
		return "Option [legend=" + legend + ", xAxis=" + xAxis + ", series=" + series + "]";
	}
	
}
