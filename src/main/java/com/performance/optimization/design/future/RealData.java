package com.performance.optimization.design.future;


public class RealData implements Data {
	
	protected final String result;
	
	public RealData(String para){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<10;i++){
			buffer.append(para).append("、");
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
		result = buffer.toString();
	}
	
	public String getResult() {
		return result;
	}
}
