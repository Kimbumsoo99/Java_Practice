package com.ssafy.ws.step5;

import java.util.Arrays;

public class ArticleManager {
	private final int MAX_ARTICLE_SIZE = 100;
	private Article[] articles = new Article[MAX_ARTICLE_SIZE];
	private int articleSize;
	
	public Article[] getArticleList() {
		return Arrays.copyOf(articles, articleSize);
	}
	
	public void updateArticle(Article article) {
		for (int i = 0; i < articleSize; i++) {
			if(article.getArticleld() == articles[i].getArticleld()) {
				articles[i] = article;
				break;
			}
		}
	}
	
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
	

	
	public void addArticle(Article article) {
		articles[articleSize++] = article;
	}
	
	public void removeArticle(int articleId) {
		CommentManager cm = new CommentManager();
		cm.removeArticle(articleId);
		int idx = -1;
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
	
	public ImageArticle[] getImageArticleList() {
		ImageArticle[] returnArticles = new ImageArticle[articleSize];
		int idx = 0;
		for (int i = 0; i < articleSize; i++) {
			if(articles[i] instanceof ImageArticle) {
				returnArticles[idx++] = (ImageArticle) articles[i];
			}
		}
		return Arrays.copyOf(returnArticles, idx);
	}
	
	public double getImageSizeAvg() {
		ImageArticle[] imageArticles = getImageArticleList();
		double avg = 0.0;
		for (int i = 0; i < imageArticles.length; i++) {
			avg += (imageArticles[i].getHeight() * imageArticles[i].getWidth());
		}
		return avg / imageArticles.length;
	}
	
	public Article getArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if(articles[i].getArticleld() == articleId) {
				return articles[i];
			}
		}
		return null;
	}
	
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
			// 誘몄셿�꽦
			UserManager um = new UserManager();
			for (int i = 0; i < articleSize; i++) {
				if(um.getUser(keyword) != null && articles[i].getUserSeq() == um.getUser(keyword).getUserSeq()) {
					returnArticles[idx++] = articles[i];
				}
			}
			return Arrays.copyOf(returnArticles, idx);
		}
	}
}
