package com.GDP.test.dao;

import java.util.List;

import com.GDP.test.model.Chart;
import com.GDP.test.model.EventAnalytics;



public interface ChartDAO {

	public EventAnalytics getAllData(String eventName);
}
