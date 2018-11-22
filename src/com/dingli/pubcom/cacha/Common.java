package com.dingli.pubcom.cacha;

import java.util.HashMap;
import java.util.Map;

public class Common {
	private static Map<Object, Object> codeCommon = new HashMap<Object, Object>();
	
	private static Map<Object, Object> tokenCommon = new HashMap<Object, Object>();

	public static Map<Object, Object> getCodeCommon() {
		return codeCommon;
	}

	public static void setCodeCommon(Map<Object, Object> codeCommon) {
		Common.codeCommon = codeCommon;
	}

	public static Map<Object, Object> getTokenCommon() {
		return tokenCommon;
	}

	public static void setTokenCommon(Map<Object, Object> tokenCommon) {
		Common.tokenCommon = tokenCommon;
	}
}
