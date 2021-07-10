package inGamGraphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage ground;
    public static BufferedImage grass;

    public static BufferedImage bread;
    public static BufferedImage cloth;
    public static BufferedImage commodity;
    public static BufferedImage egg;
    public static BufferedImage fabric;
    public static BufferedImage feather;
    public static BufferedImage flour;
    public static BufferedImage iceCream;
    public static BufferedImage milk;
    public static BufferedImage pocketMilk;

    public static BufferedImage[] bearUp = new BufferedImage[3];
    public static BufferedImage[] bearDown = new BufferedImage[3];
    public static BufferedImage[] bearLeft = new BufferedImage[3];
    public static BufferedImage[] bearRight = new BufferedImage[3];

    public static BufferedImage[] buffaloUp = new BufferedImage[3];
    public static BufferedImage[] buffaloDown = new BufferedImage[3];
    public static BufferedImage[] buffaloLeft = new BufferedImage[3];
    public static BufferedImage[] buffaloRight = new BufferedImage[3];

    public static BufferedImage[] catUp = new BufferedImage[3];
    public static BufferedImage[] catDown = new BufferedImage[3];
    public static BufferedImage[] catLeft = new BufferedImage[3];
    public static BufferedImage[] catRight = new BufferedImage[3];

    public static BufferedImage[] chickenUp = new BufferedImage[3];
    public static BufferedImage[] chickenDown = new BufferedImage[3];
    public static BufferedImage[] chickenLeft = new BufferedImage[3];
    public static BufferedImage[] chickenRight = new BufferedImage[3];

    public static BufferedImage[] dogUp = new BufferedImage[3];
    public static BufferedImage[] dogDown = new BufferedImage[3];
    public static BufferedImage[] dogLeft = new BufferedImage[3];
    public static BufferedImage[] dogRight = new BufferedImage[3];

    public static BufferedImage[] lionUp = new BufferedImage[3];
    public static BufferedImage[] lionDown = new BufferedImage[3];
    public static BufferedImage[] lionLeft = new BufferedImage[3];
    public static BufferedImage[] lionRight = new BufferedImage[3];

    public static BufferedImage[] tigerUp = new BufferedImage[3];
    public static BufferedImage[] tigerDown = new BufferedImage[3];
    public static BufferedImage[] tigerLeft = new BufferedImage[3];
    public static BufferedImage[] tigerRight = new BufferedImage[3];

    public static BufferedImage[] turkeyUp = new BufferedImage[3];
    public static BufferedImage[] turkeyDown = new BufferedImage[3];
    public static BufferedImage[] turkeyLeft = new BufferedImage[3];
    public static BufferedImage[] turkeyRight = new BufferedImage[3];

    public static void init(){
        ground = ImageLoader.loadImage("/res/textures/land/ground.png");
        grass = ImageLoader.loadImage("/res/textures/land/grass.png");

        bread = ImageLoader.loadImage("/res/textures/commodities/bread/bread.png");
        cloth = ImageLoader.loadImage("/res/textures/commodities/cloth/cloth.png");
        egg = ImageLoader.loadImage("/res/textures/commodities/egg/egg.png");
        fabric = ImageLoader.loadImage("/res/textures/commodities/fabric/fabric.png");
        feather = ImageLoader.loadImage("/res/textures/commodities/feather/feather.png");
        flour = ImageLoader.loadImage("/res/textures/commodities/flour/flour.png");
        iceCream = ImageLoader.loadImage("/res/textures/commodities/iceCream/iceCream.png");
        milk = ImageLoader.loadImage("/res/textures/commodities/milk/milk.png");
        pocketMilk = ImageLoader.loadImage("/res/textures/commodities/pocketMilk/pocketMilk.png");

        SpriteSheet bearSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/bear/bear.png"));
        bearSheet.cropAnimals(bearUp , bearDown , bearLeft , bearRight);

        SpriteSheet buffaloSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/buffalo/buffalo.png"));
        buffaloSheet.cropAnimals(buffaloUp , buffaloDown , buffaloLeft , buffaloRight);

        SpriteSheet catSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/cat/cat.png"));
        catSheet.cropAnimals(catUp , catDown , catLeft ,catRight);

        SpriteSheet chickenSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/chicken/chicken.png"));
        chickenSheet.cropAnimals(chickenUp , chickenDown , chickenLeft , chickenRight);

        SpriteSheet dogSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/dog/dog.png"));
        dogSheet.cropAnimals(dogUp , dogDown , dogLeft , dogRight);

        SpriteSheet lionSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/lion/lion.png"));
        lionSheet.cropAnimals(lionUp , lionDown , lionLeft , lionRight);

        SpriteSheet tigerSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/animals/tiger/tiger.png"));
        tigerSheet.cropAnimals(tigerUp , tigerDown , tigerLeft , tigerRight);

        turkeyInit();
    }
    private static void turkeyInit(){
        turkeyDown[0] = ImageLoader.loadImage("/res/textures/animals/turkey/down/turkeydown0.png");
        turkeyDown[1] = ImageLoader.loadImage("/res/textures/animals/turkey/down/turkeydown1.png");
        turkeyDown[2] = ImageLoader.loadImage("/res/textures/animals/turkey/down/turkeydown2.png");

        turkeyUp[0] = ImageLoader.loadImage("/res/textures/animals/turkey/up/turkeyUp0.png");
        turkeyUp[1] = ImageLoader.loadImage("/res/textures/animals/turkey/up/turkeyUp1.png");
        turkeyUp[2] = ImageLoader.loadImage("/res/textures/animals/turkey/up/turkeyUp2.png");

        turkeyLeft[0] = ImageLoader.loadImage("/res/textures/animals/turkey/left/turkeyleft0.png");
        turkeyLeft[1] = ImageLoader.loadImage("/res/textures/animals/turkey/left/turkeyleft1.png");
        turkeyLeft[2] = ImageLoader.loadImage("/res/textures/animals/turkey/left/turkeyleft2.png");

        turkeyRight[0] = ImageLoader.loadImage("/res/textures/animals/turkey/right/turkeyright0.png");
        turkeyRight[1] = ImageLoader.loadImage("/res/textures/animals/turkey/right/turkeyright1.png");
        turkeyRight[2] = ImageLoader.loadImage("/res/textures/animals/turkey/right/turkeyright2.png");
    }
}

