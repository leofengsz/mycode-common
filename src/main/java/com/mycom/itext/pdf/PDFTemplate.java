package com.mycom.itext.pdf;

import java.io.File;
import java.util.List;
import java.util.Map;

public class PDFTemplate {
  
  private File templateFile;
  private Map<String,List<TemplateLabel>> labels;
  
  public File getTemplateFile() {
    return templateFile;
  }
  public void setTemplateFile(File templateFile) {
    this.templateFile = templateFile;
  }
  public Map<String,List<TemplateLabel>> getLabels() {
    return labels;
  }
  public void setLabels(Map<String,List<TemplateLabel>> labels) {
    this.labels = labels;
  }

}
