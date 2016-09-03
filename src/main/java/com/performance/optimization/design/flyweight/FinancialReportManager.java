package com.performance.optimization.design.flyweight;

/**
 * 具体享元类  个人的财政报告
 * @author qiaolin
 *
 */
public class FinancialReportManager implements IReportManager{

	protected String tenantId ;
	
	public FinancialReportManager(String tenantId){
		System.out.println("初始化财政报表");
		this.tenantId = tenantId;
	}
	
	public String createReport() {
		return "This is a finanicial report";
	}
}
