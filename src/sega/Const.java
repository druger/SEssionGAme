package sega;

public class Const {

    public static final class Game {
        private Game() {
        }

        public static final String GAME_NAME = "SEssion GAme";
        public static final String BG_MUSIC = "/res/Music/1.mp3";
        public static final String JUMP_MUSIC = "/res/SFX/jump.mp3";
        public static final int GAME_WEIGHT = 800;
        public static final int GAME_HEIGHT = 600;
    }

    public static final class Sprite {
        private Sprite() {
        }

        public static final String BLOCK = "/res/Sprites/dirt/dirt.png";
        public static final String PLAYER = "/res/Sprites/Players/player.png";
        public static final String PLAYER_GUN = "/res/Sprites/Players/playerGun.png";
        public static final String PREPOD_PHYSICS = "/res/Sprites/Teachers/fizika.png";
        public static final String PREPOD_MATAN = "/res/Sprites/Teachers/matan.png";
        public static final String PREPOD_PRG = "/res/Sprites/Teachers/prg.png";
        public static final String PREPOD_ENG = "/res/Sprites/Teachers/eng.png";
        public static final String BULLET = "/res/Sprites/bullet.png";
        public static final String NEXT_LEVEL = "/res/Sprites/next.png";
    }

    public static final class Background {
        private Background() {
        }

        public static final String LEVEL0 = "/res/Levels/level0.png";
        public static final String STREET = "/res/Backgrounds/streetIate.jpg";
        public static final String MATAN = "/res/Backgrounds/matan.jpg";
        public static final String PRG = "/res/Backgrounds/prg.jpg";
        public static final String PHYSICS = "/res/Backgrounds/fizika.jpg";
        public static final String ENG = "/res/Backgrounds/eng.jpg";
        public static final String TV = "/res/Backgrounds/telek.png";
        public static final String MENU = "/res/Menu/menu.png";
    }

    public static final class Level {
        private Level() {
        }

        public static final String LEVEL1 = "/res/Levels/level1.png";
        public static final String LEVEL2 = "/res/Levels/level2.png";
        public static final String LEVEL3 = "/res/Levels/level3.png";
        public static final String LEVEL4 = "/res/Levels/level4.png";
        public static final String LEVEL5 = "/res/Levels/level5.png";
    }

    public static final class Hud {
        private Hud() {
        }

        public static final String LIVE = "/res/HUD/live.png";
        public static final String MONEY = "/res/HUD/money.png";
    }
}
