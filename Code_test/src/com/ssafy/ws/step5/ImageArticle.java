package com.ssafy.ws.step5;

public class ImageArticle extends Article{
	private String imageName;
	private int width;
	private int height;
	public ImageArticle() {}
	public ImageArticle(int articleld, String title, String content, int userSeq, String imageName, int width, int height) {
		super(articleld, title, content, userSeq);
		this.imageName = imageName;
		this.width = width;
		this.height = height;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImageArticle [imageName=");
		builder.append(imageName);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
