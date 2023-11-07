package top.shuzz.video.sort.service.controller;

import cn.hutool.system.SystemUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shuzz.video.sort.service.core.response.ResponseResult;
import top.shuzz.video.sort.service.dto.ResourceDirScanDto;
import top.shuzz.video.sort.service.service.ResourceService;

import java.io.File;

@RestController
@RequestMapping(value = "/api/resource")
@RequiredArgsConstructor
public class ResourceController {

    final private ResourceService resourceService;

    @PostMapping(value = "scan-dirs")
    public ResponseResult scanResourceDir(@RequestBody @Valid final ResourceDirScanDto scanDto) {

        final var dirs = resourceService.scanResourceDir(scanDto.getDir())
                .stream()
                .map(File::getAbsolutePath)
                .toList();

        if (SystemUtil.getOsInfo().isWindows()) {
            return ResponseResult.success(dirs.stream().map(f -> f.replaceAll("\\\\", "/")).toList());
        } else {
             return ResponseResult.success(dirs);
        }
    }


}
