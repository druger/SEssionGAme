
package framework;

import sega.BufferedImageLoader;

import java.awt.image.BufferedImage;

public class Texture {
    private SpriteList bl;
    private SpriteList pl;
    private SpriteList pgl;
    private SpriteList plm;
    private SpriteList plf;
    private SpriteList plp;
    private SpriteList ple;

    private BufferedImage blockList;
    private BufferedImage prepodListEng;
    private BufferedImage prepodListPrg;
    private BufferedImage prepodListFizika;
    private BufferedImage prepodListMatan;
    private BufferedImage playerGunList;
    private BufferedImage playerList;

    public BufferedImage[] block = new BufferedImage[3];
    public BufferedImage[] player = new BufferedImage[7];
    public BufferedImage[] playerJump = new BufferedImage[2];
    public BufferedImage[] playerGun = new BufferedImage[7];
    public BufferedImage[] playerGunJump = new BufferedImage[2];
    public BufferedImage[] prepodMatan = new BufferedImage[10];
    public BufferedImage[] prepodFizika = new BufferedImage[8];
    public BufferedImage[] prepodPrg = new BufferedImage[8];
    public BufferedImage[] prepodEng = new BufferedImage[8];

    public Texture() {

        BufferedImageLoader loader = new BufferedImageLoader();

        try {
            blockList = loader.loadImage("/res/Sprites/dirt/dirt.png");
            playerList = loader.loadImage("/res/Sprites/Players/player.png");
            playerGunList = loader.loadImage("/res/Sprites/Players/playerGun.png");
            prepodListMatan = loader.loadImage("/res/Sprites/Teachers/matan.png");
            prepodListFizika = loader.loadImage("/res/Sprites/Teachers/fizika.png");
            prepodListPrg = loader.loadImage("/res/Sprites/Teachers/prg.png");
            prepodListEng = loader.loadImage("/res/Sprites/Teachers/eng.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

        initSprites();
        getTextures();
    }

    private void initSprites() {
        bl = new SpriteList(blockList);
        pl = new SpriteList(playerList);
        pgl = new SpriteList(playerGunList);
        plm = new SpriteList(prepodListMatan);
        plf = new SpriteList(prepodListFizika);
        plp = new SpriteList(prepodListPrg);
        ple = new SpriteList(prepodListEng);
    }

    private void getTextures() {
        initRoads();
        initPlayer();
        initPlayerJump();
        initPlayerGun();
        initPrepodMatan();
        initPrepodFizika();
        initPrepodPrg();
        initPrepodEng();
    }

    private void initPrepodEng() {
        prepodEng[0] = ple.grabImage(1, 1, 69, 100);
        prepodEng[1] = ple.grabImage(2, 1, 69, 100);
        prepodEng[2] = ple.grabImage(3, 1, 69, 100);
        prepodEng[3] = ple.grabImage(4, 1, 69, 100);

        prepodEng[4] = ple.grabImage(1, 2, 69, 100);
        prepodEng[5] = ple.grabImage(2, 2, 69, 100);
        prepodEng[6] = ple.grabImage(3, 2, 69, 100);
        prepodEng[7] = ple.grabImage(4, 2, 69, 100);
    }

    private void initPrepodPrg() {
        prepodPrg[0] = plp.grabImage(1, 1, 70, 100);
        prepodPrg[1] = plp.grabImage(2, 1, 70, 100);
        prepodPrg[2] = plp.grabImage(3, 1, 70, 100);
        prepodPrg[3] = plp.grabImage(4, 1, 70, 100);

        prepodPrg[4] = plp.grabImage(1, 2, 70, 100);
        prepodPrg[5] = plp.grabImage(2, 2, 70, 100);
        prepodPrg[6] = plp.grabImage(3, 2, 70, 100);
        prepodPrg[7] = plp.grabImage(4, 2, 70, 100);
    }

    private void initPrepodFizika() {
        prepodFizika[0] = plf.grabImage(1, 1, 71, 100);
        prepodFizika[1] = plf.grabImage(2, 1, 71, 100);
        prepodFizika[2] = plf.grabImage(3, 1, 71, 100);
        prepodFizika[3] = plf.grabImage(4, 1, 71, 100);

        prepodFizika[4] = plf.grabImage(1, 2, 71, 100);
        prepodFizika[5] = plf.grabImage(2, 2, 71, 100);
        prepodFizika[6] = plf.grabImage(3, 2, 71, 100);
        prepodFizika[7] = plf.grabImage(4, 2, 71, 100);
    }

    private void initPrepodMatan() {
        prepodMatan[0] = plm.grabImage(1, 1, 69, 100);
        prepodMatan[1] = plm.grabImage(2, 1, 69, 100);
        prepodMatan[2] = plm.grabImage(3, 1, 69, 100);
        prepodMatan[3] = plm.grabImage(4, 1, 69, 100);
        prepodMatan[4] = plm.grabImage(5, 1, 69, 100);

        prepodMatan[5] = plm.grabImage(1, 2, 69, 100);
        prepodMatan[6] = plm.grabImage(2, 2, 69, 100);
        prepodMatan[7] = plm.grabImage(3, 2, 69, 100);
        prepodMatan[8] = plm.grabImage(4, 2, 69, 100);
        prepodMatan[9] = plm.grabImage(5, 2, 69, 100);
    }

    private void initPlayerGun() {
        playerGun[0] = pgl.grabImage(1, 1, 130, 172);

        playerGun[1] = pgl.grabImage(1, 2, 103, 172);
        playerGun[2] = pgl.grabImage(1, 3, 115, 172);
        playerGun[3] = pgl.grabImage(1, 4, 140, 172);

        playerGun[4] = pgl.grabImage(1, 5, 101, 172);
        playerGun[5] = pgl.grabImage(1, 6, 115, 172);
        playerGun[6] = pgl.grabImage(1, 7, 140, 172);

        playerGunJump[0] = pgl.grabImage(1, 8, 100, 168);
        playerGunJump[1] = pgl.grabImage(2, 8, 100, 168);
    }

    private void initPlayerJump() {
        playerJump[0] = pl.grabImage(1, 4, 90, 172);
        playerJump[1] = pl.grabImage(2, 4, 90, 172);
    }

    private void initPlayer() {
        player[0] = pl.grabImage(1, 1, 110, 172);

        player[1] = pl.grabImage(1, 2, 90, 172);
        player[2] = pl.grabImage(2, 2, 90, 172);
        player[3] = pl.grabImage(3, 2, 90, 172);

        player[4] = pl.grabImage(1, 3, 90, 172);
        player[5] = pl.grabImage(2, 3, 90, 172);
        player[6] = pl.grabImage(3, 3, 90, 172);
    }

    private void initRoads() {
        block[0] = bl.grabImage(1, 1, 100, 32); //дорога_иатэ
        block[1] = bl.grabImage(1, 2, 500, 32); //дорога_кабинет
    }
}
