package com.GDP.test.service.impl;

import java.util.List;

import com.GDP.test.dao.ChartDAO;
import com.GDP.test.model.Chart;
import com.GDP.test.model.EventAnalytics;
import com.GDP.test.service.ChartService;

public class ChartServiceImpl implements ChartService {

	ChartDAO chartdaoimpl;

	public ChartDAO getChartdaoimpl() {
		return chartdaoimpl;
	}

	public void setChartdaoimpl(ChartDAO chartdaoimpl) {
		this.chartdaoimpl = chartdaoimpl;
	}


	@Override
	public EventAnalytics getAllData(String eventName) {
		return chartdaoimpl.getAllData(eventName);
	}

}
