// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.zxing.camera;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

public final class PlanarYUVLuminanceSource extends LuminanceSource
{

    public PlanarYUVLuminanceSource(byte abyte0[], int i, int j, int k, int l, int i1, int j1)
    {
        super(i1, j1);
        if(k + i1 > i || l + j1 > j)
        {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        } else
        {
            yuvData = abyte0;
            dataWidth = i;
            dataHeight = j;
            left = k;
            top = l;
            return;
        }
    }

    public int getDataHeight()
    {
        return dataHeight;
    }

    public int getDataWidth()
    {
        return dataWidth;
    }

    public byte[] getMatrix()
    {
        int k;
        int l;
        k = getWidth();
        l = getHeight();
        if(k != dataWidth || l != dataHeight) goto _L2; else goto _L1
_L1:
        byte abyte0[] = yuvData;
_L4:
        return abyte0;
_L2:
        int i = k * l;
        byte abyte1[] = new byte[i];
        int j = top * dataWidth + left;
        if(k == dataWidth)
        {
            System.arraycopy(yuvData, j, abyte1, 0, i);
            return abyte1;
        }
        byte abyte2[] = yuvData;
        i = 0;
        do
        {
            abyte0 = abyte1;
            if(i >= l)
                continue;
            System.arraycopy(abyte2, j, abyte1, i * k, k);
            j += dataWidth;
            i++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public byte[] getRow(int i, byte abyte0[])
    {
        int j;
        byte abyte1[];
label0:
        {
            if(i < 0 || i >= getHeight())
                throw new IllegalArgumentException((new StringBuilder()).append("Requested row is outside the image: ").append(i).toString());
            j = getWidth();
            if(abyte0 != null)
            {
                abyte1 = abyte0;
                if(abyte0.length >= j)
                    break label0;
            }
            abyte1 = new byte[j];
        }
        int k = top;
        int l = dataWidth;
        int i1 = left;
        System.arraycopy(yuvData, (k + i) * l + i1, abyte1, 0, j);
        return abyte1;
    }

    public boolean isCropSupported()
    {
        return true;
    }

    public Bitmap renderCroppedGreyscaleBitmap()
    {
        int l = getWidth();
        int i1 = getHeight();
        int ai[] = new int[l * i1];
        byte abyte0[] = yuvData;
        int j = top * dataWidth + left;
        for(int i = 0; i < i1; i++)
        {
            for(int k = 0; k < l; k++)
                ai[i * l + k] = 0xff000000 | 0x10101 * (abyte0[j + k] & 0xff);

            j += dataWidth;
        }

        Bitmap bitmap = Bitmap.createBitmap(l, i1, android.graphics.Bitmap.Config.ARGB_8888);
        bitmap.setPixels(ai, 0, l, 0, 0, l, i1);
        return bitmap;
    }

    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte yuvData[];
}
