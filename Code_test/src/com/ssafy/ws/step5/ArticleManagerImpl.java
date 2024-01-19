package com.ssafy.ws.step5;

import java.util.Arrays;

public class ArticleManagerImpl implements IArticleManager{
	private final int MAX_ARTICLE_SIZE = 100;
	private final int MAX_COMMENT_SIZE = 100;
	private Article[] articles = new Article[MAX_ARTICLE_SIZE];
	private Comment[] comments = new Comment[MAX_COMMENT_SIZE];
	private int articleSize;
	private int commentSize;
	private static IArticleManager instance = new ArticleManagerImpl();
	private ArticleManagerImpl() {}
	public static IArticleManager getInstance() {
		return instance;
	}
	
	@Override
	public Article[] getArticleList() {
		return Arrays.copyOf(articles, articleSize);
	}
	
	@Override
	public Article getArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if(articles[i].getArticleld() == articleId) {
				return articles[i];
			}
		}
		return null;
	}
	
	@Override
	public void addArticle(Article article) {
		articles[articleSize++] = article;
	}
	
	@Override
	public void removeArticle(int articleId) {
		Comment[] changeComments = new Comment[MAX_COMMENT_SIZE];
		int idx = 0;
		for (int i = 0; i < commentSize; i++) {
			if(articleId != comments[i].getArticleld()) {
				changeComments[idx++] = comments[i];
			}
		}
		comments = changeComments;
		idx = -1;
		for (int i = 0; i < articleSize; i++) {
			if(getArticle(articleId).hashCode() == articles[i].hashCode()) {
				articles[i] = null;
				idx = i;
				break;
			}
		}
		
		for (int i = idx; i < articleSize; i++) {
			articles[i] = articles[i+1];
		}
		articleSize--;
	}
	
	@Override
	public void updateArticle(Article article) {
		for (int i = 0; i < articleSize; i++) {
			if(article.getArticleld() == articles[i].getArticleld()) {
				articles[i] = article;
				break;
			}
		}
	}
	
	@Override
	public Article[] getTextArticleList() {
		Article[] returnArticles = new Article[articleSize];
		int idx = 0;
		for (int i = 0; i < articleSize; i++) {
			if(!(articles[i] instanceof ImageArticle)) {
				returnArticles[idx++] = articles[i];
			}
		}
		return Arrays.copyOf(returnArticles, idx);
	}
	
	@Override
	public ImageArticle[] getImageArticleList() {
		ImageArticle[] returnArticles = new ImageArticle[articleSize];
		int idx = 0;
		for (int i = 0; i < articleSize; i++) {
			if(articles[i] instanceof ImageArticle img) {
				returnArticles[idx++] = img;
			}
		}
		return Arrays.copyOf(returnArticles, idx);
	}
	
	@Override
	public double getImageSizeAvg() {
		ImageArticle[] imageArticles = getImageArticleList();
		double avg = 0.0;
		for (int i = 0; i < imageArticles.length; i++) {
			avg += (imageArticles[i].getHeight() * imageArticles[i].getWidth());
		}
		return avg / imageArticles.length;
	}
	
	@Override
	public Article[] search(int option, String keyword) {
		Article[] returnArticles = new Article[articleSize];
		int idx = 0;
		switch (option) {
		case 1:
			for (int i = 0; i < articleSize; i++) {
				if(articles[i].getTitle().contains(keyword)) {
					returnArticles[idx++] = articles[i];
				}
			}
			return Arrays.copyOf(returnArticles, idx);
		case 2:
			for (int i = 0; i < articleSize; i++) {
				if(articles[i].getContent().contains(keyword)) {
					returnArticles[idx++] = articles[i];
				}
			}
			return Arrays.copyOf(returnArticles, idx);
		default:
			// 미완성
			IUserManager um = UserManagerImpl.getInstance();
			for (int i = 0; i < articleSize; i++) {
				if(um.getUser(keyword) != null && articles[i].getUserSeq() == um.getUser(keyword).getUserSeq()) {
					returnArticles[idx++] = articles[i];
				}
			}
			return Arrays.copyOf(returnArticles, idx);
		}
	}

	@Override
	public void addComment(Comment comment) {
		comments[commentSize++] = comment;
	}

	@Override
	public void removeComment(int commentId) {
		int idx = -1;
		for (int i = 0; i < commentSize; i++) {
			if(commentId == comments[i].getCommentId()) {
				comments[i] = null;
				idx = i;
				break;
			}
		}
		for (int i = idx; i < commentSize; i++) {
			comments[i] = comments[i+1];
		}
		commentSize--;
	}

	@Override
	public Comment[] getCommentList(int articleId) {
		Comment[] returnComments = new Comment[commentSize];
		int idx = 0;
		for (int i = 0; i < commentSize; i++) {
			if(comments[i].getArticleld() == articleId) {
				returnComments[idx++] = comments[i];
			}
		}
		return Arrays.copyOf(returnComments, idx);
	}
	
	@Override
	public Comment getComment(int commentId) {
		for (int i = 0; i < commentSize; i++) {
			if(comments[i].getCommentId() == commentId) {
				return comments[i];
			}
		}
		return null;
	}
	
}
