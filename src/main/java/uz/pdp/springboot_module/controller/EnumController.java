package uz.pdp.springboot_module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.entity.DayOfWeek;
import uz.pdp.springboot_module.mapper.EnumMapper;
import uz.pdp.springboot_module.payload.HaftaKuni;

@RestController
@RequestMapping("/api/enum")
public class EnumController {

    private final EnumMapper mapper;

    public EnumController(EnumMapper mapper) {
        this.mapper = mapper;
    }


    @GetMapping("/toDayOfWeek")
    public DayOfWeek toDayOfWeek() {
        return mapper.toDayOfWeek(HaftaKuni.JUMA);
    }

    @GetMapping("/toHaftaKuni")
    public HaftaKuni toHaftaKuni() {
        return mapper.toHaftaKuni(DayOfWeek.WEDNESDAY);
    }

}
