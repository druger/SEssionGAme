
package framework;

import java.awt.image.BufferedImage;
import sega.BufferedImageLoader;

public class Texture {
    SpriteList bl, pl, pgl, fl, plm, plf, plp, ple;
    
    private BufferedImage block_list = null;
    private BufferedImage player_list = null;
    private BufferedImage playerGun_list = null;
    private BufferedImage prepod_list_matan = null;
    private BufferedImage prepod_list_fizika = null;
    private BufferedImage prepod_list_prg = null;
    private BufferedImage prepod_list_eng = null;
    
    public BufferedImage[] block = new BufferedImage[3];
    public BufferedImage[] player = new BufferedImage[7];
    public BufferedImage[] player_jump = new BufferedImage[2];
    public BufferedImage[] playerGun = new BufferedImage[7];
    public BufferedImage[] playerGun_jump = new BufferedImage[2];
    public BufferedImage[] prepod_matan = new BufferedImage[10];
    public BufferedImage[] prepod_fizika = new BufferedImage[8];
    public BufferedImage[] prepod_prg = new BufferedImage[8];
    public BufferedImage[] prepod_eng = new BufferedImage[8];
    
    public Texture(){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            block_list = loader.loadImage("/res/Sprites/dirt/dirt.png");
            player_list = loader.loadImage("/res/Sprites/Players/player.png");
            playerGun_list = loader.loadImage("/res/Sprites/Players/playerGun.png");
            prepod_list_matan = loader.loadImage("/res/Sprites/Teachers/matan.png");
            prepod_list_fizika = loader.loadImage("/res/Sprites/Teachers/fizika.png");
            prepod_list_prg = loader.loadImage("/res/Sprites/Teachers/prg.png");
            prepod_list_eng = loader.loadImage("/res/Sprites/Teachers/eng.png");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        bl = new SpriteList(block_list);
        pl = new SpriteList(player_list);
        pgl = new SpriteList(playerGun_list);
        plm = new SpriteList(prepod_list_matan);
        plf = new SpriteList(prepod_list_fizika);
        plp = new SpriteList(prepod_list_prg);
        ple = new SpriteList(prepod_list_eng);
        
        getTextures();
    }
    
    private void getTextures(){
        block[0] = bl.grabImage(1, 1, 100, 32); //дорога_иатэ
        block[1] = bl.grabImage(1, 2, 500, 32); //дорога_кабинет
        
        //кадры игорока при движении вправо
        player[0] = pl.grabImage(1, 1, 110, 172); //кадр игорока без действий
        
    	player[1] = pl.grabImage(1, 2, 90, 172); //кадр игорока при хотьбе(1-6)
        player[2] = pl.grabImage(2, 2, 90, 172); 
        player[3] = pl.grabImage(3, 2, 90, 172);  
        
        //движение влево
        player[4] = pl.grabImage(1, 3, 90, 172); 
        player[5] = pl.grabImage(2, 3, 90, 172); 
        player[6] = pl.grabImage(3, 3, 90, 172);
        
        //кадры игрока при прыжке
        player_jump[0]= pl.grabImage(1, 4, 90, 172);
        player_jump[1]= pl.grabImage(2, 4, 90, 172);
        
        //игрок с оружием
        playerGun[0] = pgl.grabImage(1, 1, 130, 172); 
        
    	playerGun[1] = pgl.grabImage(1, 2, 103, 172); 
        playerGun[2] = pgl.grabImage(1, 3, 115, 172); 
        playerGun[3] = pgl.grabImage(1, 4, 140, 172);  

        playerGun[4] = pgl.grabImage(1, 5, 101, 172); 
        playerGun[5] = pgl.grabImage(1, 6, 115, 172); 
        playerGun[6] = pgl.grabImage(1, 7, 140, 172);
        
        playerGun_jump[0]= pgl.grabImage(1, 8, 100, 168);
        playerGun_jump[1]= pgl.grabImage(2, 8, 100, 168);
        
        //кадры препода 
        prepod_matan[0] = plm.grabImage(1, 1, 69, 100);
        prepod_matan[1] = plm.grabImage(2, 1, 69, 100);
        prepod_matan[2] = plm.grabImage(3, 1, 69, 100);
        prepod_matan[3] = plm.grabImage(4, 1, 69, 100);
        prepod_matan[4] = plm.grabImage(5, 1, 69, 100);
        
        prepod_matan[5] = plm.grabImage(1, 2, 69, 100);
        prepod_matan[6] = plm.grabImage(2, 2, 69, 100);
        prepod_matan[7] = plm.grabImage(3, 2, 69, 100);
        prepod_matan[8] = plm.grabImage(4, 2, 69, 100);
        prepod_matan[9] = plm.grabImage(5, 2, 69, 100);
        ///////////
        prepod_fizika[0] = plf.grabImage(1, 1, 71, 100);
        prepod_fizika[1] = plf.grabImage(2, 1, 71, 100);
        prepod_fizika[2] = plf.grabImage(3, 1, 71, 100);
        prepod_fizika[3] = plf.grabImage(4, 1, 71, 100);
        
        prepod_fizika[4] = plf.grabImage(1, 2, 71, 100);
        prepod_fizika[5] = plf.grabImage(2, 2, 71, 100);
        prepod_fizika[6] = plf.grabImage(3, 2, 71, 100);
        prepod_fizika[7] = plf.grabImage(4, 2, 71, 100);
        //////////
        prepod_prg[0] = plp.grabImage(1, 1, 70, 100);
        prepod_prg[1] = plp.grabImage(2, 1, 70, 100);
        prepod_prg[2] = plp.grabImage(3, 1, 70, 100);
        prepod_prg[3] = plp.grabImage(4, 1, 70, 100);
        
        prepod_prg[4] = plp.grabImage(1, 2, 70, 100);
        prepod_prg[5] = plp.grabImage(2, 2, 70, 100);
        prepod_prg[6] = plp.grabImage(3, 2, 70, 100);
        prepod_prg[7] = plp.grabImage(4, 2, 70, 100);
        //////
        prepod_eng[0] = ple.grabImage(1, 1, 69, 100);
        prepod_eng[1] = ple.grabImage(2, 1, 69, 100);
        prepod_eng[2] = ple.grabImage(3, 1, 69, 100);
        prepod_eng[3] = ple.grabImage(4, 1, 69, 100);
        
        prepod_eng[4] = ple.grabImage(1, 2, 69, 100);
        prepod_eng[5] = ple.grabImage(2, 2, 69, 100);
        prepod_eng[6] = ple.grabImage(3, 2, 69, 100);
        prepod_eng[7] = ple.grabImage(4, 2, 69, 100);
        
        
    }
}
