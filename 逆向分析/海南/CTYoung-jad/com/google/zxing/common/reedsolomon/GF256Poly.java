// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.common.reedsolomon;


// Referenced classes of package com.google.zxing.common.reedsolomon:
//            GF256

final class GF256Poly
{

    GF256Poly(GF256 gf256, int ai[])
    {
        if(ai == null || ai.length == 0)
            throw new IllegalArgumentException();
        field = gf256;
        int j = ai.length;
        if(j > 1 && ai[0] == 0)
        {
            int i;
            for(i = 1; i < j && ai[i] == 0; i++);
            if(i == j)
            {
                coefficients = gf256.getZero().coefficients;
                return;
            } else
            {
                coefficients = new int[j - i];
                System.arraycopy(ai, i, coefficients, 0, coefficients.length);
                return;
            }
        } else
        {
            coefficients = ai;
            return;
        }
    }

    GF256Poly addOrSubtract(GF256Poly gf256poly)
    {
        if(!field.equals(gf256poly.field))
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        if(isZero())
            return gf256poly;
        if(gf256poly.isZero())
            return this;
        int ai[] = coefficients;
        int ai2[] = gf256poly.coefficients;
        int ai1[] = ai2;
        gf256poly = ai;
        if(ai.length > ai2.length)
        {
            gf256poly = ai2;
            ai1 = ai;
        }
        ai = new int[ai1.length];
        int j = ai1.length - gf256poly.length;
        System.arraycopy(ai1, 0, ai, 0, j);
        for(int i = j; i < ai1.length; i++)
            ai[i] = GF256.addOrSubtract(gf256poly[i - j], ai1[i]);

        return new GF256Poly(field, ai);
    }

    GF256Poly[] divide(GF256Poly gf256poly)
    {
        if(!field.equals(gf256poly.field))
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        if(gf256poly.isZero())
            throw new IllegalArgumentException("Divide by 0");
        GF256Poly gf256poly2 = field.getZero();
        GF256Poly gf256poly1 = this;
        int i = gf256poly.getCoefficient(gf256poly.getDegree());
        i = field.inverse(i);
        GF256Poly gf256poly3;
        for(; gf256poly1.getDegree() >= gf256poly.getDegree() && !gf256poly1.isZero(); gf256poly1 = gf256poly1.addOrSubtract(gf256poly3))
        {
            int j = gf256poly1.getDegree() - gf256poly.getDegree();
            int k = field.multiply(gf256poly1.getCoefficient(gf256poly1.getDegree()), i);
            gf256poly3 = gf256poly.multiplyByMonomial(j, k);
            gf256poly2 = gf256poly2.addOrSubtract(field.buildMonomial(j, k));
        }

        return (new GF256Poly[] {
            gf256poly2, gf256poly1
        });
    }

    int evaluateAt(int i)
    {
        if(i != 0) goto _L2; else goto _L1
_L1:
        int j = getCoefficient(0);
_L4:
        return j;
_L2:
        int j1 = coefficients.length;
        if(i == 1)
        {
            i = 0;
            int k = 0;
            do
            {
                j = i;
                if(k >= j1)
                    continue;
                i = GF256.addOrSubtract(i, coefficients[k]);
                k++;
            } while(true);
        }
        int l = coefficients[0];
        int i1 = 1;
        do
        {
            j = l;
            if(i1 >= j1)
                continue;
            l = GF256.addOrSubtract(field.multiply(i, l), coefficients[i1]);
            i1++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    int getCoefficient(int i)
    {
        return coefficients[coefficients.length - 1 - i];
    }

    int[] getCoefficients()
    {
        return coefficients;
    }

    int getDegree()
    {
        return coefficients.length - 1;
    }

    boolean isZero()
    {
        boolean flag = false;
        if(coefficients[0] == 0)
            flag = true;
        return flag;
    }

    GF256Poly multiply(int i)
    {
        GF256Poly gf256poly;
        if(i == 0)
        {
            gf256poly = field.getZero();
        } else
        {
            gf256poly = this;
            if(i != 1)
            {
                int k = coefficients.length;
                int ai[] = new int[k];
                for(int j = 0; j < k; j++)
                    ai[j] = field.multiply(coefficients[j], i);

                return new GF256Poly(field, ai);
            }
        }
        return gf256poly;
    }

    GF256Poly multiply(GF256Poly gf256poly)
    {
        if(!field.equals(gf256poly.field))
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        if(isZero() || gf256poly.isZero())
            return field.getZero();
        int ai[] = coefficients;
        int k = ai.length;
        gf256poly = gf256poly.coefficients;
        int l = gf256poly.length;
        int ai1[] = new int[(k + l) - 1];
        for(int i = 0; i < k; i++)
        {
            int i1 = ai[i];
            for(int j = 0; j < l; j++)
                ai1[i + j] = GF256.addOrSubtract(ai1[i + j], field.multiply(i1, gf256poly[j]));

        }

        return new GF256Poly(field, ai1);
    }

    GF256Poly multiplyByMonomial(int i, int j)
    {
        if(i < 0)
            throw new IllegalArgumentException();
        if(j == 0)
            return field.getZero();
        int k = coefficients.length;
        int ai[] = new int[k + i];
        for(i = 0; i < k; i++)
            ai[i] = field.multiply(coefficients[i], j);

        return new GF256Poly(field, ai);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(getDegree() * 8);
        int i = getDegree();
        do
        {
            if(i >= 0)
            {
                int k = getCoefficient(i);
                if(k != 0)
                {
                    int j;
                    if(k < 0)
                    {
                        stringbuffer.append(" - ");
                        j = -k;
                    } else
                    {
                        j = k;
                        if(stringbuffer.length() > 0)
                        {
                            stringbuffer.append(" + ");
                            j = k;
                        }
                    }
                    if(i == 0 || j != 1)
                    {
                        j = field.log(j);
                        if(j == 0)
                            stringbuffer.append('1');
                        else
                        if(j == 1)
                        {
                            stringbuffer.append('a');
                        } else
                        {
                            stringbuffer.append("a^");
                            stringbuffer.append(j);
                        }
                    }
                    if(i != 0)
                        if(i == 1)
                        {
                            stringbuffer.append('x');
                        } else
                        {
                            stringbuffer.append("x^");
                            stringbuffer.append(i);
                        }
                }
                i--;
                continue;
            }
            return stringbuffer.toString();
        } while(true);
    }

    private final int coefficients[];
    private final GF256 field;
}
