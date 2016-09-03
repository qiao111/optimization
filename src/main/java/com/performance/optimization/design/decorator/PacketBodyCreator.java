package com.performance.optimization.design.decorator;

/**
 * 被装饰者(具体组件)  返回数据包的核心数据 也是主要的业务处理
 * @author qiaolin
 *
 */
public class PacketBodyCreator implements IPacketCreator{
	
	public PacketBodyCreator(){
		System.out.println("被装饰者构造器");
	}
	
	public String handleContent() {
		return "Content of Packet";
	}

}
