package com.hlx.view.common;

/**
 * A abstract frame that be used to build a frame
 * and have refresh function quickly
 * @author hlx
 * @version 1.0 2018-3-18
 */
public abstract class RenewableFrame extends GeneralFrame implements Renewable{

    /**
     * @param isNoTitle if true, remove the title of frame
     */
    public RenewableFrame(boolean isNoTitle) {
        super(isNoTitle);
    }
}
