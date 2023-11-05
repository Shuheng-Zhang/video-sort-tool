package top.shuzz.video.sort.service.core.launcher;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.shuzz.video.sort.service.core.config.AppRuntimeConfig;

import java.io.File;


@Order(999)
@Component
public class AppStartupLauncher implements ApplicationRunner {

    final private static Log LOGGER = LogFactory.get();

    @Resource
    private AppRuntimeConfig appRuntimeConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final var thumbnailStorageDir = appRuntimeConfig.getThumbnailStorageDir();

        LOGGER.info("[STARTING_UP] Found THUMBNAIL_STORAGE_DIR={}", thumbnailStorageDir);

        LOGGER.info("[STARTING_UP] Checking THUMBNAIL_STORAGE_DIR...");

        final var dirExisted =  FileUtil.exist(thumbnailStorageDir);
        if (!dirExisted) {
            LOGGER.warn("[STARTING_UP] THUMBNAIL_STORAGE_DIR NOT EXISTED, Generating...");
            FileUtil.mkdir(thumbnailStorageDir);
        }

        final var isDir = FileUtil.isDirectory(thumbnailStorageDir);
        if (!isDir) {
            LOGGER.error("[STARTING_UP] THUMBNAIL_STORAGE_DIR={} is NOT A DIRECTORY", thumbnailStorageDir);
            LOGGER.error("[STARTING_UP] Service Startup Failed");
            System.exit(0);
        }

        final var dirEmpty = FileUtil.isDirEmpty(new File(thumbnailStorageDir));
        if (!dirEmpty) {
            LOGGER.info("[STARTING_UP] Cleaning up THUMBNAIL_STORAGE_DIR...");
            FileUtil.clean(thumbnailStorageDir);
        }

        LOGGER.info("[STARTING_UP] Initialization Completed");
    }
}
