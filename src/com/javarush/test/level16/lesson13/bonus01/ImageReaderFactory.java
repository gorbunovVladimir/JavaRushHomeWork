package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Vl on 27.02.2015.
 */
public class ImageReaderFactory
{public static ImageReader getReader(ImageTypes imageTypes){
    ImageReader result = null;

    if (imageTypes==ImageTypes.BMP){result = new BmpReader();}
    else if (imageTypes==ImageTypes.JPG){result = new JpgReader();}
    else if (imageTypes==ImageTypes.PNG){result = new PngReader();}
    else throw new IllegalArgumentException("Неизвестный тип картинки");
    return result;

     /*switch (imageTypes) {
        case BMP:
            result = new BmpReader();
            break;
        case JPG:
            result = new JpgReader();
            break;
        case PNG:
            result = new PngReader();
            break;
        default:
            throw new IllegalArgumentException("Неизвестный тип картинки");}
            //break;*/


    /*if (imageTypes.equals(ImageTypes.BMP)){result = new BmpReader();}
    else if (imageTypes.equals(ImageTypes.JPG)){result = new JpgReader();}
    else if (imageTypes.equals(ImageTypes.PNG)){result = new PngReader();}
    else throw new IllegalArgumentException("Неизвестный тип картинки");
    return result;*/
   }
}
