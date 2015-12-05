package org.wlf.filedownloader_demo2;

import android.app.Application;
import android.os.Environment;

import org.wlf.filedownloader.FileDownloadConfiguration;
import org.wlf.filedownloader.FileDownloadConfiguration.Builder;
import org.wlf.filedownloader.FileDownloadManager;

import java.io.File;

/**
 * Demo2 Test Application
 * <br/>
 * 测试2应用的Application
 *
 * @author wlf(Andy)
 * @datetime 2015-12-05 10:12 GMT+8
 * @email 411086563@qq.com
 */
public class FileDownloadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // init FileDownloadManager
        initFileDownloadManager();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        // release FileDownloadManager
        releaseFileDownloadManager();
    }

    // init FileDownloadManager
    private void initFileDownloadManager() {
        // 1.create FileDownloadConfiguration.Builder
        Builder builder = new FileDownloadConfiguration.Builder(this);
        // 2.config FileDownloadConfiguration.Builder
        builder.configFileDownloadDir(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator +
                "FileDownloader2");// config the download path
        builder.configDownloadTaskSize(3);// allow 3 download task at the same time
        FileDownloadConfiguration configuration = builder.build();// build FileDownloadConfiguration with the builder
        // 3.init FileDownloadManager with the configuration
        FileDownloadManager.getInstance(this).init(configuration);
    }

    // release FileDownloadManager
    private void releaseFileDownloadManager() {
        FileDownloadManager.getInstance(this).release();
    }
}
