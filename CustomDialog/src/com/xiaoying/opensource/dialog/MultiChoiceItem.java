/*
 * 文件名：CheckableItem.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-8-28
 * 修改人：xiaoying
 * 修改时间：2013-8-28
 * 版本：v1.0
 */
package com.xiaoying.opensource.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Single choice item view.
 * @author xiaoying
 *
 */
public class MultiChoiceItem extends LinearLayout implements Checkable {
	/** icon */
	private ImageView mImageView = null;
	/** text */
	private TextView mTextView = null;
	/** CheckBox */
	private CheckBox mCheckBox = null;

	public MultiChoiceItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public MultiChoiceItem(Context context) {
		this(context, null);
	}
	
	private void initView(Context context) {
		View.inflate(context, R.layout.item_dialog_multichoice, this);
		mImageView = (ImageView) findViewById(R.id.iv_item_dialog_multichoice_icon);
		mTextView = (TextView) findViewById(R.id.tv_item_dialog_multichoice_text);
		mCheckBox = (CheckBox) findViewById(R.id.cb_item_dialog_multichoice_radio);
	}
	
	/**
	 * Set item icon.
	 * @param resId
	 */
	public void setIcon(int resId) {
		mImageView.setImageResource(resId);
	}
	
	/**
	 * Set item icon.
	 * @param drawable
	 */
	public void setIcon(Drawable drawable) {
		mImageView.setImageDrawable(drawable);
	}
	
	/**
	 * Set Item icon's visibility.
	 * @param visibility
	 */
	public void setIconVisibility(int visibility) {
		mImageView.setVisibility(visibility);
	}
	
	/**
	 * Set item text.
	 * @param resId
	 */
	public void setText(int resId) {
		mTextView.setText(resId);
	}
	
	/**
	 * Set item text.
	 * @param text
	 */
	public void setText(CharSequence text) {
		mTextView.setText(text);
	}
	
	@Override
	public void setChecked(boolean checked) {
		mCheckBox.setChecked(checked);
	}

	@Override
	public boolean isChecked() {
		return mCheckBox.isChecked();
	}

	@Override
	public void toggle() {
		mCheckBox.setChecked(!mCheckBox.isChecked());
	}

}
