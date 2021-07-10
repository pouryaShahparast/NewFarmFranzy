package inGamGraphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    public static final int WIDTH = 48;

    public static final int HEIGHT = 48;
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }
    public BufferedImage crop(int x , int y , int width , int height){
        return sheet.getSubimage(x,y,width,height);
    }
    public void cropAnimals(BufferedImage[] up , BufferedImage[] down , BufferedImage[] left , BufferedImage[] right ){
        int y = 0;
        cropOneSide(down , y);
        y += HEIGHT;
        cropOneSide(left , y);
        y += HEIGHT;
        cropOneSide(right , y);
        y += HEIGHT;
        cropOneSide(up , y);
    }
    private void cropOneSide(BufferedImage[] bufferedImages , int y){
        bufferedImages[0] = crop( 0 , y ,WIDTH ,HEIGHT );
        bufferedImages[1] = crop( WIDTH , y ,WIDTH ,HEIGHT );
        bufferedImages[2] = crop( WIDTH * 2 , y ,WIDTH ,HEIGHT );
    }
}
