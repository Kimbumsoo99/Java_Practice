package com.ssafy.ws.step5;

import java.util.Scanner;

public class BoardTest {
	static boolean loginUser = false;
	static User user = null;
	static int userSeq = 0;
	static int articleSeq = 0;
	static int commentSeq = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserManager userManager = new UserManager();
		ArticleManager articleManager = new ArticleManager();
		CommentManager commentManager = new CommentManager();
		User user1 = new User(userSeq++, "ssafy", "1234", "김싸피", "김싸피", "ssafy@ssafy.com");
		User user2 = new User(userSeq++, "hong", "123", "홍싸피", "ssafy.hong", "hong@ssafy.com");
		User user3 = new User(userSeq++, "samsic", "samsic", "김삼식", "삼식이", "kim@ssafy.com");
		User user4 = new User(userSeq++, "happy", "happy", "이싸피", "해피바이러스", "lee@ssafy.com");
		User user5 = new User(userSeq++, "prince", "prince", "삼싸피", "프린스송", "prince@ssafy.com");
		User user6 = new User(userSeq++, "good", "good", "사싸피", "따봉맨", "good@ssafy.com");
		userManager.signup(user1);
		userManager.signup(user2);
		userManager.signup(user3);
		userManager.signup(user4);
		userManager.signup(user5);
		userManager.signup(user6);
		
		Article at1 = new Article(articleSeq++, "공지사항", "게시글 내용", 0);
		Article at2 = new Article(articleSeq++, "코딩테스트란", "게시글 내용", 1);
		Article at3 = new Article(articleSeq++, "취뽀는 나에게", "게시글 내용", 2);
		Article at4 = new Article(articleSeq++, "Java 완전정복", "게시글 내용", 3);
		Article at5 = new Article(articleSeq++, "Python 완전정복", "게시글 내용", 4);
		articleManager.addArticle(at1);
		articleManager.addArticle(at2);
		articleManager.addArticle(at3);
		articleManager.addArticle(at4);
		articleManager.addArticle(at5);
		ImageArticle iat1 = new ImageArticle(articleSeq++, "Image 잘찍는법 완전정복", "게시글 내용", 1, "사진 1", 300, 500);
		ImageArticle iat2 = new ImageArticle(articleSeq++, "클린코드 작성법", "게시글 내용2", 2, "사진 2", 500, 800);
		articleManager.addArticle(iat1);
		articleManager.addArticle(iat2);
		System.out.println("------------------------------------");
		System.out.println("게시판 접속");
		System.out.println("------------------------------------");
		Comment cm1 = new Comment(commentSeq++, 1, 4, "잘 보았습니다.");
		Comment cm2 = new Comment(commentSeq++, 1, 5, "좋은 글 입니다~~");
		commentManager.addComment(cm1);
		commentManager.addComment(cm2);
		while(true) {
			if(loginUser) {
				int mode = mainPrint(sc, articleManager);
				if(mode == 1) {
					writeBoard(sc, articleManager);
				}else if(mode == 2) {
					int boardId = choiceBoardNum(sc, articleManager);
					detailBoard(boardId, sc, userManager, articleManager, commentManager);
				}else if(mode == 3) {
					logout(userManager);
				}else {
					exit();
				}
			}else {
				int mode = nonLoginPrint(sc);
				if(mode == 0) {
					exit();
				}else if(mode == 1) {
					login(sc, userManager);
				}else if(mode == 2) {
					signIn(sc, userManager);
				}else if(mode == 3) {
					searchPrint(sc, articleManager);
				}else if(mode == 4) {
					textBoard(articleManager);
				}else if(mode == 5) {
					imageBoard(articleManager);
				}
			}
		}
	}
	static int mainPrint(Scanner sc, ArticleManager am) {
		System.out.println("게시글 목록");
		Article[] printBoard = am.getArticleList();
		for (Article article : printBoard) {
			System.out.println(article.getArticleld() + " " + article.getTitle());
		}
		System.out.println("------------------------------------");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 선택");
		System.out.println("3. 로그아웃");
		System.out.println("0. 종료");
		System.out.println("------------------------------------");
		int next = sc.nextInt();
		return next;
	}
	
	static void textBoard(ArticleManager am) {
		System.out.println("텍스트 게시글 모아보기");
		Article[] articles = am.getTextArticleList();
		for (int i = 0; i < articles.length; i++) {
			System.out.println(articles[i].getTitle());
		}
		System.out.println("------------------------------------");
	}
	
	static void imageBoard(ArticleManager am) {
		System.out.println("이미지 게시글 모아보기");
		ImageArticle[] articles = am.getImageArticleList();
		for (int i = 0; i < articles.length; i++) {
			System.out.println(articles[i].getTitle());
		}
		System.out.println();
		System.out.println("전체 이미지의 평균 크기 : " + am.getImageSizeAvg());
		System.out.println("------------------------------------");
	}
	static void searchPrint(Scanner sc,ArticleManager am) {
		System.out.println("검색 옵션");
		System.out.println("1. 제목검색");
		System.out.println("2. 내용검색");
		System.out.println("3. 작성자 검색");
		int option = searchModeGetOption(sc);
		String keyword = searchModeGetKeyword(sc);
		Article[] searchArticles = am.search(option, keyword);
		if(searchArticles.length == 0) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			for (int i = 0; i < searchArticles.length; i++) {
				if(searchArticles[i] instanceof ImageArticle img) {
					System.out.print("이미지 ");
				}else {
					System.out.print("텍스트 ");
				}
				System.out.println("게시글 : " + searchArticles[i].getTitle() + "\n");
			}
		}
		System.out.println("------------------------------------");
	}
	static int searchModeGetOption(Scanner sc) {
		return sc.nextInt();
	}
	static String searchModeGetKeyword(Scanner sc) {
		System.out.println("내용 입력");
		return sc.next();
	}
	static void detailBoard(int articleId, Scanner sc, UserManager um, ArticleManager am, CommentManager cm) {
		Article at = am.getArticle(articleId);
		at.setViewCnt(at.getViewCnt() + 1);
		System.out.println("제목 : " + at.getTitle());
		System.out.println("작성자 : " + um.getUser(at.getUserSeq()).getNickName());
		System.out.println("조회수 : " + at.getViewCnt());
		System.out.println("작성일 : " + at.getRegDate());
		System.out.println("내용 : " + at.getContent());
		System.out.println("------------------------------------");
		Comment[] commentList = cm.getCommentList(articleId);
		System.out.println("총 댓글의 수 : " + commentList.length);
		for (Comment comment : commentList) {
			System.out.println(comment.getCommentId() + ". " + comment.getContent() + " 작성자 : " + um.getUser(comment.getUserSeq()).getNickName());
		}
		System.out.println("------------------------------------");
		while(true) {
			System.out.println("1. 게시글 삭제");
			System.out.println("2. 댓글 작성");
			System.out.println("3. 댓글 삭제");
			System.out.println("0. 종료");
			System.out.println("------------------------------------");
			int mode = sc.nextInt();
			if(mode == 1) {
				if(am.getArticle(articleId).getUserSeq() == user.getUserSeq()) {
					am.removeArticle(articleId);
				}else {
					System.out.println("게시글 삭제는 작성자만 할 수 있습니다.");
				}
				System.out.println("------------------------------------");
			}else if(mode == 2) {
				// 스캐너에서 버퍼에 \n이 남아있어서 문제 발생 중
				sc.nextLine(); // 버퍼 비우기
				
				System.out.println("댓글을 작성해주세요.");
				String userCmStr = sc.nextLine();
				Comment userComment = new Comment(commentSeq++, articleId, user.getUserSeq(), userCmStr);
				cm.addComment(userComment);
				System.out.println("------------------------------------");
				detailBoard(articleId, sc, um, am, cm);
				return;
			}else if(mode == 3) {
				System.out.println("지우려는 댓글의 번호를 입력해주세요.");
				int cmNum = sc.nextInt();
				if(cm.getComment(cmNum) == null) {
					System.out.println("선택하신 댓글이 존재하지 않습니다.");
				}
				// 본인만 지울 수 있는 로직 추가
				Comment getComment = cm.getComment(cmNum);
				if(getComment.getUserSeq() == user.getUserSeq()) {
					cm.removeComment(cmNum);
				}else {
					System.out.println("게시글 삭제는 작성자만 할 수 있습니다.");
				}
				System.out.println("------------------------------------");
				detailBoard(articleId, sc, um, am, cm);
				return;
			}else {
				System.out.println("메인 화면으로 돌아갑니다.");
				System.out.println("------------------------------------");
				return;
			}
		}
	}
	static int choiceBoardNum(Scanner sc, ArticleManager am) {
		System.out.println("게시글 선택 : ");
		int articleId = sc.nextInt();
		return articleId;
	}
	static void writeBoard(Scanner sc, ArticleManager am) {
		sc.nextLine();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.println("내용 : ");
		String content = sc.nextLine();
		Article createArticle = new Article(articleSeq++, title, content,user.getUserSeq());
		am.addArticle(createArticle);
	}
	static void logout(UserManager um) {
		um.logout();
		user = null;
		loginUser = false;
	}
	static int nonLoginPrint(Scanner sc) {
		System.out.println("작업을 선택하세요.");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 검색");
		System.out.println("4. 일반 게시글 모아보기");
		System.out.println("5. 이미지 게시글 모아보기");
		System.out.println("0. 종료");
		System.out.println("------------------------------------");
		
		int next = sc.nextInt();
		return next;
	}
	static void login(Scanner sc, UserManager um) {
		System.out.println("ID 입력 :");
		String id = sc.next();
		System.out.println("PASSWORD 입력 :");
		String pw = sc.next();
		user = um.login(id, pw);
		System.out.println("------------------------------------");
		if(user == null) {
			System.out.println("로그인에 실패하셨습니다.");
		}else {
			System.out.println("로그인 성공");
			System.out.println(user.getUserName() + "님 환영합니다.");
			loginUser = true;
		}
		System.out.println("------------------------------------");
	}
	static void signIn(Scanner sc, UserManager um) {
		System.out.println("회원 가입을 시작하겠습니다.");
		// SEQ, ID, PW, USERNAME, NICKNAME, EMAIL
		System.out.println("ID 입력 :");
		String id = sc.next();
		System.out.println("비밀번호 입력 :");
		String pw = sc.next();
		System.out.println("이름 입력 :");
		String name = sc.next();
		System.out.println("닉네임 입력 :");
		String nikName = sc.next();
		System.out.println("이메일 입력 :");
		String email = sc.next();
		User addUser = new User(userSeq++, id,pw,name,nikName,email);
		um.signup(addUser);
		System.out.println("회원 가입 성공!\n로그인 후 이용해주시기 바랍니다.");
		System.out.println("------------------------------------");
	}
	
	static void exit() {
		System.out.println("안녕히 가세요.");
		System.exit(0);
	}
}
