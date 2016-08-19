package com.example.baby;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class PersonalMessage extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_message_yuli);
		initView();
	}
	private static final int PHOTO_REQUEST_CAREMA=1;
	private static final int PHOTO_REQUEST_GALLERY=2;
	private static final int PHOTO_REQUEST_CUT=3;
	private static final String PHOTO_FILE_NAME="temp_photo.jpg";
	private File tempFile;
	private CircleImageView headIcon;
	

	private void initView() {
		headIcon=(CircleImageView) findViewById(R.id.userimage);
		headIcon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changeHeadIcon();
			}

			
		});
		changeTheme();
		File file=new File(PersonalMessage.this.getFilesDir(),"test.jpg");
		if(file.exists()){
			headIcon.setImageURI(Uri.fromFile(file));
		}
	}
	
	private void changeTheme() {
		Calendar c=Calendar.getInstance();
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		if(c.get(Calendar.HOUR_OF_DAY)<18&&c.get(Calendar.HOUR_OF_DAY)>=6){
			headIcon.setImageResource(R.drawable.ic_launcher);
		}else{
			headIcon.setImageResource(R.drawable.test);
		}
		
	}

	private void changeHeadIcon() {
		final CharSequence[] items={"相册","拍照"};
		AlertDialog.Builder dig=new AlertDialog.Builder(PersonalMessage.this);
		dig.setTitle("选择图片");
		dig.setItems(items, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int item) {
				// TODO Auto-generated method stub
				if(item==0){
					Intent intent=new Intent(Intent.ACTION_PICK);
					intent.setType("image/*");
					startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
				}else{
					Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
						tempFile=new File(Environment.getDownloadCacheDirectory(),PHOTO_FILE_NAME);
						Uri uri=Uri.fromFile(tempFile);
						intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
						startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
					}else{Toast.makeText(PersonalMessage.this, "未找到存储卡,无法存储照片", Toast.LENGTH_LONG).show();
					}
				}
			}
		}).create(); 
		dig.show();
	}
			
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == PHOTO_REQUEST_GALLERY) {
			if (data != null) {
				Uri uri = data.getData();
				Log.e("图片路径？？", data.getData() +"" );
				crop(uri);
			}

		} else if (requestCode == PHOTO_REQUEST_CAREMA) {
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				crop(Uri.fromFile(tempFile));
			} else {
				Toast.makeText(PersonalMessage.this, "未找到存储卡，无法存储照片！",
						Toast.LENGTH_SHORT).show();
			}

		} else if (requestCode == PHOTO_REQUEST_CUT) {
			if (data != null) {
				final Bitmap bitmap = data.getParcelableExtra("data");
				headIcon.setImageBitmap(bitmap);
				// 保存图片到internal storage
				FileOutputStream outputStream;
				try {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
					out.flush();
					// out.close();
					// final byte[] buffer = out.toByteArray();
					// outputStream.write(buffer);
					outputStream = PersonalMessage.this.openFileOutput("test.jpg",
							Context.MODE_PRIVATE);
					out.writeTo(outputStream);
					out.close();
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				if (tempFile != null && tempFile.exists())
					tempFile.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}		
	private void crop(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri," image/*");
		intent.putExtra("crop", true);
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 250);
		intent.putExtra("outputY", 250);
		intent.putExtra("outputFormat", "JPEG");
		intent.putExtra("noFaceDetection", true);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}
}
