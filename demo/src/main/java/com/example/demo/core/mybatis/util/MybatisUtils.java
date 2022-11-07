package com.example.demo.core.mybatis.util;


import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.StringUtils;

public class MybatisUtils {

	// 예제 클래스
    public static boolean isEmpty(Object obj){
        if( obj instanceof String ) {
			System.out.println("들어감1");
			
			if (obj==null || "".equals(obj.toString().trim())) {
				System.out.println("tttttttttttttttttttttttrue");
				return true;
			}else {
				System.out.println("ffffffffffffffffffffffalse");
				return false;
			}
			//return obj==null || "".equals(obj.toString().trim());
        } else if( obj instanceof List ) { 
			System.out.println("들어감2");
			return obj==null || ((List)obj).isEmpty();
        }else if( obj instanceof Map ) {
			System.out.println("들어감3");
			return obj==null || ((Map)obj).isEmpty();
		}else if( obj instanceof Object[] ) {
			System.out.println("들어감4");
			return obj==null || Array.getLength(obj)==0;
		}
        else{
			System.out.println("들어감5"); 
			return obj==null;
		}

    }
     
    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }

	

	// 기존 당부 클래스
	/*
	public static boolean equals(String str, Object obj) {
		String val = null;
		if(null != obj) {
			val = String.valueOf(obj);
		}
		return StringUtils.equals(str, val);
	}

	public static boolean equalsAny(String str, Object... objs) {

		return StringUtils.equals(str, ArrayUtils.toStringArray(objs));
	}
  
	public static boolean isNotEmpty(Object obj) {
		String val = null;
		if(null != obj) {
			val = String.valueOf(obj);
		}
		return StringUtils.isEmpty(val);
	}

	public static boolean isEmpty(Object obj) {
		String val = null;
		if(null != obj) {
			val = String.valueOf(obj);
		}
		return StringUtils.isEmpty(val);
	}

	public static boolean isAllEmpty(Object... objs) {
		boolean check = true;
		for(Object obj : objs) {
			if(isNotEmpty(obj)) {
				check = false;
			}
		}
		return check;
	}

	public static String toString(Object obj) {
		String val = null;
		if(null != obj) {
			val = String.valueOf(obj);
		}
		return val;
	}
	*/

}
