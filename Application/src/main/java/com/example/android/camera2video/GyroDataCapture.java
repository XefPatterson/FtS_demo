package com.example.android.camera2video;

import java.nio.ByteBuffer;

/**
 * Created by Félix on 2016-04-18.
 */
public class GyroDataCapture {
    private long timestamp;
    private float xValue;
    private float yValue;
    private float zValue;

    public GyroDataCapture(float x, float y, float z, long t){
        xValue = x;
        yValue = y;
        zValue = z;
        timestamp = t;
    }

    public void updateAllValues(float x, float y, float z, long t){
        xValue = x;
        yValue = y;
        zValue = z;
        timestamp = t;
    }

    public float getX(){return xValue;}
    public float getY(){return yValue;}
    public float getZ(){return zValue;}
    public float getTimestamp(){return timestamp;}

    //TODO test this
    public byte[] toByte(){
        int totalSize =(3*Float.SIZE + Long.SIZE) / Byte.SIZE;
        byte[] arr = new byte[totalSize];
        ByteBuffer buffer = ByteBuffer.allocate(totalSize);
        buffer.putFloat(xValue);
        buffer.putFloat(yValue);
        buffer.putFloat(zValue);
        buffer.putLong(timestamp);
        return buffer.array();
    }



}
