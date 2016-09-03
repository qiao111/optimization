package com.performance.optimization.design.decorator;

import org.junit.Test;

/**
 * 装饰者测试
 * @author qiaolin
 *
 */
public class DecoratorTest {
	
	/**
	 * 将装饰者和被装饰者组装在一起
	 */
	@Test
	public void test(){
		IPacketCreator component = new PacketHTTPHeaderCreator(
				new PacketHTMLHeaderCreator(new PacketBodyCreator()));
		System.out.println(component.handleContent());
	}
}
