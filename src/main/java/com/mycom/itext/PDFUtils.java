package com.mycom.itext;

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
import com.mycom.itext.replacer.TemplateLabel;

public class PDFUtils {
	private static final Logger logger = LoggerFactory.getLogger(PDFUtils.class);

	private int fontSize;
	private ByteArrayOutputStream byteArrayOutputStream;
	private PdfReader pdfReader;
	private PdfStamper pdfStamper;
	private PdfContentByte pdfContentByte;
	private Font font;

	/**
	 * 通过模板导入数据
	 * 
	 * @param templateFile
	 *            模板源文件
	 * @param labelMap
	 *            模板标签
	 * @param values
	 *            将要修改的数据
	 * @throws Exception
	 */
	public byte[] importData(File templateFile, Map<String, TemplateLabel> labelMap, Map values) throws Exception {
		FileInputStream in = null;
		byte[] resultData = {};
		try {
			in = new FileInputStream(templateFile);
			byte[] pdfBytes = new byte[in.available()];
			in.read(pdfBytes);
			pdfReader = new PdfReader(pdfBytes);
			byteArrayOutputStream = new ByteArrayOutputStream();
			pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
			pdfContentByte = pdfStamper.getOverContent(1);
			setFont(10);
			
			updatePdf(labelMap,values);
			pdfStamper.close();
			resultData = byteArrayOutputStream.toByteArray();
		} finally {
			in.close();
			close();
		}
		
		
		return resultData;
		
	}
	
	/** Import,Fill, **/
	private void updatePdf(Map<String, TemplateLabel> labelMap, Map values){
		/** 开始写入文本 -----------**/
		pdfContentByte.saveState();
		pdfContentByte.fill();
		pdfContentByte.restoreState();
		pdfContentByte.beginText(); 
		Set<Entry> entrySet = values.entrySet();
		for(Entry entry : entrySet){
			TemplateLabel templateLabel = labelMap.get(entry.getKey());
			pdfContentByte.setColorFill(BaseColor.RED);
			pdfContentByte.rectangle(templateLabel.getX(),templateLabel.getY(),templateLabel.getW(),templateLabel.getH());
			//设置字体
			pdfContentByte.setFontAndSize(font.getBaseFont(), this.fontSize);  
			pdfContentByte.setTextMatrix(templateLabel.getX(),templateLabel.getY()+2/*修正背景与文本的相对位置*/);  
			pdfContentByte.showText((String)entry.getValue());  
		}
		
		pdfContentByte.endText();
		/** 写入结束 -----------**/
	}
	
	private void close() throws DocumentException, IOException{
		if(pdfStamper != null){
			pdfStamper.close();
		}
		if(pdfReader != null){
			pdfReader.close();
		}
		if(byteArrayOutputStream != null){
			byteArrayOutputStream.close();
		}
		
		byteArrayOutputStream=null;
	}

	/**
	 * 设置字体大小
	 * 
	 * @param fontSize
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void setFont(int fontSize) throws DocumentException, IOException {
		if (fontSize != this.fontSize) {
			this.fontSize = fontSize;
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
			font = new Font(bf, this.fontSize, Font.BOLD);
		}
	}

	public static void main(String[] args) throws Exception {
		File templateFile = new File("d://111.pdf");

		Map<String, TemplateLabel> labelMap = new HashMap<String, TemplateLabel>();
		labelMap.put("label_01", getTemplateLabel(20, 100, 10, 10, "label_01"));
		labelMap.put("label_02", getTemplateLabel(20, 200, 5, 5, "label_02"));
		labelMap.put("label_03", getTemplateLabel(20, 300, 50, 50, "label_03"));

		Map updateValues = new HashMap();
		updateValues.put("label_01", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		updateValues.put("label_02", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		updateValues.put("label_03", "cccccccccccccccccccccccccccccccccccccccccccc");
		
		PDFUtils pdfutils = new PDFUtils();
		byte[] resultDatas = pdfutils.importData(templateFile,labelMap,updateValues);
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
	public static TemplateLabel getTemplateLabel(float x, float y, float w, float h, String text) {
		TemplateLabel region = new TemplateLabel(text);
		region.setH(h);
		region.setW(w);
		region.setX(x);
		region.setY(y);
		return region;
	}

}
