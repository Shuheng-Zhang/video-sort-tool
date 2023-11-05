package top.shuzz.video.sort.service.core.config;

import cn.hutool.system.SystemUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用服务运行配置
 */
@Data
@ConfigurationProperties(prefix = "app-config")
@Configuration
public class AppRuntimeConfig {

    /**
     * 缩略图临时存储目录
     */
    private String thumbnailStorageDir = SystemUtil.USER_DIR + "/video-sort/thumbnail";
}
