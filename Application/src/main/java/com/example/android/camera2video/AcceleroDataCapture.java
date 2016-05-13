package com.example.android.camera2video;

import java.nio.ByteBuffer;
import android.util.Log;

/**
 * Created by Félix on 2016-05-12.
 */
public class AcceleroDataCapture {

    private long timestamp;
    private float xValue;
    private float yValue;
    private float zValue;

    public AcceleroDataCapture(float x, float y, float z, long t){
        xValue = x;
        yValue = y;
        zValue = z;
        timestamp = t;
    }

    //bytes should be of size (3*Float.SIZE + Long.SIZE) / Byte.SIZE);
    public AcceleroDataCapture(byte[] bytes){
        if (bytes.length != (3*Float.SIZE + Long.SIZE) / Byte.SIZE){
            Log.e("ERROR","ERROR! byte array size should be "+(3*Float.SIZE + Long.SIZE)/Byte.SIZE
                    +"but is "+bytes.length);
        }
        else{
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            xValue = buffer.getFloat();
            yValue = buffer.getFloat();
            zValue = buffer.getFloat();
            timestamp = buffer.getLong();
        }
    }

    public float getX(){return xValue;}
    public float getY(){return yValue;}
    public float getZ(){return zValue;}
    public float getTimestamp(){return timestamp;}

    /**
     * Convert value to byte array
     * @return byte array of values
     */
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

