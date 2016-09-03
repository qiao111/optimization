package com.performance.optimization.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * @author qiaolin
 *
 */
public class ReportManagerFactory {
	private static final Map<String,IReportManager> financialReportManager = new HashMap<String,IReportManager>();
	
	private static final Map<String,IReportManager> employeeReportManager = new HashMap<String,IReportManager>();
	
	/**
	 * 获取财政报表对象
	 * @param tenantId
	 * @return
	 */
	public static IReportManager getFinancialReportManager(String tenantId){
		IReportManager reportManager = financialReportManager.get(tenantId);
		if(reportManager == null){
			reportManager = new FinancialReportManager(tenantId);
			financialReportManager.put(tenantId, reportManager);
		}
		return reportManager;
	}
	
	
	/**
	 * 获取个人报表对象
	 * @param tenantId
	 * @return
	 */
	public static IReportManager getEmployeeReportManager(String tenantId){
		IReportManager reportManager = employeeReportManager.get(tenantId);
		if(reportManager == null){
			reportManager = new EmployeeReportManager(tenantId);
			employeeReportManager.put(tenantId, reportManager);
		}
		return reportManager;
	}
	
}
