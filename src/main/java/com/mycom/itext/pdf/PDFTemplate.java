package com.mycom.itext.pdf;

import java.io.File;
import java.util.Map;

public class PDFTemplate {
  
  private File templateFile;
  private int[] updPages;
  private Map<String,TemplateLabel> labelMap;
  
  public File getTemplateFile() {
    return templateFile;
  }
  public void setTemplateFile(File templateFile) {
    this.templateFile = templateFile;
  }
  public int[] getUpdPages() {
    return updPages;
  }
  public void setUpdPages(int[] updPages) {
    this.updPages = updPages;
  }
  public Map<String,TemplateLabel> getLabelMap() {
    return labelMap;
  }
  public void setLabelMap(Map<String,TemplateLabel> labelMap) {
    this.labelMap = labelMap;
  }

}
