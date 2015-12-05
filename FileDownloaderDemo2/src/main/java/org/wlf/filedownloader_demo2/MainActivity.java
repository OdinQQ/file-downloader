package org.wlf.filedownloader_demo2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import org.wlf.filedownloader.FileDownloadManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo2 Test MainActivity
 * <br/>
 * 测试2主界面
 *
 * @author wlf(Andy)
 * @datetime 2015-12-05 10:10 GMT+8
 * @email 411086563@qq.com
 */
public class MainActivity extends Activity {

    // adapter
    private DownloadFileListAdapter mDownloadFileListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main__activity_main);

        // model data
        List<CustomVideoInfo> customVideoInfos = getModelData();

        // ListView
        ListView lvDownloadFileList = (ListView) findViewById(R.id.lvDownloadFileList);
        mDownloadFileListAdapter = new DownloadFileListAdapter(this, customVideoInfos);
        lvDownloadFileList.setAdapter(mDownloadFileListAdapter);

        // registerDownloadStatusListener 
        FileDownloadManager.getInstance(this).registerDownloadStatusListener(mDownloadFileListAdapter);
    }

    // get model data 
    private List<CustomVideoInfo> getModelData() {

        List<CustomVideoInfo> customVideoInfos = new ArrayList<CustomVideoInfo>();

        String url1 = "http://182.254.149.157/ftp/image/shop/product/儿童英语升华&￥.apk";
        CustomVideoInfo customVideoInfo1 = new CustomVideoInfo(1, url1, "2015-10-11 13:20:12", "2015-10-11 14:10:50");
        customVideoInfos.add(customVideoInfo1);

        String url2 = "http://sqdd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";
        CustomVideoInfo customVideoInfo2 = new CustomVideoInfo(2, url2, "2015-10-11 13:20:12", "2015-10-11 14:10:50");
        customVideoInfos.add(customVideoInfo2);

        String url3 = "http://down.sandai.net/thunder7/Thunder_dl_7.9.41.5020.exe";
        CustomVideoInfo customVideoInfo3 = new CustomVideoInfo(1, url3, "2015-10-11 13:20:12", "2015-10-11 14:10:50");
        customVideoInfos.add(customVideoInfo3);

        return customVideoInfos;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // pause all downloads
        FileDownloadManager.getInstance(this).pauseAll();

        // unregisterDownloadStatusListener
        FileDownloadManager.getInstance(this).unregisterDownloadStatusListener(mDownloadFileListAdapter);
    }
}
