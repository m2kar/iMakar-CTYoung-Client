// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

final class FieldParser
{

    private FieldParser()
    {
    }

    static String parseFieldsInGeneralPurpose(String s)
        throws NotFoundException
    {
        if(s.length() == 0)
            return "";
        if(s.length() < 2)
            throw NotFoundException.getNotFoundInstance();
        String s1 = s.substring(0, 2);
        for(int i = 0; i < TWO_DIGIT_DATA_LENGTH.length; i++)
            if(TWO_DIGIT_DATA_LENGTH[i][0].equals(s1))
                if(TWO_DIGIT_DATA_LENGTH[i][1] == VARIABLE_LENGTH)
                    return processVariableAI(2, ((Integer)TWO_DIGIT_DATA_LENGTH[i][2]).intValue(), s);
                else
                    return processFixedAI(2, ((Integer)TWO_DIGIT_DATA_LENGTH[i][1]).intValue(), s);

        if(s.length() < 3)
            throw NotFoundException.getNotFoundInstance();
        s1 = s.substring(0, 3);
        for(int j = 0; j < THREE_DIGIT_DATA_LENGTH.length; j++)
            if(THREE_DIGIT_DATA_LENGTH[j][0].equals(s1))
                if(THREE_DIGIT_DATA_LENGTH[j][1] == VARIABLE_LENGTH)
                    return processVariableAI(3, ((Integer)THREE_DIGIT_DATA_LENGTH[j][2]).intValue(), s);
                else
                    return processFixedAI(3, ((Integer)THREE_DIGIT_DATA_LENGTH[j][1]).intValue(), s);

        for(int k = 0; k < THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH.length; k++)
            if(THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[k][0].equals(s1))
                if(THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[k][1] == VARIABLE_LENGTH)
                    return processVariableAI(4, ((Integer)THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[k][2]).intValue(), s);
                else
                    return processFixedAI(4, ((Integer)THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[k][1]).intValue(), s);

        if(s.length() < 4)
            throw NotFoundException.getNotFoundInstance();
        s1 = s.substring(0, 4);
        for(int l = 0; l < FOUR_DIGIT_DATA_LENGTH.length; l++)
            if(FOUR_DIGIT_DATA_LENGTH[l][0].equals(s1))
                if(FOUR_DIGIT_DATA_LENGTH[l][1] == VARIABLE_LENGTH)
                    return processVariableAI(4, ((Integer)FOUR_DIGIT_DATA_LENGTH[l][2]).intValue(), s);
                else
                    return processFixedAI(4, ((Integer)FOUR_DIGIT_DATA_LENGTH[l][1]).intValue(), s);

        throw NotFoundException.getNotFoundInstance();
    }

    private static String processFixedAI(int i, int j, String s)
        throws NotFoundException
    {
        if(s.length() < i)
            throw NotFoundException.getNotFoundInstance();
        String s1 = s.substring(0, i);
        if(s.length() < i + j)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            String s2 = s.substring(i, i + j);
            s = s.substring(i + j);
            return '(' + s1 + ')' + s2 + parseFieldsInGeneralPurpose(s);
        }
    }

    private static String processVariableAI(int i, int j, String s)
        throws NotFoundException
    {
        String s1 = s.substring(0, i);
        String s2;
        if(s.length() < i + j)
            j = s.length();
        else
            j = i + j;
        s2 = s.substring(i, j);
        s = s.substring(j);
        return '(' + s1 + ')' + s2 + parseFieldsInGeneralPurpose(s);
    }

    private static final Object FOUR_DIGIT_DATA_LENGTH[][];
    private static final Object THREE_DIGIT_DATA_LENGTH[][];
    private static final Object THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[][];
    private static final Object TWO_DIGIT_DATA_LENGTH[][];
    private static final Object VARIABLE_LENGTH;

    static 
    {
        VARIABLE_LENGTH = new Object();
        Object aobj[] = {
            "00", new Integer(18)
        };
        Object obj = new Integer(14);
        Object aobj1[] = {
            "02", new Integer(14)
        };
        Object aobj2[] = {
            "10", VARIABLE_LENGTH, new Integer(20)
        };
        Integer integer = new Integer(6);
        Object aobj3[] = {
            "12", new Integer(6)
        };
        Object aobj4[] = {
            "13", new Integer(6)
        };
        Object obj1 = new Integer(6);
        Object aobj5[] = {
            "17", new Integer(6)
        };
        Object aobj6[] = {
            "20", new Integer(2)
        };
        Object aobj7[] = {
            "21", VARIABLE_LENGTH, new Integer(20)
        };
        Object aobj8[] = {
            "22", VARIABLE_LENGTH, new Integer(29)
        };
        Object aobj9[] = {
            "30", VARIABLE_LENGTH, new Integer(8)
        };
        Object aobj10[] = {
            "37", VARIABLE_LENGTH, new Integer(8)
        };
        Object aobj11[] = {
            "90", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj12[] = {
            "91", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj13[] = {
            "92", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj14[] = {
            "93", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj15[] = {
            "94", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj16[] = {
            "95", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj17[] = {
            "96", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj18[] = {
            "97", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj19[] = {
            "98", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj20[] = {
            "99", VARIABLE_LENGTH, new Integer(30)
        };
        TWO_DIGIT_DATA_LENGTH = (new Object[][] {
            aobj, new Object[] {
                "01", obj
            }, aobj1, aobj2, new Object[] {
                "11", integer
            }, aobj3, aobj4, new Object[] {
                "15", obj1
            }, aobj5, aobj6, 
            aobj7, aobj8, aobj9, aobj10, aobj11, aobj12, aobj13, aobj14, aobj15, aobj16, 
            aobj17, aobj18, aobj19, aobj20
        });
        aobj20 = (new Object[] {
            "240", VARIABLE_LENGTH, new Integer(30)
        });
        Object aobj21[] = {
            "241", VARIABLE_LENGTH, new Integer(30)
        };
        obj = VARIABLE_LENGTH;
        integer = new Integer(6);
        Object aobj22[] = {
            "250", VARIABLE_LENGTH, new Integer(30)
        };
        Object aobj23[] = {
            "251", VARIABLE_LENGTH, new Integer(30)
        };
        obj1 = VARIABLE_LENGTH;
        Integer integer1 = new Integer(17);
        Object obj2 = VARIABLE_LENGTH;
        Integer integer2 = new Integer(20);
        Object obj3 = VARIABLE_LENGTH;
        Integer integer3 = new Integer(30);
        Object obj4 = VARIABLE_LENGTH;
        Object obj5 = new Integer(30);
        Integer integer4 = new Integer(17);
        Object obj6 = VARIABLE_LENGTH;
        Integer integer5 = new Integer(30);
        Integer integer6 = new Integer(13);
        Integer integer7 = new Integer(13);
        Integer integer8 = new Integer(13);
        Object aobj24[] = {
            "413", new Integer(13)
        };
        Object aobj25[] = {
            "414", new Integer(13)
        };
        Object obj7 = VARIABLE_LENGTH;
        Integer integer9 = new Integer(20);
        Object aobj26[] = {
            "421", VARIABLE_LENGTH, new Integer(15)
        };
        Integer integer10 = new Integer(3);
        Object obj8 = VARIABLE_LENGTH;
        Integer integer11 = new Integer(15);
        Object aobj27[] = {
            "424", new Integer(3)
        };
        Integer integer12 = new Integer(3);
        Integer integer13 = new Integer(3);
        THREE_DIGIT_DATA_LENGTH = (new Object[][] {
            aobj20, aobj21, new Object[] {
                "242", obj, integer
            }, aobj22, aobj23, new Object[] {
                "253", obj1, integer1
            }, new Object[] {
                "254", obj2, integer2
            }, new Object[] {
                "400", obj3, integer3
            }, new Object[] {
                "401", obj4, obj5
            }, new Object[] {
                "402", integer4
            }, 
            new Object[] {
                "403", obj6, integer5
            }, new Object[] {
                "410", integer6
            }, new Object[] {
                "411", integer7
            }, new Object[] {
                "412", integer8
            }, aobj24, aobj25, new Object[] {
                "420", obj7, integer9
            }, aobj26, new Object[] {
                "422", integer10
            }, new Object[] {
                "423", obj8, integer11
            }, 
            aobj27, new Object[] {
                "425", integer12
            }, new Object[] {
                "426", integer13
            }
        });
        obj = new Integer(6);
        integer = new Integer(6);
        obj1 = new Integer(6);
        integer1 = new Integer(6);
        Object aobj28[] = {
            "314", new Integer(6)
        };
        obj2 = new Integer(6);
        integer2 = new Integer(6);
        Object aobj29[] = {
            "320", new Integer(6)
        };
        Object aobj30[] = {
            "321", new Integer(6)
        };
        obj3 = new Integer(6);
        integer3 = new Integer(6);
        Object aobj31[] = {
            "324", new Integer(6)
        };
        obj4 = new Integer(6);
        obj5 = new Integer(6);
        integer4 = new Integer(6);
        obj6 = new Integer(6);
        integer5 = new Integer(6);
        Object aobj32[] = {
            "330", new Integer(6)
        };
        integer6 = new Integer(6);
        Object aobj33[] = {
            "332", new Integer(6)
        };
        integer7 = new Integer(6);
        integer8 = new Integer(6);
        Object aobj34[] = {
            "335", new Integer(6)
        };
        obj7 = new Integer(6);
        integer9 = new Integer(6);
        Object aobj35[] = {
            "341", new Integer(6)
        };
        integer10 = new Integer(6);
        Object aobj36[] = {
            "343", new Integer(6)
        };
        obj8 = new Integer(6);
        integer11 = new Integer(6);
        Object aobj37[] = {
            "346", new Integer(6)
        };
        integer12 = new Integer(6);
        Object aobj38[] = {
            "348", new Integer(6)
        };
        integer13 = new Integer(6);
        Integer integer14 = new Integer(6);
        Integer integer15 = new Integer(6);
        Integer integer16 = new Integer(6);
        Integer integer17 = new Integer(6);
        Object aobj39[] = {
            "354", new Integer(6)
        };
        Integer integer18 = new Integer(6);
        Integer integer19 = new Integer(6);
        Integer integer20 = new Integer(6);
        Integer integer21 = new Integer(6);
        Object aobj40[] = {
            "361", new Integer(6)
        };
        Integer integer22 = new Integer(6);
        Integer integer23 = new Integer(6);
        Integer integer24 = new Integer(6);
        Integer integer25 = new Integer(6);
        Integer integer26 = new Integer(6);
        Integer integer27 = new Integer(6);
        Object aobj41[] = {
            "368", new Integer(6)
        };
        Object aobj42[] = {
            "369", new Integer(6)
        };
        Object obj9 = VARIABLE_LENGTH;
        Integer integer28 = new Integer(15);
        Object obj10 = VARIABLE_LENGTH;
        Integer integer29 = new Integer(18);
        Object obj11 = VARIABLE_LENGTH;
        Integer integer30 = new Integer(15);
        Object obj12 = VARIABLE_LENGTH;
        Integer integer31 = new Integer(18);
        Object obj13 = VARIABLE_LENGTH;
        Integer integer32 = new Integer(30);
        THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = (new Object[][] {
            new Object[] {
                "310", obj
            }, new Object[] {
                "311", integer
            }, new Object[] {
                "312", obj1
            }, new Object[] {
                "313", integer1
            }, aobj28, new Object[] {
                "315", obj2
            }, new Object[] {
                "316", integer2
            }, aobj29, aobj30, new Object[] {
                "322", obj3
            }, new Object[] {
                "323", integer3
            }, aobj31, new Object[] {
                "325", obj4
            }, new Object[] {
                "326", obj5
            }, new Object[] {
                "327", integer4
            }, new Object[] {
                "328", obj6
            }, new Object[] {
                "329", integer5
            }, aobj32, new Object[] {
                "331", integer6
            }, aobj33, new Object[] {
                "333", integer7
            }, new Object[] {
                "334", integer8
            }, aobj34, new Object[] {
                "336", obj7
            }, new Object[] {
                "340", integer9
            }, aobj35, new Object[] {
                "342", integer10
            }, aobj36, new Object[] {
                "344", obj8
            }, new Object[] {
                "345", integer11
            }, aobj37, new Object[] {
                "347", integer12
            }, aobj38, new Object[] {
                "349", integer13
            }, new Object[] {
                "350", integer14
            }, new Object[] {
                "351", integer15
            }, new Object[] {
                "352", integer16
            }, new Object[] {
                "353", integer17
            }, aobj39, new Object[] {
                "355", integer18
            }, new Object[] {
                "356", integer19
            }, new Object[] {
                "357", integer20
            }, new Object[] {
                "360", integer21
            }, aobj40, new Object[] {
                "362", integer22
            }, new Object[] {
                "363", integer23
            }, new Object[] {
                "364", integer24
            }, new Object[] {
                "365", integer25
            }, new Object[] {
                "366", integer26
            }, new Object[] {
                "367", integer27
            }, aobj41, aobj42, new Object[] {
                "390", obj9, integer28
            }, new Object[] {
                "391", obj10, integer29
            }, new Object[] {
                "392", obj11, integer30
            }, new Object[] {
                "393", obj12, integer31
            }, new Object[] {
                "703", obj13, integer32
            }
        });
        obj6 = ((Object) (new Object[] {
            "7001", new Integer(13)
        }));
        obj = VARIABLE_LENGTH;
        integer = new Integer(30);
        integer5 = ((Integer) (new Object[] {
            "7003", new Integer(10)
        }));
        integer6 = ((Integer) (new Object[] {
            "8001", new Integer(14)
        }));
        integer7 = ((Integer) (new Object[] {
            "8002", VARIABLE_LENGTH, new Integer(20)
        }));
        integer8 = ((Integer) (new Object[] {
            "8003", VARIABLE_LENGTH, new Integer(30)
        }));
        obj7 = ((Object) (new Object[] {
            "8004", VARIABLE_LENGTH, new Integer(30)
        }));
        obj1 = new Integer(6);
        integer1 = new Integer(18);
        obj2 = VARIABLE_LENGTH;
        integer2 = new Integer(30);
        integer9 = ((Integer) (new Object[] {
            "8008", VARIABLE_LENGTH, new Integer(12)
        }));
        integer10 = ((Integer) (new Object[] {
            "8018", new Integer(18)
        }));
        obj3 = VARIABLE_LENGTH;
        integer3 = new Integer(25);
        obj4 = new Integer(6);
        obj8 = ((Object) (new Object[] {
            "8101", new Integer(10)
        }));
        integer11 = ((Integer) (new Object[] {
            "8102", new Integer(2)
        }));
        obj5 = VARIABLE_LENGTH;
        integer4 = new Integer(30);
        FOUR_DIGIT_DATA_LENGTH = (new Object[][] {
            obj6, new Object[] {
                "7002", obj, integer
            }, integer5, integer6, integer7, integer8, obj7, new Object[] {
                "8005", obj1
            }, new Object[] {
                "8006", integer1
            }, new Object[] {
                "8007", obj2, integer2
            }, 
            integer9, integer10, new Object[] {
                "8020", obj3, integer3
            }, new Object[] {
                "8100", obj4
            }, obj8, integer11, new Object[] {
                "8110", obj5, integer4
            }
        });
    }
}
