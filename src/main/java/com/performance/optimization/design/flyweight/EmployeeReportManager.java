package com.performance.optimization.design.flyweight;

/**
 * 具体享元类  员工报表
 * @author qiaolin
 *
 */
public class EmployeeReportManager implements IReportManager {

	protected String tenantId ;
	
	public EmployeeReportManager(String tenantId){
		System.out.println("初始化个人报表");
		this.tenantId = tenantId;
	}
	
	public String createReport() {
		return "This is a employee report";
	}
}
