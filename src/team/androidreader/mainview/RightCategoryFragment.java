package team.androidreader.mainview;

import java.util.List;

import team.androidreader.helpabout.AboutActivity;
import team.androidreader.helpabout.HelpActivity;
import team.androidreader.mainview.FileListHelper.FileCategory;
import team.androidreader.mainview.FileSortHelper.SortMethod;
import team.androidreader.scanner.Activity_Multichooser;
import team.androidreader.theme.ChangeThemeActivity;
import team.androidreader.utils.MyApplication;
import team.top.activity.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author ybw ht
 * 
 */
public class RightCategoryFragment extends Fragment {

	public static LinearLayout officeCategory;
	public static LinearLayout pictureCategory;
	public static LinearLayout musicCategory;
	public static LinearLayout videoCategory;
	public static LinearLayout zipCategory;
	public static LinearLayout apkCategory;
	private LinearLayout picture2pdf;
	private LinearLayout changeTheme;
	private LinearLayout help;
	private LinearLayout about;
	private List<FileInfo> pictureList;
	private List<FileInfo> musicList;
	private List<FileInfo> videoList;
	private TextView musicCount;
	private TextView videoCount;
	private TextView pictureCount;
	private List<FileInfo> officeList;
	private List<FileInfo> zipList;
	private List<FileInfo> apkList;
	private TextView officeCount;
	private TextView zipCount;
	private TextView apkCount;
	private View view;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_rightcategory, null);
		init();
		return view;
	}

	public void init() {
		officeCategory = (LinearLayout) view
				.findViewById(R.id.categoryOfficeBtn);
		pictureCategory = (LinearLayout) view
				.findViewById(R.id.categoryPictureBtn);
		musicCategory = (LinearLayout) view.findViewById(R.id.categoryMusicBtn);
		videoCategory = (LinearLayout) view.findViewById(R.id.categoryVideoBtn);
		zipCategory = (LinearLayout) view.findViewById(R.id.categoryZipBtn);
		apkCategory = (LinearLayout) view.findViewById(R.id.categoryApkBtn);
		picture2pdf = (LinearLayout) view.findViewById(R.id.functionPic2PdfBtn);
		changeTheme = (LinearLayout) view
				.findViewById(R.id.functionChangeThemeBtn);
		help = (LinearLayout) view.findViewById(R.id.moreHelpBtn);
		about = (LinearLayout) view.findViewById(R.id.moreAboutBtn);
		officeCategory.setOnClickListener(new FileCategorySelectListener());
		pictureCategory.setOnClickListener(new FileCategorySelectListener());
		musicCategory.setOnClickListener(new FileCategorySelectListener());
		videoCategory.setOnClickListener(new FileCategorySelectListener());
		zipCategory.setOnClickListener(new FileCategorySelectListener());
		apkCategory.setOnClickListener(new FileCategorySelectListener());
		picture2pdf.setOnClickListener(new FileCategorySelectListener());
		changeTheme.setOnClickListener(new FileCategorySelectListener());
		help.setOnClickListener(new FileCategorySelectListener());
		about.setOnClickListener(new FileCategorySelectListener());
		officeList = FileListHelper.GetSortedFileByCategory(getActivity(),
				FileListHelper.FileCategory.DOC, false, SortMethod.name);
		pictureList = FileListHelper.GetSortedFileByCategory(getActivity(),
				FileListHelper.FileCategory.PICTURE, false, SortMethod.name);
		musicList = FileListHelper.GetSortedFileByCategory(getActivity(),
				FileListHelper.FileCategory.MUSIC, false, SortMethod.name);
		videoList = FileListHelper.GetSortedFileByCategory(getActivity(),
				FileListHelper.FileCategory.VIDEO, false, SortMethod.name);
		zipList = FileListHelper.GetSortedFileByCategory(getActivity(),
				FileListHelper.FileCategory.ZIP, false, SortMethod.name);
		apkList = FileListHelper.GetSortedFileByCategory(getActivity(),
				FileListHelper.FileCategory.APK, false, SortMethod.name);
		musicCount = (TextView) view.findViewById(R.id.categoryMusicCount);
		videoCount = (TextView) view.findViewById(R.id.categoryVideoCount);
		pictureCount = (TextView) view.findViewById(R.id.categoryPictureCount);
		officeCount = (TextView) view.findViewById(R.id.categoryOfficeCount);
		zipCount = (TextView) view.findViewById(R.id.categoryZipCount);
		apkCount = (TextView) view.findViewById(R.id.categoryApkCount);
		musicCount.setText("(" + musicList.size() + ")");
		videoCount.setText("(" + videoList.size() + ")");
		pictureCount.setText("(" + pictureList.size() + ")");
		officeCount.setText("(" + musicList.size() + ")");
		zipCount.setText("(" + musicList.size() + ")");
		apkCount.setText("(" + musicList.size() + ")");

	}

	class FileCategorySelectListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			List<FileInfo> fileList = null;
			switch (id) {
			case R.id.categoryOfficeBtn:
				MyApplication.setChoosed(0);
				MainActivity.fileListController.handleDirectoryChange(
						officeList, "");
				MainActivity.fileListModel.setFileCategory(FileCategory.DOC);
				MainActivity.mSlidingMenu.showRightView();
				break;
			case R.id.categoryPictureBtn:
				MyApplication.setChoosed(1);
				MainActivity.fileListController.handleDirectoryChange(
						pictureList, "");
				MainActivity.fileListModel.setFileCategory(FileCategory.PICTURE);
				MainActivity.mSlidingMenu.showRightView();
				break;
			case R.id.categoryMusicBtn:
				MyApplication.setChoosed(2);
				MainActivity.fileListController.handleDirectoryChange(
						musicList, "");
				MainActivity.fileListModel.setFileCategory(FileCategory.MUSIC);
				MainActivity.mSlidingMenu.showRightView();
				break;
			case R.id.categoryVideoBtn:
				MyApplication.setChoosed(3);
				MainActivity.fileListController.handleDirectoryChange(
						videoList, "");
				MainActivity.fileListModel.setFileCategory(FileCategory.VIDEO);
				MainActivity.mSlidingMenu.showRightView();
				break;
			case R.id.categoryApkBtn:
				MyApplication.setChoosed(4);
				MainActivity.fileListController.handleDirectoryChange(apkList,
						"");
				MainActivity.fileListModel.setFileCategory(FileCategory.APK);
				MainActivity.mSlidingMenu.showRightView();
				break;
			case R.id.categoryZipBtn:
				MyApplication.setChoosed(5);
				MainActivity.fileListController.handleDirectoryChange(zipList,
						"");
				MainActivity.fileListModel.setFileCategory(FileCategory.ZIP);
				MainActivity.mSlidingMenu.showRightView();
				break;
			case R.id.functionPic2PdfBtn:
				Intent intent1 = new Intent();
				intent1.setClass(getActivity(), Activity_Multichooser.class);
				startActivity(intent1);
				break;
			case R.id.functionChangeThemeBtn:
				Intent intent2 = new Intent();
				intent2.setClass(getActivity(), ChangeThemeActivity.class);
				startActivity(intent2);
				break;
			case R.id.moreHelpBtn:
				Intent intent3 = new Intent();
				intent3.setClass(getActivity(), HelpActivity.class);
				startActivity(intent3);
				break;
			case R.id.moreAboutBtn:
				Intent intent4 = new Intent();
				intent4.setClass(getActivity(), AboutActivity.class);
				startActivity(intent4);
				break;
			default:
				break;
			}
		}
	}

}
