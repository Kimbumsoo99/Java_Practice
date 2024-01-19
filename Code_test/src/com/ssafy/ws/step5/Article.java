package com.ssafy.ws.step5;

import java.util.Date;

public class Article {
	private int articleld;
	private String title;
	private String content;
	private int userSeq;
	private int viewCnt;
	private Date regDate;
	public Article() {
		super();
	}
	public Article(int articleld, String title, String content, int userSeq) {
		super();
		this.articleld = articleld;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viewCnt = 0;
		this.regDate = new Date();
	}
	
	
	public int getArticleld() {
		return articleld;
	}
	public void setArticleld(int articleld) {
		this.articleld = articleld;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [articleld=");
		builder.append(articleld);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", userSeq=");
		builder.append(userSeq);
		builder.append(", viewCnt=");
		builder.append(viewCnt);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
}
