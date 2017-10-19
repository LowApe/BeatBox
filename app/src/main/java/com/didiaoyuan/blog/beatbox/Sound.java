package com.didiaoyuan.blog.beatbox;

import android.util.Log;

/**
 * Created by Mr.Qu on 2017/10/19.
 */

public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components=assetPath.split("/");/*分离文件名*/
//        Log.e("TAG1",components+"");
        String filename=components[components.length-1];/*获取数组第一个*/
//        Log.e("TAG",filename+"");
//        replace 删除.waw
        mName=filename.replace(".waw","");/*去掉文件的后缀名*/

    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
