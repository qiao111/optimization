package com.performance.optimization.design.future;

public class Client {
	
	public Data request(final String queryStr){
		final FutureData future = new FutureData();
		
		new Thread(){
			public void run() {
				RealData realData = new RealData(queryStr);
				System.out.println("4444444");
				future.setRealData(realData);
			};
		}.start();
		return future;
	}
	
	
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");
		System.out.println("数据：" + data.getResult());
	}
}
