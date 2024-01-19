package com.ssafy.ws.step5;

public interface IUserManager {
	User getLoginUser();
	void signup(User user);
	User login(String id, String password);
	void logout();
	User getUser(int userSeq);
	User getUser(String nickName);

}
