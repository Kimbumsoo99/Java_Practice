package com.ssafy.ws.step5;

import java.util.Date;

public class Comment {
	private int commentId;
	private int articleld;
	private int userSeq;
	private String content;
	private Date regDate;
	
	
	public Comment() {
	}


	public Comment(int commentId, int articleld, int userSeq, String content) {
		super();
		this.commentId = commentId;
		this.articleld = articleld;
		this.userSeq = userSeq;
		this.content = content;
		this.regDate = new Date();
	}


	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public int getArticleld() {
		return articleld;
	}


	public void setArticleld(int articleld) {
		this.articleld = articleld;
	}


	public int getUserSeq() {
		return userSeq;
	}


	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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
		builder.append("Comment [commentId=");
		builder.append(commentId);
		builder.append(", articleld=");
		builder.append(articleld);
		builder.append(", userSeq=");
		builder.append(userSeq);
		builder.append(", content=");
		builder.append(content);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	
}
