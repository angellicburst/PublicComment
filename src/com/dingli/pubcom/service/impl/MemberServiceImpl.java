package com.dingli.pubcom.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.pubcom.bean.Member;
import com.dingli.pubcom.cacha.Common;
import com.dingli.pubcom.cacha.LoginCode;
import com.dingli.pubcom.dao.MemberMapper;
import com.dingli.pubcom.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberDao;

	@Override
	public Member CheckLogin(Member member) {
		// System.out.println(member.getName());
		Member m = memberDao.selectByMember(member);

		return m;
	}

	@Override
	public LoginCode CheckLoginCode(LoginCode l) {

		if (l.getUsername() == null || "".equals(l.getUsername())) {
			l.setErrno(1);
			l.setMsg("手机号不能为空");
			return l;
		}

		Member m = memberDao.selectByPhone(l);

		if (m != null) {
			l.setErrno(0);
			l.setCode(getCode());
			l.setMsg(l.getCode());
			Common.getCodeCommon().put(l.getUsername(), getMD5(l.getCode()));
		} else {
			l.setErrno(1);
			l.setMsg("该手机号没有注册");
		}

		return l;
	}

	private String getCode() {
		Random rad = new Random();

		String result = rad.nextInt(1000000) + "";

		if (result.length() != 6) {
			return getCode();
		}
		return result;
	}

	private String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return md5;
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }

	@Override
	public LoginCode CheckLogin(LoginCode loginCode) {
		
		if (!Common.getCodeCommon().containsKey(loginCode.getUsername())) {
			loginCode.setErrno(1);
			loginCode.setMsg("用户不存在");
			return loginCode;
		}
		
		if (!loginCode.getCode().equals(Common.getCodeCommon().get(loginCode.getUsername()))) {
			loginCode.setErrno(1);
			loginCode.setMsg("验证码不正确");
		} else {
			loginCode.setErrno(0);
			loginCode.setMsg("登陆成功");
			String uuid = UUID.randomUUID().toString().replace("-", "");
			loginCode.setToken(uuid);
			Common.getTokenCommon().put(loginCode.getUsername(), uuid);
		}
		return loginCode;
	}
}
