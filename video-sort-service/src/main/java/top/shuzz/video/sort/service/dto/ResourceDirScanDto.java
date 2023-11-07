package top.shuzz.video.sort.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceDirScanDto implements Serializable {

    @NotNull(message = "[dir] Cannot be Empty")
    @NotBlank(message = "[dir] Cannot be Empty")
    private String dir;
}
