package com.performance.optimization.design.flyweight;

import org.junit.Test;

public class FlyWeightTest {
	
	@Test
	public void test(){
		//此时会创建employeeReportManager对象
		IReportManager employeeReportManager = ReportManagerFactory.getEmployeeReportManager("A");
		System.out.println(employeeReportManager.createReport());
		//此时会创建employeeReportManager对象
		IReportManager reportManager = ReportManagerFactory.getFinancialReportManager("A");
		System.out.println(reportManager.createReport());
		//此时不会创建employeeReportManager对象,直接取已经创建的employeeReportManager对象
		reportManager = ReportManagerFactory.getEmployeeReportManager("A");
		System.out.println(reportManager.createReport());
		//此时是同一个对象
		System.out.println(reportManager == employeeReportManager );
	}

}
