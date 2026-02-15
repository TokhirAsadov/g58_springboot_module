package uz.pdp.springboot_module.utils;

public interface Constants {
    String VERSION = "/v1";
    String DEVICE_MOBILE = "/mobile";
    String DEVICE_BROWSER = "/browser";
    String BASE_URL = VERSION+DEVICE_BROWSER+"/api";
    String BASE_MOBILE_URL = VERSION+DEVICE_MOBILE+"/api";
}
