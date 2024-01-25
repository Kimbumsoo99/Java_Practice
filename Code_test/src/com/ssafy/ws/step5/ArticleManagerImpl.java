package com.ssafy.ws.step5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleManagerImpl implements IArticleManager{

	List<Article> articles;
	Map<Integer, List<Comment>> comments;
	private static IArticleManager instance = new ArticleManagerImpl();

	private ArticleManagerImpl() {
		articles = new ArrayList<>();
		comments = new HashMap<>();
	}

	public static IArticleManager getInstance() {
		return instance;
	}

	@Override
	public Article[] getArticleList() {
		return articles.toArray(Article[]::new);
	}

	@Override
	public Article getArticle(int articleId) {
		return articles.stream()
			.filter((article) -> article.getArticleld() == articleId)
			.findFirst()
			.get();
	}

	@Override
	public void addArticle(Article article) {
		articles.add(article);
		comments.put(article.getArticleld(), new ArrayList<>());
	}

	@Override
	public void removeArticle(int articleId) {
		articles.remove(getArticle(articleId));
		comments.remove(articleId);
	}

	@Override
	public void updateArticle(Article article) {
		Article at = getArticle(article.getArticleld());
		at.setTitle(article.getTitle());
		at.setContent(article.getContent());
		at.setRegDate(article.getRegDate());
	}

	@Override
	public Article[] getTextArticleList() {
//		List<Article> returnArt =  articles.stream()
//			.filter(article -> !(article instanceof ImageArticle))
//			.collect(Collectors.toList());
//		return returnArt.toArray(new Article[returnArt.size()]);
		return articles.stream()
			.filter(article -> !(article instanceof ImageArticle))
			.toArray(Article[]::new);
	}

	@Override
	public ImageArticle[] getImageArticleList() {
		return articles.stream()
			.filter(art -> art instanceof ImageArticle)
			.toArray(ImageArticle[]::new);
	}

	@Override
	public double getImageSizeAvg() {
		return Arrays.stream(getImageArticleList())
			.mapToDouble(art -> art.getHeight() + art.getWidth())
			.average().orElse(0.0);
	}

	@Override
	public Article[] search(int option, String keyword) {
		int idx = 0;
		switch (option) {
			case 1: // 키워드 포함 제목
				return articles.stream()
					.filter(art -> art.getTitle().contains(keyword))
					.toArray(Article[]::new);
			case 2: // 키워드 포함 내용
				return articles.stream()
					.filter(art -> art.getContent().contains(keyword))
					.toArray(Article[]::new);
			default: // 유저 닉네임 일치 작성
				// 미완성
				IUserManager um = UserManagerImpl.getInstance();
				return articles.stream()
					.filter(art -> art.getUserSeq() == um.getUser(keyword).getUserSeq())
					.toArray(Article[]::new);
		}
	}

	@Override
	public void addComment(Comment comment) {
		comments.get(comment.getArticleld()).add(comment);
	}

	@Override
	public void removeComment(int commentId) {
		Comment com = getComment(commentId);
		comments.get(com.getArticleld()).remove(com);
	}

	@Override
	public Comment[] getCommentList(int articleId) {
		return comments.get(articleId).stream()
			.toArray(Comment[]::new);
	}

//	@Override
//	public Comment getComment(int commentId) {
//		// Map<Integer, List<Comment>> comments;
//		List<Comment>[] lists = comments.keySet().stream()
//			.toArray(List[]::new);
//		for (List<Comment> list : lists) {
//			return list.stream().filter(comment -> comment.getCommentId() == commentId)
//				.findFirst().get();
//		}
//		return null;
//	}

	@Override
	public Comment getComment(int commentId) {
		return comments.values().stream()
			.flatMap(List::stream) // 댓글 리스트를 평면화하여 스트림 생성
			.filter(comment -> comment.getCommentId() == commentId)
			.findFirst()
			.orElse(null); // 댓글을 찾지 못한 경우 null 반환
	}
}
