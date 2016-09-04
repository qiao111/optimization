package com.performance.optimization.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SubString {
	static class HugeStr{
		private String str = new String(new char[100000]);
		
		public String getSubString(int begin,int end){
			return str.substring(begin, end);
		}
	}
	
	static class ImprovedHugStr{
		private String str = new String(new char[100000]);
		
		public String getSubString(int begin,int end){
			return new String(str.substring(begin, end));
		}
	}
	
	public static void main(String[] args) {
		List<String> handler = new ArrayList<String>();
		
		for(int i = 0; i<100;i++){
//			HugeStr str = new HugeStr();
			ImprovedHugStr str = new ImprovedHugStr();
			handler.add(str.getSubString(1, 5));
		}
		
		HashMap<String,String> map = new LinkedHashMap<String,String>();
		
		map.put("zhangsan","zhangsan");
		map.put("lisi","lisi");
		map.put("wangwu","wangwu");
		
		Set<Entry<String,String>> entries =  map.entrySet();
		for(Entry<String,String> entry:entries){
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}
}
