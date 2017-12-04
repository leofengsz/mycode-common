package com.mycom.itext.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFUtils {
  private static final Logger logger = LoggerFactory.getLogger(PDFUtils.class);
  
  enum BColor {
    BLACK(1),RED(2);
    private int code;
    private BColor(int code) {
      this.code = code;
    }
    public int getCode(){
      return code;
    }
  } 
  
  /**
   * 通过模板导入数据
   * 
   * @param template 模板
   * @param values 将要导入修改的数据
   * @throws Exception
   */
  public static byte[] writePdfField(PDFTemplate template, Map<String, Object> values) {
    FileInputStream fileInputStream = null;
    PdfReader pdfReader = null;
    PdfStamper pdfStamper = null;
    ByteArrayOutputStream byteArrayOutputStream = null;
    byte[] resultFile = null;
    try {
      if (template == null || template.getTemplateFile() == null) {
        logger.error("模版文件为空或配置错误");
        return resultFile;
      }
      fileInputStream = new FileInputStream(template.getTemplateFile());
      byte[] pdfBytes = new byte[fileInputStream.available()];
      fileInputStream.read(pdfBytes);
      pdfReader = new PdfReader(pdfBytes);
      byteArrayOutputStream = new ByteArrayOutputStream();
      pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
      for (int pageIndex = 1; pageIndex <= pdfReader.getNumberOfPages(); pageIndex++) {
        PdfContentByte pdfContentByte = pdfStamper.getOverContent(pageIndex);
        /** 开始写入文本 ----------- **/
        pdfContentByte.saveState();
        pdfContentByte.fill();
        pdfContentByte.restoreState();
        pdfContentByte.beginText();
        Set<Entry<String, Object>> entrySet = values.entrySet();
        for (Entry<String, Object> entry : entrySet) {
          List<TemplateLabel> templateLabels = template.getLabels().get(entry.getKey());
          if (templateLabels == null || templateLabels.size() == 0) {
            continue;
          }
          for (TemplateLabel templateLabel : templateLabels) {
            if (templateLabel.getPageIndex() != pageIndex) {
              continue;
            }
            // 设置字体颜色
            if(BColor.BLACK.getCode() == templateLabel.getBaseColor()){
              pdfContentByte.setColorFill(BaseColor.BLACK);
            }else if(BColor.RED.getCode() == templateLabel.getBaseColor()){
              pdfContentByte.setColorFill(BaseColor.RED);
            }
            // pdfContentByte.rectangle(templateLabel.getX(),templateLabel.getY(),templateLabel.getW(),templateLabel.getH());
            // 设置字体
            BaseFont baseFont = BaseFont.createFont(templateLabel.getFontName(), templateLabel.getEnCoding(),BaseFont.EMBEDDED);
            pdfContentByte.setFontAndSize(baseFont, templateLabel.getFontSize());
            pdfContentByte.setTextMatrix(templateLabel.getX(), templateLabel.getY() + 2/* 修正背景与文本的相对位置 */);
            pdfContentByte.showText(String.valueOf(entry.getValue()));
          }
        }
        pdfContentByte.endText();
        /** 写入结束 ----------- **/
      }
      pdfStamper.close();
      resultFile = byteArrayOutputStream.toByteArray();
    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fileInputStream != null) {
          fileInputStream.close();
        }
        if (pdfReader != null) {
          pdfReader.close();
        }
        if (byteArrayOutputStream != null) {
          byteArrayOutputStream.close();
        }
        pdfStamper = null;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return resultFile;

  }
  
  /**
   * 组装模板标签
   * 
   * @param x
   * @param y
   * @param w
   * @param h
   * @param text
   * @return
   */
  public static TemplateLabel getTemplateLabel(float x, float y, float w, float h, String text,
      int pageIndex) {
    TemplateLabel region = new TemplateLabel(text);
    region.setH(h);
    region.setW(w);
    region.setX(x);
    region.setY(y);
    region.setPageIndex(pageIndex);
    return region;
  }

}


