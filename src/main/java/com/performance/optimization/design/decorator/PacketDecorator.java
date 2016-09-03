package com.performance.optimization.design.decorator;

/**
 * 装饰者  维护核心组件对象,负责告诉其子类，其核心业务逻辑处理全权委托给组件对象完成,自己仅作增强处理
 * @author qiaolin
 *
 */
public abstract class PacketDecorator implements IPacketCreator{
	
	 protected IPacketCreator component;
	 
	 public PacketDecorator(IPacketCreator component){
		 this.component = component;
	 }

}
