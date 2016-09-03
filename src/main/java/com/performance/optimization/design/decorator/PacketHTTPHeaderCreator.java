package com.performance.optimization.design.decorator;

import java.util.Date;

/**
 * 具体的装饰器 负责对数据头加上HTTP头信息
 * @author qiaolin
 *
 */
public class PacketHTTPHeaderCreator extends PacketDecorator{

	public PacketHTTPHeaderCreator(IPacketCreator component) {
		super(component);
		System.out.println("Http装饰者构造");
	}

	/**
	 * 对给定数据加上消息头
	 */
	public String handleContent() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Cache-Control:no-cache\n");
		buffer.append("Date:" + new Date() + "\n");
		buffer.append(component.handleContent());
		return buffer.toString();
	}

}
