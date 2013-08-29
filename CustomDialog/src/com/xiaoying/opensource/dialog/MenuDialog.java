/*
 * 文件名：MenuDialog.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-7-30
 * 修改人：xiaoying
 * 修改时间：2013-7-30
 * 版本：v1.0
 */

package com.xiaoying.opensource.dialog;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Menu dialog
 * @author xiaoying
 *
 */
public class MenuDialog extends Dialog {
	
	private ListView mLvItems;
	
	private Button mBtnNegative;
	
	private DialogInterface.OnClickListener mClickListener = null;
	
	private DialogInterface.OnClickListener mItemClickListener = null;

	public MenuDialog(Context context) {
		this(context, R.style.MenuDialogTheme);

	}
	
	public MenuDialog(Context context, int theme) {
		super(context, theme);
		initView();
	}
	
	private void initView() {
		
		setContentView(R.layout.layout_menu_dilaog);
		
		getWindow().setGravity(Gravity.BOTTOM);
		getWindow().setWindowAnimations(R.style.MenuDialogAnimation);
		LayoutParams lp = getWindow().getAttributes();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.WRAP_CONTENT;
		getWindow().setAttributes(lp);
		
		mLvItems = (ListView) findViewById(R.id.lv_menudialog_list);
		mBtnNegative = (Button) findViewById(R.id.btn_menudialog_negative);
		mBtnNegative.setVisibility(View.GONE);
		mBtnNegative.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v.getVisibility() == View.VISIBLE && mClickListener != null) {
					mClickListener.onClick(MenuDialog.this, DialogInterface.BUTTON_NEGATIVE);
				}
//				MenuDialog.this.cancel();
			}
		});
		mLvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if(mItemClickListener != null) {
					mItemClickListener.onClick(MenuDialog.this, position);
				}
//				MenuDialog.this.cancel();
			}
		});
	}
	
	/**
	 * Set negative button.
	 * @param resid
	 * @param cl
	 * @return
	 */
	public MenuDialog setNegativeButton(int resid, OnClickListener cl) {
		mClickListener = cl;
		mBtnNegative.setVisibility(View.VISIBLE);
		mBtnNegative.setText(resid);
		return this;
	}
	
	/**
	 * Set negative button.
	 * @param resid
	 * @param cl
	 * @return
	 */
	public MenuDialog setNegativeButton(String text, OnClickListener cl) {
		mClickListener = cl;
		mBtnNegative.setVisibility(View.VISIBLE);
		mBtnNegative.setText(text);
		return this;
	}
	
	/**
	 * Set menu items.
	 * @param items
	 * @param listener
	 * @return
	 */
	public MenuDialog setItems(String [] items, DialogInterface.OnClickListener listener) {
		mItemClickListener = listener;
		mLvItems.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.item_menu_dialog, R.id.tv_item_menudialog, items));
		return this;
	}
	
	/**
	 * Set menu items.
	 * @param items
	 * @param listener
	 * @return
	 */
	public MenuDialog setItems(List<String> items, DialogInterface.OnClickListener listener) {
		mItemClickListener = listener;
		mLvItems.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.item_menu_dialog, R.id.tv_item_menudialog, items));
		return this;
	}
}
