package com.hlx;

import com.hlx.service.RecognitionServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * A test about recognize the game result
 * @author hlx
 * @version 1.0 2018-3-16
 */
public class RecognizeTest {

    private static final Logger logger = Logger.getLogger(RecognizeTest.class);

    @Test
    public void mainTest() {
        RecognitionServiceImpl recognitionService = new RecognitionServiceImpl();
        String result = "144441";
        logger.info(recognitionService.recognize(result));
        result = "444444";
        logger.info(recognitionService.recognize(result));
        result = "122222";
        logger.info(recognitionService.recognize(result));
        result = "124444";
        logger.info(recognitionService.recognize(result));
        result = "123456";
        logger.info(recognitionService.recognize(result));
        result = "123444";
        logger.info(recognitionService.recognize(result));
        result = "132222";
        logger.info(recognitionService.recognize(result));
        result = "123544";
        logger.info(recognitionService.recognize(result));
        result = "133456";
        logger.info(recognitionService.recognize(result));
    }
}
