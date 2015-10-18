package com.example.adil.taskmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;

/**
 * Created by Adil on 11-Oct-15.
 */
public class viewPictureActivity extends Activity {
    private Button pictureButton;
    private File imageFile;
    private AlertDialog imageDialog;
    private static int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_view);
        setUpViews();
    }

    private void setUpViews() {
        pictureButton = (Button) findViewById(R.id.take_picture);
        pictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             /*imageFile = new File(Environment.getExternalStoragePublicDirectory( )
              ,"test.jpg");*/
             imageFile = new File(Environment.getExternalStorageDirectory(),"JaguarTaskManager/Test" + i++ + ".jpg");
                Uri tempUri = Uri.fromFile(imageFile);

              intent.putExtra(MediaStore.EXTRA_OUTPUT,tempUri);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,0.2);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            switch(resultCode){
                case Activity.RESULT_OK:
                    if(imageFile.exists()){
                        imageDialog = new AlertDialog.Builder(this)
                                .setTitle(R.string.image_success)
                                .setMessage(R.string.image_success_msg)
                                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })


                                .create();
                        imageDialog.show();
                    }
                    else{
                        imageDialog = new AlertDialog.Builder(this)
                                .setTitle(R.string.image_failure)
                                .setMessage(R.string.image_failure_msg)
                                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })


                                .create();
                        imageDialog.show();
                    }
                break;
                case Activity.RESULT_CANCELED:
                default:
                    break;
            }
        }
    }
}
