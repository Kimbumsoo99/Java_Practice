package com.ssafy.ws.step5;

public class UserManagerImpl implements IUserManager{
	private final int MAX_USER_SIZE = 100;
	private User loginUser;
	private User[] users = new User[MAX_USER_SIZE];
	private int userSize;
	private static IUserManager instance = new UserManagerImpl();
	
	private UserManagerImpl() {}
	
	public static IUserManager getInstance() {
		return instance;
	}
	
	@Override
	public User getLoginUser() {
		return loginUser;
	}
	
	@Override
	public void signup(User user) {
		users[userSize++] = user;
	}
	
	@Override
	public User login(String id, String password) {
		for (int i = 0; i < userSize; i++) {
			if(users[i].getUserId().equals(id) && users[i].getPassword().equals(password)) {
				this.loginUser = users[i];
				break;
			}
		}
		return loginUser;
	}
	
	@Override
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
	
	@Override
	public User getUser(int userSeq) {
		for (int i = 0; i < userSize; i++) {
			if(users[i].getUserSeq() == userSeq) {
				return users[i];
			}
		}
		return null;
	}
	
	@Override
	public User getUser(String nickName) {
		for (int i = 0; i < userSize; i++) {
			if(users[i].getNickName() == nickName) {
				return users[i];
			}
		}
		return null;
	}
}
