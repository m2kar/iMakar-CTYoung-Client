// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common;


// Referenced classes of package com.google.zxing.common:
//            BitArray

public final class BitMatrix
{

    public BitMatrix(int i)
    {
        this(i, i);
    }

    public BitMatrix(int i, int j)
    {
        if(i < 1 || j < 1)
        {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        } else
        {
            width = i;
            height = j;
            rowSize = i + 31 >> 5;
            bits = new int[rowSize * j];
            return;
        }
    }

    public void clear()
    {
        int j = bits.length;
        for(int i = 0; i < j; i++)
            bits[i] = 0;

    }

    public boolean equals(Object obj)
    {
        if(obj instanceof BitMatrix) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if(width == ((BitMatrix) (obj = (BitMatrix)obj)).width && height == ((BitMatrix) (obj)).height && rowSize == ((BitMatrix) (obj)).rowSize && bits.length == ((BitMatrix) (obj)).bits.length)
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if(i >= bits.length)
                        break label1;
                    if(bits[i] != ((BitMatrix) (obj)).bits[i])
                        break label0;
                    i++;
                }
            } while(true);
        }
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public void flip(int i, int j)
    {
        j = rowSize * j + (i >> 5);
        int ai[] = bits;
        ai[j] = ai[j] ^ 1 << (i & 0x1f);
    }

    public boolean get(int i, int j)
    {
        int k = rowSize;
        return (bits[k * j + (i >> 5)] >>> (i & 0x1f) & 1) != 0;
    }

    public int getHeight()
    {
        return height;
    }

    public BitArray getRow(int i, BitArray bitarray)
    {
        BitArray bitarray1;
label0:
        {
            if(bitarray != null)
            {
                bitarray1 = bitarray;
                if(bitarray.getSize() >= width)
                    break label0;
            }
            bitarray1 = new BitArray(width);
        }
        int k = rowSize;
        for(int j = 0; j < rowSize; j++)
            bitarray1.setBulk(j << 5, bits[i * k + j]);

        return bitarray1;
    }

    public int[] getTopLeftOnBit()
    {
        int i;
        for(i = 0; i < bits.length && bits[i] == 0; i++);
        if(i == bits.length)
            return null;
        int k = i / rowSize;
        int l = rowSize;
        int i1 = bits[i];
        int j;
        for(j = 0; i1 << 31 - j == 0; j++);
        return (new int[] {
            (i % l << 5) + j, k
        });
    }

    public int getWidth()
    {
        return width;
    }

    public int hashCode()
    {
        int j = ((width * 31 + width) * 31 + height) * 31 + rowSize;
        for(int i = 0; i < bits.length; i++)
            j = j * 31 + bits[i];

        return j;
    }

    public void set(int i, int j)
    {
        j = rowSize * j + (i >> 5);
        int ai[] = bits;
        ai[j] = ai[j] | 1 << (i & 0x1f);
    }

    public void setRegion(int i, int j, int k, int l)
    {
        if(j < 0 || i < 0)
            throw new IllegalArgumentException("Left and top must be nonnegative");
        if(l < 1 || k < 1)
            throw new IllegalArgumentException("Height and width must be at least 1");
        int i1 = i + k;
        l = j + l;
        if(l > height || i1 > width)
            throw new IllegalArgumentException("The region must fit inside the matrix");
        for(; j < l; j++)
        {
            int j1 = rowSize;
            for(k = i; k < i1; k++)
            {
                int ai[] = bits;
                int k1 = (k >> 5) + j * j1;
                ai[k1] = ai[k1] | 1 << (k & 0x1f);
            }

        }

    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(height * (width + 1));
        for(int i = 0; i < height; i++)
        {
            int j = 0;
            while(j < width) 
            {
                String s;
                if(get(j, i))
                    s = "X ";
                else
                    s = "  ";
                stringbuffer.append(s);
                j++;
            }
            stringbuffer.append('\n');
        }

        return stringbuffer.toString();
    }

    public final int bits[];
    public final int height;
    public final int rowSize;
    public final int width;
}
