package team.top.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import android.R.integer;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PngToPdf {

	/**
	 * 
	 * @param imageUrllist
	 * @param mOutputPdfFileName
	 * @return
	 * @throws FileNotFoundException
	 * @throws BadElementException
	 * @throws MalformedURLException
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static File convertPngToPdf(List<String> imageUrllist,
			String mOutputPdfFileName) throws FileNotFoundException, BadElementException, MalformedURLException, DocumentException, IOException {
		Document doc = new Document(PageSize.A4, 20, 20, 20, 20);
		FileOutputStream fileOutputStream = new FileOutputStream(mOutputPdfFileName);
		PdfWriter.getInstance(doc, fileOutputStream);
		float height,width;
		Image image;
		int percent;
		doc.open();
		for (String string : imageUrllist) {
			doc.newPage();
			image = Image.getInstance(string);
			height = image.getHeight();
			width = image.getWidth();
			percent = getPercent2(height, width);
			image.setAlignment(Image.MIDDLE);
			image.scalePercent(percent);// 表示是原来图像的比例;
			doc.add(image);
			System.out.println("convert " + string + "successful");
		}
		doc.close();
		File mOutputPdfFile = new File(mOutputPdfFileName);
		if (!mOutputPdfFile.exists()) {
			mOutputPdfFile.deleteOnExit();
			return null;
		}
		return mOutputPdfFile;
	}

	/**
	 * 第一种解决方案 在不改变图片形状的同时，判断，如果h>w，则按h压缩，否则在w>h或w=h的情况下，按宽度压缩
	 * 
	 * @param h
	 * @param w
	 * @return
	 */
	private static int getPercent(float h, float w) {
		int p = 0;
		float p2 = 0.0f;
		if (h > w) {
			p2 = 297 / h * 100;
		} else {
			p2 = 210 / w * 100;
		}
		p = Math.round(p2);
		return p;
	}

	/**
	 * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的
	 * 
	 * @param args
	 */
	private static int getPercent2(float h, float w) {
		int p = 0;
		float p2 = 0.0f;
		p2 = 530 / w * 100;
		p = Math.round(p2);
		return p;
	}

}