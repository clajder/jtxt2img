/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Oembedler Inc. and Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 *  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 *  persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.embedler.moon.jtxt2img.test;

import com.embedler.moon.jtxt2img.ImgTextProperties;
import com.embedler.moon.jtxt2img.JTxt2Img;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.text.MessageFormat;

public class JTxt2ImgTest {

    private String outputDirectory;

    @Before
    public void before() {
        outputDirectory = System.getenv("IMG_OUTPUT");
    }

    @Test
    public void simpleTest() {
        ImgTextProperties imgTextProperties = new ImgTextProperties();

        imgTextProperties.setBgColor("167");
        imgTextProperties.setFgColor("945");
        imgTextProperties.setFormat(ImgTextProperties.IMG_FORMAT.JPG);
        imgTextProperties.setWidth(10);
        imgTextProperties.setHeight(10);

        String fontsDir = outputDirectory;
        new File(fontsDir).mkdirs();
        for (int i = 0; i < 9; i++) {
            String name = String.valueOf(1);
            imgTextProperties.setText(name);
            File file = new File(outputDirectory, "file-" + i);
            JTxt2Img.withProperties(imgTextProperties).generate().write(file);
        }
    }

    @Test
    public void simpleBuilderTest() {

        String fontsDir = outputDirectory;

        new File(fontsDir).mkdirs();
        for (int i = 0; i < 9; i++) {

            String fileName = MessageFormat.format("image-{0}.{1}", i, ImgTextProperties.IMG_FORMAT.JPG.toString().toLowerCase());
            File file = new File(outputDirectory, fileName);

            JTxt2Img.withText(String.valueOf(i))
                    .backgroundColor("487")
                    .foregroundColor("278")
                    .format(ImgTextProperties.IMG_FORMAT.JPG)
                    .width(50)
                    .font(Font.getFont(Font.MONOSPACED))
                    .height(90)
                    .generate()
                    .write(file);
        }

    }
}
