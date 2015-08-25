package com.jgzuke.piceffects;

/**
 * Created by jgzuke on 15-08-24.
 */
public class ASCIIConstants {
    private static final boolean T = true;
    private static final boolean f = false;
    protected static final boolean[][] a1 = new boolean[][] { // '#'
            {f, f, T, T, T},
            {f, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, f},
            {T, T, T, f, f}
    };
    protected static final boolean[][] b1 = new boolean[][] { // '%'
            {T, T, T, f, f},
            {T, T, T, f, f},
            {T, T, T, T, f},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {f, T, T, T, T},
            {f, f, T, T, T},
            {f, f, T, T, T}
    };
    protected static final boolean[][] c1 = new boolean[][] { // '|'
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, f}
    };
    protected static final boolean[][] c2 = new boolean[][] { // '/'
            {f, f, f, T, T},
            {f, f, f, T, T},
            {f, f, T, T, T},
            {f, f, T, T, T},
            {f, T, T, T, T},
            {f, T, T, T, f},
            {T, T, T, T, f},
            {T, T, T, f, f},
            {T, T, T, f, f}
    };
    protected static final boolean[][] c3 = new boolean[][] { // '/'
            {f, f, T, T, T},
            {f, f, T, T, T},
            {f, T, T, T, T},
            {f, T, T, T, f},
            {T, T, T, T, f},
            {T, T, T, f, f},
            {T, T, T, f, f},
            {T, T, f, f, f},
            {T, T, f, f, f}
    };
    protected static final boolean[][] c4 = new boolean[][] { // '\'
            {T, T, f, f, f},
            {T, T, f, f, f},
            {T, T, T, f, f},
            {T, T, T, f, f},
            {T, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, T},
            {f, f, T, T, T},
            {f, f, T, T, T}
    };
    protected static final boolean[][] c5 = new boolean[][] { // '\'
            {T, T, T, f, f},
            {T, T, T, f, f},
            {T, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, T},
            {f, f, T, T, T},
            {f, f, T, T, T},
            {f, f, f, T, T},
            {f, f, f, T, T}
    };
    protected static final boolean[][] d1 = new boolean[][] { // '*'
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, T, T, T, f},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {f, T, T, T, f},
            {f, f, f, f, f},
            {f, f, f, f, f}
    };
    protected static final boolean[][] d2 = new boolean[][] { // '^'
            {f, f, T, f, f},
            {f, T, T, T, f},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, f, T, T},
            {T, f, f, f, T},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f}
    };
    protected static final boolean[][] e1 = new boolean[][] { // '-'
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, T, T, T, f},
            {T, T, T, T, T},
            {f, T, T, T, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f}
    };
    protected static final boolean[][] e2 = new boolean[][] { // '_'
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T}
    };
    protected static final boolean[][] e3 = new boolean[][] { // '"'
            {T, T, T, T, T},
            {T, T, T, T, T},
            {T, T, T, T, T},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f}
    };
    protected static final boolean[][] f1 = new boolean[][] { // '''
            {f, f, T, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f}
    };
    protected static final boolean[][] f2 = new boolean[][] { // '.'
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, T, f, f}
    };
    protected static final boolean[][] g = new boolean[][] { // ' '
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f},
            {f, f, f, f, f}
    };




    /*
    a1 '#'
    b1 '%'
    c1 '|'
    c2 '/'
    c3 '/'
    c4 '\'
    c5 '\'
    d1 '*'
    d2 '^'
    e1 '-'
    e2 '_'
    e3 '"'
    f1 '''
    f2 '.'
    g ' '
    */
    protected static final char[] CHAR_SYMBOLS = new char[] {
            '#',
            '%',
            '|', '/', '/', '\\', '\\',
            '*', '^',
            '-', '_', '"',
            '\'', '.',
            ' '
    };
    protected static final boolean[][][] BOOLEAN_SYMBOLS = new boolean[][][] {
            a1,
            b1,
            c1, c2, c3, c4, c5,
            d1, d2,
            e1, e2, e3,
            f1, f2,
            g
    };

    protected static final int[] BRIGHTNESS_LEVELS = new int[] {
            0,
            1,
            2, 2, 2, 2, 2,
            3, 3,
            4, 4, 4,
            5, 5,
            6
    };
    protected static int getBrightnessDistanceScoreBase(int index1, int index2) {
        return 800 * Math.abs(BRIGHTNESS_LEVELS[index1] - BRIGHTNESS_LEVELS[index2]);
    }
}
