package com.GDP.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "barchart")
public class Chart {

	@Id
	@Column(name = "Year")
	private String year;
	
	@Column(name = "Sales")
	private int sales;
	
	@Column(name = "Expenses")
	private int expenses;
	
	@Column(name = "Profit")
	private int profit;
	
	public Chart(String year, int sales, int expenses, int profit) {
		super();
		this.year = year;
		this.sales = sales;
		this.expenses = expenses;
		this.profit = profit;
	}
	
	
	
	public Chart() {
		super();
	}



	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getExpenses() {
		return expenses;
	}
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	
	
	
}
