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
	}

	public synchronized String getResult() {
		while(!isReady){
			try{
				wait();//阻塞当前线程
			}catch(InterruptedException e){
				
			}
		}
		return realData.result;
	}

}
