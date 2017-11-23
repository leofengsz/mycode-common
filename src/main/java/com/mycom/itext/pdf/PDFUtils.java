package com.mycom.itext.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFUtils {
	private static final Logger logger = LoggerFactory.getLogger(PDFUtils.class);
	private static final String FONTNAME = "STSong-Light";
	private static final String ENCODING = "UniGB-UCS2-H";
	private static final int FONT_SIZE = 8;
	
	/**
	 * 通过模板导入数据
	 * 
	 * @param template
	 *            模板
	 * @param values
	 *            将要导入修改的数据
	 * @throws Exception
	 */
	public static byte[] importData(PDFTemplate template, Map<String,String> values) {
		FileInputStream fileInputStream = null;
		PdfReader pdfReader = null;
		PdfStamper pdfStamper = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		byte[] resultFile = null;
		try {
			fileInputStream = new FileInputStream(template.getTemplateFile());
			byte[] pdfBytes = new byte[fileInputStream.available()];
			fileInputStream.read(pdfBytes);
			pdfReader = new PdfReader(pdfBytes);
			byteArrayOutputStream = new ByteArrayOutputStream();
			pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
			for (int i = 0; i < template.getUpdPages().length; i++) {
			  updatePdf(pdfStamper,template.getLabelMap(),template.getUpdPages()[i],values);
            }
			pdfStamper.close();
			resultFile = byteArrayOutputStream.toByteArray();
		}catch(DocumentException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}finally {
		  try {
		    if(fileInputStream != null){
		      fileInputStream.close();
		    }
		    if(pdfReader != null){
		      pdfReader.close();
		    }
		    if(byteArrayOutputStream != null){
		      byteArrayOutputStream.close();
		    }
		    pdfStamper = null;
          } catch (IOException e) {
            e.printStackTrace();
          }
		}
		return resultFile;
		
	}
	
	private static void updatePdf(PdfStamper pdfStamper,Map<String, TemplateLabel> labelMap, int pageIndex, Map<String,String> values) throws DocumentException,IOException{
	  PdfContentByte pdfContentByte = pdfStamper.getOverContent(1);
	  BaseFont bf = BaseFont.createFont(FONTNAME, ENCODING, BaseFont.EMBEDDED);
	  Font font = new Font(bf, FONT_SIZE, Font.BOLD);
	  /** 开始写入文本 -----------**/
		pdfContentByte.saveState();
		pdfContentByte.fill();
		pdfContentByte.restoreState();
		pdfContentByte.beginText(); 
		Set<Entry<String,String>> entrySet = values.entrySet();
		for(Entry<String,String> entry : entrySet){
			TemplateLabel templateLabel = labelMap.get(entry.getKey());
			if(templateLabel.getPageIndex() != pageIndex){
			  continue;
			}
			pdfContentByte.setColorFill(BaseColor.RED);
			//pdfContentByte.rectangle(templateLabel.getX(),templateLabel.getY(),templateLabel.getW(),templateLabel.getH());
			//设置字体
			pdfContentByte.setFontAndSize(font.getBaseFont(), FONT_SIZE);  
			pdfContentByte.setTextMatrix(templateLabel.getX(),templateLabel.getY()+2/*修正背景与文本的相对位置*/);  
			pdfContentByte.showText(entry.getValue());  
		}
		
		pdfContentByte.endText();
		/** 写入结束 -----------**/
	}

	public static void main(String[] args) throws Exception {
		File templateFile = new File("f://111.pdf");

		Map<String, TemplateLabel> labelMap = new HashMap<String, TemplateLabel>();
		labelMap.put("label_01", getTemplateLabel(20, 100, 10, 10, "label_01",1));
		labelMap.put("label_02", getTemplateLabel(20, 200, 5, 5, "label_02",2));
		labelMap.put("label_03", getTemplateLabel(20, 300, 50, 50, "label_03",2));

		Map<String,String> updateValues = new HashMap<String,String>();
		updateValues.put("label_01", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		updateValues.put("label_02", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		updateValues.put("label_03", "cccccccccccccccccccccccccccccccccccccccccccc");
		PDFTemplate template = new PDFTemplate();
		template.setLabelMap(labelMap);
		template.setTemplateFile(templateFile);
		int[] updPages = {1,2};
		template.setUpdPages(updPages);
		
		byte[] resultDatas = PDFUtils.importData(template,updateValues);
		FileOutputStream fileOutputStream = new FileOutputStream("d://333.pdf");
		fileOutputStream.write(resultDatas);
		fileOutputStream.flush();

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
	public static TemplateLabel getTemplateLabel(float x, float y, float w, float h, String text, int pageIndex) {
		TemplateLabel region = new TemplateLabel(text);
		region.setH(h);
		region.setW(w);
		region.setX(x);
		region.setY(y);
		region.setPageIndex(pageIndex);
		return region;
	}

}
