package com.laptrinhjavaweb.model;

public class CommentModel extends AbstractModel<CommentModel> {

	private long commentId;
	private long userId;
	private long newId;
	private String content;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getNewId() {
		return newId;
	}

	public void setNewId(long newId) {
		this.newId = newId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
