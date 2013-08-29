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
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Single choice item view.
 * @author xiaoying
 *
 */
public class SingleChoiceItem extends LinearLayout implements Checkable {
	/** icon */
	private ImageView mImageView = null;
	/** text */
	private TextView mTextView = null;
	/** RadioButton */
	private RadioButton mRadioButton = null;

	public SingleChoiceItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public SingleChoiceItem(Context context) {
		this(context, null);
	}
	
	private void initView(Context context) {
		View.inflate(context, R.layout.item_dialog_singlechoice, this);
		mImageView = (ImageView) findViewById(R.id.iv_item_dialog_singlechoice_icon);
		mTextView = (TextView) findViewById(R.id.tv_item_dialog_singlechoice_text);
		mRadioButton = (RadioButton) findViewById(R.id.rbtn_item_dialog_singlechoice_radio);
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
		mRadioButton.setChecked(checked);
	}

	@Override
	public boolean isChecked() {
		return mRadioButton.isChecked();
	}

	@Override
	public void toggle() {
		mRadioButton.setChecked(!mRadioButton.isChecked());
	}

}
