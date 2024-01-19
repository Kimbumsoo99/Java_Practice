package com.ssafy.ws.step5;

public class UserManager {
	private final int MAX_USER_SIZE = 100;
	private User loginUser;
	private User[] users = new User[MAX_USER_SIZE];
	private int userSize;
	
	public User getLoginUser() {
		return null;
	}
	
	public void signup(User user) {
		users[userSize++] = user;
	}
	
	public User login(String id, String password) {
		for (int i = 0; i < userSize; i++) {
			if(users[i].getUserId().equals(id) && users[i].getPassword().equals(password)) {
				this.loginUser = users[i];
				break;
			}
		}
		return loginUser;
	}
	
	public void logout() {
		loginUser = null;
	}
	
//	public int getUserSeqByNickName(String nickName) {
//		for (int i = 0; i < userSize; i++) {
//			if(users[i].getNickName() == nickName) {
//				return users[i].getUserSeq();
//			}
//		}
//		return 0;
//	}
	
	public User getUser(int userSeq) {
		for (int i = 0; i < userSize; i++) {
			if(users[i].getUserSeq() == userSeq) {
				return users[i];
			}
		}
		return null;
	}
	
	public User getUser(String nickName) {
		for (int i = 0; i < userSize; i++) {
			if(users[i].getNickName() == nickName) {
				return users[i];
			}
		}
		return null;
	}
}
