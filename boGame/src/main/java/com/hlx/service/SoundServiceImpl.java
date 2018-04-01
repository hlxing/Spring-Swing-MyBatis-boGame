package com.hlx.service;

import com.hlx.App;
import com.hlx.config.SoundEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * The service be used to play kinds of game sounds
 * @author hlx
 * @version 1.0 2018-3-28
 */
@Service
public class SoundServiceImpl implements SoundService{

    private static final Logger logger = Logger.getLogger(SoundServiceImpl.class);

    private static final String PREFIX = "sound/";

    private static final String SUFFIX = ".wav";

    private Map<String, Clip> soundMap = new HashMap<>();

    @Override
    public void play(SoundEnum sound) {
        try {
            InputStream is = App.class.getResourceAsStream(PREFIX+sound.getValue()+SUFFIX);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            soundMap.put(sound.getValue(), clip);
        } catch(Exception ex) {
            logger.info(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void stop(SoundEnum sound) {
        Clip clip = soundMap.get(sound.getValue());
        if(clip!=null&&clip.isRunning()){
            clip.stop();
        }
    }
}
