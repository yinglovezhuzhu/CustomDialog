package com.xiaoying.opensource.test;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.xiaoying.opensource.dialog.CustomDialog;
import com.xiaoying.opensource.dialog.CustomProgressDialog;
import com.xiaoying.opensource.dialog.MenuDialog;
import com.xiaoying.opensource.dialog.R;

public class MainActivity extends Activity implements OnClickListener{
	
	private String [] mItems = null;
	
	private int [] mIcons = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mItems = getResources().getStringArray(R.array.items);
		mIcons = new int[mItems.length];
		for (int i = 0; i < mIcons.length; i++) {
			mIcons[i] = R.drawable.ic_launcher;
		}
		
		findViewById(R.id.btn_menu_dialog).setOnClickListener(this);
		findViewById(R.id.btn_msg_dialog).setOnClickListener(this);
		findViewById(R.id.btn_msg_dialog_close).setOnClickListener(this);
		findViewById(R.id.btn_input_dialog).setOnClickListener(this);
		findViewById(R.id.btn_items_dialog).setOnClickListener(this);
		findViewById(R.id.btn_single_choice_dialog).setOnClickListener(this);
		findViewById(R.id.btn_multi_choice_dialog).setOnClickListener(this);
		findViewById(R.id.btn_progress_dialog_spinner).setOnClickListener(this);
		findViewById(R.id.btn_progress_dialog_horizontal).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected void showShortToast(String pMsg) {
		Toast.makeText(this, pMsg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_menu_dialog:
			new MenuDialog(MainActivity.this)
			.setItems(mItems, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showShortToast("Item clicked +++>> " + which);
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showShortToast("Cancel MenuDialog-_-");
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_msg_dialog:
			new CustomDialog(this)
//			.setIcon(R.drawable.ic_launcher)
//			.setTitleText(R.string.app_name)
//			.setTitleBackgroundResource(R.drawable.bg_title_bar)
			.setMessage(R.string.message)
			.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_msg_dialog_close:
			new CustomDialog(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitleText(R.string.app_name)
			.setCloseButton(R.drawable.btn_dialog_close_selector)
			.setMessage(R.string.message)
			.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_input_dialog:
			new CustomDialog(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitleText(R.string.app_name)
			.setMessage(R.string.message)
			.setInput("请输入")
			.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_items_dialog:
			new CustomDialog(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitleText(R.string.app_name)
			.setItems(mItems, mIcons, Gravity.LEFT, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showShortToast("Item Clicked +++>>> " + which);
					dialog.cancel();
				}
			})
			.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_single_choice_dialog:
			new CustomDialog(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitleText(R.string.app_name)
			.setSingleChoiceItems(mItems, mIcons, 0, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showShortToast("Item Clicked +++>>> " + which);
//					dialog.cancel();
				}
			})
			.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_multi_choice_dialog:
			new CustomDialog(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitleText(R.string.app_name)
			.setMultiChoiceItems(mItems, mIcons, null, new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					showShortToast("Item Clicked +++>>> " + which + " == " + isChecked);
				}
			})
			.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			})
			.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).show();
			break;
		case R.id.btn_progress_dialog_spinner:
			CustomProgressDialog cpd = CustomProgressDialog.show(this, null, getString(R.string.loading));
			cpd.setCanceledOnTouchOutside(false);
			cpd.setCancelable(true);
			break;
		case R.id.btn_progress_dialog_horizontal:
			CustomProgressDialog cpd2 = new CustomProgressDialog(this);
			cpd2.setMessage(getString(R.string.loading));
			cpd2.setCanceledOnTouchOutside(false);
			cpd2.setCancelable(true);
			cpd2.setProgressStyle(CustomProgressDialog.STYLE_HORIZONTAL);
			cpd2.show();
			cpd2.setProgress(50);
			cpd2.setMessage("aaaa");
			break;
		default:
			break;
		}
	}

}
