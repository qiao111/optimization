package com.performance.optimization.design.decorator;

/**
 * 组件接口 定义了被装饰者的核心功能和装饰者需要增强的功能点
 * @author qiaolin
 *
 */
public interface IPacketCreator {
	String handleContent();//用于内容处理
}
