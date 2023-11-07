package top.shuzz.video.sort.service.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ResourceService {

    final List<String> VIDEO_FILE_EXT_LIST = List.of("mp4", "3gp", "mpeg", "mov", "ts", "mkv", "rmvb");

    final private static Log LOGGER = LogFactory.get();

    /**
     * 扫描资源目录
     * @param rootDir 资源根目录路径
     */
    public List<File> scanResourceDir(final String rootDir) {
        Assert.isTrue(
                FileUtil.exist(rootDir) && FileUtil.isDirectory(rootDir),
                "Path [" + rootDir + "] is NOT EXISTED NOR A DIRECTORY"
        );

        final var resultList = new ArrayList<File>();
        resultList.add(new File(rootDir));

        final var dirs = this.loopDirs(new File(rootDir));
        resultList.addAll(dirs);

        LOGGER.info("================================ Resource Directory Scan Result ================================");
        resultList.forEach(dir -> LOGGER.info("Found Dir: {}", dir.getName()));
        LOGGER.info("================================ Resource Directory Scan Result ================================\n");

        return resultList;
    }

    private List<File> loopDirs(final File rootDir) {
        Assert.isTrue(
                FileUtil.exist(rootDir) && FileUtil.isDirectory(rootDir),
                "Path [" + rootDir + "] is NOT EXISTED NOR A DIRECTORY"
        );

        final var dirList = new ArrayList<File>();

        final var subDirs = rootDir.listFiles(File::isDirectory);

        if (subDirs != null) {
            dirList.addAll(Arrays.asList(subDirs));

            for (File subDir : subDirs) {
                final var subs = loopDirs(subDir);
                dirList.addAll(subs);
            }
        }

        return dirList;
    }
}
