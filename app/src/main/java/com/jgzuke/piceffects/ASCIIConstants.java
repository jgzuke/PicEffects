package com.jgzuke.piceffects;

/**
 * Created by jgzuke on 15-08-24.
 */
public class ASCIIConstants {
    private static final boolean T = true;
    private static final boolean f = false;
    protected static final boolean[][] aa = new boolean[][] { // '#'
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
    protected static final boolean[][] ab = new boolean[][] { // '%'
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
    protected static final boolean[][] ba = new boolean[][] { // '|'
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
    protected static final boolean[][] bb = new boolean[][] { // '/'
            {f, f, f, T, T},
            {f, f, T, T, T},
            {f, f, T, T, T},
            {f, T, T, T, T},
            {f, T, T, T, f},
            {T, T, T, T, f},
            {T, T, T, f, f},
            {T, T, T, f, f},
            {T, T, f, f, f}
    };
    protected static final boolean[][] bc = new boolean[][] { // '\'
            {T, T, f, f, f},
            {T, T, T, f, f},
            {T, T, T, f, f},
            {T, T, T, T, f},
            {f, T, T, T, f},
            {f, T, T, T, T},
            {f, f, T, T, T},
            {f, f, T, T, T},
            {f, f, f, T, T}
    };
    protected static final boolean[][] bd = new boolean[][] { // '*'
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
    protected static final boolean[][] be = new boolean[][] { // '^'
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
    protected static final boolean[][] ca = new boolean[][] { // '-'
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
    protected static final boolean[][] cb = new boolean[][] { // '_'
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
    protected static final boolean[][] cc = new boolean[][] { // '^'
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
    protected static final boolean[][] da = new boolean[][] { // '''
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
    protected static final boolean[][] db = new boolean[][] { // '.'
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
    protected static final boolean[][] dc = new boolean[][] { // ' '
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
    protected static final char[][] CHAR_SYMBOLS = new char[][] {
            {'#', '%'},
            {'|', '/', '\\', '*', '^'},     //, '*', '_', '^'},
            {'-', '_', '"'},     //, '<', '>', '=', ':'},
            {'\'', '.', ' '}     //, '.'}
    };
    protected static final boolean[][][][] BOOLEAN_SYMBOLS = new boolean[][][][] {
            {aa, ab},
            {ba, bb, bc, bd, be},
            {ca, cb, cc},
            {da, db, dc}
    };
}
