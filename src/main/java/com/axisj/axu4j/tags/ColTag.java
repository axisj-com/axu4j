package com.axisj.axu4j.tags;

import org.apache.commons.lang.StringUtils;

import com.axisj.axu4j.config.ConfigReader;

public class ColTag extends AXUTagSupport {
	
	public ColTag() throws Exception {
		super();
		this.tagBody  = ConfigReader.getConfig().getColWrap();
		this.isDoBody = true;
	}
	
	// =======================================================

	private String id;
	private String size;
	private String css;
	private String style;

	// =======================================================
	
	public String getId() {
		return StringUtils.defaultIfEmpty(id, String.format("col-%d", tagIndex));
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
}
