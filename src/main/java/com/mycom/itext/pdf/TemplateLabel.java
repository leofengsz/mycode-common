package com.mycom.itext.pdf;

/**
 *  模板标签
 */
public class TemplateLabel {

	private String labelName;
	private Float x;
	private Float y;
	private Float w;
	private Float h;
	
	private int pageIndex=1;
	private String fontName="STSong-Light";
	private String enCoding="UniGB-UCS2-H";
	private int fontSize=8;
	// 字体颜色：1=黑色，2=红色
	private int baseColor=1;
	
	
	
	public TemplateLabel(String labelName){
		this.labelName = labelName;
	}
	
	/**
	 * 替换区域的别名
	 * @return
	 */
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public Float getX() {
		return x;
	}
	public void setX(Float x) {
		this.x = x;
	}
	public Float getY() {
		return y;
	}
	public void setY(Float y) {
		this.y = y;
	}
	public Float getW() {
		return w;
	}
	public void setW(Float w) {
		this.w = w;
	}
	public Float getH() {
		return h;
	}
	public void setH(Float h) {
		this.h = h;
	}

  public int getPageIndex() {
    return pageIndex;
  }

  public void setPageIndex(int pageIndex) {
    this.pageIndex = pageIndex;
  }

  public String getFontName() {
    return fontName;
  }

  public void setFontName(String fontName) {
    this.fontName = fontName;
  }

  public String getEnCoding() {
    return enCoding;
  }

  public void setEnCoding(String enCoding) {
    this.enCoding = enCoding;
  }

  public int getFontSize() {
    return fontSize;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
  }

  public int getBaseColor() {
    return baseColor;
  }

  public void setBaseColor(int baseColor) {
    this.baseColor = baseColor;
  }
}