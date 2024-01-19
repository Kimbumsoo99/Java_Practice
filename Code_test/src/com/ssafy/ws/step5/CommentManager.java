package com.ssafy.ws.step5;

import java.util.Arrays;

public class CommentManager {
	private final int MAX_COMMENT_SIZE = 1000;
	private Comment[] comments = new Comment[MAX_COMMENT_SIZE];
	private int commentSize;
	
	public void addComment(Comment comment) {
		comments[commentSize++] = comment;
	}
	public Comment getComment(int commentId) {
		for (int i = 0; i < commentSize; i++) {
			if(comments[i].getCommentId() == commentId) {
				return comments[i];
			}
		}
		return null;
	}
	
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
	
	public void removeArticle(int articleId) {
		Comment[] changeComments = new Comment[MAX_COMMENT_SIZE];
		int idx = 0;
		for (int i = 0; i < commentSize; i++) {
			if(articleId != comments[i].getArticleld()) {
				changeComments[idx++] = comments[i];
			}
		}
		comments = changeComments;
	}
	
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
}
