package com.GDP.test.service;

import java.util.List;

import com.GDP.test.model.Chart;
import com.GDP.test.model.EventAnalytics;

public interface ChartService {

	public EventAnalytics getAllData(String eventName);
}
