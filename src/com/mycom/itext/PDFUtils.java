package com.mycom.itext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycom.itext.replacer.TemplateLabel;

public class PDFUtils {


  /**
   * 根据模板修改PDF文件内容
   * 
   * @param templateFile 模板源文件
   * @param templateLabelList 模板标签列表
   * @param updateValues 将要修改的参数列表
   * @throws Exception
   */
  public static File modify(File templateFile,List<TemplateLabel> templateLabelList,Map updateValues) throws Exception {
    return null;
  }
  
  public static void main(String[] args) {
    File templateFile = new File("d://111.pdf");
    List<TemplateLabel> templateLabelList = new ArrayList<TemplateLabel>();
    TemplateLabel tl1 = new TemplateLabel("");
    templateLabelList.add(tl1);
    
    
  }

}
