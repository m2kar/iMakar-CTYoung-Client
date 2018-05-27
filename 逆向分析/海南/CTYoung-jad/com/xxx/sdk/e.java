// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import com.xxx.sdk.b.f;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.c.d;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.xxx.sdk:
//            k

public abstract class e extends k
{

    public e()
    {
        a = Pattern.compile("((src[\u3000 \t]*=[\u3000 \t]*[\"']([^\"']+)[\"'])|(href[\u3000 \t]*=[\u3000 \t]*[\"']([^\"']+((.ico)|(.css)))[\"'])|(url[\u3000 \t]*\\([\u3000 \t]*[\"']?([^\"'\\)]+)[\"']?[\u3000 \t]*\\)))");
    }

    public final String a(String s, File file)
    {
        if(!f.d(s))
            break MISSING_BLOCK_LABEL_500;
        Object obj;
        c.info((new StringBuilder("\u8BF7\u6C42url:")).append(s).append("\u662Fweb\u8D44\u6E90\uFF0C\u9700\u8981\u4E0B\u8F7D\u5F53\u524D\u9875\u9762\u6240\u6709\u5F15\u7528\u8D44\u6E90\uFF0C\u4F8B\u5982\uFF1A\u56FE\u7247,css,js,video,audio").toString());
        obj = get(s);
        if(!b.f(((String) (obj))))
            break MISSING_BLOCK_LABEL_53;
        c.warn("\u4E0B\u8F7Dweb\u8D44\u6E90\uFF08html\u6216\u8005css\u7B49\uFF09\u9875\u9762\u4E3A\u7A7A");
        return "";
        File file1;
        String s3;
        boolean flag;
        String s1;
        String s2;
        File file2;
        Matcher matcher;
        try
        {
            s1 = s.substring(0, s.indexOf('/', 8)).concat("/");
            s2 = s.substring(0, s.lastIndexOf("/")).concat("/");
            file2 = new File((new StringBuilder()).append(file.getPath().concat(File.separator)).append(s.hashCode()).toString());
            file2.mkdirs();
            s3 = file2.getPath();
            c.info((new StringBuilder("\u8BF7\u6C42\u57DF\u540D\uFF1A")).append(s1).append(", \u5F53\u524D\u7F51\u9875\u4F4D\u7F6E\uFF1A").append(s2).append(", \u7F13\u5B58\u672C\u5730\u76EE\u5F55:").append(s3).toString());
            matcher = a.matcher(((CharSequence) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            c.a("\u4E0B\u8F7Dweb\u8D44\u6E90\uFF08html\u6216\u8005css\u7B49\uFF09\u4E2D\u9519\u8BEF\u3002", s);
            return "";
        }
        file = ((File) (obj));
        file1 = file;
        flag = matcher.find();
        if(!flag)
            break; /* Loop/switch isn't completed */
        obj = matcher.group(3);
        file = ((File) (obj));
        if(b.f(((String) (obj))))
            file = matcher.group(5);
        obj = file;
        if(b.f(file))
            obj = matcher.group(10);
        if(!((String) (obj)).startsWith("//")) goto _L2; else goto _L1
_L1:
        file = (new StringBuilder("http:")).append(((String) (obj))).toString();
_L3:
        file = file1.replace(((CharSequence) (obj)), a(((String) (file)), file2));
        continue; /* Loop/switch isn't completed */
_L2:
label0:
        {
            if(!((String) (obj)).startsWith("/"))
                break label0;
            file = (new StringBuilder()).append(s1).append(((String) (obj))).toString();
        }
          goto _L3
        if(!"http".equalsIgnoreCase(((String) (obj)).substring(0, 4)))
            break MISSING_BLOCK_LABEL_356;
        file = ((File) (obj));
          goto _L3
        file = (new StringBuilder()).append(s2).append(((String) (obj))).toString();
          goto _L3
        file;
        c.a("\u5FFD\u7565\u9519\u8BEF", file);
        file = file1;
        if(true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_197;
_L4:
        c.info("\u66FF\u6362\u540Eweb\u8D44\u6E90\uFF08html\u6216\u8005css\u7B49\uFF09\u6587\u6863\u5185\u5BB9\uFF1A\r\n".concat(file1));
        s = s3.concat(File.separator).concat(s.substring(s.lastIndexOf("/") + 1));
        file = new File(s);
        file.createNewFile();
        file = new FileWriter(file);
        d.a(file1, file);
        file.flush();
        d.a(file);
        c.info((new StringBuilder("\u66FF\u6362\u540Eweb\u8D44\u6E90\uFF08html\u6216\u8005css\u7B49\uFF09\u6587\u6863\u5199\u5165\u6587\u4EF6\uFF3B")).append(s).append("]").toString());
        return s;
        return super.a(s, file);
    }

    private Pattern a;
}
