/*
 * Copyright (C) 2014  Yuninfo Guangzhou
 *
 *		yinglovezhuzhu@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensource.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 *
 * @author yinglovezhuzhu@gmail.com
 *
 */
public class SlidingDialog extends Dialog {
	
	private LinearLayout mLlContent;
	private Button mBtnPositive;
	private Button mBtnNegative;
	private View mDivider;
	
	private DialogInterface.OnClickListener mPositiveListener;
	private DialogInterface.OnClickListener mNegativeListener;

	public SlidingDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		initView(context);
	}

	public SlidingDialog(Context context, int theme) {
		super(context, theme);
		initView(context);
	}

	public SlidingDialog(Context context) {
		super(context);
		initView(context);
	}

	@Override
	public void setContentView(int layoutResID) {
		View.inflate(getContext(), layoutResID, mLlContent);
	}
	
	@Override
	public void setContentView(View view) {
		mLlContent.addView(view);
	}
	
	@Override
	public void setContentView(View view, android.view.ViewGroup.LayoutParams params) {
		mLlContent.addView(view, params);
	}
	
	/**
	 * 设置PositiveButton
	 * @param resid
	 * @param l
	 * @return
	 */
	public SlidingDialog setPositiveButton(int resid, DialogInterface.OnClickListener l) {
		mPositiveListener = l;
		mBtnPositive.setVisibility(View.VISIBLE);
		mDivider.setVisibility(View.VISIBLE);
		mBtnPositive.setText(resid);
		return this;
	}
	
	/**
	 * 设置PositiveButton
	 * @param text
	 * @param l
	 * @return
	 */
	public SlidingDialog setPositiveButton(CharSequence text, DialogInterface.OnClickListener l) {
		mPositiveListener = l;
		mBtnPositive.setVisibility(View.VISIBLE);
		mDivider.setVisibility(View.VISIBLE);
		mBtnPositive.setText(text);
		return this;
	}
	
	/**
	 * 设置NagativeButton
	 * @param resid
	 * @param l
	 * @return
	 */
	public SlidingDialog setNagativeButton(int resid, DialogInterface.OnClickListener l) {
		mNegativeListener = l;
		mBtnNegative.setVisibility(View.VISIBLE);
		mDivider.setVisibility(View.VISIBLE);
		mBtnNegative.setText(resid);
		return this;
	}
	
	/**
	 * 设置NagativeButton
	 * @param text
	 * @param l
	 * @return
	 */
	public SlidingDialog setNagativeButton(CharSequence text, DialogInterface.OnClickListener l) {
		mNegativeListener = l;
		mBtnNegative.setVisibility(View.VISIBLE);
		mDivider.setVisibility(View.VISIBLE);
		mBtnNegative.setText(text);
		return this;
	}
	
	/**
	 * 初始化视图
	 * @param context
	 */
	private void initView(Context context) {
		
		super.setContentView(R.layout.layout_sliding_dilaog);
		
		getWindow().setGravity(Gravity.BOTTOM);
		getWindow().setWindowAnimations(R.style.SlidingDialogAnimation);
		LayoutParams lp = getWindow().getAttributes();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.WRAP_CONTENT;
		getWindow().setAttributes(lp);
		
		mLlContent = (LinearLayout) findViewById(R.id.ll_slidingdialog_content);
		mBtnPositive = (Button) findViewById(R.id.btn_slidingdialog_positive);
		mBtnNegative = (Button) findViewById(R.id.btn_slidingdialog_negative);
		mDivider = findViewById(R.id.view_slidingdialog_divider);
		
		mBtnPositive.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mBtnPositive.getVisibility() == View.VISIBLE && null != mPositiveListener) {
					mPositiveListener.onClick(SlidingDialog.this, Dialog.BUTTON_POSITIVE);
				}
				SlidingDialog.this.cancel();
			}
		});
		
		mBtnNegative.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mBtnNegative.getVisibility() == View.VISIBLE && null != mNegativeListener) {
					mNegativeListener.onClick(SlidingDialog.this, Dialog.BUTTON_NEGATIVE);
				}
				SlidingDialog.this.cancel();
			}
		});
	}
}
