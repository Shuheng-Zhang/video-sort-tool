package top.shuzz.video.sort.service.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.shuzz.video.sort.service.core.config.AppRuntimeConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResourceServiceTest {

    @Resource
    private AppRuntimeConfig appRuntimeConfig;

    @Resource
    private ResourceService resourceService;

    @Test
    void scanResourceDir() {

        // resourceService.scanResourceDir("D:/Workspace/PROJECT_DEVELOPMENT_DATA/video-sort-tool");
        resourceService.scanResourceDir("D:/迅雷下载/式.7z.001");
    }
}