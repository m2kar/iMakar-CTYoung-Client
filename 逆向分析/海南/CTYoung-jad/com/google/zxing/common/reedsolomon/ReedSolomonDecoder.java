// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common.reedsolomon;


// Referenced classes of package com.google.zxing.common.reedsolomon:
//            ReedSolomonException, GF256Poly, GF256

public final class ReedSolomonDecoder
{

    public ReedSolomonDecoder(GF256 gf256)
    {
        field = gf256;
    }

    private int[] findErrorLocations(GF256Poly gf256poly)
        throws ReedSolomonException
    {
        int l = gf256poly.getDegree();
        if(l == 1)
        {
            int ai[] = new int[1];
            ai[0] = gf256poly.getCoefficient(1);
            gf256poly = ai;
        } else
        {
            int ai1[] = new int[l];
            int j = 0;
            int k;
            for(int i = 1; i < 256 && j < l; j = k)
            {
                k = j;
                if(gf256poly.evaluateAt(i) == 0)
                {
                    ai1[j] = field.inverse(i);
                    k = j + 1;
                }
                i++;
            }

            gf256poly = ai1;
            if(j != l)
                throw new ReedSolomonException("Error locator degree does not match number of roots");
        }
        return gf256poly;
    }

    private int[] findErrorMagnitudes(GF256Poly gf256poly, int ai[], boolean flag)
    {
        int i1 = ai.length;
        int ai1[] = new int[i1];
        for(int i = 0; i < i1; i++)
        {
            int j1 = field.inverse(ai[i]);
            int k = 1;
            int j = 0;
            while(j < i1) 
            {
                int l = k;
                if(i != j)
                {
                    l = field.multiply(ai[j], j1);
                    if((l & 1) == 0)
                        l |= 1;
                    else
                        l &= -2;
                    l = field.multiply(k, l);
                }
                j++;
                k = l;
            }
            ai1[i] = field.multiply(gf256poly.evaluateAt(j1), field.inverse(k));
            if(flag)
                ai1[i] = field.multiply(ai1[i], j1);
        }

        return ai1;
    }

    private GF256Poly[] runEuclideanAlgorithm(GF256Poly gf256poly, GF256Poly gf256poly1, int i)
        throws ReedSolomonException
    {
        GF256Poly gf256poly3 = gf256poly;
        GF256Poly gf256poly2 = gf256poly1;
        if(gf256poly.getDegree() < gf256poly1.getDegree())
        {
            gf256poly2 = gf256poly;
            gf256poly3 = gf256poly1;
        }
        GF256Poly gf256poly4 = field.getOne();
        gf256poly1 = field.getZero();
        GF256Poly gf256poly5 = field.getZero();
        gf256poly = field.getOne();
        do
        {
            GF256Poly gf256poly7 = gf256poly5;
            GF256Poly gf256poly8 = gf256poly4;
            GF256Poly gf256poly6 = gf256poly3;
            if(gf256poly2.getDegree() < i / 2)
                break;
            gf256poly3 = gf256poly2;
            gf256poly4 = gf256poly1;
            gf256poly5 = gf256poly;
            if(gf256poly3.isZero())
                throw new ReedSolomonException("r_{i-1} was zero");
            gf256poly2 = gf256poly6;
            gf256poly = field.getZero();
            int j = gf256poly3.getCoefficient(gf256poly3.getDegree());
            j = field.inverse(j);
            int k;
            int l;
            for(; gf256poly2.getDegree() >= gf256poly3.getDegree() && !gf256poly2.isZero(); gf256poly2 = gf256poly2.addOrSubtract(gf256poly3.multiplyByMonomial(k, l)))
            {
                k = gf256poly2.getDegree() - gf256poly3.getDegree();
                l = field.multiply(gf256poly2.getCoefficient(gf256poly2.getDegree()), j);
                gf256poly = gf256poly.addOrSubtract(field.buildMonomial(k, l));
            }

            gf256poly1 = gf256poly.multiply(gf256poly4).addOrSubtract(gf256poly8);
            gf256poly = gf256poly.multiply(gf256poly5).addOrSubtract(gf256poly7);
        } while(true);
        i = gf256poly.getCoefficient(0);
        if(i == 0)
        {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        } else
        {
            i = field.inverse(i);
            return (new GF256Poly[] {
                gf256poly.multiply(i), gf256poly2.multiply(i)
            });
        }
    }

    public void decode(int ai[], int i)
        throws ReedSolomonException
    {
        GF256Poly gf256poly = new GF256Poly(field, ai);
        Object aobj[] = new int[i];
        boolean flag1 = field.equals(GF256.DATA_MATRIX_FIELD);
        boolean flag = true;
        int j = 0;
        while(j < i) 
        {
            GF256 gf256 = field;
            int l;
            if(flag1)
                l = j + 1;
            else
                l = j;
            l = gf256poly.evaluateAt(gf256.exp(l));
            aobj[aobj.length - 1 - j] = l;
            if(l != 0)
                flag = false;
            j++;
        }
        if(!flag)
        {
            GF256Poly gf256poly1 = new GF256Poly(field, ((int []) (aobj)));
            aobj = runEuclideanAlgorithm(field.buildMonomial(i, 1), gf256poly1, i);
            gf256poly1 = aobj[0];
            GF256Poly gf256poly2 = aobj[1];
            int ai1[] = findErrorLocations(gf256poly1);
            gf256poly2 = findErrorMagnitudes(gf256poly2, ai1, flag1);
            i = 0;
            while(i < ai1.length) 
            {
                int k = ai.length - 1 - field.log(ai1[i]);
                if(k < 0)
                    throw new ReedSolomonException("Bad error location");
                ai[k] = GF256.addOrSubtract(ai[k], gf256poly2[i]);
                i++;
            }
        }
    }

    private final GF256 field;
}
