/*
 * Copyright (C) 2014  The Android Open Source Project.
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
package com.opensource.dialog.demo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.opensource.dialog.CustomDialog;
import com.opensource.dialog.CustomProgressDialog;
import com.opensource.dialog.MenuDialog;

/**
 * Use：
 * 
 * @author yinglovezhuzhu@gmail.com
 */
public class MainActivity extends Activity implements View.OnClickListener {
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
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showShortToast("Cancel MenuDialog-_-");
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_msg_dialog:
                new CustomDialog(MainActivity.this)
//			.setIcon(R.drawable.ic_launcher)
//			.setTitleText(R.string.app_name)
//			.setTitleBackgroundResource(R.drawable.bg_title_bar)
                        .setMessage(R.string.message)
                        .setPositiveButton(com.opensource.dialog.R.string.dialog_ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_msg_dialog_close:
                new CustomDialog(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitleText(R.string.app_name)
                        .setCloseButton(com.opensource.dialog.R.drawable.selector_custom_dialog_close_btn)
                        .setMessage(R.string.message)
                        .setPositiveButton(com.opensource.dialog.R.string.dialog_ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_input_dialog:
                new CustomDialog(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitleText(R.string.app_name)
                        .setMessage(R.string.message)
                        .setInput("请输入")
                        .setPositiveButton(com.opensource.dialog.R.string.dialog_ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_items_dialog:
                new CustomDialog(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitleText(R.string.app_name)
                        .setItems(mItems, mIcons, Gravity.LEFT, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showShortToast("Item Clicked +++>>> " + which);
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton(com.opensource.dialog.R.string.dialog_ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_single_choice_dialog:
                new CustomDialog(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitleText(R.string.app_name)
                        .setSingleChoiceItems(mItems, mIcons, 0, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showShortToast("Item Clicked +++>>> " + which);
//					dialog.cancel();
                            }
                        })
                        .setPositiveButton(com.opensource.dialog.R.string.dialog_ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_multi_choice_dialog:
                new CustomDialog(MainActivity.this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitleText(R.string.app_name)
                        .setMultiChoiceItems(mItems, mIcons, null, new DialogInterface.OnMultiChoiceClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                showShortToast("Item Clicked +++>>> " + which + " == " + isChecked);
                            }
                        })
                        .setPositiveButton(com.opensource.dialog.R.string.dialog_ok, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(com.opensource.dialog.R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                break;
            case R.id.btn_progress_dialog_spinner:
                CustomProgressDialog cpd = CustomProgressDialog.show(MainActivity.this, null, getString(R.string.loading));
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
