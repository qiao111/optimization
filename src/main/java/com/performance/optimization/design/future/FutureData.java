package com.performance.optimization.design.future;

public class FutureData implements Data {
	
	protected RealData realData = null;
	
	protected boolean isReady = false;
	
	public synchronized void setRealData(RealData realData){
		if(isReady){
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();//通知所有线程阻塞线程
		System.out.println("111111");
	}

	public synchronized String getResult() {
		while(!isReady){
			System.out.println("aaaaaaa");
			try{
				wait();//阻塞当前线程
			}catch(InterruptedException e){
				
			}
		}
		System.out.println("222222222");
		return realData.result;
	}

}
