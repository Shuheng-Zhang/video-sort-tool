package top.shuzz.video.sort.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>基于 OpenCV(JavaCV 实现) 的视频分类服务</p>
 *
 * <hr />
 *
 * <ol>
 *     <li>扫描指定视频根目录</li>
 *     <li>计算视频文件MD5值</li>
 *     <li>通过MD5的值进行初步分组</li>
 * </ol>
 *
 * <hr />
 *
 * <ol>
 *     <li>对视频进行截帧, 需要对不同时长的视频进行不同数量的帧截取</li>
 *     <li>指定基准视频及其基准帧图像</li>
 *     <li>对其他视频进行截取帧图像并进行与基准视频帧图像进行图像比对</li>
 *     <li>通过多组比对计算平均相似度, 判定基于基准视频的其他视频是否为同组视频</li>
 * </ol>
 */
@SpringBootApplication
public class VideoSortServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoSortServiceApplication.class, args);
    }

}
