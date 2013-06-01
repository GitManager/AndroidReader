package team.androidreader.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;

public class ScreenCapturer {
	
	@SuppressWarnings("deprecation")
	public static boolean TakeScreenShot(Activity activity,String saveDir,String saveName){
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		
		Bitmap bitmap = view.getDrawingCache();
		//Point size = new Point();
		//activity.getWindowManager().getDefaultDisplay().getSize(size);
		int w = activity.getWindowManager().getDefaultDisplay().getWidth();
		int h = activity.getWindowManager().getDefaultDisplay().getHeight();
		
		//int titlebarH
		bitmap =  Bitmap.createBitmap(bitmap, 0, 0, w, h);
		return WriteBitmapToSdcard(bitmap,saveDir,saveName);
	}
	
	private static boolean WriteBitmapToSdcard(Bitmap bitmap,String saveDir,String saveName){
		FileOutputStream fileOutputStream = null;
		try {
			String filenameString = saveDir + "/" + saveName + ".jpg";
			fileOutputStream = new FileOutputStream(filenameString);
			bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
		} catch (Exception e) {
			if(fileOutputStream != null)
			{
				try {
					fileOutputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
					return false;
				}
				return false;
			}
		}
		return true;
	}

}