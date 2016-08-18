package org.dolphin.study.java.compress.gzip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by sunqi on 16/7/12.
 */
public class GzipUtilTest {

    private static Logger logger = LogManager.getLogger(GzipUtilTest.class);

    @Test public void gzipTest() {
        String source = "android,com.android.ContactsSocialWidget,com.android.Unzip,com.android.alarmclock,com.android.backupconfirm,com.android.bluetooth,com.android.browser,com.android.calculator2,com.android.calendar,com.android.certinstaller,com.android.contacts,com.android.defcontainer,com.android.email,com.android.exchange,com.android.gallery3d,com.android.htmlviewer,com.android.inputdevices,com.android.keychain,com.android.launcher,com.android.mms,com.android.musicfx,com.android.packageinstaller,com.android.phone,com.android.providers.applications,com.android.providers.calendar,com.android.providers.contacts,com.android.providers.downloads,com.android.providers.downloads.ui,com.android.providers.drm,com.android.providers.media,com.android.providers.settings,com.android.providers.telephony,com.android.providers.usagestats,com.android.providers.userdictionary,com.android.quicksearchbox,com.android.settings,com.android.sharedstoragebackup,com.android.smspush,com.android.soundrecorder,com.android.stk,com.android.systemui,com.android.vending,com.android.vpndialogs,com.android.wallpaper.livepicker,com.bodunxiyan.ibaozhang,com.example.fmdemo_2,com.example.fmsdk5,com.example.fraudmetrixsdk_2_0_0,com.google.android.apps.genie.geniewidget,com.google.android.apps.maps,com.google.android.feedback,com.google.android.googlequicksearchbox,com.google.android.gsf,com.google.android.gsf.login,com.google.android.location,com.google.android.street,com.google.android.syncadapters.bookmarks,com.google.android.syncadapters.calendar,com.google.android.syncadapters.contacts,com.meizu.MzAutoInstaller,com.meizu.account,com.meizu.cloud,com.meizu.filemanager,com.meizu.flyme.service.find,com.meizu.input,com.meizu.media.music,com.meizu.media.video,com.meizu.mstore,com.meizu.mzsimcontacts,com.meizu.mzsyncservice,com.meizu.notepaper,com.meizu.recent.app,com.meizu.theme,com.meizu.usetips,com.meizu.wapisetting,com.sina.weibo,com.svox.pico,com.tencent.mm,com.tencent.mobileqq,net.openvpn.openvpn";
        try {
            String zipText = GzipUtil.compress(source);
            logger.info("zipText:" + zipText);
            logger.info("zipTextLength:" + zipText.getBytes().length);
            String sourceText = GzipUtil.uncompress(zipText);
            logger.info("sourceText:" + sourceText);
            logger.info("sourceTextLength:" + sourceText.getBytes().length);
        } catch (IOException e) {
            logger.error("zip error", e);
        }
    }

    @Test public void gzipSourceTest() {
        String source = "test";
        try {
            logger.info("sourceText:" + source);

            logger.info("unzip Text:" + GzipUtil.uncompress(source));
        } catch (Exception e) {
            logger.error("unzip exception", e);
        }
    }
}
