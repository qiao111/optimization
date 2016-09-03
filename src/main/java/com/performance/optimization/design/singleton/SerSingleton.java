package com.performance.optimization.design.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 可序列化的单例
 * @author qiaolin
 *
 */
public class SerSingleton implements Serializable{
	
	private static final long serialVersionUID = 3641141275445251177L;

	private SerSingleton(){
		System.out.println("singleton is create ");
	}
	
	private static SerSingleton instance = new SerSingleton();
	
	public static SerSingleton getInstance(){
		return instance;
	}
	
	public static void createString(){
		System.out.println("create string in SerSingleton ");
	}
	
	/**
	 * 阻止生成新的实例，返回当前的，确保唯一性
	 * 此方法会在调用readObject之后调用,如果有此方法则调用此方法返回对象，如果没有则返回readObject的对象
	 * @see java.io.ObjectStreamClass invokeReadResolve
	 * @return
	 */
	private Object readResolve(){
		return instance;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerSingleton ser = null;
		SerSingleton serOld = SerSingleton.getInstance();
		//序列化到本地
		FileOutputStream fos = new FileOutputStream("singleton");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(serOld);
		oos.flush();
		oos.close();
		
		//反序列化
		FileInputStream fis = new FileInputStream("singleton");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		ser = (SerSingleton) ois.readObject();
		System.out.println(ser);
//		ois.close();
		System.out.println(serOld);
		
		
	}
	
}
