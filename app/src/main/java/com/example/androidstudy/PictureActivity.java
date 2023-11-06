package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.androidstudy.utils.GlideEngine;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.tbruyelle.rxpermissions3.RxPermissions;


import java.util.ArrayList;

import io.reactivex.rxjava3.disposables.Disposable;


public class PictureActivity extends AppCompatActivity {

    RxPermissions rxPermissions = new RxPermissions(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        findViewById(R.id.openPicture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean isGranted = rxPermissions.isGranted(Manifest.permission.CAMERA);
                if(!isGranted){
                    return;
                }

                applyPermission(rxPermissions, Manifest.permission.CAMERA);


                PictureSelector.create(PictureActivity.this)
                        .openGallery(SelectMimeType.ofImage())
                        .setImageSpanCount(3)
                        .isDisplayCamera(true)
                        .isPreviewImage(true)
                        .setImageEngine(GlideEngine.createGlideEngine())
                        .forResult(new OnResultCallbackListener<LocalMedia>() {
                            @Override
                            public void onResult(ArrayList<LocalMedia> result) {

                            }

                            @Override
                            public void onCancel() {

                            }
                        });
            }
        });
    }

    public Disposable applyPermission(RxPermissions rxPermissions, String... permissions) {
        Disposable disposable = rxPermissions.requestEach(permissions)
                .subscribe(permission -> {

                });
        return disposable;
    }
}