package com.dingli.pubcom.service;

import com.dingli.pubcom.bean.Member;
import com.dingli.pubcom.cacha.LoginCode;

public interface MemberService {
	public Member CheckLogin(Member member);
	
	public LoginCode CheckLoginCode(LoginCode loginCode);
	
	public LoginCode CheckLogin(LoginCode loginCode);

}
