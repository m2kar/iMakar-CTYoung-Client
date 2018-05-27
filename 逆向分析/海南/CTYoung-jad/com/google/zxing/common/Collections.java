// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common;

import java.util.Vector;

// Referenced classes of package com.google.zxing.common:
//            Comparator

public final class Collections
{

    private Collections()
    {
    }

    public static void insertionSort(Vector vector, Comparator comparator)
    {
        int k = vector.size();
        for(int i = 1; i < k; i++)
        {
            Object obj = vector.elementAt(i);
            int j = i - 1;
            do
            {
                if(j < 0)
                    break;
                Object obj1 = vector.elementAt(j);
                if(comparator.compare(obj1, obj) <= 0)
                    break;
                vector.setElementAt(obj1, j + 1);
                j--;
            } while(true);
            vector.setElementAt(obj, j + 1);
        }

    }
}
