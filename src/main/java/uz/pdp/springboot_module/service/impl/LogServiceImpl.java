package uz.pdp.springboot_module.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.service.LogService;

@Service
public class LogServiceImpl implements LogService {
    private static final Logger log = LoggerFactory.getLogger(LogServiceImpl.class);

    @Override
    public void logInfo(String logPath, String message) {
        try {
            MDC.put("logPath", logPath);
            log.info(message);
        } finally {
            MDC.remove("logPath");
        }
    }
}
